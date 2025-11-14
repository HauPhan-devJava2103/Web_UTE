package vn.phuchau.service.UserServiceImpl;

import java.util.List;

import vn.phuchau.dao.CategoryDao;
import vn.phuchau.dao.impl.CategoryDaoImpl;
import vn.phuchau.modal.Category;
import vn.phuchau.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

	CategoryDao categoryDao = new CategoryDaoImpl();

	@Override
	public void insert(Category category) {
		this.categoryDao.insert(category);

	}

	@Override
	public void edit(Category category) {
		this.categoryDao.edit(category);

	}

	@Override
	public void delete(int id) {
		this.categoryDao.delete(id);

	}

	@Override
	public Category get(int id) {
		return this.categoryDao.get(id);
	}

	@Override
	public List<Category> getAll() {
		return categoryDao.getAll();
	}

	@Override
	public List<Category> search(String keyword) {
		return categoryDao.search(keyword);
	}

}
