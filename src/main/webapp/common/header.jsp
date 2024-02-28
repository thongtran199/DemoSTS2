<%@page import="com.sgu.service.impl.CartServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.sgu.service.CartService" %>
<%@ page import="com.sgu.service.impl.CartServiceImpl" %>
<%@ page import="com.sgu.constant.SessionAttribute" %>
<%@ page import="com.sgu.entity.User" %>
<%@ page import="com.sgu.entity.Cart" %>
<div class="py-1 bg-primary">
	<div class="container">
		<div
			class="row no-gutters d-flex align-items-start align-items-center px-md-0">
			<div class="col-lg-12 d-block">
				<div class="row d-flex">
					<div class="col-md pr-4 d-flex topper align-items-center">
						<div
							class="icon mr-2 d-flex justify-content-center align-items-center">
							<span class="icon-phone2"></span>
						</div>
						<span class="text">+ 1235 2355 98</span>
					</div>
					<div class="col-md pr-4 d-flex topper align-items-center">
						<div
							class="icon mr-2 d-flex justify-content-center align-items-center">
							<span class="icon-paper-plane"></span>
						</div>
						<span class="text">thongtranr27@email.com</span>
					</div>
					<div
						class="col-md-5 pr-4 d-flex topper align-items-center text-lg-right">
						<span class="text">3-5 Business days delivery &amp; Free
							Returns</span>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<nav
	class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light"
	id="ftco-navbar">
	<div class="container">
		<a class="navbar-brand" href="index">PoR27.Shop</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#ftco-nav" aria-controls="ftco-nav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="oi oi-menu"></span> Menu
		</button>

		<div class="collapse navbar-collapse" id="ftco-nav">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active"><a href="index" class="nav-link">Home</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="dropdown04"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Category</a>
					<div class="dropdown-menu" aria-labelledby="dropdown04">
					<a class="dropdown-item" href="product?action=view">Tất cả</a>
							
						<a class="dropdown-item" href="product?action=view&category=1">Điện
							thoại</a> <a class="dropdown-item"
							href="product?action=view&category=2">Laptop</a> <a
							class="dropdown-item" href="product?action=view&category=3">Đồng
							hồ </a> <a class="dropdown-item"
							href="product?action=view&category=4">Tai nghe</a> <a
							class="dropdown-item" href="product?action=view&category=5">Máy
							cũ</a>
					</div></li>
				<li class="nav-item"><a href="about" class="nav-link">About</a></li>
				<li class="nav-item"><a href="blog" class="nav-link">Blog</a></li>
				<li class="nav-item"><a href="contact" class="nav-link">Contact</a></li>
				<c:choose>
					<c:when test="${not empty sessionScope.currentUser}">

						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="dropdown19"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Welcome,
								${sessionScope.currentUser.fullName}</a>
							<div class="dropdown-menu" aria-labelledby="dropdown19">
								<a class="dropdown-item" href="profile">Thông tin cá nhân</a>
								 <a
									class="dropdown-item" href="myorder">Lịch sử mua
									hàng</a>
																	 <a
									class="dropdown-item" href="cart">Giỏ hàng</a>
									<a
									class="dropdown-item" href="changePass">Đổi mật khẩu</a>
									 <a class="dropdown-item" href="logout">Đăng xuất</a>
							</div></li>

					</c:when>
					<c:otherwise>
						<li class="nav-item"><a href="login" class="nav-link">Login</a></li>
						<li class="nav-item"><a href="register" class="nav-link">Register</a></li>
						<li class="nav-item"><a href="forgotPass" class="nav-link">Forgot
								Password</a></li>
					</c:otherwise>
				</c:choose>




			</ul>
		</div>
	</div>
</nav>
<!-- END nav -->

