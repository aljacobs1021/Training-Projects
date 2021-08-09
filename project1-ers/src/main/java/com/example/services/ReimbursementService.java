package com.example.services;

import java.sql.Timestamp;
//import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.example.dao.RStatusDAO;
import com.example.dao.ReimbDAO;
import com.example.dao.UserDAO;
import com.example.models.RStatus;
import com.example.models.RType;
import com.example.models.Reimbursement;
import com.example.models.Type;
//import com.example.models.User;
import com.example.models.User;

public class ReimbursementService {

	private ReimbDAO rDao;
	//private UserDAO uDao;
	//private RStatusDAO rStatusDao;
	private String type;
	private double amount;
	private Timestamp submittedTS;
	private String desc;
	private User creator;
	private RStatus status;
	
	public ReimbursementService() {
		
	}
	
	public ReimbursementService(ReimbDAO rDao) {
		this.rDao = rDao;
		//this.uDao = uDao;
	}
	public ReimbursementService(ReimbDAO rDao, UserDAO uDao, RStatusDAO rStatusDao) {
		this.rDao = rDao;
		//this.uDao = uDao;
		//this.rStatusDao = rStatusDao;
	}

	public ReimbursementService(String type, double amount, Timestamp submittedTS, String desc, RStatus status, User creator) {
		this.type = type;
		this.amount = amount;
		this.submittedTS = submittedTS;
		this.desc = desc;
		this.status = status;
		this.creator = creator;
	}
	
	public RType getType(String rType) {
		return rDao.getRType(rType);
	}
	
	public void addReimb(double amount, String desc, RStatus status, RType type) {
		Reimbursement r = new Reimbursement(amount, desc, status, type);
		rDao.insert(r);
	}
	
	public List<Reimbursement> selectAllReimb(){
		return rDao.selectAll();
	}
	
	public void updateReimbursement(RType type, double amount, LocalDateTime resolveddate, String desc, RStatus status) {
		Reimbursement r = new Reimbursement(type, amount, resolveddate, desc, status);
		rDao.update(r);
	}
	
	public void deleteReimbByID(int id){
		rDao.deleteReimbById(id);
	}

	public void addReimb(String reimtype, double amount,Timestamp ts,String description, RStatus status, User employee) {
		System.out.println(reimtype);
		 
		if(reimtype.equals("LODGING")) {
			System.out.println("Please no updates to thing");
			RType t = new RType(1, Type.LODGING);
			Reimbursement r = new Reimbursement(amount,ts,description,status,t,employee);
			System.out.println(r);
			rDao.insert(r);
		}else if(reimtype.equals("TRAVEL")) {
			System.out.println("Please no updates to thing");
			RType t = new RType(0, Type.TRAVEL);
			Reimbursement r = new Reimbursement(amount,ts,description,status,t,employee);
			System.out.println(r);
			rDao.insert(r);
		}else if(reimtype.equals("FOOD")) {
			System.out.println("Please no updates to thing");
			RType t = new RType(2, Type.FOOD);
			Reimbursement r = new Reimbursement(amount,ts,description,status,t,employee);
			System.out.println(r);
			rDao.insert(r);
		}else if(reimtype.equals("OTHER")) {
			System.out.println("Please no updates to thing");
			RType t = new RType(3, Type.OTHER);
			Reimbursement r = new Reimbursement(amount,ts,description,status,t,employee);
			System.out.println(r);
			rDao.insert(r);
		}
	}


}