package com.spring.boot.service.system;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.spring.boot.entity.ParamHtmlTemple;
import com.spring.boot.service.IParamHtmlTempleService;
import com.spring.boot.service.IQueryFunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: com.spring.boot
 * @description:
 * @author: zhendong.wu
 * @create: 2019-04-21 09:16
 **/
@Service("paHtTmService")
public class PaHtTmService {
    @Autowired
    private IParamHtmlTempleService paramHtmlTempleService;

    public List<ParamHtmlTemple> findAll(){
        EntityWrapper entityWrapper=  new EntityWrapper<ParamHtmlTemple>();
        entityWrapper.where("status={0}","TRUE");
     return   paramHtmlTempleService.selectList(entityWrapper);
    }
}
