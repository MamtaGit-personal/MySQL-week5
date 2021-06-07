package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private final static String URL = "jdbc:mysql://localhost:3306/vehicles";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "Promineo_2021";
	
	private static Connection connection;
	private static DBConnection instance;
	
	/* connectionString =  jdbc:mysql://hostname:port/databasename. The localhost is an 
	 * alias to 127.0.0.1, which is my actual computer. Here the 
	 * hostname = localhost, port = 3306 and database = vehicles (I have created this database)*/
	
	private DBConnection(Connection connection) {
		this.connection = connection;
	}	
	
	public static Connection getConnection() {
		if(instance == null) {
			try {
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				instance = new DBConnection(connection);
				System.out.println("Connected Successfully");
			}
			catch(SQLException e) {
				System.out.println("Error connecting to the database");
				e.printStackTrace();
			}
		}// if
		return DBConnection.connection;
	}
}
