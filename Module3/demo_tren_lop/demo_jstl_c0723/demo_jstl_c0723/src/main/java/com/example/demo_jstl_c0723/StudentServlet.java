package com.example.demo_jstl_c0723;

import com.example.demo_jstl_c0723.model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(value = "/student")
public class StudentServlet extends HttpServlet {
    private static List<Student> students = new ArrayList<>();
    static {
        students.add(new Student(1,"chánh",true,4,1));
        students.add(new Student(2,"Tuấn",true,8,1));
        students.add(new Student(3,"Long",true,7,1));
        students.add(new Student(4,"Đoài",true,5,1));
        students.add(new Student(5,"Thư",false,8,1));
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/student/list.jsp");
        req.setAttribute("studentList", students);
        req.setAttribute("myDate", new Date());
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
