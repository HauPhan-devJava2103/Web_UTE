package vn.phuchau.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.phuchau.utils.Constant;

@WebServlet("/image")

public class DownloadFileController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String filename = req.getParameter("fname");

		if (filename == null || filename.isBlank()) {
			resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "File name is required");
			return;
		}

		File file = new File(Constant.DIR + File.separator + filename);

		if (!file.exists()) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		// Xác định file
		String mimeType = Files.probeContentType(file.toPath());
		if (mimeType == null) {
			mimeType = "application/octet-stream";
		}
		resp.setContentType(mimeType);
		resp.setContentLengthLong(file.length());

		try (InputStream in = new FileInputStream(file); OutputStream out = resp.getOutputStream()) {
			in.transferTo(out);
		}

	}
}
