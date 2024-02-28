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
																aria-label="Rendering engine: activate to sort column descending">UserID
															</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
																rowspan="1" colspan="1"
																aria-label="Browser: activate to sort column ascending">FullName</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
																rowspan="1" colspan="1"
																aria-label="Platform(s): activate to sort column ascending">UserName</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
																rowspan="1" colspan="1"
																aria-label="Platform(s): activate to sort column ascending">Password</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
																rowspan="1" colspan="1"
																aria-label="Platform(s): activate to sort column ascending">Email</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
																rowspan="1" colspan="1"
																aria-label="Platform(s): activate to sort column ascending">Role</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
																rowspan="1" colspan="1"
																aria-label="Platform(s): activate to sort column ascending">Poster</th>
															<th class="sorting" tabindex="0" aria-controls="example1"
																rowspan="1" colspan="1"
																aria-label="CSS grade: activate to sort column ascending">Action
															</th>
														</tr>
													</thead>
													<tbody>
														<c:forEach items="${users}" var="item" varStatus="loop">
															<c:set var="rowClass"
																value="${loop.index % 2 == 0 ? 'even' : 'odd'}" />
															<tr class="${rowClass}">
																<td class="dtr-control sorting_1" tabindex="0">${item.userID}</td>
																<td class="dtr-control sorting_1" tabindex="0">${item.fullName}</td>
																<td class="dtr-control sorting_1" tabindex="0">${item.userName}</td>
																<td class="dtr-control sorting_1" tabindex="0">${item.password}</td>
																<td class="dtr-control sorting_1" tabindex="0">${item.email}</td>
																<td class="dtr-control sorting_1" tabindex="0"><c:choose>
																	<c:when test="${item.role == 0}">
        Admin
    </c:when>
																	<c:when test="${item.role == 1}">
        Seller
    </c:when>
																	<c:when test="${item.role == 2}">
        Customer
    </c:when>
																	<c:otherwise>

																	</c:otherwise>
																</c:choose></td>
																	<td><img src="files/imageuser/${item.image}"
																	style="width: 50px; height: 50px;" /></td>
																	<td>
																	<div>
																		<button type="button"
																			class="btn btn-block btn-outline-warning btn-sm"
																			onclick="editBtn('${item.userID}')">Sửa</button>
																		<button type="button"
																			class="btn btn-block btn-outline-danger btn-sm"
																			onclick="deleteBtn('${item.userID}')">Xóa</button>
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
		<%@ include file="/common/admin/footer.jsp" %>
	<script>
  $(function () {
    $("#example1").DataTable({
      "responsive": true, "lengthChange": false, "autoWidth": false,
      "buttons": ["copy", "csv", "excel", "pdf", "print", "colvis"]
    }).buttons().container().appendTo('#example1_wrapper .col-md-6:eq(0)');
  });
  function deleteBtn(id)
  {
      const deleteURL = "http://localhost:8080/DemoSTS/adaccount?action=delete&id="+id;

      fetch(deleteURL, {
          method: "GET",
      })
      .then(response => {
          if (response.ok) {
             // alert("Xóa thành công");
              window.location.href="http://localhost:8080/DemoSTS/adaccount";
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
      const editURL = "http://localhost:8080/DemoSTS/adaccount?action=edit&id="+id;
      console.log(editURL);
      window.location.href = editURL;
  }
	</script>

</body>
</html>
