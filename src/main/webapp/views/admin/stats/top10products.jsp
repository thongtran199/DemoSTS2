<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>AdminLTE 3 | Dashboard</title>
<%@ include file="/common/admin/head.jsp" %>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper">
		
<%@ include file="/common/admin/header.jsp" %>
			<!-- Main content -->
			<section class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-12">

							<!-- /.card -->

							<div class="card">
								<div class="card-header">
									<h3 class="card-title">TOP 10 sản phẩm bán chạy nhất</h3>
								</div>
								<!-- /.card-header -->
								<div class="card-body">
									<div id="example1_wrapper"
										class="dataTables_wrapper dt-bootstrap4">
										<div class="row">
											<div class="col-sm-12">
												<table id="example1"
													class="table table-bordered table-striped dataTable dtr-inline"
													aria-describedby="example1_info">
													<thead>
														<tr>
															<th class="sorting sorting_asc" tabindex="0"
																aria-controls="example1" rowspan="1" colspan="1"
																aria-sort="ascending"
																aria-label="Rendering engine: activate to sort column descending">ProductID
															</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
																rowspan="1" colspan="1"
																aria-label="Browser: activate to sort column ascending">ProductName</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
																rowspan="1" colspan="1"
																aria-label="Platform(s): activate to sort column ascending">Quantity</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
																rowspan="1" colspan="1"
																aria-label="Platform(s): activate to sort column ascending">Sold Quantity</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
																rowspan="1" colspan="1"
																aria-label="Platform(s): activate to sort column ascending">UnitPrice</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
																rowspan="1" colspan="1"
																aria-label="Platform(s): activate to sort column ascending">Color</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
																rowspan="1" colspan="1"
																aria-label="Engine version: activate to sort column ascending">Poster
															</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach items="${products}" var="item" varStatus="loop">
															<c:set var="rowClass"
																value="${loop.index % 2 == 0 ? 'even' : 'odd'}" />
															<tr class="${rowClass}">
																<td class="dtr-control sorting_1" tabindex="0">${item.productID}</td>
																<td class="dtr-control sorting_1" tabindex="0"><a
																	href="http://localhost:8080/DemoSTS/product?action=viewDetail&id=${item.productID}">${item.productName}</a></td>
																<td class="dtr-control sorting_1" tabindex="0">${item.quantity}</td>
																<td class="dtr-control sorting_1" tabindex="0">${item.soldQuantity}</td>
																<td class="dtr-control sorting_1" tabindex="0">${item.unitPrice}</td>
																<td class="dtr-control sorting_1" tabindex="0">${item.color}</td>
																<td><img src="files/product/${item.image}"
																	style="width: 50px; height: 50px;" /></td>
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
		<%@ include file="/common/admin/footer.jsp" %>
	<script>
  $(function () {
    $("#example1").DataTable({
      "responsive": true, "lengthChange": false, "autoWidth": false,
      "buttons": ["copy", "csv", "excel", "pdf", "print", "colvis"]
    }).buttons().container().appendTo('#example1_wrapper .col-md-6:eq(0)');
  });

	</script>

</body>
</html>
