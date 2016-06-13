package com.linbin.mvpframework.module.weather.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.linbin.mvpframework.Base.BaseActivity;
import com.linbin.mvpframework.R;
import com.linbin.mvpframework.bean.WeatherInfo;
import com.linbin.mvpframework.event.StatusBarEvent;
import com.linbin.mvpframework.module.Retrofit.ui.InformationActivity;
import com.linbin.mvpframework.module.weather.Presenter.WeatherDetailPresenterImpl;
import com.linbin.mvpframework.module.weather.View.IWeatherDetailView;
import com.linbin.mvpframework.util.RxBus;

import java.util.List;

import rx.Observable;
import rx.functions.Action1;

/**
 * Created by linbin_dian91 on 2016/3/18.
 */
public class WeatherActivity  extends BaseActivity<WeatherDetailPresenterImpl> implements IWeatherDetailView{

    private TextView temp;
    private TextView weather;
    private Observable<StatusBarEvent> mObservable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        initView();
        initPresenter();
        initRxBusEvent();
    }

    private void initRxBusEvent() {
        mObservable = RxBus.get().register("change",StatusBarEvent.class);
        mObservable.subscribe(new Action1<StatusBarEvent>() {
            @Override
            public void call(StatusBarEvent statusBarEvent) {
                weather.setText("大太阳");
            }
        });
    }

    private void initPresenter() {
        mPresenter = new WeatherDetailPresenterImpl(this,"www.baidu.com");
    }

    private void initView() {
        weather = (TextView) findViewById(R.id.id_weather);
        temp = (TextView) findViewById(R.id.id_temp);
        temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WeatherActivity.this,InformationActivity.class);
                WeatherActivity.this.startActivity(intent);
            }
        });
    }


    @Override
    public void initWeatherDetail(List<WeatherInfo> weatherInfos) {
        if (weatherInfos != null){
            WeatherInfo weatherInfo = weatherInfos.get(0);
            weather.setText(weatherInfo.getWeather());
            temp.setText(weatherInfo.getTemp());
        }
    }
}
