package com.linbin.mvpframework.module.Retrofit.Presenter;

import com.linbin.mvpframework.Base.BasePresenterImpl;
import com.linbin.mvpframework.bean.ProductBean;
import com.linbin.mvpframework.module.Retrofit.Model.IInformationInteractor;
import com.linbin.mvpframework.module.Retrofit.Model.InformationInteractorImpl;
import com.linbin.mvpframework.module.view.IInformationView;

/**
 * Created by Administrator on 2016/6/12.
 */
public class InformationPresenterImpl extends BasePresenterImpl<IInformationView, ProductBean>  {
    public InformationPresenterImpl(IInformationView view ,String url) {
        super(view);
        IInformationInteractor informationInteractor = new InformationInteractorImpl();
        mSubscription = informationInteractor.requestInformationList(this,url);
    }

    @Override
    public void requestSuccess(ProductBean data) {
//        super.requestSuccess(data);
//       mViewRef.get().initinformationDetail(data);
    }
}
