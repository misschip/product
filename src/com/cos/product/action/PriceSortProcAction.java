package com.cos.product.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.product.model.Product;
import com.cos.product.repository.ProductRepository;
import com.cos.product.repository.ProductRepository.SortBy;
import com.google.gson.Gson;

public class PriceSortProcAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductRepository productRepository = ProductRepository.getInstance();
		List<Product> products = productRepository.findAll(SortBy.price);
		
		Gson gson = new Gson();
		String result = gson.toJson(products);
		
		System.out.println(result);
		
		response.setCharacterEncoding("UTF-8");	// 이렇게 utf-8로 설정해 주고 나서 getWriter() 해야 한글이 안 깨짐!!
		PrintWriter out = response.getWriter();
		out.print(result);
	}

}
