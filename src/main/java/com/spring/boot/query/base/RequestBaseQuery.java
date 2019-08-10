package com.spring.boot.query.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.spring.boot.entity.base.BaseEntity;
import javafx.beans.DefaultProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: com.spring.boot
 * @description: 基本查询bean
 * @author: zhendong.wu
 * @create: 2018-09-09 17:24
 **/
public class RequestBaseQuery extends BaseQuery {
    @JsonProperty(defaultValue = "10")
   private int size;
    @JsonProperty(defaultValue = "1")
    private int page;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}

