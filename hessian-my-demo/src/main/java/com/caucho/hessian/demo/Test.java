package com.caucho.hessian.demo;

import com.caucho.hessian.client.HessianProxyFactory;
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

        HessianProxyFactory factory = new HessianProxyFactory();


        tradeDO.setAttribute(JSON.toJSONString(attributeDO));
        String result = JSON.toJSONString(tradeDO);
        System.out.println(result);
    }
}
