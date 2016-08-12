package com.linbin.mvpframework.http.manager;

import android.support.annotation.NonNull;

import com.linbin.mvpframework.bean.ProductBean;
import com.linbin.mvpframework.bean.ProfitBean;
import com.linbin.mvpframework.http.service.IHttpService;
import com.linbin.mvpframework.util.NetUtil;
import com.linbin.mvpframework.widget.BaseApplication;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by Administrator on 2016/6/12.
 */
public class RetrofitManager {
    //设缓存有效期为两天
    protected static final long CACHE_STALE_SEC = 60 * 60 * 24 * 2;
    //查询缓存的Cache-Control设置，为if-only-cache时只查询缓存而不会请求服务器，max-stale可以配合设置缓存失效时间
    protected static final String CACHE_CONTROL_CACHE = "only-if-cached, max-stale=" + CACHE_STALE_SEC;
    //查询网络的Cache-Control设置，头部Cache-Control设为max-age=0时则不会使用缓存而请求服务器
    protected static final String CACHE_CONTROL_NETWORK = "max-age=0";

    private IHttpService mService;
    private static OkHttpClient mOkHttpClient;

    public static RetrofitManager builder() {
        return new RetrofitManager();
    }

    private RetrofitManager() {

        initOkHttpClient();

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://139.196.173.191:42000/").client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build();

        mService = retrofit.create(IHttpService.class);
    }

    // 配置OkHttpClient
    private void initOkHttpClient() {
        if (mOkHttpClient == null) {
            synchronized (RetrofitManager.class) {
                if (mOkHttpClient == null) {
                    // 因为BaseUrl不同所以这里Retrofit不为静态，但是OkHttpClient配置是一样的,静态创建一次即可
                    File cacheFile = new File(BaseApplication.getContext().getCacheDir(),
                            "HttpCache"); // 指定缓存路径
                    Cache cache = new Cache(cacheFile, 1024 * 1024 * 100); // 指定缓存大小100Mb
                    // 云端响应头拦截器，用来配置缓存策略
                    Interceptor rewriteCacheControlInterceptor = new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request request = chain.request();
                            if (!NetUtil.isConnected(BaseApplication.getContext())) {
                                request = request.newBuilder()
                                        .cacheControl(CacheControl.FORCE_CACHE).build();
                            }
                            Response originalResponse = chain.proceed(request);
                            if (NetUtil.isConnected(BaseApplication.getContext())) {
                                //有网的时候读接口上的@Headers里的配置，你可以在这里进行统一的设置
                                String cacheControl = request.cacheControl().toString();
                                return originalResponse.newBuilder()
                                        .header("Cache-Control", cacheControl)
                                        .removeHeader("Pragma").build();
                            } else {
                                return originalResponse.newBuilder().header("Cache-Control",
                                        "public, only-if-cached," + CACHE_STALE_SEC)
                                        .removeHeader("Pragma").build();
                            }
                        }
                    };
                    mOkHttpClient = new OkHttpClient.Builder().cache(cache)
                            .addNetworkInterceptor(rewriteCacheControlInterceptor)
                            .addInterceptor(rewriteCacheControlInterceptor)
                            .connectTimeout(30, TimeUnit.SECONDS).build();
                }
            }
        }
    }


    /**
     * 根据网络状况获取缓存的策略
     *
     * @return
     */
    @NonNull
    private String getCacheControl() {
        return NetUtil.isConnected(BaseApplication.getContext()) ? CACHE_CONTROL_NETWORK : CACHE_CONTROL_CACHE;
    }

    public Observable<ProductBean> getInformationObservable(String url){
        return  mService.getInformation(getCacheControl(),url);
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .unsubscribeOn(Schedulers.io());
    }

    public Observable<ProfitBean> getProfitObservable(String url){
        return mService.getProfit(url);
    }

}
