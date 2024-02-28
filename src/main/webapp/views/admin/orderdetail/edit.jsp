<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>AdminLTE 3 | Dashboard</title>

<%@ include file="/common/admin/head.jsp"%>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper">

		<%@ include file="/common/admin/header.jsp"%>
		<!-- Main content -->
		<div class="card card-primary">
			<div class="card-header">
				<h3 class="card-title">Edit product ${product.productName}</h3>
			</div>
			<!-- /.card-header -->
			<!-- form start -->
			<form>
				<div class="card-body">


					<div class="row">
						<div class="col-sm-12 ">
							<div class="form-group">
								<label for="">Products</label> <select
									class="custom-select rounded-0" id="productID">
									<c:forEach items="${products}" var="item" varStatus="loop">
										<option value="${item.productID}">${item.productID} - ${item.productName}</option>
									</c:forEach>

								</select>
							</div>
						</div>
					

					</div>
					
					<div class="row">
						<div class="col-sm-6 ">
							<div class="form-group">
								<label for="">unitPrice</label> <input type="number"
									class="form-control" id="unitPrice" placeholder=""
									value="${orderDetail.unitPrice}">
									
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group">
								<label for="">quantity</label> <input type="number"
									class="form-control" id="quantity" placeholder=""
									value="${orderDetail.quantity}">
									<input type="hidden" id="orderID" value="${orderDetail.order.orderID}">
									<input type="hidden" id="orderDetailID" value="${orderDetail.orderDetailID}">
							</div>
						</div>

					</div>


					<!-- /.card-body -->
				</div>
				<div class="card-footer">

					<button id="submitBtn" type="button" class="btn btn-block btn-dark">Submit</button>
				</div>
			</form>
		</div>
		<!-- /.content -->
	</div>
	<!-- /.content-wrapper -->
	<%@ include file="/common/admin/footer.jsp"%>
	<script>
	$("#submitBtn").click(function (event) {
	    // Prevent the form from submitting
	    event.preventDefault();
	    var url = "http://localhost:8080/DemoSTS/adorderdetail?action=edit";
	    var formData = {
	    	'orderDetailID': $("#orderDetailID").val(),
	        'productID': $("#productID").val(),
	        'quantity': $("#quantity").val(),
	        'unitPrice': $("#unitPrice").val(),
	    };

	    console.log(formData);
	    $.ajax({
	        url: url,
	        type: "POST",
	        data: formData,
	    }).then(function (data) {
	        window.location.href = "http://localhost:8080/DemoSTS/adorder?action=viewDetail&id="+$("#orderID").val();
	    }).fail(function (err) {
	        console.log("Oops error: " + err);
	    });

	});

	</script>
</body>
</html>
