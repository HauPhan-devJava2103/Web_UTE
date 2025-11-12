package vn.phuchau.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.phuchau.service.UserService;
import vn.phuchau.service.UserServiceImpl.UserServiceImpl;

@WebServlet("/register")
public class RegisterController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String REGISTER = "/register.jsp";
	public static final String LOGIN = "/login.jsp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
		rd.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String confirmPassword = req.getParameter("confirmPassword");

		UserService userService = new UserServiceImpl();
		String alertMsg = "";

		if (userService.checkExistEmail(email)) {
			alertMsg = "Email đã tồn tại";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher(REGISTER).forward(req, resp);
			return;

		}
		if (userService.checkExistUsername(username)) {
			alertMsg = "Tài khoản đã tồn tại!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher(REGISTER).forward(req, resp);
			return;
		}

		if (!password.equals(confirmPassword)) {
			alertMsg = "Mật khẩu nhập lại không khớp";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher(REGISTER).forward(req, resp);
		}
		boolean isSuccess = userService.register(username, email, password);
		if (isSuccess) {
			alertMsg = "Đăng ký thành công! Vui lòng đăng nhập.";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher(LOGIN).forward(req, resp);
		} else {
			alertMsg = "System error!";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher(REGISTER).forward(req, resp);
		}

	}

}
