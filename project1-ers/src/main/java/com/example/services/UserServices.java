package com.example.services;

import com.example.dao.UserDAO;
import com.example.exceptions.InvalidCredentialsException;
import com.example.exceptions.UserDoesNotExistException;
import com.example.exceptions.UserNameAlreadyExistsException;
import com.example.logging.Logging;
import com.example.models.Roles;
import com.example.models.User;

public class UserServices {
    private UserDAO uDao;

    public UserServices(UserDAO u) {
        this.uDao = u;
    }

    public User signUp(String first, String last, String email, String password, Roles role)
            throws UserNameAlreadyExistsException {
        User u = new User(first, last, email, password, role);

        try {
            uDao.insert(u);
            Logging.logger.info("uServ: New user has registered");
        } catch (Exception e) {
            Logging.logger.warn("uServ: Username created that already exists in the database");
            throw new UserNameAlreadyExistsException();
        }

        return u;
    }

    public User signIn(String username, String password) throws UserDoesNotExistException, InvalidCredentialsException {

        User u = uDao.getUserByUsername(username);

        if (u.getID() == 0) {
            Logging.logger.warn("uServ: User tried loggging in that does not exist");
            throw new UserDoesNotExistException();
        } else if (!u.getPass().equals(password)) {
            Logging.logger.warn("uServ: User tried to login with invalid credentials");
            throw new InvalidCredentialsException();
        } else {
            Logging.logger.info("uServ: User was logged in");
            return u;
        }
    }

    public User getUserByUsername(String username) {
		return uDao.getUserByUsername(username);
	}

}
