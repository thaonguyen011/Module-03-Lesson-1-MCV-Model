package com.example.product_management.controller;

import com.example.product_management.model.GenericProductDAO;
import com.example.product_management.model.IProductDAO;
import com.example.product_management.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name="ProductServlet",  urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    private final IProductDAO productDAO;

    public ProductServlet() {
        productDAO = new GenericProductDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    showNewForm(req, resp);
                    break;
                case "edit":
                    showEditForm(req, resp);
                    break;
                case "delete":
                    deleteProduct(req, resp);
                    break;
                default:
                    listProduct(req, resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                    insertProduct(req, resp);
                    break;
                case "edit":
                    updateProduct(req, resp);
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void listProduct(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException{
        List<Product> productList = productDAO.selectAllProduct();
        req.setAttribute("listProduct", productList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("product/list.jsp");
        dispatcher.forward(req, res);
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        productDAO.deleteProduct(id);
        List<Product> productList = productDAO.selectAllProduct();
        req.setAttribute("listProduct", productList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("product/list.jsp");
        dispatcher.forward(req, resp);
    }

    private void insertProduct(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        String name = req.getParameter("name");
        float price = Float.parseFloat(req.getParameter("price"));
        String brand = req.getParameter("brand");
        String description = req.getParameter("description");

        Product product = new Product(name, price, brand, description);
        productDAO.insertProduct(product);
        RequestDispatcher dispatcher = req.getRequestDispatcher("product/create.jsp");
        dispatcher.forward(req, resp);
    }

    private void updateProduct(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException  {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        float price = Float.parseFloat(req.getParameter("price"));
        String brand = req.getParameter("brand");
        String description = req.getParameter("description");

        Product product = new Product(id, name, price, brand, description);
        productDAO.updateProduct(id, product);
        RequestDispatcher dispatcher = req.getRequestDispatcher("product/edit.jsp");
        dispatcher.forward(req, resp);
    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse resp)throws SQLException, ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("product/create.jsp");
        dispatcher.forward(req, resp);
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp)throws SQLException, ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("product/edit.jsp");
        dispatcher.forward(req, resp);
    }
 }
