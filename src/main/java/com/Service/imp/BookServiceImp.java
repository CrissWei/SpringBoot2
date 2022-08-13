package com.Service.imp;

import com.Dao.BookDao;
import com.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Component 通用
@Service("BookService")//("BookService") 专用service层,BookService是一个我取的名字
public class BookServiceImp implements BookService {
    //多态 ，目前还是new所以耦合度高，后期改进不能使用new
    //private BookDao bd = new BookDaoImp();

    @Autowired //依赖注入
    private BookDao bd;

/* 有了上面的 @Autowired 可以删掉setter注入
    //删掉 new BookDaoImp()， 提供对应的set方法
    public void setBd(BookDao bd) {
        this.bd = bd;
    }
*/

    @Override
    public void save() {
        System.out.println("book service save.......");
        bd.save();// book dao save.....业务层调用数据层方法
    }
}
