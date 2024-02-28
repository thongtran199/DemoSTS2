<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Catalog-Z Bootstrap 5.0 HTML Template</title>
<%@ include file="/common/head.jsp"%>
</head>
<body>
	<!-- Page Loader -->
	<%@ include file="/common/header.jsp"%>

	<div class="container my-5">
		<h2>Thông tin cá nhân</h2>
		<div class="row">
			<div class="col-4 d-flex align-items-center justify-content-center">

				<img id="imagePreview" style="width: 50%;" src="files/imageuser/${user.image}"
					alt="Sakura" />
			</div>



			<div class="col-8">
<form id="profileForm" method="post" enctype="multipart/form-data">
				<input type="hidden" id="oldavt"
						value="${user.image}">
					<input type="file" id="imageInput"
						name="image">  <input type="text"
						class="form-control mt-3" value="${user.fullName}" name="fullName"
						aria-label="Full Name" aria-describedby="basic-addon1"> <input
						type="email" class="form-control my-3" value="${user.email}"
						name="email" aria-label="Email" aria-describedby="basic-addon1">
					<input style="width: 100%; height: 50px" type="submit"
						value="Update Profile" class="submit px-3 btn btn-primary"
						id="submitBtn">
				</form>

			</div>

		</div>


	</div>



	<%@ include file="/common/footer.jsp"%>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script> const imageInput = document.getElementById('imageInput');
const imagePreview = document.getElementById('imagePreview');

imageInput.addEventListener('change', function () {
    const file = imageInput.files[0];
    if (file) {
        const reader = new FileReader();

        reader.onload = function (e) {
            imagePreview.src = e.target.result;
        };

        reader.readAsDataURL(file);
    } else {
        imagePreview.src = ''; // Clear the preview if no file is selected
    }
});

$(document).ready(function () {
    $("#profileForm").submit(function (e) {
        e.preventDefault(); // Prevent the default form submission.

        // Serialize the form data.
        var formData = new FormData(this);

        $.ajax({
            type: "POST",
            url: "profile?oldavt="+$("#oldavt").val(), // Replace with the actual server URL.
            data: formData,
            contentType: false,
            processData: false,
            success: function (data) {
               window.location.href ="http://localhost:8080/DemoSTS/profile";
            },
            error: function (xhr, status, error) {
                console.log(error);
            }
        });
    });
});

</script>
</body>
</html>