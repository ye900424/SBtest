package com.tmp;

import lombok.Data;
import org.apache.ibatis.session.ExecutorType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangh on 2016/02/29.
 * Author : zhangh
 * Date : 2016/02/29
 * Email : zhangh@dtdream.com
 * Readme : com.dtdream.vanyar.boot.mybatis
 */
@Data
public class MybatisProperties extends Properties {
    public static final String MYBATIS_PREFIX = "mybatis";
    /**
     * Config file path.
     */
    private String config;

    /**
     * Location of mybatis mapper files.
     */
    private String[] mapperLocations;

    /**
     * Package to scan domain objects.
     */
    private String typeAliasesPackage;

    /**
     * Classes of alias. (More preferred than {@link #typeAliasesPackage})
     */
    private Class<?>[] typeAliases;

    /**
     * Package to scan handlers.
     */
    private String typeHandlersPackage;

    /**
     * Check the config file exists.
     */
    private boolean checkConfigLocation = false;

    /**
     * Execution mode.
     */
    private ExecutorType executorType = ExecutorType.SIMPLE;

    /**
     * Configuration for Datasource.
     */
    private String url = null;
    private String username;
    private String password;
    private String driverClassName;
    private Boolean testOnBorrow = true;
    private String validationQuery = "SELECT 1";
    private int validationQueryTimeout = 1000;
    private int initialSize = 5;
    private int maxActive = 20;
    private int minIdle = 0;
    private int maxWait = 60000;
    private boolean poolPreparedStatements = Boolean.TRUE;
    private int maxPoolPreparedStatementPerConnectionSize = 100;

    /**
     * references for current mybatis.
     */
    private String dataSourceRef = null;
    private String transactionManagerRef = null;
    private String sqlSessionFactoryRef = null;
    private String sqlSessionTemplateRef = null;
    /**
     * names for current mybatis.
     */
    private String dataSourceName = "dataSource";
    private String transactionManagerName = "transactionManager";
    private String sqlSessionFactoryName = "sqlSessionFactory";
    private String sqlSessionTemplateName = "sqlSessionTemplate";

    /**
     * mapper scan base packages.
     */
    private List<String> mapperScan = null;

    public MybatisProperties() {
        this.mapperScan = new ArrayList<>(1);
        this.mapperScan.add("com.dtdream.vanyar.**.dao");
    }
}
