package com.linbin.mvpframework.module.weather.View;

import com.linbin.mvpframework.Base.BaseView;
import com.linbin.mvpframework.bean.WeatherInfo;

import java.util.List;

/**
 * Created by linbin_dian91 on 2016/3/18.
 */
public interface IWeatherDetailView extends BaseView {
    void initWeatherDetail(List<WeatherInfo> weatherInfos);
}
