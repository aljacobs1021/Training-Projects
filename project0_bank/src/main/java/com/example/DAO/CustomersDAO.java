package com.example.DAO;

import java.sql.SQLException;
import java.util.List;

import com.example.Models.Customer;
import com.example.Models.User;

public interface CustomersDAO {

    List<Customer> getAllCustomers();

    Customer getCustomerByUsername(String username);

    void createCustomer(User u) throws SQLException;

    void updateCustomer(Customer c);

    void deleteCustomer(Customer c);

}
