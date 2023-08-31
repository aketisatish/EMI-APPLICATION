package com.user.registration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.sql.SQLException;
import java.util.Properties;

public class TestConnection {
	public static Connection createConnection() throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream("C:\\Users\\Dell\\Desktop\\Project\\emiApplication\\connection.properties"));
		Connection connection = null;
		try {
			Class.forName(properties.getProperty("driver"));
			connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"),
			 properties.getProperty("password"));
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			connection = DriverManager.getConnection(
//					"jdbc:oracle:thin:@localhost:1521:xe", "satish", "welcome");
			//System.out.println("connection created successfully!!");
		} catch (ClassNotFoundException | SQLException  e) {
			e.printStackTrace();
		}

		return connection;
	}
}
