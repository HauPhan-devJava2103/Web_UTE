package vn.phuchau.dao;

import java.util.List;

import vn.phuchau.modal.Category;

public interface CategoryDao {

	void insert(Category category);

	void edit(Category category);

	void delete(int id);

	Category get(int id);

	List<Category> getAll();

	List<Category> search(String keyword);

}
