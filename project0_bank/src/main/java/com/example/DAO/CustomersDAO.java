package com.example.DAO;

import java.util.List;

import com.example.Models.Customer;
import com.example.Models.User;

public interface CustomersDAO {

    List<Customer> getAllCustomers();

    Customer getCustomerByUsername(String username);

    void createCustomer(User u);

    void updateCustomer(Customer c);

    void deleteCustomer(Customer c);

}
