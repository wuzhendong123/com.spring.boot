package com.spring.boot;

import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import org.junit.Test;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 测试生成代码
 * </p>
 *
 * @author K神
 * @date 2017/12/18
 */
public class GeneratorServiceEntity {
    public static void main(String[] args) {
        String path="E:\\soft\\Generator";
        String packagePath="com.spring.boot";
        String packagePathStr="\\"+packagePath.replaceAll("\\.","\\\\");

        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(path);
        gc.setFileOverride(true);
        gc.setActiveRecord(true);
        // XML 二级缓存
        gc.setEnableCache(false);
        // XML ResultMap
        gc.setBaseResultMap(true);
        // XML columList
        gc.setBaseColumnList(true);
        gc.setAuthor("zhendong.wu");

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        // gc.setMapperName("%sDao");
        // gc.setXmlName("%sDao");
        // gc.setServiceName("MP%sService");
        // gc.setServiceImplName("%sServiceDiy");
        // gc.setControllerName("%sAction");
        mpg.setGlobalConfig(gc);


        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert() {
            // 自定义数据库表字段类型转换【可选】
            @Override
            public DbColumnType processTypeConvert(String fieldType) {
                System.out.println("转换类型：" + fieldType);
                // 注意！！processTypeConvert 存在默认类型转换，如果不是你要的效果请自定义返回、非如下直接返回。
                return super.processTypeConvert(fieldType);
            }
        });
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("wuzhendong");
        dsc.setPassword("wuzhendong");
        dsc.setUrl("jdbc:mysql://192.168.16.160:3306/test?useUnicode=true&characterEncoding=utf8&autoReconnect=true&failOverReadOnly=false");
        mpg.setDataSource(dsc);

        // 策略配置 实体设置
        StrategyConfig strategy = new StrategyConfig();
        // strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意
        // strategy.setTablePrefix(new String[] { "tlog_", "tsys_" });//
        // 此处可以修改为您的表前缀NamingStrategy.underline_to_camel
        // 表名生成策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 需要生成的表
        strategy.setInclude(
                new String[] { "sys_operator_role_ref","sys_role","sys_role_permissions_ref","sys_role_menu_ref","sys_permissions"});
        strategy.setSuperEntityClass("com.spring.boot.entity.base.BaseEntity");
        strategy.setSuperEntityColumns(new String[] { "code", "create_time","optimistic","update_time" }); //写的是数据库字段名

        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(packagePath);
        //pc.setModuleName("entity");
        mpg.setPackageInfo(pc);

        // 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无】
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>(5);
                map.put("abc", getConfig().getGlobalConfig().getAuthor() + "-mp");
                setMap(map);
            }
        };
        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();

     /*   // 自定义 xxList.jsp 生成

        focList.add(new FileOutConfig("/template/list.jsp.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return path+packagePathStr+"/" + tableInfo.getEntityName() + ".jsp";
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
*/


        // 自定义 mapper.xml 生成
        focList.add(new FileOutConfig("/templates/generator/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return path+packagePathStr+"/xml/" + tableInfo.getEntityName() + "Mapper.xml";
            }
        });
        focList.add(new FileOutConfig("/templates/generator/controller.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return path+packagePathStr+"/web/" + tableInfo.getEntityName() + "Controller.java";
            }
        });
        focList.add(new FileOutConfig("/templates/generator/mapper.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return path+packagePathStr+"/mapper/" + tableInfo.getEntityName() + "Mapper.java";
            }
        });
        focList.add(new FileOutConfig("/templates/generator/service.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return path+packagePathStr+"/service/I" + tableInfo.getEntityName() + "Service.java";
            }
        });
        focList.add(new FileOutConfig("/templates/generator/serviceImpl.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return path+packagePathStr+"/service/impl/" + tableInfo.getEntityName() + "ServiceImpl.java";
            }
        });
        focList.add(new FileOutConfig("/templates/generator/entity.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return path+packagePathStr+"/entity/" + tableInfo.getEntityName() + ".java";
            }
        });



        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 关闭默认 xml 生成，调整生成 至 根目录
        TemplateConfig tc = new TemplateConfig();
        // 如果设置FileOutConfig  设置为null 不再进行mapper生成，
        tc.setXml(null);
        tc.setController(null);
        tc.setService(null);
        tc.setServiceImpl(null);
        tc.setMapper(null);
        tc.setEntity(null);
        mpg.setTemplate(tc);
        // 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/templates 下面内容修改，
        // 放置自己项目的 src/main/resources/templates 目录下, 默认名称一下可以不配置，也可以自定义模板名称
        // TemplateConfig tc = new TemplateConfig();
        // tc.setController("...");
        // tc.setEntity("...");
        // tc.setMapper("...");
        // tc.setXml("...");
        // tc.setService("...");
        // tc.setServiceImpl("...");
        // 如上任何一个模块如果设置 空 OR Null 将不生成该模块。
        // mpg.setTemplate(tc);
        // 执行生成
        mpg.execute();

        // 打印注入设置【可无】
        System.err.println(mpg.getCfg().getMap().get("abc"));
    }
    //@Test
    public void generateCode() {
        String packageName = "com.spring.boot";
        boolean serviceNameStartWithI = false;//user -> UserService, 设置成true: user -> IUserService
        generateByTables(serviceNameStartWithI, packageName, "student");
    }

    private void generateByTables(boolean serviceNameStartWithI, String packageName, String... tableNames) {
        GlobalConfig config = new GlobalConfig();
        String dbUrl = "jdbc:mysql://192.168.16.160:3306/test?useUnicode=true&characterEncoding=utf8&autoReconnect=true&failOverReadOnly=false";
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl(dbUrl)
                .setUsername("wuzhendong")
                .setPassword("wuzhendong")
                .setDriverName("com.mysql.jdbc.Driver");
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setCapitalMode(true)
                .setEntityLombokModel(false)
                .setDbColumnUnderline(true)
                .setNaming(NamingStrategy.underline_to_camel)
                .setInclude(tableNames);//修改替换成你需要的表名，多个表名传数组
        config.setActiveRecord(false)
                .setAuthor("zhendong.wu")
                .setOutputDir("E:\\soft\\Generator")
                .setFileOverride(true);
        if (!serviceNameStartWithI) {
            config.setServiceName("%sService");
        }
        new AutoGenerator().setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(
                        new PackageConfig()
                                .setParent(packageName)
                                .setController("controller")
                                .setEntity("entity")
                ).execute();
    }

    private void generateByTables(String packageName, String... tableNames) {
        generateByTables(true, packageName, tableNames);
    }
}
