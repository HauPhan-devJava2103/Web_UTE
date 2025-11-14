<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Home Page - Login</title>

<!-- Bootstrap CSS (v5) -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet" />
</head>
<body>

	<nav class="navbar navbar-light bg-light">
		<div class="container">
			<a class="navbar-brand" href="#">My Website</a>
		</div>
	</nav>

	<div class="container d-flex justify-content-center align-items-center"
		style="height: 80vh;">
		<a href="${pageContext.request.contextPath}/login"
			class="btn btn-danger px-4"> Login </a>
	</div>

</body>
</html>
