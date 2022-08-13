import com.Config.SpringConfig;
import com.Dao.BookDao;
import com.Service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppAnno {
    public static void main(String[] args) {
        //获取IOC容器
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
        //获取bean,参数是XML里面自己定义的名字
        BookDao bd = (BookDao) ac.getBean(BookDao.class);
        //用容器来调用方法
        bd.save();
        System.out.println(bd);

        System.out.println("=========");

        //获取bean
        //BookService bs = (BookService) ac.getBean("BookService");
        BookService bs = (BookService) ac.getBean(BookService.class);
        //用容器来调用方法
        bs.save();
        System.out.println(bs);
    }
}
