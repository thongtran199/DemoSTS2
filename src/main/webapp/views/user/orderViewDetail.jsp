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

<section class="ftco-section ftco-cart">
		<div class="container">
			<div class="row">
			<h2>Chi tiết đơn hàng # ${orderID}</h2>
				<div class="col-md-12 ftco-animate fadeInUp ftco-animated">
					<div class="cart-list">
						<table class="table">
							<thead class="thead-primary">
								<tr class="text-center">
									<th>OrderDetailID</th>
									<th>Image</th>
									<th>ProductName</th>
									<th>Quantity</th>
									<th>UnitPrice</th>
									<th>Total</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${orderDetails}" var="item">
									<tr class="text-center">
									

										<td class="price">
										
											<h3>${item.orderDetailID}</h3>
										
										</td>
																				<td class="image-prod"><div class="img"
												style="background-image:url(files/product/${item.product.image});"></div></td>

										<td class="product-name"><a href="product?action=viewDetail&id=${item.product.productID}">${item.product.productName}</a></td>

										<td class="quantity">
		${item.quantity }
										</td>

										<td class="total">${item.unitPrice}</td>
																				<td class="total">${item.quantity * item.unitPrice}</td>
									</tr>
									<!-- END TR-->
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</section>
	
	<%@ include file="/common/footer.jsp"%>
</body>
</html>