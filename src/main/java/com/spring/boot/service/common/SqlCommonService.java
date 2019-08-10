package com.spring.boot.service.common;

import com.baomidou.mybatisplus.plugins.Page;
import com.spring.boot.config.ds.context.GenMapperBuilderAssistant;
import com.spring.boot.entity.QueryFunction;
import org.apache.ibatis.builder.MapperBuilderAssistant;
import org.apache.ibatis.executor.keygen.NoKeyGenerator;
import org.apache.ibatis.mapping.*;
import org.apache.ibatis.scripting.LanguageDriver;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @program: com.spring.boot
 * @description:
 * @author: zhendong.wu
 * @create: 2019-04-20 19:07
 **/
@Component
public class SqlCommonService implements InitializingBean {
    protected LanguageDriver languageDriver;
    protected MapperBuilderAssistant builderAssistant;
    Configuration  configuration;
    @Autowired
    protected SqlSessionFactory sqlSessionFactory;
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    private String pre="manual_sql";
    public MappedStatement bulid(String sql,String code ){

      return  create(sql,code);
    }
    public MappedStatement reset(String sql,String code ){
        remove(code);
        return create(sql,code);
    }
    private void remove(String code){
        String statementName =bulidSqlId(code);
        MappedStatement mappedStatement=  getMappedStatement(statementName);
        if(mappedStatement!=null){
            configuration.getMappedStatements().remove(mappedStatement);
        }
    }
    private MappedStatement create(String sql,String code ){
        if(sql.indexOf("<script>")<=-1){
            StringBuilder sbl=new StringBuilder();
            sbl.append("<script>").append(sql).append("</script>");
            sql=sbl.toString();
        }
        SqlSource sqlSource = this.languageDriver.createSqlSource(this.configuration, sql, Map.class);
        return  this.addSelectMappedStatement(code,  sqlSource, Map.class);
    }
    public String bulidSqlId(String id ){
         return  pre+ "_" + id;
    }

    private MappedStatement addSelectMappedStatement( String id, SqlSource sqlSource, Class<?> resultType) {

        return this.addMappedStatement( id, sqlSource, SqlCommandType.SELECT, (Class)null, (String)null, resultType,  (String)null, (String)null);
    }
    private MappedStatement addMappedStatement( String id, SqlSource sqlSource, SqlCommandType sqlCommandType, Class<?> parameterClass, String resultMap, Class<?> resultType,  String keyProperty, String keyColumn) {
        String statementName =bulidSqlId(id);

          MappedStatement mappedStatement=  getMappedStatement(statementName);
            if(mappedStatement!=null){
                return mappedStatement;
            }
             boolean isSelect = false;
            if (sqlCommandType == SqlCommandType.SELECT) {
                isSelect = true;
            }
            return this.builderAssistant.addMappedStatement(statementName, sqlSource, StatementType.PREPARED, sqlCommandType, (Integer)null, (Integer)null, (String)null, parameterClass, resultMap, resultType, (ResultSetType)null, !isSelect, isSelect, false, null, keyProperty, keyColumn, this.configuration.getDatabaseId(), this.languageDriver, (String)null);
    }

    private MappedStatement getMappedStatement(String statementName){
        try{
            MappedStatement mappedStatement=  configuration.getMappedStatement(statementName);
            if(mappedStatement!=null){
                return mappedStatement;
            }
        }catch (Exception e){
            return null;
        }
            return null;
    }

    public Page<QueryFunction> selectPageByCode(String code,Page<QueryFunction> pagePg, Object map) {
        pagePg.setRecords( sqlSessionTemplate.selectList(this.bulidSqlId(code),map,pagePg));
        return pagePg;
    }
    @Override
    public void afterPropertiesSet() throws Exception {
          configuration= sqlSessionFactory.getConfiguration();
        languageDriver= configuration.getDefaultScriptingLanguageInstance();
       builderAssistant=  new GenMapperBuilderAssistant(configuration, null);
        builderAssistant.setCurrentNamespace(pre);
    }
    public Logger log = LoggerFactory.getLogger(getClass());

}
