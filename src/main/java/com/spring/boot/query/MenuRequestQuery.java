package com.spring.boot.query;

import com.spring.boot.query.base.BaseQuery;
import com.spring.boot.query.base.RequestBaseQuery;

import java.util.Date;

/**
 * @program: com.spring.boot
 * @description: 菜单查询bean
 * @author: zhendong.wu
 * @create: 2018-09-09 17:23
 **/
public class MenuRequestQuery extends RequestBaseQuery {
    private String name;
    private Date createTimeStart;
    private Date createTimeEnd;
    private String status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTimeStart() {
        return createTimeStart;
    }

    public void setCreateTimeStart(Date createTimeStart) {
        this.createTimeStart = createTimeStart;
    }

    public Date getCreateTimeEnd() {
        return createTimeEnd;
    }

    public void setCreateTimeEnd(Date createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
