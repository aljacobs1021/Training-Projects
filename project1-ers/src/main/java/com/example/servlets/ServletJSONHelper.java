package com.example.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.controllers.LoginController;
//import com.example.controllers.LogoutController;
import com.example.controllers.SessionController;
import com.fasterxml.jackson.core.JsonProcessingException;

public class ServletJSONHelper {
	
	public static void process(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException{
		System.out.println("In the ServletJSONHelper with URI: " + req.getRequestURI());
		switch(req.getRequestURI()) {
			case "/project1-ers/api/login":
				LoginController.login(req, res);
				break;
			/*case "/SocialHubWeek4/api/logout":
				//LogoutController.logout(req, res);
				break; */
			case "/project1-ers/api/getSession":
				SessionController.getSession(req, res);
				break;
		}
	}
	
}