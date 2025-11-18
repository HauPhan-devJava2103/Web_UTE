package vn.phuchau.dao;

import java.util.List;

import vn.phuchau.modal.Category;

public interface CategoryDao {

	void insert(Category category);

	void update(Category category);

	void delete(int id);

	Category findById(int id);

	List<Category> findAll();

	List<Category> findName(String keyword);

}
