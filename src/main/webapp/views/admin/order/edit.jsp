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
			<div class="card card-primary">
				<div class="card-header">
					<h3 class="card-title">Edit order ${order.orderID}</h3>
				</div>
				<!-- /.card-header -->
				<!-- form start -->

			</div>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
		<%@ include file="/common/admin/footer.jsp" %>

</body>
</html>
