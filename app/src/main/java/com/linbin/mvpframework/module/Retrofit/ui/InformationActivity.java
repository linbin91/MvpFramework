package com.linbin.mvpframework.module.Retrofit.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.linbin.mvpframework.Base.BaseActivity;
import com.linbin.mvpframework.R;
import com.linbin.mvpframework.bean.ProfitBean;
import com.linbin.mvpframework.module.Retrofit.Presenter.ProfitPresenterImpl;
import com.linbin.mvpframework.module.view.IInformationView;

/**
 * Created by Administrator on 2016/6/12.
 */
public class InformationActivity extends BaseActivity<ProfitPresenterImpl> implements IInformationView,View.OnClickListener {



    private TextView temp;
    private TextView weather;
    private TextView jump;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        initView();
        initPresenter();
    }



    private void initPresenter() {
        mPresenter = new ProfitPresenterImpl(this,"http://139.196.173.191:42000/blb-api/profitTips");
    }

    private void initView() {
        weather = (TextView) findViewById(R.id.id_weather);
        temp = (TextView) findViewById(R.id.id_temp);
        jump = (TextView) findViewById(R.id.id_jump);
    }

    @Override
    public void initinformationDetail(ProfitBean infos) {
        weather.setText(infos.resources.get(0).realName);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.id_jump:
                doJump();
                break;
            default:
                break;
        }
    }

    private void doJump() {

    }
}
