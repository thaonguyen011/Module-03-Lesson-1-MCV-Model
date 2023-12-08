package com.example.product_management.model;

import java.util.List;

public interface IProductDAO {
    List<Product> selectAllProduct();
    Product selectProductById(int id);
    boolean insertProduct(Product product);
    boolean updateProduct(int id, Product product);
    boolean deleteProduct(int id);
}
