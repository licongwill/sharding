/**
 * Copyright(c) 1999-2004 Alibaba.com, All Rights Reserved. Project: project.config Author: houzi Createdate: 下午1:26:17
 * Version: 1.0
 */
package com.lic.sharding.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.pool.DruidDataSource;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Description:
 * @project project.config
 * @class DruidConfig.java
 * @author houzi
 * @version 1.0
 * @date 2018年11月10日 下午1:26:17
 */
@Configuration
@EnableConfigurationProperties(DruidProperties.class)
public class DruidConfig {

    @Autowired
    private DruidProperties druidProperties;

    @Bean
    public DataSource druidDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(druidProperties.getDriverClassName());
        dataSource.setUrl(druidProperties.getUrl());
        dataSource.setUsername(druidProperties.getUsername());
        dataSource.setPassword(druidProperties.getPassword());
        dataSource.setMaxActive(druidProperties.getMaxActive());
        dataSource.setMinIdle(druidProperties.getMinIdle());
        dataSource.setMaxWait(druidProperties.getMaxWait());
        dataSource.setValidationQuery(druidProperties.getValidationQuery());
        dataSource.setTimeBetweenEvictionRunsMillis(druidProperties.getTimeBetweenEvictionRunsMillis());
        dataSource.setMinEvictableIdleTimeMillis(druidProperties.getMinEvictableIdleTimeMillis());
        dataSource.setProxyFilters(Lists.newArrayList(statFilter()));
        return dataSource;
    }

    @Bean
    public Filter statFilter() {

        StatFilter filter = new StatFilter();
        filter.setSlowSqlMillis(3000);
        filter.setLogSlowSql(true);
        filter.setMergeSql(true);
        return filter;
    }
}
