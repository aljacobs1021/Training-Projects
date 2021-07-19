package com.example.DAO;

import java.util.List;

import com.example.Models.Employee;
import com.example.Models.User;

public interface EmployeesDAO {

    List<Employee> getAllEmployees();

    User getEmployeeByID(int employeeID);

    void createEmployee(User u);

    void updateEmployee(User u);

    void deleteEmployee(User u);

}