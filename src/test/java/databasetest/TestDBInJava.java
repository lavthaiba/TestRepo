package databasetest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDBInJava {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "newdb";
		String dbURL = url + dbName;
		
		String username = "root";
		String password = "root";
		
		//create an object for mysql jdbc driver class
		
		String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver).newInstance();
		
		// connect to mysql database system
		
	Connection connection =	DriverManager.getConnection(dbURL, username, password);
	
	if(!connection.isClosed()) {
	
		System.out.println("successfully connected to mydb");
	}
	
	// Execute the query
	Statement statement = connection.createStatement();
	ResultSet resultSet = statement.executeQuery("select * from person");
	
	while(resultSet.next()) {

		System.out.println(resultSet.getString("name"));
	}
	connection.close();
	
	if(connection.isClosed()) {
		System.out.println("Database sucessfully closed!");
	}
	
	}
}
