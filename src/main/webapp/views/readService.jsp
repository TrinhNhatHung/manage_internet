<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<div>
	<p class="title-content mt-3 mb-2">Danh sách dịch vụ</p>
	<div class="border">
		<p class="form-header pl-3 pr-3 mb-3">Danh sách dịch vụ của cửa
			hàng</p>
		<div class="m-3 search-area">
			<form action="${pageContext.request.contextPath}/readService"
				method="get">
				<label for="search" class="form-label">Search:</label> <input
					type="text" class="form-control" id="search" name="searchName"
					placeholder="Search..." value="${searchName }">
				<button type="submit" class="btn btn-success">Seach</button>
			</form>
		</div>
		<div class="text-danger ml-3">${message }</div>
		<div class="pl-3 pr-3">
			<table class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th scope="col" style="width: 10%">Mã DV</th>
						<th scope="col" style="width: 40%">Tên DV</th>
						<th scope="col" style="width: 20%">Đơn vị tính</th>
						<th scope="col" style="width: 20%">Đơn giá</th>
						<th scope="col" style="width: 10%">Actions</th>
					</tr>
				</thead>
				<tbody id="content-data">
					<c:forEach items="${dichVus }" var="dichvu">
						<tr>
							<td>${dichvu.maDV}</td>
							<td>${dichvu.tenDV}</td>
							<td>${dichvu.donViTinh}</td>
							<td>${dichvu.donGia}</td>
							<td><a href="${pageContext.request.contextPath}/updateService?maDV=${dichvu.maDV}"><i
									class="fas fa-edit"></i></a> <a onclick="deleteItem(event)"
								href="${pageContext.request.contextPath}/deleteService?maDV=${dichvu.maDV }"><i
									class="fas fa-trash-alt"></i></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<ul class="pagination">
				<li class="page-item"><a class="page-link"
					href="${pageContext.request.contextPath}/readService?page=${previousPage }&searchName=${searchName}">Previous</a></li>
				<c:forEach var="i" begin="1" end="${totalPages}">
					<li
						class="page-item <c:if test="${i == currentPage }">active</c:if>">
						<a class="page-link"
						href="${pageContext.request.contextPath}/readService?page=${i }&searchName=${searchName}">
							${i } </a>
					</li>
				</c:forEach>
				<li class="page-item"><a class="page-link"
					href="${pageContext.request.contextPath}/readService?page=${nextPage }&searchName=${searchName}">Next</a></li>
			</ul>
		</div>
	</div>
</div>