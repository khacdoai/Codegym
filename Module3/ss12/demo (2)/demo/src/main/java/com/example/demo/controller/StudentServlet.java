package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.IStudentService;
import com.example.demo.service.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/student-servlet")
public class StudentServlet extends HttpServlet {
   private IStudentService iStudentService = new StudentService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                showFormCreate(request,response);
                break;
            default:
                showList(request, response);
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher
                = request.getRequestDispatcher("/create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Student> list = iStudentService.showList();
        request.setAttribute("list",list);
        RequestDispatcher requestDispatcher
                = request.getRequestDispatcher("/student-list.jsp");
        requestDispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                addNewStudent(request,response);
                break;

        }
    }

    private void addNewStudent(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        boolean gender = request.getParameter("gender").equals("male");
        double point = Double.parseDouble(request.getParameter("point"));
        iStudentService.addNewStudent(new Student(name,gender,point));
        try {
            // Truyền vào value của servlet
            response.sendRedirect("/student-servlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
