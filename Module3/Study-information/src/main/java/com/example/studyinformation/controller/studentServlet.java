package com.example.studyinformation.controller;

import com.example.studyinformation.HelloServlet;
import com.example.studyinformation.model.Student;
import com.example.studyinformation.service.IStudentService;
import com.example.studyinformation.service.impl.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "studentServlet", value = "/studentServlet")
public class studentServlet extends HttpServlet {
    IStudentService studentService = new StudentService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                showFormCreate(request,response);
                break;
            case "edit":
                updateStudent(request,response);
                break;
            default:
                showList(request,response);
                break;
        }

    }
    private void showList(HttpServletRequest request, HttpServletResponse response){
        List<Student> list = studentService.showlist();
        request.setAttribute("list", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showFromUpdate(HttpServletRequest request,HttpServletResponse response){
        int ma_HS = Integer.parseInt(request.getParameter("id"));
        Student student = studentService.selectStudent(ma_HS);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/edit.jsp");
        request.setAttribute("student",student);
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showFormCreate(HttpServletRequest request, HttpServletResponse response){
        RequestDispatcher dispatcher = request.getRequestDispatcher("/create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                createStudent(request,response);
                break;
            case "delete":
                deleteStudent(request,response);
                break;
            case "update":
                updateStudent(request,response);
            default:
                showList(request, response);
                break;
        }
    }
    private void deleteStudent(HttpServletRequest request, HttpServletResponse response){
        int ma_HS = Integer.parseInt(request.getParameter("ma_HS"));
        studentService.deleteStudent(ma_HS);
        try {
            response.sendRedirect("/studentServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void updateStudent(HttpServletRequest request , HttpServletResponse response){
        String ten_HS = request.getParameter("ten_HS");
        String ngay_sinh = request.getParameter("ngay_sinh");
        String email = request.getParameter("email");
        String lop = request.getParameter("lop");
        String dia_chi = request.getParameter("dia_chi");
        Student student = new Student(ten_HS,ngay_sinh,email,lop,dia_chi);
        studentService.updateStudent(student);
        try {
            response.sendRedirect("/studentServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void createStudent(HttpServletRequest request, HttpServletResponse response){
        String ten_HS = request.getParameter("ten_HS");
        String ngay_sinh = request.getParameter("ngay_sinh");
        String email = request.getParameter("email");
        String lop = request.getParameter("lop");
        String dia_chi = request.getParameter("dia_chi");
        studentService.addnewStudent(new Student(ten_HS,ngay_sinh,email,lop,dia_chi));
        try {
            response.sendRedirect("/studentServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
