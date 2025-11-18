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
	public void update(Category category) {
		Category cate = new Category();
		cate = categoryDao.findById(category.getId());
		if (cate != null) {
			this.categoryDao.update(category);

		}

	}

	@Override
	public void delete(int id) {
		Category cate = new Category();
		cate = categoryDao.findById(id);
		if (cate != null) {
			this.categoryDao.delete(id);

		}

	}

	@Override
	public Category findById(int id) {
		return this.categoryDao.findById(id);
	}

	@Override
	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	@Override
	public List<Category> findName(String keyword) {
		return categoryDao.findName(keyword);
	}

}
