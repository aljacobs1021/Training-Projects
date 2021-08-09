package com.example.dao;

import java.util.List;

import com.example.models.User;
import com.example.utils.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDAO {

	public UserDAO() {

	}

	public void insert(User user) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.save(user);
		tx.commit();
	}

	public void update(User user) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.update(user);
		tx.commit();
	}

	public User selectById(int id) {
		Session ses = HibernateUtil.getSession();
		User user = ses.createQuery("from User where id =" + id, User.class).uniqueResult();
		return user;
	}

	public List<User> getAllUsers() {
		Session ses = HibernateUtil.getSession();
		List<User> uList = ses.createQuery("from User", User.class).list();
		return uList;
	}

	public User getUserByUsername(String username) {
		Session ses = HibernateUtil.getSession();
		List<User> uList = ses.createQuery("from User where username='" + username + "'", User.class).list();
		if(uList.size() == 0) {
			return null;
		}
		return uList.get(0);
	}

	public void delete(User u) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.delete(u);
		tx.commit();
	}
}