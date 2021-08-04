package com.example.dao;

import java.util.List;

import com.example.models.RStatus;
import com.example.utils.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class RStatusDAO {
    public RStatusDAO() {
		
	}
	
	public void insert(RStatus status) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.save(status);
		tx.commit();
	}
	
	public void update(RStatus status) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.update(status);
		tx.commit();
	}
	
	public RStatus selectById(int id) {
		Session ses = HibernateUtil.getSession();
		RStatus status = ses.get(RStatus.class, id);
		return status;
	}
	
	public List<RStatus> selectAll(){
		Session ses = HibernateUtil.getSession();
		List<RStatus> rSList = ses.createQuery("from RStatus", RStatus.class).list();
		return rSList;
	}
}

