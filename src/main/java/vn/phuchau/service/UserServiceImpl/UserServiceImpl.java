package vn.phuchau.service.UserServiceImpl;

import vn.phuchau.dao.UserDao;
import vn.phuchau.dao.impl.UserDaoImpl;
import vn.phuchau.modal.User;
import vn.phuchau.service.UserService;

public class UserServiceImpl implements UserService {

	UserDao userDao = new UserDaoImpl();

	@Override
	public User login(String username, String password) {
		User user = this.get(username);
		if (user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

	@Override
	public User get(String username) {
		return userDao.get(username);
	}

}
