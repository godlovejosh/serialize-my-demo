package com.google.code.gson.demo;

import com.google.gson.Gson;

public class GsonUtils {

    private static class GsonHolder {
        private static final Gson INSTANCE = new Gson();
    }

    /**
     * 获取Gson实例，由于Gson是线程安全的，这里共同使用同一个Gson实例
     */
    public static Gson getInstance() {
        return GsonHolder.INSTANCE;
    }

    private static <T> T fromJson(String json, Class<T> clazz){
        return GsonUtils.getInstance().fromJson(json, clazz);
    }

    public static void main(String[] args){
        GsonUtils.fromJson("{}", BaseDO.class);
    }

}
