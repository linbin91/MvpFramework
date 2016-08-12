package com.linbin.mvpframework.Base;

import com.linbin.mvpframework.callback.RequestCallback;

import java.lang.ref.WeakReference;

import rx.Subscription;

/**
 * Created by linbin_dian91 on 2016/3/18.
 */
public class BasePresenterImpl<T extends  BaseView,V> implements BasePresenter,RequestCallback<V> {

    protected Subscription mSubscription;
    protected WeakReference<T> mViewRef;

    public  BasePresenterImpl(T view){
        mViewRef = new WeakReference<T>(view);
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {
        if (mViewRef != null){
            mViewRef.clear();
            mViewRef = null;
        }
        if (mSubscription != null && !mSubscription.isUnsubscribed()){
            mSubscription.unsubscribe();
        }
    }

    @Override
    public void beforeRequest() {
        mViewRef.get().showProgress();
    }

    @Override
    public void requestError(String msg) {
        mViewRef.get().toast(msg);
        mViewRef.get().hideProgress();
    }

    @Override
    public void requestComplete() {
        mViewRef.get().hideProgress();
    }

    @Override
    public void requestSuccess(V data) {

    }
}
