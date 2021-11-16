<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<div>
	<p class="title-content mt-3 mb-2">Chỉnh sửa khách hàng</p>
	<form action="${pageContext.request.contextPath}/updateCustomer" method="post" class="border" id="updateCustomer">
		<p class="form-header pl-3 pr-3 mb-3">Chỉnh sửa tài khoản cho khách hàng</p>
		<div class="text-danger ml-3">${message }</div>
		<div class="d-flex flex-column pl-3 pr-3 text-secondary">
			<div class="form-group">
				<label for="name">Tên khách hàng</label> <input type="text"
					name="name" class="form-control" id="name"
					placeholder="Enter the name" value="${khachhang.tenKH }">
			</div>
			<div class="form-group">
				<label for="address">Địa chỉ</label> <input type="text"
					name="address" class="form-control" id="address"
					placeholder="Enter the address" value="${khachhang.diaChi }">
			</div>
			<div class="form-group">
				<label for="phone">Số điện thoại</label> <input type="text" name="phone"
					class="form-control" id="phone" placeholder="Enter the phone number" value="${khachhang.soDienThoai }">
			</div>
			<div class="form-group">
				<label for="email">Địa chỉ email</label> <input type="email" name="email"
					class="form-control" id="email"
					placeholder="example@gmail.com" value="${khachhang.email }">
			</div>
			<input type="hidden" name="maKH" value="${khachhang.maKH }">
			<div class="form-group">
				<button type="submit" class="btn btn-outline-secondary">Submit</button>
				<button type="reset" class="btn btn-outline-secondary">Reset</button>
			</div>
		</div>
	</form>
</div>