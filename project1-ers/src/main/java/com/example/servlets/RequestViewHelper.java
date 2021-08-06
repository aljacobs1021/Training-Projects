package com.example.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import com.example.controllers.LoginViewController;

public class RequestViewHelper {
	
	//This is the class the will delegate tasks to certain controllers
	public static String process(HttpServletRequest req) throws ServletException, IOException {
		System.out.println("In the request helper, with the URI: " + req.getRequestURI());
		//We will use the specific URI's to send the request to the correct controller
		switch(req.getRequestURI()) {
			case "/project1-ers/login":
				return LoginViewController.fetchLoginPage(req);
		}
		return "/project1-ers/login";
	}
	
}