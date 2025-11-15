package vn.phuchau.controller.admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import vn.phuchau.modal.Category;
import vn.phuchau.service.CategoryService;
import vn.phuchau.service.UserServiceImpl.CategoryServiceImpl;
import vn.phuchau.utils.Constant;

@WebServlet("/admin/category/add")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)
public class CategoryAddController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CategoryService categoryService = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/category-add.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		String name = req.getParameter("name");
		Part filePart = req.getPart("imageFile");

		String fileName = null;

		if (filePart != null && filePart.getSize() > 0) {

			fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

			File uploadDir = new File(Constant.DIR);
			if (!uploadDir.exists()) {
				uploadDir.mkdirs();
			}

			filePart.write(Constant.DIR + File.separator + fileName);
		}

		Category category = new Category();
		category.setName(name);
		category.setImages(fileName);

		categoryService.insert(category);
		resp.sendRedirect(req.getContextPath() + "/admin/category");
	}

}
