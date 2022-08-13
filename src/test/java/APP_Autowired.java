import com.Config.SpringConfig;
import com.Dao.BookDao;
import com.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class APP_Autowired {
    public static void main(String[] args) {
        //获取IOC容器
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);

        //获取bean，参数接口名字
        BookService bs = ac.getBean(BookService.class);
        bs.save();
        //@Autowired //依赖注入  在private BookDao bd;上面

    }
}
