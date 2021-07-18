package com.example.Services;

import com.example.DAO.CustomerDB;
import com.example.DAO.CustomersDAO;
import com.example.Exceptions.InvalidCredentialsException;
import com.example.Exceptions.UserDoesNotExistException;
import com.example.Exceptions.UserNameAlreadyExistsException;
import com.example.Logging.Logging;
import com.example.Models.Customer;
import com.example.Models.User;

public class UserServices {
    private CustomersDAO uDao = new CustomerDB();

    public User signUp(String firstName, String lastName, String email, String username, String password)
            throws UserNameAlreadyExistsException {
        User u = new User(firstName, lastName, email, username, password);

        return u;
    }

    public Customer login(String username, String password)
            throws UserDoesNotExistException, InvalidCredentialsException {
        Customer u = uDao.getCustomerByUsername(username);
        if (u == null) {
            Logging.logger.warn("User tried loggging in that does not exist");
            throw new UserDoesNotExistException();
        } else {
            if (!u.getPass().equals(password)) {
                Logging.logger.warn("User tried to login with invalid credentials");
                throw new InvalidCredentialsException();
            } else {
                System.out.println("Successful Login!");
                return u;
            }
        }

    }
}
