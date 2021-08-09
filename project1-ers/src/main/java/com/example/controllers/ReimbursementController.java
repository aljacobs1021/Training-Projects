package com.example.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.dao.RStatusDAO;
import com.example.dao.RTypeDAO;
import com.example.dao.ReimbDAO;
import com.example.dao.URolesDAO;
import com.example.dao.UserDAO;
import com.example.models.RStatus;
import com.example.models.RType;
import com.example.models.Reimbursement;
import com.example.models.Status;
import com.example.models.User;
import com.example.services.ReimbursementService;
import com.example.services.UserServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class ReimbursementController {
	private static UserDAO uDao = new UserDAO();
	private static UserServices uServ = new UserServices(uDao);
	// private static URolesDAO urDao = new URolesDAO();
	private static ReimbDAO rDao = new ReimbDAO();
	private static ReimbursementService rServ = new ReimbursementService(rDao);
	// private static RTypeDAO tDao = new RTypeDAO();
	// private static RStatusDAO sDao = new RStatusDAO();

	public static void addReimbursements(HttpServletRequest req, HttpServletResponse res)
			throws JsonProcessingException, IOException {

		StringBuilder buffer = new StringBuilder();
		BufferedReader reader = req.getReader();
		// breaking up the JSON string object into separate lines to use later
		String line;
		while ((line = reader.readLine()) != null) {
			buffer.append(line);
			buffer.append(System.lineSeparator());
		}
		// we converted the string builder into a string which the ObjectMapper can read
		// from
		String data = buffer.toString();
		System.out.println(data);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode parsedObj = mapper.readTree(data);

		Reimbursement r = new Reimbursement();
		int id = r.getID();
		String retype = r.getType().toString();
		int type = r.getType().getId();
		int stat = r.getStatus().getId();

		System.out.println("retype var in addReimbursement");
		System.out.println(retype);
		double amount = Double.parseDouble(parsedObj.get("amount").asText());
		// wanted to use timestamp?
		Timestamp submittedTS = Timestamp.from(Instant.now());
		String description = parsedObj.get("description").asText();
		int userID = parsedObj.get("userID").asInt();
		User creator = uServ.getUserById(userID);
		System.out.println("userv in addReimbursement");
		RStatus status = new RStatus(1, Status.SUBMITTED);
		rServ.addReimb(retype, amount, submittedTS, description, status, creator);
		System.out.println("rserv in addReimbursement");
		ObjectNode ret = mapper.createObjectNode();
		ret.put("message", "Successfully submitted a new request maybe who knows i dont");
		res.getWriter().write(new ObjectMapper().writeValueAsString(ret));
		req.getSession().setAttribute("reimb_id", id);
		req.getSession().setAttribute("type", type);
		req.getSession().setAttribute("status", stat);
		res.setStatus(HttpServletResponse.SC_OK);
		res.addHeader("Access-Control-Allow-Origin", "*");
		res.setHeader("Content-Type", "application/json");
		res.setHeader("Access-Control-Allow-Methods", "POST");
		ObjectNode reimb = mapper.createObjectNode();

		reimb.put("reimb_id", id);
		System.out.println("id: " + id);
		switch (type) {
			case 1:
				reimb.put("type", "FOOD");
				break;
			case 2:
				reimb.put("type", "LODGING");
				break;
			case 3:
				reimb.put("type", "OTHER");
				break;
			case 4:
				reimb.put("type", "TRAVEL");
				break;
			default:
				reimb.put("type", "NA");
		}

		switch (stat) {
			case 1:
				reimb.put("stat", "SUBMITTED");
				break;
			case 2:
				reimb.put("stat", "APPROVED");
				break;
			case 3:
				reimb.put("stat", "DENIED");
				break;
			default:
				reimb.put("stat", "NA");
		}

		System.out.println("type: " + type);
		System.out.println("status: " + stat);

		// res.getWriter().println("User signed in!");
		res.getWriter().write(new ObjectMapper().writeValueAsString(reimb));

	}
}
