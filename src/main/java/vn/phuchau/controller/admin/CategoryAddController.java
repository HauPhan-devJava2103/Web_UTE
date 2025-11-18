package vn.phuchau.controller.admin;

import static vn.phuchau.utils.Constant.UPLOAD_DIRECTORY;

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

@WebServlet("/admin/category/add")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, // 1MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50 // 50MB
)
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

		String statusStr = req.getParameter("status");
		int status = Integer.parseInt(statusStr);

		Category category = new Category();
		category.setName(name);
		category.setStatus(status);

		String fname = "";
		String uploadPath = UPLOAD_DIRECTORY;
		File uploadDir = new File(uploadPath);

		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		try {

			Part part = req.getPart("images");
			if (part.getSize() > 0) {
				String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();

				int index = filename.lastIndexOf(".");
				String ext = filename.substring(index + 1);
				fname = System.currentTimeMillis() + "." + ext;

				// upload File
				part.write(uploadPath + "/" + fname);

				// Ghi DB
				category.setImages(fname);
			} else {
				category.setImages("avata.png");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		categoryService.insert(category);
		resp.sendRedirect(req.getContextPath() + "/admin/category");
	}

}
