package com.fms.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.fms.beans.Address;
import com.fms.beans.Customer;

public class CustomerJDBCImpl implements CustomerDAO {

	@Override
	public Customer addCustomer(Customer customer) {
		Connection con = null;
		PreparedStatement pstmt = null;
		Address address = new Address();

		try {
			// 2.Get the connection
			String dbUrl = "jdbc:mysql://localhost:3306/forestrymanagementsystem_db";

			// Third way of connecting
			FileReader fn = new FileReader("C:/Users/Vidhatrieeeee/Desktop/db.properties");
			Properties props = new Properties();
			props.load(fn);
			con = DriverManager.getConnection(dbUrl, props);
			
			// 3.Issue the sql queries
			String sql = "insert customer values(?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, customer.getCustomerId());
			pstmt.setString(2, customer.getCustomerName());
			pstmt.setLong(7, customer.getTelephoneNumber());
			pstmt.setString(8, customer.getEmailAddress());
			pstmt.setString(4, customer.getAddress().getStreetAddress1());
			pstmt.setString(5, customer.getAddress().getStreetAddress2());
			pstmt.setString(6, customer.getAddress().getTownCity());
			pstmt.setInt(9, customer.getAddress().getPostCode());
			pstmt.setString(3, customer.getCustomerPassword());
			int count = pstmt.executeUpdate();

			if (count > 0) {
				return customer;
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
		return customer;
	}

	@Override
	public boolean deleteCustomer(Integer customer_id, String Password) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			// 2.Get the connection
			String dbUrl = "jdbc:mysql://localhost:3306/forestrymanagementsystem_db";
			con = DriverManager.getConnection(dbUrl, "JDBC", "abcd");

			// 3.Issue the sql queries
			String sql = "delete from customer where customer_id=? and password=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, customer_id);
			pstmt.setString(2, Password);

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

	@Override
	public Customer modifyCustomer(Customer customer, String passwd) {
		Connection con = null;
		PreparedStatement pstmt = null;
		Address address = new Address();
		try {

			// 2.Get the connection
			String dbUrl = "jdbc:mysql://localhost:3306/forestrymanagementsystem_db";
			con = DriverManager.getConnection(dbUrl, "JDBC", "abcd");

			// 3.Issue the sql queries
			String sql = "update customer set customer_Name =? ,telephoneNo=? ,email=?,streetAddress1 =? ,streetAddress2=?,"
					+ "town_City=?,postCode=? ,password=? where customer_id=? and Password = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, customer.getCustomerName());
			pstmt.setLong(2, customer.getTelephoneNumber());
			pstmt.setString(3, customer.getEmailAddress());
			pstmt.setString(4, customer.getAddress().getStreetAddress1());
			pstmt.setString(5, customer.getAddress().getStreetAddress2());
			pstmt.setString(6, customer.getAddress().getTownCity());
			pstmt.setInt(7, customer.getAddress().getPostCode());
			pstmt.setString(8, customer.getCustomerPassword());
			pstmt.setInt(9, customer.getCustomerId());
			pstmt.setString(10, passwd);
			customer.setAddress(address);

			int count = pstmt.executeUpdate();
			if (count > 0) {
				return customer;
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
	public Customer searchCustomer(Integer customer_id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Customer customer = null;
		Address address = new Address();

		try {

			// 2.Get the connection
			String dbUrl = "jdbc:mysql://localhost:3306/forestrymanagementsystem_db";

			
			FileReader fn = new FileReader("C:/Users/Vidhatrieeeee/Desktop/db.properties");
			Properties props = new Properties();
			props.load(fn);
			con= DriverManager.getConnection(dbUrl, props); 
			System.out.println("Connected");
			
			
			// 3.Issue the sql queries
			String sql = "select * from customer where customer_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, customer_id);
			rs = pstmt.executeQuery();

			// 4.process the result
			if (rs.next()) {
				int customerId = rs.getInt("customer_id");
				String customerName = rs.getString("customer_Name");
				String streetAddress1 = rs.getString("streetAddress1");
				String streetAddress2 = rs.getString("streetAddress2");
				String townCity = rs.getString("town_City");
				int postCode = rs.getInt("postCode");
				Long telephoneNumber = rs.getLong("telephoneNo");
				String email = rs.getString("email");
				String customerPassword = rs.getString("password");

				customer = new Customer();
				customer.setCustomerId(customerId);
				customer.setCustomerName(customerName);
				address.setStreetAddress1(streetAddress1);
				address.setStreetAddress2(streetAddress2);
				address.setTownCity(townCity);
				address.setPostCode(postCode);
				customer.setTelephoneNumber(telephoneNumber);
				customer.setEmailAddress(email);
				customer.setCustomerPassword(customerPassword);
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return customer;

	}
}
