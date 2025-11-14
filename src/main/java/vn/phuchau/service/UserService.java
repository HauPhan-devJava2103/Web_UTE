package vn.phuchau.service;

import vn.phuchau.modal.User;

public interface UserService {
	User login(String username, String password);

	User get(String username);

	// Register
	void insert(User user);

	boolean register(String username, String email, String password);

	boolean checkExistEmail(String email);

	boolean checkExistUsername(String username);

	boolean updatePassword(String email, String password);
}
