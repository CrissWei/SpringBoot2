package com.example;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot_mybatisplus.Dao.BookDao;

import com.example.springboot_mybatisplus.Dao.StudentDao;
import com.example.springboot_mybatisplus.DoMain.Book;
import com.example.springboot_mybatisplus.DoMain.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
/***
*@Data 2022/7/27
Book{id=1, name='马云', age=99, sex='男', address='杭州', math=66, english=78}
Book{id=2, name='马化腾', age=38, sex='男', address='深圳', math=100, english=100}
Book{id=3, name='马景涛', age=55, sex='男', address='香港', math=56, english=77}
Book{id=4, name='柳岩', age=20, sex='女', address='湖南', math=76, english=65}
Book{id=5, name='柳青', age=20, sex='男', address='湖南', math=86, english=null}
Book{id=6, name='刘德华', age=57, sex='男', address='香港', math=99, english=99}
Book{id=7, name='马德', age=22, sex='女', address='香港', math=99, english=99}
Book{id=8, name='德坞西亚', age=18, sex='男', address='南京', math=56, english=65}
* */
@SpringBootTest
class SpringBootMyBatisPlusApplicationTests {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private StudentDao studentDao;

    @Test//【MyBatis自己的方法， 成功】
    void test1() {
        List<Book> all = bookDao.getAll();
        //System.out.println(all);// 不分行，不美观不方便
        all.forEach(System.out::println);//遍历分行，看着美观方便
    }

    @Test//【18<=age<=30】
    void test1_round() {
        List<Book> all = bookDao.getRoundAge(18,30);
        all.forEach(System.out::println);//遍历分行，看着美观方便
    }

    @Test//select * from Student where name like '%马%';
    //select * from Student where name like '%#{name}%' 【为什么这不行啊】
    void test1_like() {
        List<Book> ma = bookDao.getLikeName("马");
        System.out.println(ma);
    }



    @Test//【MyBatisPlus自动的方法， 成功】 类似什么的getAll()，查询所有
    void test2() {
        List<Student> students = studentDao.selectList(null);
        System.out.println(students); //不分行
    }

    @Test//查询所有数据, select * from student
    void test3() {
        List<Student> students = studentDao.selectList(null);
        students.forEach(System.out::println);//遍历，分行
    }
    @Test//根据id查数据
    void test4(){
        Student student = studentDao.selectById(5);
        System.out.println(student);
    }

    @Test//【成功添加insert数据】
    void test5(){
        Student student = new Student(98,"张三",24,"男","成都",100,99);
        studentDao.insert(student);
    }

    @Test//【成功添加delete数据】
    void test6(){
        studentDao.deleteById(98);
    }

    @Test//写的了就update更新，不写的就不变
    void test7(){
        Student stu = new Student();
        stu.setId(98);//id=98是张三
        stu.setAge(666);
        stu.setName("张33");
        studentDao.updateById(stu);
    }



    @Test //分页查询 limit , select * from student limit 1,10;  代表查第1页，每页10条数据
    void test8(){//yml里面开启log日志：SELECT id,name,age,sex,address,math,english FROM student
        IPage page = new Page();
        studentDao.selectPage(page,null);

        System.out.println("当前页码值:"+page.getCurrent());
        System.out.println("每页显示数:"+page.getSize());
        System.out.println("一基多少页:"+page.getPages());
        System.out.println("一共多少条数据:"+page.getTotal());
        System.out.println("数据:"+page.getRecords());
    }

    @Test//条件查询 select * from student where age<30;

    void test9(){
        QueryWrapper qw = new QueryWrapper();
        qw.lt("age",30); //lt 意思是less than ,gt 是greater than
        List list = studentDao.selectList(qw);
        System.out.println(list);
    }

    @Test//条件查询 select * from student where age>30;
    void test10(){
        QueryWrapper qw = new QueryWrapper();
        qw.gt("age",30);
        List list = studentDao.selectList(qw);
        System.out.println(list);
    }
    @Test//条件查询 select * from student where age<30;
    void test11(){
        LambdaQueryWrapper<Student> qw = new LambdaQueryWrapper<>();
        qw.lt(Student::getAge,30);
        List<Student> list = studentDao.selectList(qw);
        System.out.println(list);
    }


}
