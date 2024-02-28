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
			<form action="adsupplier?action=edit" method="post">
				<div class="card-body">
					<div class="row">
						<div class="col-sm-4">
							<div class="form-group">
								<label for="">address</label> <input type="text"
									class="form-control" id="address" name="address" placeholder=""
									value="${supplier.address}"> <input type="hidden"
									id="supplierID" name="supplierID"
									value="${supplier.supplierID}" />
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<label for="">companyName</label> <input type="text"
									class="form-control" id="name" name="companyName"
									placeholder="" value="${supplier.companyName}">
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<label for="">contactEmaik</label> <input type="email"
									class="form-control" id="email" name="contactEmail"
									placeholder="" value="${supplier.contactEmail}">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-4">
							<div class="form-group">
								<label for="">contactFax</label> <input type="text"
									class="form-control" id="fax" name="contactFax" placeholder=""
									value="${supplier.contactFax}">
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<label for="">contactNumber</label> <input type="text"
									class "form-control" id="number" name="contactNumber"
									placeholder="" value="${supplier.contactNumber}">
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<label for="">contactPerson</label> <input type="text"
									class="form-control" id="person" name="contactPerson"
									placeholder="" value="${supplier.contactPerson}">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-3">
							<div class="form-group">
								<label for="">Country</label> <select
									class="custom-select rounded-0" id="country" name="country">
									<option value="United States"
										${supplier.country == 'United States' ? 'selected' : ''}>Mỹ</option>
									<option value="Viet Nam"
										${supplier.country == 'Viet Nam' ? 'selected' : ''}>Việt
										Nam</option>
								</select>
							</div>
						</div>
						<div class="col-sm-3">
							<div class="form-group">
								<label for="">City</label> <select
									class="custom-select rounded-0" id="city" name="city">
									<option value="Ho Chi Minh"
										${supplier.city == 'Ho Chi Minh' ? 'selected' : ''}>Hồ
										Chí Minh</option>
									<option value="Gia Lai"
										${supplier.city == 'Gia Lai' ? 'selected' : ''}>Gia
										Lai</option>
									<option value="Quang Ngai"
										${supplier.city == 'Quang Ngai' ? 'selected' : ''}>Quảng
										Ngãi</option>
								</select>
							</div>
						</div>
						<div class="col-sm-3">
							<div class="form-group">
								<label for="">State</label> <select
									class="custom-select rounded-0" id="state" name="state">
									<option value="Tan Phu"
										${supplier.state == 'Tan Phu' ? 'selected' : ''}>Tân
										Phú</option>
									<option value="Quan 4"
										${supplier.state == 'Quan 4' ? 'selected' : ''}>Quận
										4</option>
									<option value="Quan 5"
										${supplier.state == 'Quan 5' ? 'selected' : ''}>Quận
										5</option>
									<option value="Pleiku"
										${supplier.state == 'Pleiku' ? 'selected' : ''}>Pleiku</option>
									<option value="Duc Pho"
										${supplier.state == 'Duc Pho' ? 'selected' : ''}>Đức
										Phổ</option>
								</select>
							</div>
						</div>
						<div class="col-sm-3">
							<div class="form-group">
								<label for="">zipcode</label> <input type="text"
									class="form-control" id="zipcode" name="zipcode" placeholder=""
									value="${supplier.zipcode}">
							</div>
						</div>
					</div>
				</div>
				<div class="card-footer">
					<button id="submitBtn" type="submit" value="Submit"
						class="btn btn-block btn-dark">Submit</button>
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
