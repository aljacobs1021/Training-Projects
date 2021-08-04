package com.example.dao;

import java.util.List;

import com.example.models.URoles;
import com.example.utils.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class URolesDAO {
    public URolesDAO() {
		
	}
	
	public void insert(URoles roles) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.save(roles);
		tx.commit();
	}
	
	public void update(URoles roles) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.update(roles);
		tx.commit();
	}
	
	public URoles selectById(int id) {
		Session ses = HibernateUtil.getSession();
		URoles roles = ses.get(URoles.class, id);
		return roles;
	}
	
	public List<URoles> selectAll(){
		Session ses = HibernateUtil.getSession();
		List<URoles> uRList = ses.createQuery("from URoles", URoles.class).list();
		return uRList;
	}
}
