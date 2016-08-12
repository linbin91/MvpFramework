package com.linbin.mvpframework.module.Retrofit.Presenter;

import com.linbin.mvpframework.Base.BasePresenterImpl;
import com.linbin.mvpframework.bean.ProfitBean;
import com.linbin.mvpframework.module.Retrofit.Model.RrofitInteractorImpl;
import com.linbin.mvpframework.module.view.IInformationView;

/**
 * Created by Administrator on 2016/6/12.
 */
public class ProfitPresenterImpl extends BasePresenterImpl<IInformationView, ProfitBean>  {
    public ProfitPresenterImpl(IInformationView view , String url) {
        super(view);
        RrofitInteractorImpl informationInteractor = new RrofitInteractorImpl();
        mSubscription = informationInteractor.requestRrofitList(this,url);
    }

    @Override
    public void requestSuccess(ProfitBean data) {
       mViewRef.get().initinformationDetail(data);
    }
}
