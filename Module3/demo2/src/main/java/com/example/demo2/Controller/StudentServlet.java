package com.example.demo2.Controller;

import com.example.demo2.Model.Student;
import com.example.demo2.Repository.BaseRepository;
import com.example.demo2.Service.IStudentService;
import com.example.demo2.Service.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.swing.plaf.synth.SynthFormattedTextFieldUI;
import java.io.IOException;
import java.sql.Connection;
import java.util.Collections;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/studentServlet")
public class StudentServlet extends HttpServlet {
    IStudentService studentService = new StudentService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                showCreateStudent(request,response);
                break;
            case "edit":
                showUpdateStudent(request,response);
                break;
            case "delete":
                deleteStudent(request,response);
                break;
            default:
                showList(request,response);
                break;
        }

    }
    private void showList(HttpServletRequest request, HttpServletResponse response){
        List<Student> list = studentService.findByAll();
        request.setAttribute("list",list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    private void showUpdateStudent(HttpServletRequest request, HttpServletResponse response){
        int ma_hs = Integer.parseInt(request.getParameter("ma_HS"));
        Student student = studentService.selectStudent(ma_hs);
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
    private void showCreateStudent(HttpServletRequest request,HttpServletResponse response){
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
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "create":
                createStudent(request,response);
                break;
            case "edit":
                break;
            case "delete":
                deleteStudent(request,response);
                break;
            default:
                showList(request,response);
                break;
        }

    }
    private void deleteStudent (HttpServletRequest request, HttpServletResponse response){
        int ma_hs = Integer.parseInt(request.getParameter("ma_hs"));
        studentService.deleteStudent(ma_hs);
        try {
            response.sendRedirect("studentServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void createStudent(HttpServletRequest request, HttpServletResponse response){
        String ten_hs = request.getParameter("ten_hs");
        String ngay_sinh = request.getParameter("ngay_sinh");
        String email = request.getParameter("email");
        String lop = request.getParameter("lop");
        String dia_chi = request.getParameter("dia_chi");
        studentService.addNewStudent(new Student(ten_hs,ngay_sinh,email,lop,dia_chi));

        try {
            response.sendRedirect("studentServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    }
