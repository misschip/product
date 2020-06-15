package com.cos.product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.product.action.Action;
import com.cos.product.action.DeleteAction;
import com.cos.product.action.HomeAction;
import com.cos.product.action.PriceSortProcAction;


@WebServlet("/prod")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doProcess(request, response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("cmd");
		Action action = router(command);
		action.execute(request, response);
	}
	
	private Action router(String command) {
		if (command.equals("home")) {
			return new HomeAction();
		} else if (command.equals("delete")) {
			return new DeleteAction();
		} else if (command.equals("priceSortProc")) {
			return new PriceSortProcAction();
		}
		
		return null;
	}

}
