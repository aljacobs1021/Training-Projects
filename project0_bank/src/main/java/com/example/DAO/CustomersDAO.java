package com.example.DAO;

import java.util.List;

import com.example.Models.Customer;
import com.example.Models.User;

public interface CustomersDAO {

    List<User> getAllCustomers();

    Customer getCustomerByUsername(String username);

    void createCustomer(User u);

    void updateCustomer(User u);

    void deleteCustomer(User u);

}
