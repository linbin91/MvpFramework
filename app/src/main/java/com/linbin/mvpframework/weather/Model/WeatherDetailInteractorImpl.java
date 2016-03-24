package com.linbin.mvpframework.weather.Model;

import android.os.Handler;

import com.linbin.mvpframework.callback.RequestCallback;
import com.linbin.mvpframework.weather.Bean.WeatherInfo;


/**
 * Created by linbin_dian91 on 2016/3/18.
 */
public class WeatherDetailInteractorImpl implements  IWeatherDetailInteractor<WeatherInfo> {
    Handler mHandler = new Handler();
    @Override
    public void requestWeatherDetail(final RequestCallback<WeatherInfo> callback, String url) {
        // 这边可以使用到okhttt，为了演示就直接用延时来说明问题下
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(1000);
                    final  WeatherInfo info = new WeatherInfo();
                    info.temp = "10/25";
                    info.weather = "小到大雨";
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.requestSuccess(info);
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
