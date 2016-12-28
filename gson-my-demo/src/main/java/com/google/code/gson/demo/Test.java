package com.google.code.gson.demo;


import com.google.gson.GsonBuilder;
import serialize.entity.model.TradeAttributeDO;
import serialize.entity.model.TradeDO;

import java.util.Date;

/**
 * @author wuxing
 */
public class Test {
    public static void main(String[] args) {
        TradeAttributeDO attributeDO = new TradeAttributeDO();
        TradeDO tradeDO = new TradeDO();
        attributeDO.setOrigOrgCode("W1000");
        attributeDO.setOrigOrgName("部门");
        attributeDO.setUseCarDate(new Date());
        tradeDO.setAttribute(GsonUtils.getInstance().toJson(attributeDO));
        String result = GsonUtils.getInstance().toJson(tradeDO);
        System.out.println(result);

        GsonBuilder gsonBuilder = new GsonBuilder();

//        Gson gson = new GsonBuilder()
//                .registerTypeAdapter(Id.class, new IdTypeAdapter())
//                .enableComplexMapKeySerialization()
//                .serializeNulls()
//                .setDateFormat(DateFormat.LONG)
//                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
//                .setPrettyPrinting()
//                .setVersion(1.0)
//                .create();
    }
}
