package com.example.springboot_mybatis.Dao;

import com.example.springboot_mybatis.DoMain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper //这个接口@Mapper是动态代理，不需要实现类impl去重新方法了
public interface BookDao {

    //【成功】找到了数据
    @Select("select * from student where id = #{id}")//#{id}是形参
    public Book getById(Integer id);

    //自己再测试一个方法试试 【失败】 ---> List<Book> 【成功】
    @Select("select * from student")
    public List<Book> getAll();// 如果是public Book getAll();【失败】

    //【成功】找到数据
    @Select("select * from student where name = #{name}")//#{name}是下面的形参
    public Book getByName(String name);

    //查>=id的数据【失败】 --- >【成功】
    @Select("select * from student where id >=#{id}")
    public List<Book> getBigId(Integer id);


    @Select("select * from student where age >=#{age}")
    public List<Book> getBigAge(Integer age);

}
