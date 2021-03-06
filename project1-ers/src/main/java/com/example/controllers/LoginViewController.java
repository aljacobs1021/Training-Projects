package com.example.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class LoginViewController {

	public static String fetchLoginPage(HttpServletRequest req) throws ServletException, IOException {
		System.out.println(req.getContentType());
		System.out.println("This should return the view login.html");
		return "resources/html/login.html";

	}

	public static String fetchEmployeePage(HttpServletRequest req) throws ServletException, IOException {
		System.out.println(req.getContentType());
		System.out.println("This should return the view Employee.html");
		return "resources/html/Employee.html";

	}

	public static String fetchManagerPage(HttpServletRequest req) throws ServletException, IOException {
		System.out.println(req.getContentType());
		System.out.println("This should return the view Manager.html");
		return "resources/html/Manager.html";

	}

}