package com.linbin.mvpframework.module.weather.ui;

import android.app.Activity;
import android.os.Bundle;

import com.linbin.mvpframework.R;
import com.linbin.mvpframework.event.StatusBarEvent;
import com.linbin.mvpframework.util.RxBus;

/**
 * Created by Administrator on 2016/6/12.
 */
public class TestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxBus.get().post("change", new StatusBarEvent());
    }
}
