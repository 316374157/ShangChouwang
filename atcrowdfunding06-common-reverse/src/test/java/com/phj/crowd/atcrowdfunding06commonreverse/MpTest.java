package com.phj.crowd.atcrowdfunding06commonreverse;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.phj.crowd.atcrowdfunding06commonreverse.dao.RoleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 31637
 * @date 2020/7/22 16:57
 */
@SpringBootTest
public class MpTest {

    @Autowired
    RoleMapper roleMapper;

    @Test
    void testGenerator(){
        //1.全局配置
        GlobalConfig  globalConfig = new GlobalConfig();
        globalConfig.setActiveRecord(false) //是否支持AR模式
                .setAuthor("phj") //设置作者
                .setOutputDir(System.getProperty("user.dir")+"/src/main/java") //设置文件生成路径
                .setFileOverride(true) //设置文件是否覆盖（本次生成的是否覆盖上一次生成的）
                .setIdType(IdType.AUTO) //设置主键生成策略
                .setServiceName("%sService") //设置生成的service接口的名字的首字母是否为I，即IBookService，前面的设置生成的名字是BookService
                .setBaseResultMap(true) //生成BaseResultMap
                .setBaseColumnList(true);//生成BaseColumnList
        //2.数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL) //设置数据库类型
                .setDriverName("com.mysql.cj.jdbc.Driver") //设置驱动
                .setUrl("jdbc:mysql://localhost/project_crowd?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8") //设置URL
                .setUsername("root")
                .setPassword("123456");
        //3.策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true)  //是否打开全局大写命名
                .setNaming(NamingStrategy.underline_to_camel)  //数据表名映射实体类名的策略
                .setColumnNaming(NamingStrategy.underline_to_camel)  //数据表字段映射实体类数据的策略
                .setTablePrefix("t_") //设置表名前缀
                .setInclude("t_auth");  //设置要映射的表
        //4.包名策略配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.phj.crowd.atcrowdfunding06commonreverse")  //设置父包名，即统一的包名前缀
                .setMapper("dao")  //设置dao层生成的包名
                .setEntity("entity")  //实体类
                .setService("service")  //service
                .setController("controller")  //控制器
                .setXml("mapper"); //映射文件位置

        //5.整合配置
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(globalConfig)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig)
                .setTemplateEngine(new FreemarkerTemplateEngine());
        //6.执行
        autoGenerator.execute();
    }

    @Test
    void mapperTest(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        roleMapper.addAdminRole(3, list);
    }

}
