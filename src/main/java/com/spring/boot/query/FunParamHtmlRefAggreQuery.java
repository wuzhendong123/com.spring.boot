package com.spring.boot.query;

import java.util.Arrays;

/**
 * @program: com.spring.boot
 * @description:
 * @author: zhendong.wu
 * @create: 2019-04-21 10:59
 **/
public class FunParamHtmlRefAggreQuery {
    private String queryCode;
    private FunParamHtmlRefQuery[] funParam;

    public String getQueryCode() {
        return queryCode;
    }

    public void setQueryCode(String queryCode) {
        this.queryCode = queryCode;
    }

    public FunParamHtmlRefQuery[] getFunParam() {
        return funParam;
    }

    public void setFunParam(FunParamHtmlRefQuery[] funParam) {
        this.funParam = funParam;
    }

    @Override
    public String toString() {
        return "FunParamHtmlRefAggreQuery{" +
                "queryCode='" + queryCode + '\'' +
                ", funParam=" + Arrays.toString(funParam) +
                '}';
    }
}
