package com.linbin.mvpframework.module.Retrofit.ui;

import android.os.Bundle;
import android.widget.TextView;

import com.linbin.mvpframework.Base.BaseActivity;
import com.linbin.mvpframework.R;
import com.linbin.mvpframework.bean.Information;
import com.linbin.mvpframework.module.Retrofit.Presenter.InformationPresenterImpl;
import com.linbin.mvpframework.module.view.IInformationView;

/**
 * Created by Administrator on 2016/6/12.
 */
public class InformationActivity extends BaseActivity<InformationPresenterImpl> implements IInformationView {



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
        mPresenter = new InformationPresenterImpl(this,"http://tq.91.com/info/?&tag=8");
    }

    private void initView() {
        weather = (TextView) findViewById(R.id.id_weather);
        temp = (TextView) findViewById(R.id.id_temp);
        weather.setText("1111111");
    }

    @Override
    public void initinformationDetail(Information infos) {
        temp.setText(infos.getItems().getTitle());
    }

}
