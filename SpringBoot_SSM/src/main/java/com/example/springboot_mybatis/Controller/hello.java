package com.example.springboot_mybatis.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {

    //浏览器输入http://localhost:8080/hello ，会看到 hello cris!
    //如果端口是80，那么直接localhost/hello 就行
    @RequestMapping("/hello")
    public String hi(){
        System.out.println("控制台spring boot 打印\"hello cris! \"...");
        return "hello cris! ";

    }
}
