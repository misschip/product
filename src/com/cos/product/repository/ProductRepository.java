package com.cos.product.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cos.product.db.DBConn;
import com.cos.product.model.Product;
import com.cos.product.model.Type;

public class ProductRepository {
	private static final String TAG = "ProductRepository : ";
	
	private static ProductRepository instance = new ProductRepository();
	private ProductRepository() {};
	
	public static ProductRepository getInstance() {
		return instance;
	}
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	public int deleteById(int id) {
		final String SQL = "DELETE FROM product WHERE id = ?";
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
		
			pstmt.setInt(1, id);
			
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	
	
	public List<Product> findAll() {
		final String SQL = "SELECT id,name,type,price,count FROM product";
		
		try {
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			
			List<Product> products = new ArrayList<>();
			
			while (rs.next()) {
				Product p = Product.builder()
						.id(rs.getInt("id"))
						.name(rs.getString("name"))
						.type(Type.valueOf(rs.getString("type")))
						.price(rs.getInt("price"))
						.count(rs.getInt("count"))
						.build();
				
				products.add(p);
			}
		
			return products;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
