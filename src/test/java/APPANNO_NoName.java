import com.Config.SpringConfig;
import com.Dao.BookDao;
import com.Service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class APPANNO_NoName {
    public static void main(String[] args) {
        //获取IOC容器
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);

        //获取bean,参数接口名字
        BookDao bd = ac.getBean(BookDao.class);
        bd.save();
        System.out.println(bd);

        //获取bean，参数接口名字
        BookService bs = ac.getBean(BookService.class);
        System.out.println(bs);
    }
}
