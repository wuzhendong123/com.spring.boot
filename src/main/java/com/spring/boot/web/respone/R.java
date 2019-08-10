package com.spring.boot.web.respone;

import com.baomidou.mybatisplus.plugins.Page;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: com.spring.boot
 * @description: 返回信息封装
 * @author: zhendong.wu
 * @create: 2019-03-16 15:28
 **/
public class R extends HashMap<String,Object> {

    public static R ok(){

        return bulid("code","0").put("msg","操作成功");
    }
    public static R okList(Page page){

        return ok().put("rows",page.getRecords()).put("total",page.getTotal());
    }

    private static R bulid(String code,String message){

        return new R().put(code,message);
    }
    public static R error(){

        return error("未知异常");
    }
    public static R error(String code,String message){

        return bulid("code",code).put("msg",message);
    }
    public static R error(String message){

        return error("9999",message);
    }

    @Override
    public R put(String key, Object value) {
         super.put(key, value);
         return this;

    }
}

