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

	@Override
	public void insert(User user) {
		userDao.insert(user);

	}

	@Override
	public boolean register(String username, String email, String password) {
		if (userDao.checkExistEmail(email) || userDao.checkExistEmail(username)) {
			return false;
		}
		userDao.insert(new User(username, email, password));
		return true;

	}

	@Override
	public boolean checkExistEmail(String email) {
		return userDao.checkExistEmail(email);
	}

	@Override
	public boolean checkExistUsername(String username) {
		return userDao.checkExistUsername(username);
	}

	@Override
	public boolean updatePassword(String email, String password) {
		return this.userDao.updatePassword(email, password);
	}

}
