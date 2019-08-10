package com.spring.boot.query.base;

/**
 * @program: com.spring.boot
 * @description:
 * @author: zhendong.wu
 * @create: 2019-04-20 17:06
 **/
public class ParamMapQuery {
    private String key;
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ParamMapQuery{" +
                "key='" + key + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
