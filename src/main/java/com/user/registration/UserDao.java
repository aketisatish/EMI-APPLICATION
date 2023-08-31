package com.user.registration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
//import java.io.FileNotFoundException;
//import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;

public class UserDao {
	// insert the data from database
	
	public static int saveData(UserData user) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		try {
			connection = TestConnection.createConnection();
			preparedStatement = connection.prepareStatement("insert into Loan values(?,?,?,?,?,?,?)");
			preparedStatement.setString(1, user.getEmployeeId());
			preparedStatement.setString(2, user.getCaste());
			preparedStatement.setString(3, user.getDateOfJoining());
			preparedStatement.setString(4, user.getEmployeeName());
			preparedStatement.setString(5, user.getSubCaste());
			preparedStatement.setString(6, user.getEmployeeFatherName());
			preparedStatement.setDouble(7, user.getThriftDeposit());
			result = preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (connection != null)
				connection.close();
			if (preparedStatement != null)
				preparedStatement.close();
		}
		return result;
	}

	// retrieve the data from data base

	public static ResultSet listOfUsers() {
		ResultSet resultSet = null;
		Connection connection = null;
		Statement statement = null;
		
		try {
			connection = TestConnection.createConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from loan");
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}

	// update the user data
	// ("update loan set caste=?, dateofJoining=?,
	// employeeName=?, subCaste=?,employeeFatherName=?,thriftDeposit=? where
	// employeeId =?;");
	public static boolean UpdateUser(UserData user) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean rowUpdated = false;
		
		try {
			connection = TestConnection.createConnection();
			preparedStatement = connection.prepareStatement(
					"update loan set caste=?, dateofJoining=?, employeeName=?, subCaste=?, employeeFatherName=?, thriftDeposit=? where employeeId=?");

			preparedStatement.setString(1, user.getCaste());
			preparedStatement.setString(2, user.getDateOfJoining());
			preparedStatement.setString(3, user.getEmployeeName());
			preparedStatement.setString(4, user.getSubCaste());
			preparedStatement.setString(5, user.getEmployeeFatherName());
			preparedStatement.setDouble(6, user.getThriftDeposit());
			preparedStatement.setString(7, user.getEmployeeId());
			rowUpdated = preparedStatement.execute();

		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		return rowUpdated;
	}

	// delete the user data
	// ("delete from loan where employeeId =?;");
	public static boolean deleteUserById(String employeeId) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean result = true;
		try {
			connection = TestConnection.createConnection();
			preparedStatement = connection.prepareStatement("delete from loan where employeeId=?");
			preparedStatement.setString(1, employeeId);
			result = preparedStatement.execute();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}

		return result;

	}

	public static ResultSet findById(String employeeId) {
		ResultSet resultset=null;
		
		try {
			Connection connection= TestConnection.createConnection();
		 PreparedStatement preparedStatement= connection.prepareStatement("select * from loan where employeeId=?");
		preparedStatement.setString(1, employeeId);
		 resultset= preparedStatement.executeQuery();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
		}
		
		return resultset;
	}

}