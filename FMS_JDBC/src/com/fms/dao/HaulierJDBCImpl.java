package com.fms.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.fms.beans.Address;
import com.fms.beans.Haulier;

public class HaulierJDBCImpl implements HaulierDAO {

	@Override
	public Haulier addHaulier(Haulier haulier) {
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
			String sql = "insert into haulier values(?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, haulier.getHaulierId());
			pstmt.setString(2, haulier.getHaulierName());
			pstmt.setLong(6, haulier.getTelephoneNumber());
			pstmt.setString(7, haulier.getEmailAddress());
			pstmt.setString(3, haulier.getAddress().getStreetAddress1());
			pstmt.setString(4, haulier.getAddress().getStreetAddress2());
			pstmt.setString(5, haulier.getAddress().getTownCity());
			pstmt.setInt(9, haulier.getAddress().getPostCode());
			pstmt.setString(8, haulier.getHaulierPassword());
			int count = pstmt.executeUpdate();

			if (count > 0) {
				return haulier;
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
	public boolean deleteHaulier(Integer haulierId, String haulierPassword) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			// 1. load the driver
			Class.forName("com.mysql.jdbc.Driver");

			// 2.Get the connection
			String dbUrl = "jdbc:mysql://localhost:3306/forestrymanagementsystem_db";
			con = DriverManager.getConnection(dbUrl, "JDBC", "abcd");

			// 3.Issue the sql queries
			String sql = "delete from haulier where haulier_Id=? and Password=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, haulierId);
			pstmt.setString(2, haulierPassword);

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
	public Haulier searchHaulier(Integer haulierId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Haulier haulier = null;
		Address address = new Address();

		try {
			// 1. load the driver
			Class.forName("com.mysql.jdbc.Driver");

			// 2.Get the connection
			String dbUrl = "jdbc:mysql://localhost:3306/forestrymanagementsystem_db";
			con = DriverManager.getConnection(dbUrl, "JDBC", "abcd");

			// 3.Issue the sql queries
			String sql = "select * from haulier where haulier_Id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, haulierId);
			rs = pstmt.executeQuery();

			// 4.process the result
			if (rs.next()) {
				int haulierId1 = rs.getInt("haulier_Id");
				String haulierName = rs.getString("haulier_Name");
				String streetAddress1 = rs.getString("streetAddress1");
				String streetAddress2 = rs.getString("streetAddress2");
				String townCity = rs.getString("town_City");
				int postCode = rs.getInt("postCode");
				Long telephoneNumber = rs.getLong("telephoneNo");
				String email = rs.getString("email");
				String haulierPassword = rs.getString("Password");

				haulier = new Haulier();
				haulier.setHaulierId(haulierId);
				;
				haulier.setHaulierName(haulierName);
				address.setStreetAddress1(streetAddress1);
				address.setStreetAddress2(streetAddress2);
				address.setTownCity(townCity);
				address.setPostCode(postCode);
				haulier.setTelephoneNumber(telephoneNumber);
				haulier.setEmailAddress(email);
				haulier.setHaulierPassword(haulierPassword);
				haulier.setAddress(address);
			} else {
				return null;
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
		return haulier;

	}

	@Override
	public Haulier modifyHaulier(Haulier haulier, String passwd) {
		Connection con = null;
		PreparedStatement pstmt = null;
		Address address = new Address();
		try {
			// 1. load the driver
			Class.forName("com.mysql.jdbc.Driver");

			// 2.Get the connection
			String dbUrl = "jdbc:mysql://localhost:3306/forestrymanagementsystem_db";
			con = DriverManager.getConnection(dbUrl, "JDBC", "abcd");

			// 3.Issue the sql queries
			String sql = "update haulier set haulier_Name =? ,telephoneNo=? ,email=?,streetAddress1 =? ,streetAddress2=?,"
					+ "town_City=?,postCode=? , Password=? where haulier_Id=? and Password = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, haulier.getHaulierName());
			pstmt.setLong(2, haulier.getTelephoneNumber());
			pstmt.setString(3, haulier.getEmailAddress());
			pstmt.setString(4, haulier.getAddress().getStreetAddress1());
			pstmt.setString(5, haulier.getAddress().getStreetAddress2());
			pstmt.setString(6, haulier.getAddress().getTownCity());
			pstmt.setInt(7, haulier.getAddress().getPostCode());
			pstmt.setString(8, haulier.getHaulierPassword());
			pstmt.setInt(9, haulier.getHaulierId());
			pstmt.setString(10, passwd);

			int count = pstmt.executeUpdate();
			if (count > 0) {
				return haulier;
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

}
