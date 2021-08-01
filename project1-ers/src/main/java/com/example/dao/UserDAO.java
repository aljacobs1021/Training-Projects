package com.example.dao;

import java.util.List;

import com.example.models.User;

public interface UserDAO {

	List<User> getAllUsers();

	User getUserByUserName(String username);

	void createUser(User u);

	void updateUser(User u);

	void deleteUser(User u);
}