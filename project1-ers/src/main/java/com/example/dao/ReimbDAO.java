package com.example.dao;

import java.util.List;

import javax.persistence.Query;

import com.example.models.RType;
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

	public RType getRType(String rType) {
		Session ses = HibernateUtil.getSession();
		RType type = ses.createQuery("from ReimbursementType where ersType=" + rType, RType.class).uniqueResult();
		return type;
	}

	public List<Reimbursement> selectAll() {
		Session ses = HibernateUtil.getSession();
		List<Reimbursement> rList = ses.createQuery("from Reimbursement", Reimbursement.class).list();
		return rList;
	}
	
	public void deleteReimbById(int id) {
		Session ses = HibernateUtil.getSession();
		Reimbursement r = ses.get(Reimbursement.class, id);
		Transaction tx = ses.beginTransaction();
		ses.delete(r);
		tx.commit();
	}
}