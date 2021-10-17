package Service;

import Model.User;

public interface UserService {

	void createUser(User user);
	
	User search(String name);
	
	
}
