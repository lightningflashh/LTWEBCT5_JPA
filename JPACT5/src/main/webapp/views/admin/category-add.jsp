<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<form action="<c:url value='/admin/category/insert' />" method="post" enctype='multipart/form-data'>

    <!-- Category Name Input -->
    <label>Category name:</label><br>
    <input type="text" id="name" name="categoryName"><br>

    <!-- Images Upload and Display -->
    <label for="image">Images</label><br>

    <!-- If image URL starts with 'https' -->
    <c:if test="${cate.images.substring(0, 5) == 'https'}">
        <c:url value="${cate.images}" var="imgUrl"></c:url>
    </c:if>

    <!-- If image URL does not start with 'https' -->
    <c:if test="${cate.images.substring(0, 5) != 'https'}">
        <c:url value="/image?fname=${cate.images}" var="imgUrl"></c:url>
    </c:if>

    <!-- Display image -->
    <img id="imagess" height="150" width="200" src="" /><br>

    <!-- File Upload Input -->
    <input type="file" onchange="chooseFile(this)" id="image" name="images"><br>

    <!-- Status -->
    <p>Status:</p>

    <!-- Active status -->
    <input type="radio" id="ston" name="status" value="1">
    <label>Đang hoạt động</label><br>

    <!-- Inactive status -->
    <input type="radio" id="css" name="status" value="0">
    <label for="css">Khóa</label><br>

    <!-- Submit Button -->
    <input type="submit" value="Submit">
</form>


