package com.linbin.mvpframework.callback;

/**
 * Created by linbin_dian91 on 2016/3/18.
 */
public interface RequestCallback<T> {
    /**
     * 请求之前
     */
    void beforeRequest();

    /**
     * 请求错误
     * @param msg
     */
    void requestError(String msg);

    /**
     * 请求完成
     */
    void requestComplete();

    /**
     * 请求成功
     * @param data
     */
    void requestSuccess(T data);
}
