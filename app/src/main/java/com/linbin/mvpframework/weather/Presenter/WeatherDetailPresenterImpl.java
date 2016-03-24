package com.linbin.mvpframework.weather.Presenter;

import com.linbin.mvpframework.Base.BasePresenterImpl;
import com.linbin.mvpframework.weather.Bean.WeatherInfo;
import com.linbin.mvpframework.weather.Model.WeatherDetailInteractorImpl;
import com.linbin.mvpframework.weather.View.IWeatherDetailView;

/**
 * Created by linbin_dian91 on 2016/3/18.
 */
public class WeatherDetailPresenterImpl extends BasePresenterImpl<IWeatherDetailView,WeatherInfo> {
    public WeatherDetailPresenterImpl(IWeatherDetailView view, String url) {
        super(view);
        WeatherDetailInteractorImpl weatherDetailInteractor = new WeatherDetailInteractorImpl();
        weatherDetailInteractor.requestWeatherDetail(this, url);
    }

    @Override
    public void requestSuccess(WeatherInfo data) {
        super.requestSuccess(data);
        mView.initWeatherDetail(data);
    }
}
