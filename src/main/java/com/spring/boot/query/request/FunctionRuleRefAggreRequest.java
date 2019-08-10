package com.spring.boot.query.request;

import com.spring.boot.query.base.ParamMapQuery;

/**
 * @program: com.spring.boot
 * @description:
 * @author: zhendong.wu
 * @create: 2019-05-01 12:34
 **/
public class FunctionRuleRefAggreRequest {
    private String code;
    private ParamMapQuery[] param;
    private String funTempleCode;
    private String html ;

    public ParamMapQuery[] getParam() {
        return param;
    }

    public void setParam(ParamMapQuery[] param) {
        this.param = param;
    }

    public String getFunTempleCode() {
        return funTempleCode;
    }

    public void setFunTempleCode(String funTempleCode) {
        this.funTempleCode = funTempleCode;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
