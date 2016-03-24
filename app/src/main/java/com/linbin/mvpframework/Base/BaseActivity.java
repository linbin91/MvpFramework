package com.linbin.mvpframework.Base;

import android.app.Activity;

/**
 * Created by linbin_dian91 on 2016/3/17.
 */
public abstract class BaseActivity<T extends  BasePresenter> extends Activity implements  BaseView {

   protected  T mPresenter;
    @Override
    public void toast(String msg) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
}
