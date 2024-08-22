package org.arthur.ss11_mvc.controller;

import org.arthur.ss11_mvc.model.Country;
import org.arthur.ss11_mvc.service.ICountryService;
import org.arthur.ss11_mvc.service.impl.CountryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/country")
public class CountryController extends HttpServlet {
    ICountryService countryService = new CountryService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null){
            action="";
        }
        switch (action){
            case "add":
                addNewCountry(req,resp);
                break;
        }
    }

    private void addNewCountry(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        if(id == null){
            id="";
        }

        String name = req.getParameter("newCountryName");
        Country country = new Country(name);
        boolean isSuccess = countryService.add(country);
        String mess = "Add new country successful";
        if (!isSuccess) {
            mess = "Add Failed";
        }
        try {
            if(id.equals("")){
                resp.sendRedirect("/product?action=add&mess=" + mess);
            } else  {
                resp.sendRedirect("/product?action=update&id="+id+"&mess=" + mess);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
