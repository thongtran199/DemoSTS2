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
			<form action="adsupplier?action=create" method="post">
    <div class="card-body">
        <div class="row">
            <div class="col-sm-4">
                <div class="form-group">
                    <label for="">address</label>
                    <input type="text" class="form-control" id="address" name="address" placeholder="" value="">
                </div>
            </div>
            <div class="col-sm-4">
                <div class="form-group">
                    <label for="">companyName</label>
                    <input type="text" class="form-control" id="name" name="companyName" placeholder="" value="">
                </div>
            </div>
            <div class="col-sm-4">
                <div class="form-group">
                    <label for="">contactEmaik</label>
                    <input type="email" class="form-control" id="email" name="contactEmail" placeholder="" value="">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-4">
                <div class="form-group">
                    <label for="">contactFax</label>
                    <input type="text" class="form-control" id="fax" name="contactFax" placeholder="" value="">
                </div>
            </div>
            <div class="col-sm-4">
                <div class form-group>
                    <label for="">contactNumber</label>
                    <input type="text" class="form-control" id="number" name="contactNumber" placeholder="" value="">
                </div>
            </div>
            <div class="col-sm-4">
                <div class="form-group">
                    <label for="">contactPerson</label>
                    <input type="text" class="form-control" id="person" name="contactPerson" placeholder="" value="">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-3">
                <div class="form-group">
                    <label for="">Country</label>
                    <select class="custom-select rounded-0" id="country" name="country">
                        <option value="United States">Mỹ</option>
                        <option value="Viet Nam">Việt Nam</option>
                    </select>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="form-group">
                    <label for="">City</label>
                    <select class="custom-select rounded-0" id="city" name="city">
                        <option value="Ho Chi Minh">Hồ Chí Minh</option>
                        <option value="Gia Lai">Gia Lai</option>
                        <option value="Quang Ngai">Quảng Ngãi</option>
                    </select>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="form-group">
                    <label for="">State</label>
                    <select class="custom-select rounded-0" id="state" name="state">
                        <option value="Tan Phu">Tân Phú</option>
                        <option value="Quan 4">Quận 4</option>
                        <option value="Quan 5">Quận 5</option>
                        <option value="Pleiku">Pleiku</option>
                        <option value="Duc Pho">Đức Phổ</option>
                    </select>
                </div>
            </div>
            <div class="col-sm-3">
                <div class="form-group">
                    <label for="">zipcode</label>
                    <input type="text" class="form-control" id="zipcode" name="zipcode" placeholder="" value="">
                </div>
            </div>
        </div>
    </div>
    <div class="card-footer">
        <button id="submitBtn" type="submit" value="Submit" class="btn btn-block btn-dark">Submit</button>
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
