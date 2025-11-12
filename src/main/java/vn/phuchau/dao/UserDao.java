package vn.phuchau.dao;

import vn.phuchau.modal.User;

public interface UserDao {
	User get(String username);

	void insert(User user);

	boolean checkExistEmail(String email);

	boolean checkExistUsername(String username);
}
