package com.linbin.mvpframework.module.Retrofit.Model;

import com.linbin.mvpframework.bean.ProfitBean;
import com.linbin.mvpframework.callback.RequestCallback;
import com.linbin.mvpframework.http.manager.RetrofitManager;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2016/6/12.
 */
public class RrofitInteractorImpl implements IProfitInteractor {


    @Override
    public Subscription requestRrofitList(final RequestCallback callback, String url) {
        return RetrofitManager.builder().getProfitObservable(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ProfitBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ProfitBean bean) {
                        callback.requestSuccess(bean);
                    }
                });
    }
}
