package com.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
//import org.hibernate.criterion.Restrictions;

import com.example.models.Reimbursement;
import com.example.utils.HibernateUtil;

public class ReimbDAOHibernate implements ReimbDAO {
	@Override
	public List<Reimbursement> getAllReimbursements() {
		Session ses = HibernateUtil.getSession();
		List<Reimbursement> reimbursement = ses
				.createNativeQuery("select * from ers_reimbursement", Reimbursement.class).list();
		// ses.close();
		return reimbursement;
	}

	// HQL allows you to create queries based on the object rather than the table
	@Override
	public Reimbursement getRRByID(int id) {
		Session ses = HibernateUtil.getSession();
		Reimbursement reimbursement = ses.createQuery("from Reimbursement where id=" + id, Reimbursement.class)
				.uniqueResult();
		return reimbursement;
	}

	// Sessions have built in methods that help you achieve basic crud operations
	@Override
	public void createRR(Reimbursement r) {
		Session ses = HibernateUtil.getSession();
		Transaction tran = ses.beginTransaction();
		// .save will save the object to the database for you
		ses.save(r);
		tran.commit();
		// ses.close();
	}

	@Override
	public void updateRR(Reimbursement r) {
		Session ses = HibernateUtil.getSession();
		Transaction tran = ses.beginTransaction();
		// .update will update a specific record for you
		ses.update(r);
		tran.commit();
		// ses.close();
	}

	@Override
	public void deleteRR(Reimbursement r) {
		Session ses = HibernateUtil.getSession();
		Transaction tran = ses.beginTransaction();
		// .update delete will delete an entity from the table for you
		ses.delete(r);
		tran.commit();
		// ses.close();
	}
}