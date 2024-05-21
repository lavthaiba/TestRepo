package databasetest;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlConnect {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		String host = "jdbc:mysql://localhost:3306/";
		String dbName = "classicmodels";
		String username = "root";
		String password = "root";
		
		
		String dbURL = host + dbName;
		
		String dbDriver = "com.mysql.cj.jdbc.Driver";
	//	Class.forName(dbDriver).newInstance();
		
		Class.forName(dbDriver).getDeclaredConstructor().newInstance();
		
		//connection
		Connection connection = DriverManager.getConnection(dbURL, username, password);
		if(!connection.isClosed()) {
			
			System.out.println("Database connected successfully!");
		}
		
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from customers");
		
			while (resultSet.next()) {
			
			System.out.println(resultSet.getString("creditLimit"));
		}
		
		connection.close();
		
		if(connection.isClosed()) {
			
			System.out.println("Database connection is closed!");
		}

	}
	
	

}
