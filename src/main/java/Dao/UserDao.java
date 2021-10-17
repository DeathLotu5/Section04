package Dao;

import Model.User;

public interface UserDao {
	
	void CreateUser(User user);
	
	User search(String username);
	
}
