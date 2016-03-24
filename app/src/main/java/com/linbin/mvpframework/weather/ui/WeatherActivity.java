package com.linbin.mvpframework.weather.ui;

import android.os.Bundle;
import android.widget.TextView;

import com.linbin.mvpframework.Base.BaseActivity;
import com.linbin.mvpframework.R;
import com.linbin.mvpframework.weather.Bean.WeatherInfo;
import com.linbin.mvpframework.weather.Presenter.WeatherDetailPresenterImpl;
import com.linbin.mvpframework.weather.View.IWeatherDetailView;

/**
 * Created by linbin_dian91 on 2016/3/18.
 */
public class WeatherActivity  extends BaseActivity<WeatherDetailPresenterImpl> implements IWeatherDetailView{

    private TextView temp;
    private TextView weather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        initView();
        initPresenter();
    }

    private void initPresenter() {
        mPresenter = new WeatherDetailPresenterImpl(this,"www.baidu.com");
    }

    private void initView() {
        weather = (TextView) findViewById(R.id.id_weather);
        temp = (TextView) findViewById(R.id.id_temp);
    }

    @Override
    public void initWeatherDetail(WeatherInfo data) {
        if (data != null){
            weather.setText(data.weather);
            temp.setText(data.temp);
        }
    }
}
