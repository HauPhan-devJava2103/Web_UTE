<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Sửa danh mục sản phẩm</title>
</head>
<body>
    <h2>Sửa danh mục sản phẩm</h2>

    <form action="${pageContext.request.contextPath}/admin/category/edit"
          method="post"
          enctype="multipart/form-data">

        <!-- ID và ảnh cũ -->
        <input type="hidden" name="id" value="${category.id}" />
        <input type="hidden" name="oldImage" value="${category.images}" />

        <div>
            <label>Tên danh mục:</label><br>
            <input type="text" name="name" required value="${category.name}" />
        </div>
        <br>

        <div>
            <label>Ảnh hiện tại:</label><br>
            <c:if test="${not empty category.images}">
                <img src="${pageContext.request.contextPath}/image?fname=${category.images}"
                     width="120" height="90" />
            </c:if>
            <c:if test="${empty category.images}">
                <span>Chưa có ảnh</span>
            </c:if>
        </div>
        <br>

        <div>
            <label>Ảnh mới (nếu muốn đổi):</label><br>
            <input type="file" name="imageFile" />
        </div>
        <br>

        <button type="submit">Cập nhật</button>
        <a href="${pageContext.request.contextPath}/admin/category">Quay lại danh sách</a>
    </form>
</body>
</html>
