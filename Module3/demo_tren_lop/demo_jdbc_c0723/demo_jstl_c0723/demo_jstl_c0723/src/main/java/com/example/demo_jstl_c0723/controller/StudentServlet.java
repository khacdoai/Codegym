package com.example.demo_jstl_c0723.controller;

import com.example.demo_jstl_c0723.model.Clazz;
import com.example.demo_jstl_c0723.model.Student;
import com.example.demo_jstl_c0723.service.IClassService;
import com.example.demo_jstl_c0723.service.IStudentService;
import com.example.demo_jstl_c0723.service.impl.ClassService;
import com.example.demo_jstl_c0723.service.impl.StudentService;

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
    private IStudentService studentService = new StudentService();
    private IClassService classService = new ClassService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action ==null){
            action = "";
        }
        switch (action){
            case "add":
                showAddForm(req,resp);
                // thêm mới
                break;
            case "delete":
                // xoá
                break;
            default:
                // hiể thị danh sách
                showList(req,resp);

        }
    }

    private void showAddForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/student/add.jsp");
        List<Clazz> classList = classService.findAll();
        req.setAttribute("classList",classList);
        requestDispatcher.forward(req, resp);
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/student/list.jsp");
        req.setAttribute("studentList", studentService.findAll());
        req.setAttribute("myDate", new Date());
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action ==null){
            action = "";
        }
        switch (action){
            case "add":
                save(req,resp);
                // thêm mới
                break;
            case "delete":
                // xoá
                break;
            default:


        }
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) {
//        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        boolean gender = Boolean.parseBoolean(req.getParameter("gender"));
        float point = Float.parseFloat(req.getParameter("point"));
        int classId = Integer.parseInt(req.getParameter("classId"));
        Student student = new Student(name,gender,point,classId);
        boolean isSuccess =studentService.add(student);
        String mess = "Them moi thanh cong";
        if (!isSuccess){
           mess = "Thêm mới không thành công";
        }
        try {
            resp.sendRedirect("/student?mess="+mess);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
