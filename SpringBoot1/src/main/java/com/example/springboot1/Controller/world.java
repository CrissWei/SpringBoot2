package com.example.springboot1.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class world {

    //浏览器输入http://localhost:8080/world ，会看到 hello world!
    @RequestMapping("/world")
    public String hi(){
        System.out.println("控制台spring boot 打印 \"hello world! \"...");
        return "hello world! ";

    }
}
