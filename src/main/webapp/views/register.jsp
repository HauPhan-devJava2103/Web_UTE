<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Đăng ký tài khoản</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body class="bg-light">

	<div class="container py-5">
		<div class="row justify-content-center">
			<div class="col-md-6 col-lg-5">

				<div class="card shadow-sm border-0">
					<div class="card-body p-4">

						<h3 class="text-center mb-4">Đăng Ký Tài Khoản</h3>

						<!-- Hiển thị thông báo -->
						<c:if test="${not empty alert}">
							<div
								class="alert 
                            <c:choose>
                                <c:when test="${alert.contains('thành công')}">alert-success</c:when>
                                <c:otherwise>alert-danger</c:otherwise>
                            </c:choose>
                            alert-dismissible fade show"
								role="alert">
								${alert}
								<button type="button" class="btn-close" data-bs-dismiss="alert"></button>
							</div>
						</c:if>

						<!-- Form đăng ký -->
						<form action="${pageContext.request.contextPath}/register"
							method="post">

							<div class="mb-3">
								<label class="form-label">Tên đăng nhập</label>
								<div class="input-group">
									<span class="input-group-text">@</span> <input type="text"
										name="username" class="form-control"
										placeholder="Nhập tên đăng nhập" required>
								</div>
							</div>

							<div class="mb-3">
								<label class="form-label">Email</label>
								<div class="input-group">
									<span class="input-group-text">Email</span> <input type="email"
										name="email" class="form-control" placeholder="Nhập email"
										required>
								</div>
							</div>

							<div class="mb-3">
								<label class="form-label">Mật khẩu</label>
								<div class="input-group">
									<span class="input-group-text">Lock</span> <input
										type="password" name="password" class="form-control"
										placeholder="Nhập mật khẩu" required>
								</div>
							</div>
							<div class="mb-3">
								<label class="form-label">Nhập lại mật khẩu</label>
								<div class="input-group">
									<span class="input-group-text">Lock</span> <input
										type="password" name="confirmPassword" class="form-control"
										placeholder="Nhập lại mật khẩu" required>
								</div>
							</div>

							<div class="d-grid">
								<button type="submit" class="btn btn-primary btn-lg">
									Đăng Ký</button>
							</div>
						</form>

						<div class="text-center mt-3">
							<p>
								Đã có tài khoản? <a
									href="${pageContext.request.contextPath}/login"
									class="text-decoration-none"> Đăng nhập ngay </a>
							</p>
						</div>

					</div>
				</div>

			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>