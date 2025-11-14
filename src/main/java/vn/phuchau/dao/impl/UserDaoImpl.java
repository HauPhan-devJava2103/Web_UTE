package vn.phuchau.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vn.phuchau.config.DBMySQLConnect;
import vn.phuchau.dao.UserDao;
import vn.phuchau.modal.User;

public class UserDaoImpl implements UserDao {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public User get(String username) {
		String sql = "SELECT * FROM `User` WHERE username = ?";
		try {
			conn = new DBMySQLConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(User user) {
		String sql = "INSERT INTO `User`(username,email,password) VALUES (?,?,?)";
		try {
			conn = new DBMySQLConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean checkExistEmail(String email) {
		String query = "SELECT 1 FROM `User` WHERE email = ? LIMIT 1";

		try (Connection conn = new DBMySQLConnect().getConnection();
				PreparedStatement ps = conn.prepareStatement(query)) {

			ps.setString(1, email);
			try (ResultSet rs = ps.executeQuery()) {
				return rs.next();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean checkExistUsername(String username) {

		String query = "SELECT 1 FROM `User` WHERE username = ? LIMIT 1";

		try (Connection conn = new DBMySQLConnect().getConnection();
				PreparedStatement ps = conn.prepareStatement(query)) {

			ps.setString(1, username);
			try (ResultSet rs = ps.executeQuery()) {
				return rs.next();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updatePassword(String email, String newPassword) {
		String sql = "UPDATE `User` SET password = ? WHERE email = ?";
		try (Connection conn = new DBMySQLConnect().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, newPassword);
			ps.setString(2, email);
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
