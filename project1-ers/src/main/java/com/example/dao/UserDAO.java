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
		User user = ses.get(User.class, id);
		return user;
	}

	public List<User> selectAll() {
		Session ses = HibernateUtil.getSession();
		List<User> uList = ses.createQuery("from User", User.class).list();
		return uList;
	}
}