package com.Dao.imp;

import com.Dao.BookDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

//@Component
//@Repository("BookDao") //("BookDao"), BookDao是一个我取的名字
@Repository
@Scope
public class BookDaoImp implements BookDao {

    @Value("张维666") //简单赋值
    private String name;
    @Override
    public void save() {
        long start = System.currentTimeMillis();
        //万次执行效率。看时间
        for (int i = 0; i < 100; i++) {
            System.out.println("book dao save....."+name);
        }
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println("共消耗 "+time+" ms");
    }

    //以下方法专门为了测试AOP面向切面编程
    @Override
    public void update() {
        System.out.println("book dao update.....");
    }
    @Override
    public void delete() {
        System.out.println("book dao delete.....");
    }
    @Override
    public void select() {
        System.out.println("book dao select.....");
    }
}
