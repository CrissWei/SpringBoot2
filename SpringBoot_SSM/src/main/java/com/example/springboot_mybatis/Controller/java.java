package com.example.springboot_mybatis.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class java {

    //浏览器输入http://localhost:8080/java ，会看到 hello java!
    //如果端口是80，那么直接localhost/java 就行
    @RequestMapping("/java")
    public String hi(){
        System.out.println("控制台spring boot 打印\"hello java! \"...");
        return "hello java! ";

    }
}
