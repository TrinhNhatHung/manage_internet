<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<div>
	<p class="title-content mt-3 mb-2">Chỉnh sửa dịch vụ</p>
	<form action="${pageContext.request.contextPath}/updateService" method="post" class="border" id="updateService">
		<p class="form-header pl-3 pr-3 mb-3">Chỉnh sửa thông tin dịch vụ</p>
		<div class="text-danger ml-3">${message }</div>
		<div class="d-flex flex-column pl-3 pr-3 text-secondary">
			<div class="form-group">
				<label for="name">Tên dịch vụ</label> <input type="text"
					name="name" class="form-control" id="name" value="${dichvu.tenDV }">
			</div>
			<div class="form-group">
				<label for="unit">Đơn vị tính</label> <input type="text"
					name="unit" class="form-control" id="unit" value="${dichvu.donViTinh }">
			</div>
			<div class="form-group">
				<label for="price">Đơn giá</label> <input type="number" name="price"
					class="form-control" id="price" value="${dichvu.donGia }">
			</div>
			<input type="hidden" name="maDV" value="${dichvu.maDV }">
			<div class="form-group">
				<button type="submit" class="btn btn-outline-secondary">Submit</button>
				<button type="reset" class="btn btn-outline-secondary">Reset</button>
			</div>
		</div>
	</form>
</div>