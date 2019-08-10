package com.spring.boot.query;

import com.spring.boot.query.base.BaseQuery;
import com.spring.boot.query.base.ParamMapQuery;
import com.spring.boot.query.base.ParamQuery;

import java.util.Arrays;

/**
 * @program: com.spring.boot
 * @description:
 * @author: zhendong.wu
 * @create: 2019-04-20 12:15
 **/
public class ParamHtmlTempleQuery extends BaseQuery {
    private String name;
    private String html;
    private String status;
    private String exampleHtml;
    private ParamQuery[] paramQuery;
    private ParamMapQuery[] paramMapQuery;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ParamQuery[] getParamQuery() {
        return paramQuery;
    }

    public void setParamQuery(ParamQuery[] paramQuery) {
        this.paramQuery = paramQuery;
    }

    public ParamMapQuery[] getParamMapQuery() {
        return paramMapQuery;
    }

    public void setParamMapQuery(ParamMapQuery[] paramMapQuery) {
        this.paramMapQuery = paramMapQuery;
    }

    public String getExampleHtml() {
        return exampleHtml;
    }

    public void setExampleHtml(String exampleHtml) {
        this.exampleHtml = exampleHtml;
    }

    @Override
    public String toString() {
        return "ParamHtmlTempleQuery{" +
                "name='" + name + '\'' +
                ", html='" + html + '\'' +
                ", status='" + status + '\'' +
                ", exampleHtml='" + exampleHtml + '\'' +
                ", paramQuery=" + Arrays.toString(paramQuery) +
                ", paramMapQuery=" + Arrays.toString(paramMapQuery) +
                '}';
    }
}
