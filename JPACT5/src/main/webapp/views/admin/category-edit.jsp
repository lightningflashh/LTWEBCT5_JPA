<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<form action="<c:url value='/admin/category/update'/>" method="post" enctype='multipart/form-data'>

    <label for="categoryname">Category Name:</label><br>
    <input type="text" id="categoryname" name="categoryName" value="${cate.categoryName}" required><br>

    <label for="images">Images:</label><br>

    <!-- Check if image URL starts with 'https' -->
    <c:if test="${cate.images.substring(0, 5) == 'https'}">
        <c:url value="${cate.images}" var="imgUrl"></c:url>
    </c:if>

    <!-- Check if image URL doesn't start with 'https' (local image) -->
    <c:if test="${cate.images.substring(0, 5) != 'https'}">
        <c:url value="/image?fname=${cate.images}" var="imgUrl"></c:url>
    </c:if>

    <img id="imagess" height="150" width="200" src="${imgUrl}"/><br>

    <input type="file" onchange="chooseFile(this)" id="images" name="images" value="{cate.images}"><br>

    <p>Status:</p>

    <!-- Active status -->
    <input type="radio" id="active" name="status" value="1" ${cate.status == 1 ? 'checked' : ''}>
    <label for="active">Đang hoạt động</label><br>

    <!-- Inactive status -->
    <input type="radio" id="inactive" name="status" value="0" ${cate.status != 1 ? 'checked' : ''}>
    <label for="inactive">Khóa</label><br>

    <!-- Hidden field for category ID -->
    <input type="hidden" name="categoryId" value="${cate.categoryId}">

    <input type="submit" value="Submit">
</form>

