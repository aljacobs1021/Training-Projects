package com.example.DAO;

import java.sql.SQLException;
import java.util.List;

import com.example.Models.Employee;
import com.example.Models.User;

public interface EmployeesDAO {

    List<Employee> getAllEmployees();

    User getEmployeeByID(int employeeID);

    void createEmployee(User u) throws SQLException;

    void updateEmployee(Employee e);

    void deleteEmployee(Employee e);

}