package com.linbin.mvpframework.weather.Model;

import com.linbin.mvpframework.callback.RequestCallback;

/**
 * Created by linbin_dian91 on 2016/3/18.
 */
public interface IWeatherDetailInteractor<T> {
    public  void  requestWeatherDetail(RequestCallback<T> callback, String url);
}
