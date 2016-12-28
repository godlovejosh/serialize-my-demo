package com.google.code.gson.demo;

import com.google.gson.Gson;
import org.junit.Test;
import serialize.entity.model.TradeDO;

/**
 * @author wuxing
 */
public class Demo01 {

    @Test
    public void test01() {
        TradeDO tradeDO = new TradeDO();
        tradeDO.setId(10000L);
        Gson gson = new Gson();
        String json = gson.toJson(tradeDO);
        System.out.println(json);
        TradeDO tradeDO1 = gson.fromJson(json, TradeDO.class);
        System.out.println(tradeDO1.getId());
    }
}
