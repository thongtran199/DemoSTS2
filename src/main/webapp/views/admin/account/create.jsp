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
			<form>
				<div class="card-body">
					<div class="row">
						<div class="col-sm-8">
							<div class="row">
								<div class="form-group col-sm-12 d-flex">
									<label for="">image</label> <input type="file"
										class="form-control" id="image" placeholder="">
									<button class="btn btn-primary ml-3">Upload</button>
								</div>

							</div>

							<div class="form-group">
								<label for="">fullName</label> <input type="text"
									class="form-control" id="fullName" placeholder="" value=""><input
									type="hidden" id="" value="" />
							</div>
						</div>
						<div
							class="col-sm-4  d-flex justify-content-end align-items-center">
							<div class="form-group"
								style="width: 200px; min-height: 175px; overflow: hidden">
								<img src="files/imageuser/default.png"
									style="width: 100%; height: 100%; object-fit: contain;"
									id="posterImg" />
							</div>
						</div>

					</div>
					<div class="row">
						<div class="col-sm-4 ">
							<div class="form-group">
								<label for="">userName</label> <input type="text"
									class="form-control" id="userName" placeholder="" value="">
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<label for="">password</label> <input type="text"
									class="form-control" id="password" placeholder="" value="">
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<label for="">role</label> <select
									class="custom-select rounded-0" id="role">
									<option value="0">Admin</option>
									<option value="1">Seller</option>
									<option value="2">Customer</option>
								</select>
							</div>
						</div>

					</div>
					<div class="row">
						<div class="col-sm-4">
							<div class="form-group">
								<label for="">Ship City</label> <select
									class="custom-select rounded-0" id="shipCity">
									<option value="Hồ Chí Minh">Hồ Chí Minh</option>
									<option value="Đà Nẵng">Đà Nẵng</option>
									<option value="Gia Lai">Gia Lai</option>
									<option value="Quảng Ngãi">Quảng Ngãi</option>
								</select>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<label for="">Ship State</label> <select
									class="custom-select rounded-0" id="shipState">
									<option value="Tân Phú">Tân Phú</option>
									<option value="Quận 4">Quận 4</option>
									<option value="Quận 5">Quận 5</option>
									<option value="Pleiku">Pleiku</option>
									<option value="Đức Phổ">Đức Phổ</option>
								</select>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<label for="">telNumber</label> <input type="text"
									class="form-control" id="telNumber" placeholder="" value="">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-6">
							<div class="form-group">
								<label for="">shipAddress</label> <input type="text"
									class="form-control" id="shipAddress" placeholder="" value="">
							</div>
						</div>
												<div class="col-sm-6">
							<div class="form-group">
								<label for="">Email</label> <input type="email"
									class="form-control" id="email" placeholder="" value="">
							</div>
						</div>
					</div>



					<!-- /.card-body -->
				</div>
				<div class="card-footer">

					<button id="submitBtn" type="button" class="btn btn-block btn-dark">Submit</button>
				</div>
			</form>
		</div>
		<!-- /.content -->
	</div>
	<!-- /.content-wrapper -->
	<%@ include file="/common/admin/footer.jsp"%>
	<script>
	document.addEventListener("DOMContentLoaded", function() {
	    const imageInput = document.getElementById("image");
	    const uploadButton = document.getElementById("uploadButton");
	    const posterImg = document.getElementById("posterImg");


	    imageInput.addEventListener("change", function() {
	        const selectedFile = imageInput.files[0];

	        if (selectedFile) {

	            const reader = new FileReader();

	            reader.onload = function(e) {
	              
	                posterImg.src = e.target.result;
	                document.getElementById("imageURL").value = e.target.result;
	            };


	            reader.readAsDataURL(selectedFile);
	        }
	    });

	   
	    uploadButton.addEventListener("click", function() {
	        imageInput.click();
	    });
	});
	
	$("#submitBtn").click(function () {
	    var url = "http://localhost:8080/DemoSTS/adaccount?action=create";
	    var formData = new FormData();


	    formData.append('fullName', $("#fullName").val());
	    formData.append('userName', $("#userName").val());
	    formData.append('password', $("#password").val());
	    formData.append('shipCity', $("#shipCity").val());
	    formData.append('shipState', $("#shipState").val());
	    formData.append('shipAddress', $("#shipAddress").val());
	    formData.append('telNumber', $("#telNumber").val());
	    formData.append('role', $("#role").val());
	    formData.append('email', $("#email").val());


	    var imageInput = document.getElementById('image');
	    var imageFile = imageInput.files[0];


	    if (imageFile) {
	        formData.append('image', imageFile, imageFile.name);
	    }

	    $.ajax({
	        url: url,
	        type: "POST",
	        data: formData,
	        processData: false, // Set processData and contentType to false
	        contentType: false,
	    }).then(function (data) {
	        window.location.href = "http://localhost:8080/DemoSTS/adaccount";
	    }).fail(function (err) {
	        console.log("Oops error: " + err);
	    });
	});

	</script>
</body>
</html>
