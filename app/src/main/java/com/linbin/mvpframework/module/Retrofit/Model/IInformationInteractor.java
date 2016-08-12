package com.linbin.mvpframework.module.Retrofit.Model;

import com.linbin.mvpframework.callback.RequestCallback;

import rx.Subscription;

/**
 * Created by Administrator on 2016/6/12.
 */
public interface IInformationInteractor<T> {
    Subscription requestInformationList(RequestCallback<T> callback, String url);
}
