import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "calculatorDiscountServlet", value = "/calculatorDiscount")
public class calculatorDiscountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ProductDesciption = request.getParameter("ProductDesciption");
        float ListPrice = Float.parseFloat(request.getParameter("ListPrice"));
        float DiscountPercent = Float.parseFloat(request.getParameter("DiscountPercent"));

        float discount = (float) ( DiscountPercent * 0.01);
        float discountPrice = ListPrice -discount;

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1> Product description: " + ProductDesciption + "</h1>");
        writer.println("<h1> Discount Amount: " + discount + "</h1>");
        writer.println("<h1> Discount Price: " + discountPrice + "</h1>");
        writer.println("</html>");

    }
}
