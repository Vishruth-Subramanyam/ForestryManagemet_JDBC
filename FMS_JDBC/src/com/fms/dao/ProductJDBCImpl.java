package com.fms.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.fms.beans.Product;

public class ProductJDBCImpl implements ProductDAO {

	@Override
	public Product addProduct(Product product) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			// 2.Get the connection
			String dbUrl = "jdbc:mysql://localhost:3306/forestrymanagementsystem_db";

			// Third way of connecting
			FileReader fn = new FileReader("C:/Users/Vidhatrieeeee/Desktop/db.properties");
			Properties props = new Properties();
			props.load(fn);
			con = DriverManager.getConnection(dbUrl, props);
		

			// 3.Issue the sql queries
			String sql = "insert into product values(?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, product.getProductId());
			pstmt.setString(2, product.getProductName());
			pstmt.setString(3, product.getProductDescription());

			int count = pstmt.executeUpdate();

			if (count > 0) {
				return product;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. Close all JDBC objects
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public Product modifyProduct(Product product, Integer productId) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			// 1. load the driver
			Class.forName("com.mysql.jdbc.Driver");

			// 2.Get the connection
			String dbUrl = "jdbc:mysql://localhost:3306/forestrymanagementsystem_db";
			con = DriverManager.getConnection(dbUrl, "JDBC", "abcd");

			// 3.Issue the sql queries
			String sql = "update product set product_Name =? ,product_Description =? where product_Id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, product.getProductName());
			pstmt.setString(2, product.getProductDescription());
			pstmt.setInt(3, productId);

			int count = pstmt.executeUpdate();
			if (count > 0) {
				return product;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. Close all JDBC objects
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public boolean deleteProduct(Integer productId) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			// 1. load the driver
			Class.forName("com.mysql.jdbc.Driver");

			// 2.Get the connection
			String dbUrl = "jdbc:mysql://localhost:3306/forestrymanagementsystem_db";
			con = DriverManager.getConnection(dbUrl, "JDBC", "abcd");

			// 3.Issue the sql queries
			String sql = "delete from product where product_Id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, productId);

			int count = pstmt.executeUpdate();

			// 4. Process the Result returned by SQL Queries
			if (count > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5. Close all JDBC objects
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return false;
	}

}
