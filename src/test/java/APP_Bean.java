import com.Config.JdbcConfig;
import com.Config.SpringConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;

public class APP_Bean {
    public static void main(String[] args) {
        //获取IOC容器
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfig.class);
        //获取第三方bean
        DataSource ds = ac.getBean(DataSource.class);
        System.out.println(ds);
    }
}
