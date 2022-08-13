import com.Config.SpringConfig;
import com.Dao.BookDao;
import com.Dao.imp.BookDaoImp;
import com.Service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class APP_AOP {
    public static void main(String[] args) {
        //获取IOC容器
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);

        //获取bean，参数接口名字
        BookDao bd = ac.getBean(BookDao.class);
        //调用接口方法
        //bd.save();//万次执行共消耗 120 ms

        bd.update();//有切面增强功能
        //bd.select();//有切面增强功能
        //bd.delete();//无
    }
}
