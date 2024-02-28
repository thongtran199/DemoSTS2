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
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="https://unpkg.com/gijgo@1.9.14/js/gijgo.min.js" type="text/javascript"></script>
    <link href="https://unpkg.com/gijgo@1.9.14/css/gijgo.min.css" rel="stylesheet" type="text/css" />
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
							<input id="datepicker" width="276" onchange="handleDateChange()" style="margin-bottom:200px"/>
								<div class="card-header">
									<h3 class="card-title">DataTable with default features</h3>
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
																aria-label="Rendering engine: activate to sort column descending">OrderID
															</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
																rowspan="1" colspan="1"
																aria-label="Browser: activate to sort column ascending">CustomerName</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
																rowspan="1" colspan="1"
																aria-label="Platform(s): activate to sort column ascending">SellerName</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
																rowspan="1" colspan="1"
																aria-label="Platform(s): activate to sort column ascending">OrderDate</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
																rowspan="1" colspan="1"
																aria-label="Platform(s): activate to sort column ascending">Total</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
																rowspan="1" colspan="1"
																aria-label="Platform(s): activate to sort column ascending">Status</th>
														
	
						
														</tr>
													</thead>
													<tbody>
														<c:forEach items="${orders}" var="item" varStatus="loop">
															<c:set var="rowClass"
																value="${loop.index % 2 == 0 ? 'even' : 'odd'}" />
															<tr class="${rowClass}">
																<td class="dtr-control sorting_1" tabindex="0"><a
																	href="http://localhost:8080/adorder?action=viewDetail&id=${item.orderID}">${item.orderID}</a></td>
																<td class="dtr-control sorting_1" tabindex="0">${item.user.fullName}</td>
																<td class="dtr-control sorting_1" tabindex="0">${item.seller.fullName}</td>
																<td class="dtr-control sorting_1" tabindex="0">${item.orderDate}</td>
																<td class="dtr-control sorting_1" tabindex="0">${item.total}</td>
																<td class="dtr-control sorting_1" tabindex="0">${item.status}</td>
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

	    $('#datepicker').datepicker();

	    // Kiểm tra xem có tham số day, month và year trong URL không
	    var urlParams = new URLSearchParams(window.location.search);
	    var day = urlParams.get("day");
	    var month = urlParams.get("month");
	    var year = urlParams.get("year");

	    if (day !== null && month !== null && year !== null) {
	      // Nếu có các tham số day, month và year, cập nhật trường nhập ngày
	      var formattedDate = (month < 10 ? '0' : '') + month + '/' + (day < 10 ? '0' : '') + day + '/' + year;
	      $('#datepicker').val(formattedDate);
	    } else {
	      // Nếu không có các tham số, cập nhật trường nhập ngày với ngày hôm nay
	      var today = new Date();
	      var currentDay = today.getDate();
	      var currentMonth = today.getMonth() + 1;
	      var currentYear = today.getFullYear();
	      var currentFormattedDate = (currentMonth < 10 ? '0' : '') + currentMonth + '/' + (currentDay < 10 ? '0' : '') + currentDay + '/' + currentYear;
	      $('#datepicker').val(currentFormattedDate);
	    }
	  });
	
	function handleDateChange() {
	    var dateInput = document.getElementById("datepicker");
	    var selectedDate = dateInput.value;

	    var parts = selectedDate.split("/");

	    if (parts.length === 3) {
	        var month = parseInt(parts[0], 10);
	        var day = parseInt(parts[1], 10);
	        var year = parseInt(parts[2], 10);

	        // The URL parameters should be separated by "&" instead of "?"
	        window.location.href = "adstats?action=print&day=" + day + "&month=" + month + "&year=" + year;
	    }
	}


	</script>

</body>
</html>
