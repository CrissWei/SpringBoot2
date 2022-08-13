import com.Dao.BookDao;
import com.Service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class APPXML {
    public static void main(String[] args) {
        //获取IOC容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("ApplicationContext.xml");

        //获取bean,参数是XML里面自己定义的名字
        BookDao bd = (BookDao) ac.getBean("BookDao");
        //用容器来调用方法
        bd.save();

        System.out.println("=========");

        //获取bean
        BookService bs = (BookService) ac.getBean("BookService");
        //用容器来调用方法
        bs.save();
    }
}
