package com.Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Configuration //代表是配置类
@ComponentScan("com")
@Import(JdbcConfig.class)//导入Jdbc类
@EnableAspectJAutoProxy//注解开发AOP切面
public class SpringConfig {
}
