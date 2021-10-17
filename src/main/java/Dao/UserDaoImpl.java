package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.User;

public class UserDaoImpl implements UserDao{

	@Override
	public void CreateUser(User user) {
		Connection connection = JDBCConnection.getJDBCConnection();
		
		String sql = "INSERT INTO USER(name, username, password, role, age) VALUES(?,?,?,?,?)";
	
		try {
			PreparedStatement preStatement = connection.prepareStatement(sql);
			preStatement.setString(1, user.getName());
			preStatement.setString(2, user.getUsername());
			preStatement.setString(3, user.getPassword());
			preStatement.setString(4, user.getRole());
			preStatement.setInt(5, user.getAge());
			
			preStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public User search(String username) {
		Connection connection = JDBCConnection.getJDBCConnection();
		
		String sql = "SELECT * FROM USER WHERE USERNAME = ?";
		
		try {
			PreparedStatement preStatement = connection.prepareStatement(sql);
			preStatement.setString(1, username);
			ResultSet rs = preStatement.executeQuery();
			
			while (rs.next()) {
				return rowMap(rs);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	private User rowMap(ResultSet rs) throws SQLException {
		
		User user = new User();
		
		user.setId(rs.getInt("id"));
		user.setName(rs.getString("name"));
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setRole(rs.getString("role"));
		user.setAge(rs.getInt("age"));
		
		return user;
		
	}
	
}
