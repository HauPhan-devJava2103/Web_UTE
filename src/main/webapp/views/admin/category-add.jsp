<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Thêm danh mục sản phẩm</title>
</head>
<body>
    <h2>Thêm danh mục sản phẩm</h2>

    <form action="${pageContext.request.contextPath}/admin/category/add"
          method="post"
          enctype="multipart/form-data">

        <div>
            <label>Tên danh mục:</label><br>
            <input type="text" name="name" required />
        </div>
        <br>

        <div>
            <label>Ảnh danh mục (tùy chọn):</label><br>
            <input type="file" name="images" />
        </div>
        <br>
	    <select name="status">
	        <option value="1">Hoạt động</option>
	        <option value="0">Không hoạt động</option>
	    </select>

        <button type="submit">Lưu</button>
        <a href="${pageContext.request.contextPath}/admin/category">Quay lại danh sách</a>
    </form>
</body>
</html>
