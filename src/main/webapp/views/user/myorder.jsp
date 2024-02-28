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
		<h2>Các đơn hàng của bạn</h2>
			<div class="row">
				<div class="col-md-12 ftco-animate fadeInUp ftco-animated">
					<div class="cart-list">
						<table class="table">
							<thead class="thead-primary">
								<tr class="text-center">
									<th>OrderID</th>
									<th>Total</th>
									<th>Status</th>
									<th>OrderDate</th>
									<th>Seller</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${orders}" var="item">
									<tr class="text-center">
									

										<td class="price">
										
											<h3><a href="myorderdetail?id=${item.orderID}">${item.orderID}</a> </h3>
										
										</td>

										<td class="price">${item.total}VND</td>

										<td class="quantity">
<c:choose>
    <c:when test="${item.status == 0}">
        Đang xử lý
    </c:when>
    <c:when test="${item.status == 1}">
        Đang giao
    </c:when>
    <c:when test="${item.status == 2}">
        Đã thanh toán
    </c:when>
    <c:otherwise>

    </c:otherwise>
</c:choose>
										</td>

										<td class="total">${item.orderDate}</td>
																				<td class="total">${item.seller.fullName}</td>
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