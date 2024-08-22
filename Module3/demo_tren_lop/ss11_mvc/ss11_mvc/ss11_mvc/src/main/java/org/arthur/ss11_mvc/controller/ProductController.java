package org.arthur.ss11_mvc.controller;

import org.arthur.ss11_mvc.DTO.ProductDTO;
import org.arthur.ss11_mvc.model.Product;
import org.arthur.ss11_mvc.service.ICountryService;
import org.arthur.ss11_mvc.service.IService;
import org.arthur.ss11_mvc.service.impl.CountryService;
import org.arthur.ss11_mvc.service.impl.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/product")
public class ProductController extends HttpServlet {
    IService productService = new ProductService();
    ICountryService countryService = new CountryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                showAddNewForm(req, resp);
                break;
            case "update":
                try {
                    showUpdateForm(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;

            default:
                // display list product
                showList(req, resp);
        }
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("deleteId"));
        boolean isSuccess = productService.delete(id);
        String mess = "delete successful";
        if (!isSuccess) {
            mess = "delete unsuccessful";
        }
        try {
            resp.sendRedirect("/product?mess=" + mess);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private void showUpdateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product product = productService.getProductByID(id);
        req.setAttribute("product", product);
        req.setAttribute("countryList", countryService.getListCountry());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/product/update.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void showAddNewForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("countryList", countryService.getListCountry());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/product/create.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("productList", productService.getAll());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/product/list.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                addNewProduct(req, resp);
                // thêm mới
                break;
            case "delete":
                deleteProduct(req, resp);
                break;
            case "update":
                try {
                    updateProduct(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                // update
                break;
            case "search":
                try {
                    searchProduct(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                // hiển thị danh sách
                showList(req, resp);


        }
    }

    private void searchProduct(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        String name = req.getParameter("valueSearch");
        List<ProductDTO> productList;
        productList = productService.getProductByName(name);
        req.setAttribute("productList", productList);
        req.setAttribute("valueChoose", name);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/product/list.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void updateProduct(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String description = req.getParameter("description");
        int idCountry = Integer.parseInt(req.getParameter("idCountry"));
        Product product = new Product(id, name, price, description, idCountry);
        boolean isSuccess = productService.updateProduct(product);
        String mess = "Update successful";
        if (!isSuccess) {
            mess = "Update failed";
        }
        try {
            resp.sendRedirect("/product?mess=" + mess);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void addNewProduct(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String description = req.getParameter("description");
        int idCountry = Integer.parseInt(req.getParameter("idCountry"));
        Product product = new Product(name, price, description, idCountry);
        boolean isSuccess = productService.add(product);
        String mess = "Add new product successful";
        if (!isSuccess) {
            mess = "Add Failed";
        }
        try {
            resp.sendRedirect("/product?mess=" + mess);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
