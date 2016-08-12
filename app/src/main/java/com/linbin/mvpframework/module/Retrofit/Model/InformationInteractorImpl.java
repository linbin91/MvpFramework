package com.linbin.mvpframework.module.Retrofit.Model;

import com.linbin.mvpframework.bean.ProductBean;
import com.linbin.mvpframework.callback.RequestCallback;
import com.linbin.mvpframework.http.manager.RetrofitManager;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/6/12.
 */
public class InformationInteractorImpl implements IInformationInteractor {
    @Override
    public Subscription requestInformationList(final RequestCallback callback, String url) {
        return RetrofitManager.builder().getInformationObservable(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

                .subscribe(new Observer<ProductBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ProductBean productBean) {
                        callback.requestSuccess(productBean);
                    }
                });

    }
}
