package com.example.Services;

import java.sql.SQLException;
import com.example.DAO.UserDao;
import com.example.Exceptions.InvalidCredentialsException;
import com.example.Exceptions.UserDoesNotExistException;
import com.example.Exceptions.UserNameAlreadyExistsException;
import com.example.Logging.Logging;
import com.example.Models.User;

public class UserServices {
    private UserDao uDao;

    public UserServices(UserDao u) {
        this.uDao = u;
    }

    public User signUp(String first, String last, String email, String password, boolean isEmployee)
            throws UserNameAlreadyExistsException {
        User u = new User(first, last, email, password, false);

        try {
            uDao.createUser(u);
            Logging.logger.info("uServ: New user has registered");
        } catch (SQLException e) {
            Logging.logger.warn("uServ: Username created that already exists in the database");
            throw new UserNameAlreadyExistsException();
        }

        return u;
    }

    public User signIn(String username, String password) throws UserDoesNotExistException, InvalidCredentialsException {

        User u = uDao.getUserByUsername(username);

        if (u.getId() == 0) {
            Logging.logger.warn("uServ: User tried loggging in that does not exist");
            throw new UserDoesNotExistException();
        } else if (!u.getPassword().equals(password)) {
            Logging.logger.warn("uServ: User tried to login with invalid credentials");
            throw new InvalidCredentialsException();
        } else {
            Logging.logger.info("uServ: User was logged in");
            return u;
        }
    }

}
