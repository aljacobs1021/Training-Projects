package com.example.dao;

import java.util.List;

import com.example.models.Reimbursement;
import com.example.utils.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ReimbDAO {

	public ReimbDAO() {

	}

	public void insert(Reimbursement reimbursement) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.save(reimbursement);
		tx.commit();
	}

	public void update(Reimbursement reimbursement) {
		Session ses = HibernateUtil.getSession();
		Transaction tx = ses.beginTransaction();
		ses.update(reimbursement);
		tx.commit();
	}

	public Reimbursement selectById(int id) {
		Session ses = HibernateUtil.getSession();
		Reimbursement reimbursement = ses.get(Reimbursement.class, id);
		return reimbursement;
	}

	public List<Reimbursement> selectAll() {
		Session ses = HibernateUtil.getSession();
		List<Reimbursement> rList = ses.createQuery("from Reimbursement", Reimbursement.class).list();
		return rList;
	}
}