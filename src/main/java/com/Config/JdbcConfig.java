package com.Config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class JdbcConfig {
    //1.定义一个方法获得要管理的对象
    //2.添加@Bean，表示当前方法的返回值是一个bean

    @Bean
    public DataSource datasource() {
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Drier");
        ds.setUrl("jdbc : mysql : //localhost: 3306/spring_db");
        ds.setUsername("root");
        ds.setPassword("root");
        return ds;
    }

}
