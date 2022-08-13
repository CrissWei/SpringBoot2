import com.Config.SpringConfig;
import com.Dao.BookDao;
import com.Service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class APPANNO {
    public static void main(String[] args) {
        //获取IOC容器
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
        //获取bean,参数是@Repository("BookDao") 里面自己定义的名字
        BookDao bd = (BookDao) ac.getBean("BookDao");
        bd.save(); //有了 @Autowired就可以了
        System.out.println(bd);

        //获取bean，参数是@Service("BookService") 里面自己定义的名字
        BookService bs = (BookService) ac.getBean("BookService");
        bs.save();
        System.out.println(bs);
    }
}
