package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//要打开MySql 服务，连接数据库
@SpringBootApplication
public class SpringBootMyBatisPlusApplication {

    public static void main(String[] args) {
        //args是可以修改的临时变量，如port可以修改，如果不传入args参数，就不能修改port等配置了
        //SpringApplication.run(SpringBootMyBatisPlusApplication.class, args);
        SpringApplication.run(SpringBootMyBatisPlusApplication.class);
    }

}
