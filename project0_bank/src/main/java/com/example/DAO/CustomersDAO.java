package com.example.DAO;

import java.util.List;

import com.example.User;

public class CustomersDAO {

    List<User> getAllCustomers();

    User getCustomerByUsername(String username);

    void createCustomer(User u);

    void updateCustomer(User u);

    void deleteCustomer(User u);

}
