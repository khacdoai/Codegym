package com.example.thi_ket_thuc_module.controller;

import com.example.thi_ket_thuc_module.dto.BenhAnDto;
import com.example.thi_ket_thuc_module.service.IBenhAnService;
import com.example.thi_ket_thuc_module.service.impl.BenhAnService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "BenhAnServlet", value = "/BenhAnServlet")
public class BenhAnServlet extends HttpServlet {
    private IBenhAnService benhAnService = new BenhAnService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "edit":
                showFormEdit(request,response);
                break;
            default:
                showList(request,response);
                break;
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        BenhAnDto benhAnDto = benhAnService.layBenhAn(id);
        request.setAttribute("benhAnDto",benhAnDto);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/edit.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<BenhAnDto> list = benhAnService.showList();
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setCharacterEncoding("UTF-8");
            String action = request.getParameter("action");
            if (action == null){
                action = "";
            }
            switch (action){
                case "edit":
                    chinhSuaBenhAn(request,response);
                    break;
                case "delete":
                    xoaBenhAn(request,response);
                    break;
                default:
                    showList(request,response);
                    break;
            }
}

    private void chinhSuaBenhAn(HttpServletRequest request, HttpServletResponse response) {
         String maBenhAn = request.getParameter("maMatHang");
         String maBenhNhan = request.getParameter("tenMatHang");
         String tenBenhNhan = request.getParameter("tenBenhNhan");
         Date ngayNhapvien = Date.valueOf(request.getParameter("gia"));
         Date ngayRaVien = Date.valueOf(request.getParameter("soLuong"));
         String lyDoNhapVien = request.getParameter("");
    }

    private void xoaBenhAn(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        benhAnService.xoaBenhAn(id);
        try {
            response.sendRedirect("/BenhAnServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }
