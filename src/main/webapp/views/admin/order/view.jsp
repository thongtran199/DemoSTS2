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
								<h3 class="card-title">Quản lý đơn hàng</h3>
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


														<th class="sorting" tabindex="0" aria-controls="example1"
															rowspan="1" colspan="1"
															aria-label="CSS grade: activate to sort column ascending">Action
														</th>
													</tr>
												</thead>
												<tbody>
													<c:forEach items="${orders}" var="item" varStatus="loop">
														<c:set var="rowClass"
															value="${loop.index % 2 == 0 ? 'even' : 'odd'}" />
														<tr class="${rowClass}">
															<td class="dtr-control sorting_1" tabindex="0"><a
																href="adorder?action=viewDetail&id=${item.orderID}">${item.orderID}</a></td>
															<td class="dtr-control sorting_1" tabindex="0">${item.user.fullName}</td>
															<td class="dtr-control sorting_1" tabindex="0">${item.seller.fullName}</td>
															<td class="dtr-control sorting_1" tabindex="0">${item.orderDate}</td>
															<td class="dtr-control sorting_1" tabindex="0">${item.total}</td>
															<td class="dtr-control sorting_1" tabindex="0">
															
															<c:choose>
																	<c:when test="${item.status == 0}">
																       	Người dùng chưa xác nhận
																    </c:when>
																    <c:when test="${item.status == 4}">
    																
																       	Người dùng đã xác nhận
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
															<td>
																<div>

																	<button type="button"
																		class="btn btn-block btn-outline-danger btn-sm"
																		onclick="deleteBtn('${item.orderID}')">Xóa</button>
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
  $(function () {
    $("#example1").DataTable({
      "responsive": true, "lengthChange": false, "autoWidth": false,
      "buttons": ["copy", "csv", "excel", "pdf", "print", "colvis"]
    }).buttons().container().appendTo('#example1_wrapper .col-md-6:eq(0)');
  });
  function deleteBtn(id)
  {
      const deleteURL = "http://localhost:8080/DemoSTS/adorder?action=delete&id="+id;

      fetch(deleteURL, {
          method: "GET",
      })
      .then(response => {
          if (response.ok) {
             // alert("Xóa thành công");
              window.location.href="http://localhost:8080/DemoSTS/adorder";
          } else {
              alert("Xóa không thành công");
          }
      })
      .catch(error => {
          console.error("Lỗi khi gửi yêu cầu xóa: ", error);
      });
  }
  function editBtn(id)
  {
      const editURL = "http://localhost:8080/DemoSTS/adorder?action=edit&id="+id;
      console.log(editURL);
      window.location.href = editURL;
  }
	</script>

</body>
</html>
