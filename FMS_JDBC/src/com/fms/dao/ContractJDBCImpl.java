package com.fms.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.fms.beans.Contract;

public class ContractJDBCImpl implements ContractDAO {

	@Override
	public Contract addContractor(Contract contract) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			
			// 2.Get the connection
			String dbUrl = "jdbc:mysql://localhost:3306/forestrymanagementsystem_db";

			
			FileReader fn = new FileReader("C:/Users/Vidhatrieeeee/Desktop/db.properties");
			Properties props = new Properties();
			props.load(fn);
			connection = DriverManager.getConnection(dbUrl, props);
			

			//3.Issue the sql queries
			String sql = "insert into contract values(?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1,contract.getContractNo());
			preparedStatement.setInt(2, contract.getCustomerId());
			preparedStatement.setInt(3, contract.getProductId());
			preparedStatement.setInt(4, contract.getHaulierId());
			preparedStatement.setString(5, contract.getDeliveryDate());
			preparedStatement.setString(6, contract.getDeliveryDay());
			preparedStatement.setInt(7, contract.getQuantity());
			int count = preparedStatement.executeUpdate();

			if(count>0) {
				return contract;
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//5. Close all JDBC objects
			if(connection != null)
			{
				try
				{
					connection.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(preparedStatement != null)
			{
				try {
					preparedStatement.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public boolean deleteContractor(Integer contractId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			//1. load the driver
			Class.forName("com.mysql.jdbc.Driver");

			//2.Get the connection
			String dbUrl="jdbc:mysql://localhost:3306/forestrymanagementsystem_db";
			connection = DriverManager.getConnection(dbUrl,"JDBC","abcd");

			//3.Issue the sql queries
			String sql="delete from contract where contractNo=?";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, contractId);

			int count = preparedStatement.executeUpdate();

			//4. Process the Result returned by SQL Queries
			if(count > 0){
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			//5. Close all JDBC objects
			if(connection != null)
			{
				try
				{
					connection.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(preparedStatement != null)
			{
				try {
					preparedStatement.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}

		return false;

	}

	@Override
	public Contract modifyContractor(Integer contractId, Contract contract) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			//1. load the driver
			Class.forName("com.mysql.jdbc.Driver");

			//2.Get the connection
			String dbUrl="jdbc:mysql://localhost:3306/forestrymanagementsystem_db";
			connection = DriverManager.getConnection(dbUrl,"JDBC","abcd");

			//3.Issue the sql queries
			String sql = "update contract set delivery_Date=?, delivery_Day=?, quantity=? where contractNo=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, contract.getDeliveryDate());
			preparedStatement.setString(2, contract.getDeliveryDay());
			preparedStatement.setInt(3, contract.getQuantity());
			preparedStatement.setInt(4, contractId);
			int count = preparedStatement.executeUpdate();
			if(count>0) {
				return contract;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			if(connection != null)
			{
				try
				{
					connection.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(preparedStatement != null)
			{
				try {
					preparedStatement.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		return null;
	}



}
