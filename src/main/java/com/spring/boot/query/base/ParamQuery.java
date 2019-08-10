package com.spring.boot.query.base;

/**
 * @program: com.spring.boot
 * @description:
 * @author: zhendong.wu
 * @create: 2019-04-20 16:43
 **/
public class ParamQuery {
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "ParamQuery{" +
                "key='" + key + '\'' +
                '}';
    }
}
