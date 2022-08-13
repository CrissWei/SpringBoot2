package com.example.springboot_mybatis;

import com.example.springboot_mybatis.Dao.BookDao;
import com.example.springboot_mybatis.DoMain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringBootMyBatisApplicationTests {
    //成功链接数据库，找到了， 整合SSM完美结束了
    @Autowired
    private BookDao bookDao;

    @Test //根据ID找数据 【成功】
    void getById(){
        Book book = bookDao.getById(4);
        System.out.println(book);
//Book{id=4, name='柳岩', age=20, sex='女', address='湖南', math=76, english=65}

    }

    @Test//找所有数据 【失败】 ---> 【成功】
    void getAll(){
        List<Book> all = bookDao.getAll();
        System.out.println(all);
    }


    @Test  //根据名字找到数据 【成功】
    void getName(){
        Book ma = bookDao.getByName("马化腾");
        System.out.println(ma);
//Book{id=2, name='马化腾', age=38, sex='男', address='深圳', math=100, english=100}
    }



    @Test //查找id>=5数据 【失败-->成功】
    void getBigId() {
        List<Book> bigId = bookDao.getBigId(5);
        System.out.println(bigId);
    }


    @Test //查找age>=20岁的数据 【成功】
    void getBigAge() {
        List<Book> bigAge = bookDao.getBigAge(20);
        System.out.println(bigAge);
    }


}
