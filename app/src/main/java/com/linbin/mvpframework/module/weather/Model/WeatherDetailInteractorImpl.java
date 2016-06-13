package com.linbin.mvpframework.module.weather.Model;

import com.linbin.mvpframework.bean.WeatherInfo;
import com.linbin.mvpframework.bean.WeatherInfoDao;
import com.linbin.mvpframework.callback.RequestCallback;
import com.linbin.mvpframework.widget.BaseApplication;

import java.util.List;

import de.greenrobot.dao.query.Query;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;


/**
 * Created by linbin_dian91 on 2016/3/18.
 */
public class WeatherDetailInteractorImpl implements  IWeatherDetailInteractor<List<WeatherInfo>> {


    @Override
    public Subscription getWeatherFromDb(final RequestCallback<List<WeatherInfo>> callback) {
        return Observable.create(new Observable.OnSubscribe<List<WeatherInfo>>(){
            @Override
            public void call(Subscriber<? super List<WeatherInfo>> subscriber) {
                WeatherInfo weatherInfo = new WeatherInfo(null,"雷阵雨","20/25");
                getWeatherDao().insert(weatherInfo);
                Query<WeatherInfo> query = getWeatherDao().queryBuilder().build();
                subscriber.onNext(query.list());
                subscriber.onCompleted();

            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        callback.beforeRequest();
                    }
                }).subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<WeatherInfo>>(){
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onNext(List<WeatherInfo> weatherInfos) {
                        callback.requestSuccess(weatherInfos);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.requestError("出错啦");
                    }
                });

    }

    private WeatherInfoDao getWeatherDao(){
       return  ((BaseApplication) BaseApplication.getContext()).getDaoSession().getWeatherInfoDao();
    }

}
