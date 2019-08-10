package com.spring.boot.service.impl;
import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.entity.FunctionRuleRef;
import com.spring.boot.entity.ReturnResultRuleRef;
import com.spring.boot.enums.StatusEnum;
import com.spring.boot.mapper.ReturnResultRuleRefMapper;
import com.spring.boot.query.request.ReturnResultAggRequet;
import com.spring.boot.service.IReturnResultRuleRefService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Consumer;

/**
 * <p>
 * 返回结果规则关联 服务实现类
 * </p>
 *
 * @author zhendong.wu
 * @since 2019-05-04
 */
@Service
public class ReturnResultRuleRefServiceImpl extends ServiceImpl<ReturnResultRuleRefMapper, ReturnResultRuleRef> implements IReturnResultRuleRefService {
        @Override
        public Page<ReturnResultRuleRef> selectPageByReturnResultRuleRef(Page<ReturnResultRuleRef> pagePg, ReturnResultRuleRef obj) {
        pagePg.setRecords( this.baseMapper.selectPageByReturnResultRuleRef(pagePg,obj));
        return pagePg;
        }

        @Override
        public List<ReturnResultRuleRef> bulid(String ruleCode, ReturnResultAggRequet[] returnResultAggRequet) {
                List<ReturnResultRuleRef> returnResultRuleRefs=new ArrayList<>();
                if(returnResultAggRequet==null||returnResultAggRequet.length==0){
                        return returnResultRuleRefs;
                }
                Arrays.stream(returnResultAggRequet).forEach(new Consumer<ReturnResultAggRequet>() {
                        @Override
                        public void accept(ReturnResultAggRequet returnResultAggRequet) {
                                ReturnResultRuleRef returnResultRuleRef=new ReturnResultRuleRef();
                                returnResultRuleRef.setCode(returnResultAggRequet.getCode());
                                if(returnResultAggRequet.getCode()!=null&&!"".equals(returnResultAggRequet.getCode())){

                                }else{
                                        returnResultRuleRef.setRuleCode(ruleCode);
                                        returnResultRuleRef.setStatus(StatusEnum.TRUE.name());
                                        returnResultRuleRef.setText(returnResultAggRequet.getText());
                                        returnResultRuleRef.setValue(returnResultAggRequet.getValue());
                                }

                                returnResultRuleRefs.add(returnResultRuleRef);
                        }
                });
                return returnResultRuleRefs;
        }
        @Override
        public List<ReturnResultAggRequet> buildByReturnResultRuleRef(List<ReturnResultRuleRef> returnResultRuleRefs) {
                List<ReturnResultAggRequet> lis=new ArrayList<>();
                returnResultRuleRefs.stream().forEach(new Consumer<ReturnResultRuleRef>() {
                        @Override
                        public void accept(ReturnResultRuleRef returnResultRuleRef) {
                                ReturnResultAggRequet returnResultAggRequet=new ReturnResultAggRequet();
                                returnResultAggRequet.setCode(returnResultRuleRef.getCode());
                                returnResultAggRequet.setText(returnResultRuleRef.getText());
                                returnResultAggRequet.setValue(returnResultRuleRef.getValue());
                                lis.add(returnResultAggRequet);

                        }
                });
                return lis;
        }

        @Override
        public void createUpdateBatch(String ruleCode, List<ReturnResultRuleRef> returnResultRuleRefs) {
                List<ReturnResultRuleRef> returnResultRuleRefDBs=selectByRuleCode(ruleCode,StatusEnum.TRUE.name());
                List<ReturnResultRuleRef> lisCreate=new ArrayList<>();
                List<ReturnResultRuleRef> lisUpdate=new ArrayList<>();
                Map<String,ReturnResultRuleRef> mapUpdate=new HashMap<>();
                if(returnResultRuleRefs!=null&&!returnResultRuleRefs.isEmpty()){

                        returnResultRuleRefs.forEach(new Consumer<ReturnResultRuleRef>() {
                                @Override
                                public void accept(ReturnResultRuleRef returnResultRuleRef) {
                                        if(returnResultRuleRef.getCode()==null||"".equals(returnResultRuleRef.getCode())){
                                                lisCreate.add(returnResultRuleRef);
                                        }else{
                                                mapUpdate.put(returnResultRuleRef.getCode(),returnResultRuleRef);
                                        }
                                }
                        });
                }
                if(returnResultRuleRefDBs!=null&&!returnResultRuleRefDBs.isEmpty()){
                        returnResultRuleRefDBs.forEach(new Consumer<ReturnResultRuleRef>() {
                                @Override
                                public void accept(ReturnResultRuleRef returnResultRuleRef) {
                                        ReturnResultRuleRef returnResultRuleRefTmp=  mapUpdate.get(returnResultRuleRef.getCode());
                                        if(returnResultRuleRefTmp!=null){
                                                // BeanUtil.copyPropertiesIgnoreNull();
                                        }else{
                                                returnResultRuleRef.setStatus(StatusEnum.FALSE.name());
                                                lisUpdate.add(returnResultRuleRef);
                                        }

                                }
                        });
                }
                if(!lisCreate.isEmpty()){
                        insertBatch(lisCreate);
                }

                if(!lisUpdate.isEmpty()){
                        updateBatchById(lisUpdate);
                }
        }
        @Override
        public List<ReturnResultRuleRef> selectByRuleCode(String ruleCode, String status) {
                return baseMapper.selectByRuleCode(ruleCode,status);
        }

        @Override
        public List<ReturnResultRuleRef> selectByRuleCode(String ruleCode) {
                return selectByRuleCode(ruleCode,StatusEnum.TRUE.name());
        }


}
