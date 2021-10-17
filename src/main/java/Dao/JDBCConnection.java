package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	
	public static Connection getJDBCConnection() {
		
		final String url 		= "jdbc:mysql://localhost:3306/user";
		final String username 	= "root";
		final String password 	= "";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			return DriverManager.getConnection(url, username, password);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
}
