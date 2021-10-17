package Service;

import Dao.UserDao;
import Dao.UserDaoImpl;
import Model.User;

public class UserServiceImpl implements UserService{

	private final UserDao userDao;
	
	public UserServiceImpl( ) {
		userDao = new UserDaoImpl();
	}
	
	@Override
	public void createUser(User user) {
		userDao.CreateUser(user);
		
	}

	@Override
	public User search(String name) {
		return userDao.search(name);
	}

	
	
}
