<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<div>
	<p class="title-content mt-3 mb-2">Chỉnh sửa máy</p>
	<form action="${pageContext.request.contextPath}/updateMachine" method="post" class="border" id="updateMachine">
		<p class="form-header pl-3 pr-3 mb-3">Chỉnh sửa máy của quán</p>
		<div class="text-danger ml-3">${message }</div>
		<div class="d-flex flex-column pl-3 pr-3 text-secondary">
			<div class="form-group">
				<label for="position">Vị trí</label> <input type="text"
					name="position" class="form-control" id="position" value="${may.viTri }">
			</div>
			<div class="form-group">
				<label for="status">Trạng thái</label> <input type="text"
					name="status" class="form-control" id="status" value="${may.trangThai }">
			</div>
			<input type="hidden" name="maMay" value="${may.maMay }">
			<div class="form-group">
				<button type="submit" class="btn btn-outline-secondary">Submit</button>
				<button type="reset" class="btn btn-outline-secondary">Reset</button>
			</div>
		</div>
	</form>
</div>