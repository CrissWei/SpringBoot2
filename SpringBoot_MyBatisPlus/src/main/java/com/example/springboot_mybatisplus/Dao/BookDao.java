package com.example.springboot_mybatisplus.Dao;

import com.example.springboot_mybatisplus.DoMain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper //这个接口@Mapper是动态代理，不需要实现类impl去重新方法了
public interface BookDao {

    //【成功】找到了数据
    @Select("select * from Student where id = #{id}")//#{id}是形参
    public Book getById(Integer id);

    //自己再测试一个方法试试 【失败】 ---> List<Book> 【成功】
    @Select("select * from student") //表名不区分大小写：student Student都行
    public List<Book> getAll();// 如果是public Book getAll();【失败】

    //【成功】找到数据
    @Select("select * from Student where name = #{name}")//#{name}是下面的形参
    public Book getByName(String name);

    //查>=id的数据【失败】 --- >【成功】
    @Select("select * from Student where id >=#{id}")
    public List<Book> getBigId(Integer id);

    //根据age条件查询
    @Select("select * from Student where age >=#{age}")
    public List<Book> getBigAge(Integer age);


    //select * from Student where age >=age and age<=age2
    @Select("select * from Student where age >=#{age} and age<=#{age2}")
    public List<Book> getRoundAge(Integer age,Integer age2);


    //select * from Student where name like '%马%'; 为什么不行呢？
    @Select("select * from Student where name like '%#{name}%'")
    public List<Book> getLikeName(String name);


}
