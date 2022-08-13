package com.example.springboot_mybatisplus.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot_mybatisplus.DoMain.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentDao extends BaseMapper<Student> {
    //继承这个类之后，里面很多基本的CRUD方法直接提供，无需自己写
}
