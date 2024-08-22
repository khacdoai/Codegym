package com.example.case_study.controller;

import com.example.case_study.HelloServlet;
import com.example.case_study.dto.EmployeeDto;
import com.example.case_study.model.BoPhan;
import com.example.case_study.model.Employee;
import com.example.case_study.model.TrinhDo;
import com.example.case_study.model.ViTri;
import com.example.case_study.service.IBoPhanService;
import com.example.case_study.service.IEmployeeService;
import com.example.case_study.service.ITrinhDoService;
import com.example.case_study.service.IViTriService;
import com.example.case_study.service.impl.BoPhanService;
import com.example.case_study.service.impl.EmployeeService;
import com.example.case_study.service.impl.TrinhDoService;
import com.example.case_study.service.impl.ViTriService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "employeeServlet",value = "/employeeServlet")
public class employeeServlet extends HttpServlet {
   private IEmployeeService employeeService = new EmployeeService();
   private IBoPhanService boPhanService = new BoPhanService();
   private IViTriService viTriService =  new ViTriService();
   private ITrinhDoService trinhDoService = new TrinhDoService();
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                showFormCreate(request,response);
                break;
            case "delete":
                break;
            case "update":
                break;
            default:
                showList(request,response);
                break;
        }

    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/create.jsp");
        List<BoPhan> listBoPhan = boPhanService.showlist();
        List<ViTri> listViTri = viTriService.showList();
        List<TrinhDo> listTrinhDo = trinhDoService.showList();
        request.setAttribute("listBoPhan", listBoPhan);
        request.setAttribute("listViTri",listViTri);
        request.setAttribute("listTrinhDo",listTrinhDo);
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<EmployeeDto> list = employeeService.showList();
        request.setAttribute("list", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("employee/list.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                break;
            case "delete":
                deleteEmployee(request,response);
                break;
            case "update":
                break;
            default:
                showList(request,response);
                break;
        }


    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("maNhanVien"));
        employeeService.deleteEmployee(id);
        try {
            response.sendRedirect("/employeeServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
