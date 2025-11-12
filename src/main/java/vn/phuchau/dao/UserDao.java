package vn.phuchau.dao;

import vn.phuchau.modal.User;

public interface UserDao {
	User get(String username);
}
