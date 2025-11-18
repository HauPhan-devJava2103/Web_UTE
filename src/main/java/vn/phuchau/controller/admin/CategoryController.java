package vn.phuchau.controller.admin;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.phuchau.modal.Category;
import vn.phuchau.service.CategoryService;
import vn.phuchau.service.UserServiceImpl.CategoryServiceImpl;

@WebServlet("/admin/category")
public class CategoryController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CategoryService categoryService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Category> list = categoryService.findAll();

		req.setAttribute("categories", list);
		req.getRequestDispatcher("/views/admin/category-list.jsp").forward(req, resp);
	}

}
