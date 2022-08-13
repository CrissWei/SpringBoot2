package com.example.springboot_mybatisplus.DoMain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data  //加入这个注解，相当于getter, setter , toString等等，不包含空参和全参构造
/*
@Getter
@Setter
@ToString
@EqualsAndHashCode
-----
@NoArgsConstructor
@AllArgsConstructor
*/

@TableName("student")
public class Student2_Lombok {
    @TableId(type = IdType.AUTO)//自动生成id
    private Integer id;
    private String name;
    private Integer age;
    private String sex;
    private String address;
    private Integer math;
    //private Integer english;


    //改字段名称，和db1里面的表的字段对应起来,select = false表示这个不能被查询，一般是密码
    @TableField(value = "english",select = false)

    private Integer cris;

    //说明这个属性值online不在table里面查询，只在idea里面使用
    @TableField(exist = false)
    private Integer online;



}
