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
				<h3 class="card-title">Edit product ${product.productName}</h3>
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
								<label for="">productName</label> <input type="text"
									class="form-control" id="productName" placeholder=""
									value="${product.productName}"><input type="hidden"
									id="productID" value="${product.productID}" /><input
									type="hidden" id="oldavt" value="${product.image}" />
							</div>
						</div>
						<div
							class="col-sm-4  d-flex justify-content-end align-items-center">
							<div class="form-group"
								style="width: 200px; min-height: 175px; overflow: hidden">
								<img
									src="files/product/${product.image}"
									style="width: 100%; height: 100%; object-fit: contain;"
									id="posterImg" />
							</div>
						</div>

					</div>

					<div class="row">
						<div class="col-sm-6 ">
							<div class="form-group">
								<label for="">unitPrice</label> <input type="number"
									class="form-control" id="unitPrice" placeholder=""
									value="${product.unitPrice}">
							</div>
						</div>
						<div class="col-sm-6">
							<div class="form-group">
								<label for="">quantity</label> <input type="number"
									class="form-control" id="quantity" placeholder=""
									value="${product.quantity}">
							</div>
						</div>

					</div>
					<div class="row">
						<div class="col-sm-4 ">
							<div class="form-group">
								<label for="">Category</label> <select
									class="custom-select rounded-0" id="categoryID">
									<c:forEach items="${categories}" var="item" varStatus="loop">
										<option value="${item.categoryID}">${item.categoryName}</option>
									</c:forEach>

								</select>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<label for="">Color</label> <select
									class="custom-select rounded-0" id="color">
								<option value="red">đỏ</option>
								<option value="blue">xanh dương</option>
								<option value="yellow">vàng</option>
								<option value="green">xanh lá</option>
								<option value="black">đen</option>
								<option value="white">trắng</option>
								</select>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="form-group">
								<label for="">Supplier</label> <select
									class="custom-select rounded-0" id="supplierID">
									<c:forEach items="${suppliers}" var="item" varStatus="loop">
										<option value="${item.supplierID}">${item.companyName}</option>
									</c:forEach>
								</select>
							</div>
						</div>

					</div>



					<div class="form-group">
						<label>describe</label>
						<textarea id="describeTextArea" class="form-control" rows="3"
							placeholder="">${product.description}</textarea>
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
	    var url = "http://localhost:8080/DemoSTS/adproduct?action=edit";
	    var formData = new FormData();
	    formData.append('productID', $("#productID").val());
	    formData.append('productName', $("#productName").val());
	    formData.append('categoryID', $("#categoryID").val());
	    formData.append('supplierID', $("#supplierID").val());
	    formData.append('quantity', $("#quantity").val());
	    formData.append('unitPrice', $("#unitPrice").val());
	    formData.append('color', $("#color").val());
	    formData.append('describe', $("#describeTextArea").val());


	    var imageInput = document.getElementById('image');
	    var imageFile = imageInput.files[0];


	    if (imageFile) {
	        formData.append('image', imageFile, imageFile.name);
	    }

	    $.ajax({
	        url: url,
	        type: "POST",
	        data: formData,
	        processData: false, 
	        contentType: false,
	    }).then(function (data) {
	        window.location.href = "http://localhost:8080/DemoSTS/adproduct";
	    }).fail(function (err) {
	        console.log("Oops error: " + err);
	    });
	});
	


	</script>
</body>
</html>
