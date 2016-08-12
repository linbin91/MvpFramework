package com.linbin.mvpframework.module.Retrofit.Model;

import com.linbin.mvpframework.callback.RequestCallback;

import rx.Subscription;

/**
 * Created by Administrator on 2016/6/12.
 */
public interface IProfitInteractor<T> {
    Subscription requestRrofitList(RequestCallback<T> callback, String url);
}
