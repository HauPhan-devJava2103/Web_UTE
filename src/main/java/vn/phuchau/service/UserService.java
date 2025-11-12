package vn.phuchau.service;

import vn.phuchau.modal.User;

public interface UserService {
	User login(String username, String password);

	User get(String username);
}
