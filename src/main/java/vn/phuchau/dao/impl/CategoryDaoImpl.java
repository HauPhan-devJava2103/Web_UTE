package vn.phuchau.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.phuchau.config.DBMySQLConnect;
import vn.phuchau.dao.CategoryDao;
import vn.phuchau.modal.Category;

public class CategoryDaoImpl implements CategoryDao {
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;

	@Override
	public void insert(Category category) {
		String sql = "INSERT INTO category (name,images) VALUES (?,?)";

		try {
			conn = new DBMySQLConnect().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.getName());
			ps.setString(2, category.getImages());

			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void edit(Category category) {
		String sql = "UPDATE category SET name = ?, images = ? WHERE id = ?";
		try {
			conn = new DBMySQLConnect().getConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, category.getName());
			ps.setString(2, category.getImages());
			ps.setInt(3, category.getId());

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM category WHERE id = ?";
		try {
			conn = new DBMySQLConnect().getConnection();
			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Category get(int id) {
		String sql = "SELECT id, name, images FROM category WHERE id = ?";

		try (Connection conn = new DBMySQLConnect().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, id);

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					Category category = new Category();
					category.setId(rs.getInt("id"));
					category.setName(rs.getString("name"));
					category.setImages(rs.getString("images"));
					return category;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Category> getAll() {
		List<Category> categories = new ArrayList<>();
		String sql = "SELECT * FROM category";

		try {
			conn = new DBMySQLConnect().getConnection();
			ps = conn.prepareStatement(sql);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Category category = new Category();
					category.setId(rs.getInt("id"));
					category.setName(rs.getString("name"));
					category.setImages(rs.getString("images"));
					categories.add(category);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return categories;
	}

	@Override
	public List<Category> search(String keyword) {
		List<Category> categories = new ArrayList<>();

		if (keyword == null || keyword.trim().isEmpty()) {
			return categories;
		}

		String sql = "SELECT id, name, images FROM category WHERE name LIKE ?";

		try (Connection conn = new DBMySQLConnect().getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, "%" + keyword.trim() + "%");

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Category category = new Category();
					category.setId(rs.getInt("id"));
					category.setName(rs.getString("name"));
					category.setImages(rs.getString("images"));
					categories.add(category);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return categories;
	}

}
