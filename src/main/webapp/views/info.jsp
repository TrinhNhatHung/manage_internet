<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<div>
	<p class="title-content mt-3 mb-2">Lịch sử</p>
	<div class="border">
		<p class="form-header pl-3 pr-3 mb-3">Lịch sử của cửa hàng</p>
		<div class="text-danger ml-3">${message }</div>
		<div class="pl-3 pr-3">
			<table class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th scope="col">Mã KH</th>
						<th scope="col">Tên KH</th>
						<th scope="col">Mã Máy</th>
						<th scope="col">Vị Trí</th>
						<th scope="col">TT</th>
						<th scope="col">Ngày BDSD</th>
						<th scope="col">Giờ BDSD</th>
						<th scope="col">TG SD</th>
						<th scope="col">Mã DV</th>
						<th scope="col">Ngày SD</th>
						<th scope="col">Giờ SD</th>
						<th scope="col">Số lượng</th>
						<th scope="col">Tổng tiền</th>
					</tr>
				</thead>
				<tbody id="content-data">
					<c:forEach items="${infos }" var="info">
						<tr>
							<td>${info.maKH}</td>
							<td>${info.tenKH}</td>
							<td>${info.maMay}</td>
							<td>${info.viTri}</td>
							<td>${info.trangThai}</td>
							<td>${info.m_ngayBatDauSuDung}</td>
							<td>${info.m_gioBatDauSuDung}</td>
							<td>${info.thoiGianSuDung}</td>
							<td>${info.maDV}</td>
							<td>${info.ngaySuDung}</td>
							<td>${info.gioSuDung}</td>
							<td>${info.soLuong}</td>
							<td>${info.tongTien}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<ul class="pagination">
				<li class="page-item"><a class="page-link"
					href="${pageContext.request.contextPath}/info?page=${previousPage }">Previous</a></li>
				<c:forEach var="i" begin="1" end="${totalPages}">
					<li
						class="page-item <c:if test="${i == currentPage }">active</c:if>">
						<a class="page-link"
						href="${pageContext.request.contextPath}/info?page=${i }">
							${i } </a>
					</li>
				</c:forEach>
				<li class="page-item"><a class="page-link"
					href="${pageContext.request.contextPath}/info?page=${nextPage }">Next</a></li>
			</ul>
		</div>
	</div>
</div>