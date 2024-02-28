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
		<section class="content">
			<div class="container-fluid">
				<div class="row">
					<div class="col-12">

						<!-- /.card -->

						<div class="card">
							<div class="card-header">
								<h3 class="card-title">Order# ${order.orderID}</h3>
							</div>
							<!-- /.card-header -->
							<div class="card-body">
								<div id="example1_wrapper"
									class="dataTables_wrapper dt-bootstrap4">
									<div class="row">
										<div class="col-6">
											<label for="">Trạng thái</label>
											<div class="row">
												<div class="col-8">

													<div class="form-group">


														<c:choose>

															<c:when test="${order.status == 4}">
																<select class="custom-select rounded-0" id="status">
																	<option value="4" selected>Người dùng đã xác
																		nhận</option>
																	<option value="1">Đang giao</option>
																	<option value="2">Đã thanh toán</option>
																</select>
															</c:when>

															<c:when test="${order.status == 1}">
																<select class="custom-select rounded-0" id="status">
																	<option value="1" selected>Đang giao</option>
																	<option value="2">Đã thanh toán</option>
																</select>
															</c:when>

															<c:when test="${order.status == 0}">
        Người dùng chưa xác nhận đơn hàng
    </c:when>

															<c:otherwise>
																<select class="custom-select rounded-0" id="status"
																	disabled>
																	<option value="2" selected>Đã thanh toán</option>
																</select>
															</c:otherwise>

														</c:choose>





													</div>
												</div>
												<div class="col-4">
													<c:choose>
														<c:when test="${order.status != 2 && order.status != 0}">
															<button type="button" style="height: 38px;"
																class="btn btn-block btn-primary btn-sm"
																onclick="updateBtn('${order.orderID}')">Cập
																nhật</button>
														</c:when>
														<c:otherwise>


														</c:otherwise>
													</c:choose>

													<input type="hidden" id="orderID" value="${order.orderID}" />
												</div>
											</div>
										</div>

									</div>
									<div class="row">
										<div class="col-sm-12">
											<table id="example1"
												class="table table-bordered table-striped dataTable dtr-inline"
												aria-describedby="example1_info">
												<thead>
													<tr>
														<th class="sorting" tabindex="0" aria-controls="example1"
															rowspan="1" colspan="1"
															aria-label="Browser: activate to sort column ascending">OrderDetailID</th>
														<th class="sorting" tabindex="0" aria-controls="example1"
															rowspan="1" colspan="1"
															aria-label="Platform(s): activate to sort column ascending">ProductID</th>
														<th class="sorting" tabindex="0" aria-controls="example1"
															rowspan="1" colspan="1"
															aria-label="Platform(s): activate to sort column ascending">ProductName</th>
														<th class="sorting" tabindex="0" aria-controls="example1"
															rowspan="1" colspan="1"
															aria-label="Platform(s): activate to sort column ascending">Quantity</th>
														<th class="sorting" tabindex="0" aria-controls="example1"
															rowspan="1" colspan="1"
															aria-label="Platform(s): activate to sort column ascending">UnitPrice</th>


														<th class="sorting" tabindex="0" aria-controls="example1"
															rowspan="1" colspan="1"
															aria-label="Platform(s): activate to sort column ascending">Total</th>
														<th class="sorting" tabindex="0" aria-controls="example1"
															rowspan="1" colspan="1"
															aria-label="Engine version: activate to sort column ascending">Poster
														</th>
														<th class="sorting" tabindex="0" aria-controls="example1"
															rowspan="1" colspan="1"
															aria-label="CSS grade: activate to sort column ascending">Action
														</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach items="${orderDetails}" var="item"
														varStatus="loop">
														<c:set var="rowClass"
															value="${loop.index % 2 == 0 ? 'even' : 'odd'}" />
														<tr class="${rowClass}">
															<td class="dtr-control sorting_1" tabindex="0">${item.orderDetailID}</td>
															<td class="dtr-control sorting_1" tabindex="0">${item.product.productID}</td>
															<td class="dtr-control sorting_1" tabindex="0"><a
																href="http://localhost:8080/DemoSTS/product?action=viewDetail&id=${item.product.productID}">${item.product.productName}</a></td>
															<td class="dtr-control sorting_1" tabindex="0">${item.quantity}</td>
															<td class="dtr-control sorting_1" tabindex="0">${item.unitPrice}</td>
															<td class="dtr-control sorting_1" tabindex="0">${item.unitPrice * item.quantity}</td>

															<td><img src="files/product/${item.product.image}"
																style="width: 50px; height: 50px;" /></td>
															<td>
																<div>
																	<button type="button"
																		class="btn btn-block btn-outline-warning btn-sm"
																		onclick="editBtn('${item.orderDetailID}')">Sửa</button>
																</div>
															</td>
														</tr>
													</c:forEach>
												</tbody>
											</table>
										</div>
									</div>
								</div>
							</div>
							<!-- /.card-body -->
						</div>
						<!-- /.card -->
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.container-fluid -->
		</section>

		<!-- /.content -->
	</div>
	<!-- /.content-wrapper -->
	<%@ include file="/common/admin/footer.jsp"%>
	<script>
		$(function() {
			$("#example1").DataTable(
					{
						"responsive" : true,
						"lengthChange" : false,
						"autoWidth" : false,
						"buttons" : [ "copy", "csv", "excel", "pdf", "print",
								"colvis" ]
					}).buttons().container().appendTo(
					'#example1_wrapper .col-md-6:eq(0)');
		});
		function editBtn(id) {
			const editURL = "http://localhost:8080/DemoSTS/adorderdetail?action=edit&id="
					+ id;
			console.log(editURL);
			window.location.href = editURL;
		}

		function updateBtn(id) {
			// Prevent the form from submitting
			event.preventDefault();
			var url = "http://localhost:8080/DemoSTS/adorder?action=updateStatus";
			var formData = {
				'orderID' : id,
				'status' : $("#status").val(),
			};

			console.log(formData);
			$
					.ajax({
						url : url,
						type : "POST",
						data : formData,
					})
					.then(
							function(data) {
								window.location.href = "http://localhost:8080/DemoSTS/adorder?action=viewDetail&id="
										+ $("#orderID").val();
							}).fail(function(err) {
						console.log("Oops error: " + err);
					});
		}
	</script>

</body>
</html>
