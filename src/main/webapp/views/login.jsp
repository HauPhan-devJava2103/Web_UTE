<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB"
	crossorigin="anonymous">
</head>
<body class="p-4">

	<form action="login" method="post" class="mx-auto"
		style="max-width: 480px;">
		<h2 class="mb-3 text-center">Đăng nhập tài khoản</h2>

		<c:if test="${alert != null}">
			<div class="alert alert-danger">${alert}</div>
		</c:if>

		<section class="vstack gap-3">
			<div class="input-group">
				<span class="input-group-text">@</span> <input type="text"
					placeholder="Tài khoản" name="username" class="form-control">
			</div>

			<div class="input-group">
				<span class="input-group-text">🔒</span> <input type="password"
					placeholder="Mật khẩu" name="password" class="form-control">
			</div>

			<button type="submit" class="btn btn-primary">Đăng nhập</button>

			<div class="text-center mt-3">
				<a href="${pageContext.request.contextPath}/forgot-password"
					class="text-decoration-none text-muted"> Quên mật khẩu? </a>
			</div>

			<div class="text-center">
				<p class="mb-0">
					Chưa có tài khoản? <a
						href="${pageContext.request.contextPath}/register"
						class="text-decoration-none fw-medium"> Đăng ký ngay </a>
				</p>
			</div>
		</section>
	</form>

	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
		integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.min.js"
		integrity="sha384-G/EV+4j2dNv+tEPo3++6LCgdCROaejBqfUeNjuKAiuXbjrxilcCdDz6ZAVfHWe1Y"
		crossorigin="anonymous"></script>
</body>
</html>
