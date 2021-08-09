package com.example.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.controllers.LoginController;
import com.example.controllers.ReimbursementController;
//import com.example.controllers.LogoutController;
import com.example.controllers.SessionController;
import com.fasterxml.jackson.core.JsonProcessingException;

public class ServletJSONHelper {

	public static void process(HttpServletRequest req, HttpServletResponse res)
			throws IOException, JsonProcessingException {
		System.out.println("In the JSONServlet Helper with URI: " + req.getPathInfo());
		switch (req.getPathInfo()) {
			case "/login":
				LoginController.login(req, res);
				break;
			case "/getSession":
				SessionController.getSession(req, res);
				break;
			case "/EmpRequestNewReimb":
				ReimbursementController.addReimbursements(req, res);
				break;
		}
	}

}