<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Category</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.0/font/bootstrap-icons.css"
	rel="stylesheet">
</head>
<body>

	<div class="container py-4">
		<div class="d-flex justify-content-between align-items-center mb-4">
			<h2 class="h4 mb-0">Quản lý danh mục</h2>
			<a href="${pageContext.request.contextPath}/admin/category/add"
				class="btn btn-success"> <i class="bi bi-plus-circle"></i> Thêm
				danh mục
			</a>
		</div>

		<div class="card shadow-sm">
			<div class="card-body p-0">
				<div class="table-responsive">
					<table class="table table-hover align-middle mb-0">
						<thead class="table-light">
							<tr>
								<th class="text-center" style="width: 80px;">#</th>
								<th>Tên danh mục</th>
								<th class="text-center">Ảnh</th>
								<th>Trạng thái</th>
								<th class="text-center" style="width: 120px;">Hành động</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="cat" items="${categories}" varStatus="loop">
								<tr>
									<td class="text-center fw-medium">${loop.index + 1}</td>
									<td>${cat.name}</td>

									<td class="text-center"><c:if
											test="${cat.images.substring(0,5) != 'https'}">
											<c:url value="/image?fname=${cat.images}" var="imgUrl"></c:url>
										</c:if> <c:if test="${cat.images.substring(0,5) == 'https'}">
											<c:url value="${cat.images}" var="imgUrl"></c:url>
										</c:if> <img src="${imgUrl}" width="100" height="80" /></td>
									<td><c:if test="${cat.status == 1}">
											<span>Hoạt động</span>
										</c:if> <c:if test="${cat.status != 1}">
											<span>Khóa</span>
										</c:if></td>
									<td class="text-center">
										<c:url var="editUrl" value="/admin/category/edit">
											<c:param name="id" value="${cat.id}" />
										</c:url>
										<c:url var="deleteUrl" value="/admin/category/delete">
											<c:param name="id" value="${cat.id}" />
										</c:url>

										<div class="btn-group btn-group-sm" role="group"
											aria-label="Hành động">
											<!-- Nút Sửa -->
											<a href="${editUrl}" class="btn btn-outline-primary"
												title="Sửa"> <i class="bi bi-pencil-square"></i>
											</a>

											<!-- Nút Xóa -->
											<a href="${deleteUrl}" class="btn btn-outline-danger"
												onclick="return confirm('Bạn có chắc muốn xóa danh mục: ${cat.name}?');"
												title="Xóa"> <i class="bi bi-trash"></i>
											</a>
										</div>
									</td>

								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
