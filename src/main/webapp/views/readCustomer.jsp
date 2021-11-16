<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<div>
	<p class="title-content mt-3 mb-2">Danh sách khách hàng</p>
	<div class="border">
		<p class="form-header pl-3 pr-3 mb-3">Danh sách khách của cửa hàng</p>
		<div class="m-3 search-area">
			<form action="${pageContext.request.contextPath}/readCustomer" method="get">
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
						<th scope="col" style="width: 10%">Mã KH</th>
						<th scope="col" style="width: 25%">Tên KH</th>
						<th scope="col" style="width: 25%">Địa chỉ</th>
						<th scope="col" style="width: 10%">Số điện thoại</th>
						<th scope="col" style="width: 20%">Email</th>
						<th scope="col" style="width: 10%">Actions</th>
					</tr>
				</thead>
				<tbody id="content-data">
					<c:forEach items="${khachHangs }" var="khachhang">
						<tr>
							<td>${khachhang.maKH}</td>
							<td>${khachhang.tenKH}</td>
							<td>${khachhang.diaChi}</td>
							<td>${khachhang.soDienThoai}</td>
							<td>${khachhang.email}</td>
							<td><a
								href="${pageContext.request.contextPath}/updateCustomer?maKH=${khachhang.maKH }"><i
									class="fas fa-edit"></i></a> <a onclick="deleteItem(event)"
								href="${pageContext.request.contextPath}/deleteCustomer?maKH=${khachhang.maKH }"><i
									class="fas fa-trash-alt"></i></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<ul class="pagination">
				<li class="page-item">
					<a class="page-link"
						href="${pageContext.request.contextPath}/readCustomer?page=${previousPage }&searchName=${searchName}">Previous</a></li>
				<c:forEach var="i" begin="1" end="${totalPages}">
					<li
						class="page-item <c:if test="${i == currentPage }">active</c:if>">
						<a class="page-link"
						href="${pageContext.request.contextPath}/readCustomer?page=${i }&searchName=${searchName}">
							${i } </a>
					</li>
				</c:forEach>
				<li class="page-item"><a class="page-link"
					href="${pageContext.request.contextPath}/readCustomer?page=${nextPage }&searchName=${searchName}">Next</a></li>
			</ul>
		</div>
	</div>
</div>