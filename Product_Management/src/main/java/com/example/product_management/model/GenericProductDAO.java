package com.example.product_management.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenericProductDAO implements IProductDAO{
    private final String jdbcURL= "jdbc:mysql://localhost:3306/products";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "Modicung2486!";

    private static final String INSERT_PRODUCT = "insert into products(name, price, brand, description) values (?,?,?,?);";
    private static final String UPDATE_PRODUCT = "update products set name = ?, price = ?, brand = ?, description = ? where id = ?;";
    private static final String DELETE_PRODUCT = "delete from products where id = ?;";
    private static final String SELECT_ALL_PRODUCTS = "select * from products;";
    private static final String SELECT_PRODUCT_BY_ID = "select * from products where id = ?;";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<Product> selectAllProduct() {
        List<Product> products = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCTS);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                float price = resultSet.getFloat("price");
                String brand = resultSet.getString("brand");
                String description = resultSet.getString("description");
                products.add(new Product(id, name, price, brand, description));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product selectProductById(int id) {
        Product product = null;
        try {
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_PRODUCT_BY_ID);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                float price = rs.getFloat("price");
                String brand = rs.getString("brand");
                String description = rs.getString("description");
                product = new Product(id, name, price, brand, description);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public boolean insertProduct(Product product) {
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setFloat(2, product.getPrice());
            preparedStatement.setString(3, product.getBrand());
            preparedStatement.setString(4, product.getDescription());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateProduct(int id, Product product) {
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(UPDATE_PRODUCT);
            ps.setString(1, product.getName());
            ps.setFloat(2, product.getPrice());
            ps.setString(3, product.getBrand());
            ps.setString(4, product.getDescription());
            ps.setInt(5, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteProduct(int id) {
        try {
            Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(DELETE_PRODUCT);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
