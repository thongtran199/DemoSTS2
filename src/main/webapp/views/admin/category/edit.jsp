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
				<h3 class="card-title">Create new account</h3>
			</div>
			<!-- /.card-header -->
			<!-- form start -->
			<form action="adcategory?action=edit" method="post">
				<div class="card-body">



					<div class="row">
						<div class="col-sm-12">
							<div class="form-group">
								<label for="">categoryName</label> <input type="text"
									class="form-control" name="categoryName" placeholder="" value="${category.categoryName}">
									<input
									type="hidden" name="categoryID" value="${category.categoryID}" />
							</div>
						</div>

					</div>



					<!-- /.card-body -->
				</div>
				<div class="card-footer">

					<button id="submitBtn" type="submit" class="btn btn-block btn-dark" value="Submit">Submit</button>
				</div>
			</form>
		</div>
		<!-- /.content -->
	</div>
	<!-- /.content-wrapper -->
	<%@ include file="/common/admin/footer.jsp"%>
	<script>
	
	
	

	</script>
</body>
</html>
