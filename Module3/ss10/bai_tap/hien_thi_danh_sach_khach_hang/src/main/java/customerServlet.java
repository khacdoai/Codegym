import com.example.hien_thi_danh_sach_khach_hang.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/Customer-servlet")
public class customerServlet extends HttpServlet {
   private static List<Customer> list = new ArrayList<>();
   static {
       list.add (new Customer("Nguyễn Văn Hoàn","1983-03--03","Hà Nội","<img src=\"![](../../../img/anh1.jpg)\">"));
       list.add(new Customer("Trần văn Vững","2003-09-09","Quảng Bình","<img src=\"![](../../../img/anh1.jpg)\">"));
       list.add(new Customer("Nguyễn Văn Tiến Đạt","2003-07-07","Quảng Bình","<img src=\"![](../../../img/anh1.jpg)\">"));
       list.add(new Customer("Trần Anh Hoàng","2002-06-06","Quảng Bình","<img src=\"![](../../../img/anh1.jpg)\">"));
       list.add(new Customer("Trần Văn Hiếu","2003-05-05","Quảng Bình","<img src=\"![](../../../img/anh1.jpg)\">"));
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setAttribute("list",list);
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/customer.jsp");
    requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
