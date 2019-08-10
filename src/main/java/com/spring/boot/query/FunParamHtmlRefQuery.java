package com.spring.boot.query;

import com.spring.boot.query.base.ParamMapQuery;

import java.util.Arrays;

/**
 * @program: com.spring.boot
 * @description:
 * @author: zhendong.wu
 * @create: 2019-04-21 10:47
 **/
public class FunParamHtmlRefQuery {
    private String code;
    private String queryCode;
    private String paramKey;
    private String paramHtmlCode;
    private String paramExp;
    private String status;
    private ParamMapQuery[] paramMapQuery;

    public String getQueryCode() {
        return queryCode;
    }

    public void setQueryCode(String queryCode) {
        this.queryCode = queryCode;
    }

    public String getParamKey() {
        return paramKey;
    }

    public void setParamKey(String paramKey) {
        this.paramKey = paramKey;
    }

    public String getParamHtmlCode() {
        return paramHtmlCode;
    }

    public void setParamHtmlCode(String paramHtmlCode) {
        this.paramHtmlCode = paramHtmlCode;
    }

    public String getParamExp() {
        return paramExp;
    }

    public void setParamExp(String paramExp) {
        this.paramExp = paramExp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ParamMapQuery[] getParamMapQuery() {
        return paramMapQuery;
    }

    public void setParamMapQuery(ParamMapQuery[] paramMapQuery) {
        this.paramMapQuery = paramMapQuery;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "FunParamHtmlRefQuery{" +
                "code='" + code + '\'' +
                ", queryCode='" + queryCode + '\'' +
                ", paramKey='" + paramKey + '\'' +
                ", paramHtmlCode='" + paramHtmlCode + '\'' +
                ", paramExp='" + paramExp + '\'' +
                ", status='" + status + '\'' +
                ", paramMapQuery=" + Arrays.toString(paramMapQuery) +
                '}';
    }
}
