package com.example.product_management.service;

import com.example.product_management.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> selectAll();
    Product findProductById(int id);
    void addProduct(Product product);
    void updateProduct(int id, Product product);
    void deleteProduct(int id);

}
