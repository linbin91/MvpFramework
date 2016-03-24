package com.linbin.mvpframework.Base;

import com.linbin.mvpframework.callback.RequestCallback;

/**
 * Created by linbin_dian91 on 2016/3/18.
 */
public class BasePresenterImpl<T extends  BaseView,V> implements BasePresenter,RequestCallback<V> {

    protected  T mView;

    public  BasePresenterImpl(T view){
        mView = view;
    }
    @Override
    public void onResume() {

    }

    @Override
    public void onDestroy() {
        mView = null;
    }

    @Override
    public void beforeRequest() {
        mView.showProgress();
    }

    @Override
    public void requestError(String msg) {
        mView.toast(msg);
        mView.hideProgress();
    }

    @Override
    public void requestComplete() {
        mView.hideProgress();
    }

    @Override
    public void requestSuccess(V data) {

    }
}
