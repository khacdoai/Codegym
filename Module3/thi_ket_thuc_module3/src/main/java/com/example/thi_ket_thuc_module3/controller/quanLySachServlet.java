package com.example.thi_ket_thuc_module3.controller;

import com.example.thi_ket_thuc_module3.Dto.TheMuonSachDto;
import com.example.thi_ket_thuc_module3.model.Sach;
import com.example.thi_ket_thuc_module3.service.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "quanLySachServlet", value = "/quanLySachServlet")
public class quanLySachServlet extends HttpServlet {
    private ISachService sachService = new SachService();
    public ITheMuonSachService theMuonSachService  = new TheMuonSachService();
    public ITheMuonSachDtoService theMuonSachDtoService = new TheMuonSachDtoService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                showFormCreate(request,response);
                break;
            case "thongKe":
                thongKe(request,response);
                break;
            case "search":
                timKiem(request,response);
                break;
            default:
                showList(request,response);
                break;
        }

    }

    private void timKiem(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        List<TheMuonSachDto> list1 = theMuonSachDtoService.search(name);
        request.setAttribute("list",list1);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/thongKe.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void thongKe(HttpServletRequest request, HttpServletResponse response) {
        List<TheMuonSachDto> list1 = theMuonSachDtoService.showList();
        request.setAttribute("list",list1);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/thongKe.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        String id =request.getParameter("id");
        TheMuonSachDto theMuonSachDto = theMuonSachDtoService.layThongTinSach(id);
        request.setAttribute("theMuonSachDto",theMuonSachDto);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/create2.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<Sach> list = sachService.showList();
        List<TheMuonSachDto> list1 = theMuonSachDtoService.showList();
        request.setAttribute("list",list);
        request.setAttribute("list1",list1);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list.jsp");
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
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                showFormCreate(request,response);
                break;
            case "search":
                timKiem(request,response);
                break;
            default:
                showList(request,response);
                break;
        }

    }

}
