<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<p class="title-content mt-3 mb-2">Đăng kí sử dụng dịch vụ</p>
	<form action="${pageContext.request.contextPath}/dkSuDungDV"
		method="post" class="border" id="dkSuDungDV">
		<p class="form-header pl-3 pr-3 mb-3">Đăng kí sử dụng dịch vụ cho
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
						<label for="maDV">Mã dịch vụ</label> <select class="form-control"
							name="maDV">
							<c:forEach items="${maDVs }" var="maDV">
								<option value="${maDV }">${maDV }</option>
							</c:forEach>
						</select>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<div class="form-group">
						<label for="ngaySuDung">Ngày sử dụng</label> <input type="date"
							name="ngaySuDung" class="form-control" id="ngaySuDung"
							value="${suDungDichVu.id.ngaySuDung }">
					</div>
				</div>
				<div class="col">
					<div class="form-group">
						<label for="gioSuDung">Giờ sử dụng</label> <input type="time"
							name="gioSuDung" class="form-control" id="gioSuDung">
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-6">
					<div class="form-group">
						<label for="soLuong">Số lượng</label> <input type="number"
							name="soLuong" class="form-control" id="soLuong" min="0">
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