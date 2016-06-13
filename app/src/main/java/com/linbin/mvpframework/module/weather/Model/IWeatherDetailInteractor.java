package com.linbin.mvpframework.module.weather.Model;

import com.linbin.mvpframework.callback.RequestCallback;

import rx.Subscription;

/**
 * Created by linbin_dian91 on 2016/3/18.
 */
public interface IWeatherDetailInteractor<T> {
    Subscription getWeatherFromDb(RequestCallback<T> callback);
}
