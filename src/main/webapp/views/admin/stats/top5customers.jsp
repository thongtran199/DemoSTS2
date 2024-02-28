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
									<h3 class="card-title">TOP 5 người dùng mua nhiều nhất</h3>
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
																aria-label="Rendering engine: activate to sort column descending">UsẻID
															</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
																rowspan="1" colspan="1"
																aria-label="Browser: activate to sort column ascending">FullName</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
																rowspan="1" colspan="1"
																aria-label="Platform(s): activate to sort column ascending">Email</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
																rowspan="1" colspan="1"
																aria-label="Platform(s): activate to sort column ascending">TotalMoney</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
																rowspan="1" colspan="1"
																aria-label="Platform(s): activate to sort column ascending">TotalOrder</th>

														</tr>
													</thead>
													<tbody>
														<c:forEach items="${customers}" var="item" varStatus="loop">
															<c:set var="rowClass"
																value="${loop.index % 2 == 0 ? 'even' : 'odd'}" />
															<tr class="${rowClass}">
																<td class="dtr-control sorting_1" tabindex="0">${item.userID}</td>
																<td class="dtr-control sorting_1" tabindex="0">${item.fullName}</td>
																<td class="dtr-control sorting_1" tabindex="0">${item.email}</td>
																<td class="dtr-control sorting_1" tabindex="0">${item.total}</td>
																<td class="dtr-control sorting_1" tabindex="0">${item.total_order}</td>
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
