package com.linbin.mvpframework.module.weather.Presenter;

import com.linbin.mvpframework.Base.BasePresenterImpl;
import com.linbin.mvpframework.bean.WeatherInfo;
import com.linbin.mvpframework.module.weather.Model.WeatherDetailInteractorImpl;
import com.linbin.mvpframework.module.weather.View.IWeatherDetailView;

import java.util.List;

/**
 * Created by linbin_dian91 on 2016/3/18.
 */
public class WeatherDetailPresenterImpl extends BasePresenterImpl<IWeatherDetailView,List<WeatherInfo>> {
    public WeatherDetailPresenterImpl(IWeatherDetailView view, String url) {
        super(view);
        WeatherDetailInteractorImpl weatherDetailInteractor = new WeatherDetailInteractorImpl();
        mSubscription = weatherDetailInteractor.getWeatherFromDb(this);
    }

    @Override
    public void requestSuccess(List<WeatherInfo> data) {
        mViewRef.get().initWeatherDetail(data);
    }
}
