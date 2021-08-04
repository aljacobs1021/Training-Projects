package com.example.dao;

import java.util.List;

import com.example.models.RType;
import com.example.utils.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class RTypeDAO {
    public RTypeDAO() {
		
	}
	
	public void insert(RType type) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.save(type);
		tx.commit();
	}
	
	public void update(RType type) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.update(type);
		tx.commit();
	}
	
	public RType selectById(int id) {
		Session ses = HibernateUtil.getSession();
		RType type = ses.get(RType.class, id);
		return type;
	}
	
	public List<RType> selectAll(){
		Session ses = HibernateUtil.getSession();
		List<RType> rTList = ses.createQuery("from RType", RType.class).list();
		return rTList;
	}
}
