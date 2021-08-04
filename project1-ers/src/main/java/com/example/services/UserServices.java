/* package com.example.services;

//import java.sql.SQLException;
import com.example.dao.UserDAOHibernate;
import com.example.exceptions.InvalidCredentialsException;
import com.example.exceptions.UserDoesNotExistException;
import com.example.exceptions.UserNameAlreadyExistsException;
import com.example.logging.Logging;
import com.example.models.User;

public class UserServices {
    private UserDAOHibernate uDao;

    public UserServices(UserDAOHibernate u) {
        this.uDao = u;
    }

    public User signUp(String first, String last, String username, String email, String password)
            throws UserNameAlreadyExistsException {
        User u = new User(first, last, username, email, password);

        try {
            uDao.createUser(u);
            Logging.logger.info("uServ: New user has registered");
        } catch (Exception e) {
            Logging.logger.warn("uServ: Username created that already exists in the database");
            throw new UserNameAlreadyExistsException();
        }

        return u;
    }

    public User signIn(String username, String password) throws UserDoesNotExistException, InvalidCredentialsException {

        User u = uDao.getUserByUserName(username);

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

} */