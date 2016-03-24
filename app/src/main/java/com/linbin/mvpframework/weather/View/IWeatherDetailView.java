package com.linbin.mvpframework.weather.View;

import com.linbin.mvpframework.Base.BaseView;
import com.linbin.mvpframework.weather.Bean.WeatherInfo;

/**
 * Created by linbin_dian91 on 2016/3/18.
 */
public interface IWeatherDetailView extends BaseView {
    void initWeatherDetail(WeatherInfo data);
}
