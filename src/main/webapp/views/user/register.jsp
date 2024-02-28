<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Catalog-Z Bootstrap 5.0 HTML Template</title>
<%@ include file="/common/head.jsp"%>
</head>
<body>
	<!-- Page Loader -->
	<%@ include file="/common/header.jsp"%>

	<section class="ftco-section contact-section bg-light">
		<div class="container">

			<div class="row block-9">
				<div class="col-12 order-md-last d-flex">
					<form action="register" method="post"
						class="bg-white p-5 contact-form">
						<h2 class="text-center">Register</h2>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Username"
								name="username">
						</div>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Password"
								name="password">
						</div>
						<div class="form-group">
							<input type="email" class="form-control" placeholder="Email"
								name="email">
						</div>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Telnumber"
								name="telnumber">
						</div>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Fullname"
								name="fullname">
						</div>
						<div class="form-group">
							<label for="">City</label>
							<div class="select-wrap">

								<select name="" id="shipcity" class="form-control">
									<option value="Hồ Chí Minh">Hồ Chí Minh</option>
									<option value="Quảng Ngãi">Quảng Ngãi</option>
									<option value="Gia Lai">Gia Lai</option>
									<option value="Khánh Hòa">Khánh Hòa</option>
								</select>
							</div>
						</div>
												<div class="form-group">
							<label for="">Quận / Huyện</label>
							<div class="select-wrap">
								<select name="" id="shipstate" class="form-control">
									<option value="Tân Phú">Tân Phú</option>
									<option value="Quận 5">Quận 5</option>
									<option value="Đức Phổ">Đức Phổ</option>
									<option value="Pleiku">Pleiku</option>
									<option value="Nha Trang">Nha Trang</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<input type="text" class="form-control"
								placeholder="Ship address" name="shipaddress">
						</div>
						<div class="form-group d-flex justify-content-center">
							<input type="submit" value="Register"
								class="btn btn-primary py-3 px-5">
						</div>
					</form>

				</div>

			</div>
		</div>
	</section>
	<%@ include file="/common/footer.jsp"%>
</body>
</html>