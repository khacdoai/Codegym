package com.example.usermanagement.controller;

import com.example.usermanagement.HelloServlet;
import com.example.usermanagement.model.User;
import com.example.usermanagement.service.IUserService;
import com.example.usermanagement.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "userServlet", value = "/userServlet")
public class userServlet extends HttpServlet {
    IUserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if(action == null){
            action ="";
        }
        switch (action){
            case "create":
                showFormCreate(request,response);
                break;
            case "edit":
                showFormUpdate(request,response);
                break;
            case "delete":
                deleteUser(request,response);
                break;
            case "sort":
                sortByName(request,response);
                break;
            case " ":
                addUserPermision(request,response);
                break;
            default:
                showList(request,response);
                break;

        }
    }

    private void addUserPermision(HttpServletRequest request, HttpServletResponse response) {
        User user = new User("quan", "quan.nguyen@codegym.vn", "vn");

        int[] permision = {1, 2, 4};

        userService.addUserTransaction(user, permision);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response){
        List<User> list = userService.showList();
        request.setAttribute("list",list );
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void sortByName(HttpServletRequest request, HttpServletResponse response){
        List<User> list = userService.sortByName();
        request.setAttribute("list",list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list.jsp");
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
    private void showFormUpdate(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userService.selectUser(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/edit.jsp");
        request.setAttribute("user",user);
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
            action ="";
        }
        switch (action){
            case "create":
                createNewUser(request,response);
                break;
            case "edit":
                updateUser(request,response);
                break;
            case "delete":
                deleteUser(request,response);
                break;
            case "search":
                searchByCounty(request,response);
            case "sort":
                sortByName(request,response);
            default:
                showList(request,response);
                break;

        }
    }
    private void createNewUser(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        userService.addNewUser(new User(name,email,country));
        try {
            response.sendRedirect("/userServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void  updateUser(HttpServletRequest request,HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(id,name,email,country);
        userService.updateUser(user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
        try {
            response.sendRedirect("/userServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void deleteUser(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        userService.deleteUser(id);

        try {
            response.sendRedirect("/userServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void searchByCounty(HttpServletRequest request,HttpServletResponse response){
        String searchInput = request.getParameter("search");
        List<User> list = userService.searchUserByCountry(searchInput);
        request.setAttribute("list",list);
            RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");

        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
