package com.esotericsoftware.kryo.demo;

import com.esotericsoftware.kryo.serialize.KryoSerializer;
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

        byte[] b = new KryoSerializer<TradeAttributeDO>().serialize(attributeDO);
        TradeAttributeDO result = new KryoSerializer<TradeAttributeDO>().unserialize(b);
        System.out.println(result.getOrigOrgCode());
    }
}
