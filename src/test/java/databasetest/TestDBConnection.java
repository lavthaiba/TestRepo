package databasetest;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDBConnection {

	public static void main(String [] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		String host = "jdbc:mysql://localhost:3306/";
		String dbName = "classicmodels";
		String username = "root";
		String password = "root";
		String dbURL = host + dbName;
		
		String dbDriver = "com.mysql.cj.jdbc.Driver";
	//	Class.forName(dbDriver).newInstance();
		Class.forName(dbDriver).getConstructor().newInstance();
		
		//connection
		Connection connection = DriverManager.getConnection(dbURL, username, password);
		if(!connection.isClosed()) {
			
			System.out.println("Database connected successfully!");
		}
		
		//execute query 
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from employees");
		
		while (resultSet.next()) {
			
			System.out.println("firstname:"+resultSet.getString("firstname")+"\t"+"lastname:"+resultSet.getString("lastname")+"\t"+ "email:"+resultSet.getString("email"));
		}
		
		connection.close();
		
		if(connection.isClosed()) {
			
			System.out.println("Database has been successfully closed!");
		}
		
	}
}
