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
<style>
.form-control {
	font-size: 14px;
	height: 40px;
	margin-bottom: 0px;
}

.ftco-section {
	padding-top: 20px;
}

.card-footer {
	background-color: white;
	padding: 0px;
	border: none;
}
</style>
</head>
<body>
	<!-- Page Loader -->
	<%@ include file="/common/header.jsp"%>


	<section class="ftco-section">
		<div class="container">
			<div class="row">
			<h2><%= request.getAttribute("header") %></h2>
				<form>
					<div class="card-body d-flex gap-1 align-items-center">
						<div class="form-group">
							<label for="exampleInputEmail1">Name</label> <input type="text" value="${name}"
								class="form-control" id="productName" placeholder="Enter name">
						</div>
						<div class="form-group">
							<label>Color</label> <select class="form-control" id="color"
								style="font-size: 14px;">
								<option value="">không</option>
								<option value="red">đỏ</option>
								<option value="blue">xanh dương</option>
								<option value="yellow">vàng</option>
								<option value="green">xanh lá</option>
								<option value="black">đen</option>
								<option value="white">trắng</option>
							</select>
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Giá bắt đầu</label> <input
								type="number" class="form-control" id="priceBegin" value="${priceBegin}"
								placeholder="">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Giá kết thúc</label> <input
								type="number" class="form-control" id="priceEnd" placeholder="">
						</div>
						<div class="card-footer">
							<button id="submitBtn" type="submit" class="btn btn-primary"
								style="margin-top: 17px; margin-left: 5px;">Submit</button>
						</div>
					</div>
					<!-- /.card-body -->


				</form>
			</div>
			<div class="row">
				<c:forEach items="${products}" var="item">
					<div class="col-md-6 col-lg-3 ftco-animate">
						<div class="product">
							<a href="product?action=viewDetail&id=${item.getProductID()}"
								class="img-prod"><img class="img-fluid"
								src="files/product/${item.getImage()}" alt="Colorlib Template"> <span
								class="status">30%</span>
								<div class="overlay"></div> </a>
							<div class="text py-3 pb-4 px-3 text-center">
								<h3>
									<a href="#">${item.getProductName()}</a>
								</h3>
								<div class="d-flex">
									<div class="pricing">
										<p class="price">
											<span class="mr-2 price-dc">$1000</span><span
												class="price-sale">$${item.getUnitPrice()}</span>
										</p>
									</div>
								</div>
								<div class="bottom-area d-flex px-3">
									<div class="m-auto d-flex">
										<a href="#"
											class="add-to-cart d-flex justify-content-center align-items-center text-center">
											<span><i class="ion-ios-menu"></i></span>
										</a> <a href="product?action=addToCart&id=${item.getProductID()}"
											class="buy-now d-flex justify-content-center align-items-center mx-1">
											<span><i class="ion-ios-cart"></i></span>
										</a> <a href="#"
											class="heart d-flex justify-content-center align-items-center ">
											<span><i class="ion-ios-heart"></i></span>
										</a>
									</div>
								</div>
							</div>
						</div>
					</div>

				</c:forEach>

			</div>
		</div>
	</section>


	<%@ include file="/common/footer.jsp"%>
	<script>
	$("#submitBtn").click(function (event) {
	    event.preventDefault();

	    var productName = $("#productName").val();
	    var color = $("#color").val();
	    var priceBegin = $("#priceBegin").val();
	    var priceEnd = $("#priceEnd").val();

	    var url = "http://localhost:8080/DemoSTS/product?action=search&productName=" + productName + "&color=" + color + "&priceBegin=" + priceBegin + "&priceEnd=" + priceEnd;

	    window.location.href = url;
	});


	</script>
</body>
</html>