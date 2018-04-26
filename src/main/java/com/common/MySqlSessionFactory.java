package com.common;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.concurrent.locks.LockSupport;

/**
 * Created by C.A.O on 2018/4/12.
 */
@Configuration
public class MySqlSessionFactory {

    @Autowired
    private MyBatisConfig config;

    @Autowired
    private DataSource dataSource;



    /**
     * 根据数据源创建SqlSessionFactory
     */
    @Bean
    public SqlSession sqlSession() throws Exception{
        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        fb.setDataSource(dataSource);//指定数据源(这个必须有，否则报错)
        //下边两句仅仅用于*.xml文件，如果整个持久层操作不需要使用到xml文件的话（只用注解就可以搞定），则不加
        fb.setTypeAliasesPackage(config.getTypeAliasesPackage());//指定基包
        fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(config.getMapperLocations()));//指定xml文件位置

        return fb.getObject().openSession();
    }

    @Bean
    public SqlSession sqlSessionTemplate() throws Exception{
        System.out.println("###初始化sqlSessionTemplate");
        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        fb.setDataSource(dataSource);//指定数据源(这个必须有，否则报错)
        //下边两句仅仅用于*.xml文件，如果整个持久层操作不需要使用到xml文件的话（只用注解就可以搞定），则不加
        fb.setTypeAliasesPackage(config.getTypeAliasesPackage());//指定基包
        fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(config.getMapperLocations()));//指定xml文件位置

        SqlSessionFactory sqlSessionFactory = fb.getObject();
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
        return sqlSessionTemplate;
    }
}
