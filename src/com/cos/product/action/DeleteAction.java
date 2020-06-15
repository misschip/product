package com.cos.product.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.product.repository.ProductRepository;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("DeleteAction : execute() : id : " + id);

		ProductRepository productRepository = ProductRepository.getInstance();
		int result = productRepository.deleteById(id);
		
		PrintWriter out = response.getWriter();
		out.print(result);
	}

}
