import com.Dao.BookDao;
import com.Dao.imp.BookDaoImp;
import com.Service.BookService;
import com.Service.imp.BookServiceImp;

public class APP {
    public static void main(String[] args) {

        BookDao bd = new BookDaoImp();
        bd.save();

        System.out.println("=======");

        BookService bs = new BookServiceImp();
        bs.save();
    }
}
