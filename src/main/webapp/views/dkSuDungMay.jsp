<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<p class="title-content mt-3 mb-2">Đăng kí sử dụng máy</p>
	<form action="${pageContext.request.contextPath}/dkSuDungMay"
		method="post" class="border" id="dkSuDungMay">
		<p class="form-header pl-3 pr-3 mb-3">Đăng kí sử dụng máy cho
			khách hàng</p>
		<div class="text-danger ml-3">${message }</div>
		<div class="d-flex flex-column pl-3 pr-3 text-secondary">
			<div class="row">
				<div class="col">
					<div class="form-group">
						<label for="maKH">Mã khách hàng</label> <select
							class="form-control" name="maKH">
							<c:forEach items="${maKHs }" var="maKH">
								<option value="${maKH }">${maKH }</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="col">
					<div class="form-group">
						<label for="maMay">Mã máy</label> <select class="form-control"
							name="maMay">
							<c:forEach items="${maMays }" var="maMay">
								<option value="${maMay }">${maMay }</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<div class="form-group">
						<label for="ngayBatDauSuDung">Ngày bắt đầu sử dụng</label> <input
							type="date" name="ngayBatDauSuDung" class="form-control"
							id="ngayBatDauSuDung">
					</div>
				</div>
				<div class="col">
					<div class="form-group">
						<label for="gioBatDauSuDung">Giờ bắt đầu sử dụng</label> <input
							type="time" name="gioBatDauSuDung" class="form-control"
							id="gioBatDauSuDung">
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-6">
					<div class="form-group">
						<label for="thoiGianSuDung">Thời gian sử dụng</label> <input
							type="number" name="thoiGianSuDung" class="form-control"
							id="thoiGianSuDung" min="0">
					</div>
				</div>
			</div>

			<div class="form-group">
				<button type="submit" class="btn btn-outline-secondary">Submit</button>
				<button type="reset" class="btn btn-outline-secondary">Reset</button>
			</div>
		</div>
	</form>
</div>