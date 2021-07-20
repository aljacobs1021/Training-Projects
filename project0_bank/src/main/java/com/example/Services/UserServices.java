package com.example.Services;

import java.util.Random;

// import java.sql.SQLException;

import com.example.DAO.CustomerDB;
import com.example.DAO.CustomersDAO;
import com.example.DAO.EmployeeDB;
import com.example.DAO.EmployeesDAO;
import com.example.Exceptions.InvalidCredentialsException;
import com.example.Exceptions.UserDoesNotExistException;
import com.example.Exceptions.UserNameAlreadyExistsException;
import com.example.Logging.Logging;
import com.example.Models.Customer;
// import com.example.Models.Employee;
import com.example.Models.User;

public class UserServices {
    private CustomersDAO cDao = new CustomerDB();
    private EmployeesDAO eDao = new EmployeeDB();
    Random num = new Random();

    public User customerSignUp(String firstName, String lastName, String email, String username, String password)
            throws UserNameAlreadyExistsException {
        User c = new User(firstName, lastName, email, username, password);

        try {
            cDao.createCustomer(c);
            Logging.logger.info("LOG: New user has registered");
        } catch (Exception e) {
            Logging.logger.warn("Username created that already exists in the database");
            throw new UserNameAlreadyExistsException();
        }

        return c;
    }

    public User employeeSignUp(int employeeID, String firstName, String lastName, String email, String username,
            String password) throws UserNameAlreadyExistsException {
        User e = new User(employeeID, firstName, lastName, email, username, password);

        try {
            eDao.createEmployee(e);
            Logging.logger.info("New employee has registered");
        } catch (Exception ex) {
            Logging.logger.warn("Username created that already exists in the database");
            throw new UserNameAlreadyExistsException();
        }

        return e;
    }

    public Customer login(String username, String password)
            throws UserDoesNotExistException, InvalidCredentialsException {
        Customer c = cDao.getCustomerByUsername(username);
        if (!c.getUser().equals(username)) {
            Logging.logger.warn("User tried loggging in that does not exist");
            throw new UserDoesNotExistException();
        } else {
            if (!c.getPass().equals(password)) {
                Logging.logger.warn("User tried to login with invalid credentials");
                throw new InvalidCredentialsException();
            } else {
                System.out.println("Successful Login!");
                return c;
            }
        }

    }
}
