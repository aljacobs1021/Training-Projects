package com.example.dao;

import java.util.List;

import com.example.models.Reimbursement;

public interface ReimbDAO {

	List<Reimbursement> getAllReimbursements();

	Reimbursement getRRByID(int id);

	Reimbursement getRRByAuthor(String author);

	void createRR(Reimbursement r);

	void updateRR(Reimbursement r);

	void deleteRR(Reimbursement r);
}