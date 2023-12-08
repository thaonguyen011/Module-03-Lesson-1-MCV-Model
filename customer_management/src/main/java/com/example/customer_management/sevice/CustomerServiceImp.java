package com.example.customer_management.sevice;

import com.example.customer_management.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImp implements CustomerService{
    private static Map<Integer, Customer> customers;

    static {
        customers = new HashMap<>();
        customers.put(1, new Customer(1, "John", "john@codegym.com.vn", "Hanoi"));
        customers.put(2, new Customer(1, "Bill", "bill@codegym.com.vn", "Danang"));
        customers.put(3, new Customer(1, "Alex", "alex@codegym.com.vn", "Saigon"));
        customers.put(4, new Customer(1, "Sophia", "sophia@codegym.com.vn", "Hue"));
        customers.put(4, new Customer(1, "Rose", "rose@codegym.com.vn", "Binhduong"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public void save(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    @Override
    public Customer findById(int id) {
        return customers.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customers.put(id, customer);
    }

    @Override
    public void remove(int id) {
        customers.remove(id);
    }
}
