package com.linbin.mvpframework.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/8/11.
 */
public class ProfitBean {
    public int respCode;
    public List<Item> resources;
    public static class Item{
        public int totalProfit;
        public String realName;
    }
}
