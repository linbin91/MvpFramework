package com.linbin.mvpframework.http.service;

import com.linbin.mvpframework.bean.ProductBean;
import com.linbin.mvpframework.bean.ProfitBean;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by Administrator on 2016/6/12.
 */
public interface IHttpService {
    @GET
    Observable<ProductBean> getInformation(@Header("Cache-Control") String cacheControl, @Url String url);

    @GET
    Observable<ProfitBean> getProfit(@Url String url);
}
