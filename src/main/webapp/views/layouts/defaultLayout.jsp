<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:getAsString name="title" /></title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
	integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/style1.css">
</head>
<body>
	<header class="header border-bottom">
		<p class="title text-secondary">Internet</p>
	</header>
	<div class="row main">
		<div class="col-2 navbar navbar-light border-right">
			<div class="search d-flex text-secondary mt-3">
				<input type="text" class="form-control" id="search"
					aria-describedby="search" placeholder="Search"> <i
					class="fas fa-search"></i>
			</div>
			<ul class="list-group list-group-flush navs mt-3">
				<li class="list-group-item bg-light">
					<a  class='<c:if test='${url == "createMachine" }'>bg-primary text-white</c:if>'
						href="${pageContext.request.contextPath}/createMachine"
						id="viewContent"> <i class="fas fa-plus"></i> Thêm máy
					</a></li>
				<li class="list-group-item bg-light">
					<a  class='<c:if test='${url == "readMachine" }'>bg-primary text-white</c:if>'
						href="${pageContext.request.contextPath}/readMachine"
						id="formContent"> <i class="fas fa-desktop"></i> Danh sách máy
					</a></li>
				<li class="list-group-item bg-light">
					<a 
						class='<c:if test='${url == "createCustomer" }'>bg-primary text-white</c:if>'
						href="${pageContext.request.contextPath}/createCustomer"
						id="formContent"> <i class="fas fa-plus"></i> Thêm khách hàng
					</a></li>
				<li class="list-group-item bg-light">
					<a  class='<c:if test='${url == "readCustomer" }'>bg-primary text-white</c:if>'
						href="${pageContext.request.contextPath}/readCustomer"
						id="formContent"> <i class="fas fa-users"></i> Danh sách khách hàng
					</a></li>
				<li class="list-group-item bg-light">
					<a  class='<c:if test='${url == "createService" }'>bg-primary text-white</c:if>'
						href="${pageContext.request.contextPath}/createService"
						id="formContent"> <i class="fas fa-plus"></i> Thêm dịch vụ
					</a></li>
				<li class="list-group-item bg-light">
					<a  class='<c:if test='${url == "readService" }'>bg-primary text-white</c:if>'
						href="${pageContext.request.contextPath}/readService"
						id="formContent"> <i class="fas fa-utensils"></i> Danh sách dịch vụ
				</a></li>
				<li class="list-group-item bg-light">
					<a  class='<c:if test='${url == "dkSuDungMay" }'>bg-primary text-white</c:if>'
						href="${pageContext.request.contextPath}/dkSuDungMay"
						id="formContent"><i class="fas fa-plus"></i> Đăng kí sử dụng máy
					</a></li>
				<li class="list-group-item bg-light">
					<a  class='<c:if test='${url == "dkSuDungDV" }'>bg-primary text-white</c:if>'
						href="${pageContext.request.contextPath}/dkSuDungDV"
						id="formContent"> <i class="fas fa-plus"></i> Đăng kí sử dụng dịch vụ
					</a></li>
				<li class="list-group-item bg-light">
					<a  class='<c:if test='${url == "info" }'>bg-primary text-white</c:if>'
						href="${pageContext.request.contextPath}/info"
						id="formContent"> <i class="fas fa-history"></i> Lịch sử sử dụng
					</a></li>
			</ul>
		</div>
		<div class="col" id="content">
			<tiles:insertAttribute name="body" />
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"
		integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF"
		crossorigin="anonymous"></script>
	<script type="text/javascript" src="resources/js/validation.js"></script>
</body>
</html>