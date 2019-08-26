package com.fms.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.fms.beans.Orders;

public class OrdersJDBCImpl implements OrdersDAO {

	@Override
	public Orders addOrders(Orders order) {
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
			String sql = "insert into orders values(?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, order.getOrderNo());
			pstmt.setInt(2, order.getCustomerId());
			pstmt.setInt(3, order.getProductId());
			pstmt.setInt(4, order.getHaulierId());
			pstmt.setString(5, order.getDeliveryDate());
			pstmt.setInt(6, order.getQuantity());
			int count = pstmt.executeUpdate();

			if (count > 0) {
				return order;
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
	public Orders modifyOrders(Integer ordersNum, Orders order) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			// 1. load the driver
			Class.forName("com.mysql.jdbc.Driver");

			// 2.Get the connection
			String dbUrl = "jdbc:mysql://localhost:3306/forestrymanagementsystem_db";
			con = DriverManager.getConnection(dbUrl, "JDBC", "abcd");

			// 3.Issue the sql queries
			String sql = "update orders set customer_Id =? ,product_Id=?,"
					+ "haulier_Id=?,delivery_Date=? ,quantity=? where orderNo=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, order.getCustomerId());
			pstmt.setInt(2, order.getProductId());
			pstmt.setInt(3, order.getHaulierId());
			pstmt.setString(4, order.getDeliveryDate());
			pstmt.setInt(5, order.getQuantity());
			pstmt.setInt(6, ordersNum);

			int count = pstmt.executeUpdate();
			if (count > 0) {
				return order;
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
	public boolean deleteOrders(Integer ordersNum) {
		Connection con = null;
		PreparedStatement pstmt = null;
		Orders orders = null;
		boolean status = false;

		try {
			// 1. load the driver
			Class.forName("com.mysql.jdbc.Driver");

			// 2.Get the connection
			String dbUrl = "jdbc:mysql://localhost:3306/forestrymanagementsystem_db";
			con = DriverManager.getConnection(dbUrl, "JDBC", "abcd");

			// 3.Issue the sql queries
			String sql = "delete from orders where orderNo=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, ordersNum);
			int count = pstmt.executeUpdate();

			// 4. Process the Result returned by SQL Queries
			if (count > 0) {
				// System.out.println("Profile Deleted");
				status = true;
			} else {
				// System.out.println("Profile Deletion Failed");
				status = false;
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

		return status;

	}

}
