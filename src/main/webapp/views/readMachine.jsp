<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<div>
	<p class="title-content mt-3 mb-2">Danh sách máy</p>
	<div class="border">
		<p class="form-header pl-3 pr-3 mb-3">Danh sách máy của cửa hàng</p>
		<div class="m-3 search-area">
			<form action="${pageContext.request.contextPath}/readMachine" method="get">
				<label for="search" class="form-label">Search:</label> <input
					type="text" class="form-control" id="search" name="searchMaMay"
					placeholder="Search..." value="${searchMaMay }">
				<button type="submit" class="btn btn-success">Seach</button>
			</form>
		</div>
		<div class="text-danger ml-3">${message }</div>
		<div class="pl-3 pr-3">
			<table class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th scope="col" style="width: 20%">Mã máy</th>
						<th scope="col" style="width: 30%">Vị tí</th>
						<th scope="col" style="width: 30%">Trạng thái</th>
						<th scope="col" style="width: 20%">Actions</th>
					</tr>
				</thead>
				<tbody id="content-data">
					<c:forEach items="${mays }" var="may">
						<tr>
							<td>${may.maMay}</td>
							<td>${may.viTri}</td>
							<td>${may.trangThai}</td>
							<td><a href="${pageContext.request.contextPath}/updateMachine?maMay=${may.maMay}"><i
									class="fas fa-edit"></i></a> <a onclick="deleteItem(event)"
								href="${pageContext.request.contextPath}/deleteMachine?maMay=${may.maMay }"><i
									class="fas fa-trash-alt"></i></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<ul class="pagination">
				<li class="page-item"><a class="page-link"
					href="${pageContext.request.contextPath}/readMachine?page=${previousPage }&searchMaMay=${searchMaMay}">Previous</a></li>
				<c:forEach var="i" begin="1" end="${totalPages}">
					<li
						class="page-item <c:if test="${i == currentPage }">active</c:if>">
						<a class="page-link"
						href="${pageContext.request.contextPath}/readMachine?page=${i }&searchMaMay=${searchMaMay}">
							${i } </a>
					</li>
				</c:forEach>
				<li class="page-item"><a class="page-link"
					href="${pageContext.request.contextPath}/readMachine?page=${nextPage }&searchMaMay=${searchMaMay}">Next</a></li>
			</ul>
		</div>
	</div>
</div>