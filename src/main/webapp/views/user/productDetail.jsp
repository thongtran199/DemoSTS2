<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.text.NumberFormat" %>
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
<section class="ftco-section">
    	<div class="container">
    		<div class="row">
    			<div class="col-lg-6 mb-5 ftco-animate fadeInUp ftco-animated">
    				<a href="${product.image}" class="image-popup"><img src="<c:url value='files/product/${product.image}'/>" class="img-fluid" alt="Colorlib Template"></a>
    			</div>
    			<div class="col-lg-6 product-details pl-md-5 ftco-animate fadeInUp ftco-animated">
    				<h3>${product.productName}</h3>
    				<div class="rating d-flex">
							<p class="text-left mr-4">
								<a href="#" class="mr-2">5.0</a>
								<a href="#"><span class="ion-ios-star-outline"></span></a>
								<a href="#"><span class="ion-ios-star-outline"></span></a>
								<a href="#"><span class="ion-ios-star-outline"></span></a>
								<a href="#"><span class="ion-ios-star-outline"></span></a>
								<a href="#"><span class="ion-ios-star-outline"></span></a>
							</p>
							<p class="text-left mr-4">
								<a href="#" class="mr-2" style="color: #000;">100 <span style="color: #bbb;">Rating</span></a>
							</p>
							<p class="text-left">
								<a href="#" class="mr-2" style="color: #000;">500 <span style="color: #bbb;">Sold</span></a>
							</p>
						</div>


<p class="price"><span>$${product.unitPrice}</span></p>

    				<p>${product.description}
						</p>
						<p style="color:blue;" id="messageReturn"></p>
						<div class="row mt-4">
							<div class="col-md-6">
	
							</div>
							<div class="w-100"></div>
							<div class="input-group col-md-6 d-flex mb-3">
	             	<span class="input-group-btn mr-2">
	                	<button type="button" class="quantity-left-minus btn" data-type="minus" data-field="">
	                   <i class="ion-ios-remove"></i>
	                	</button>
	            		</span>
	             	<input type="text" id="quantity" name="quantity" class="form-control input-number" value="1" min="1" max="100">
	             	<input type="hidden" id="idProduct" value="${product.productID}"/>
	             	<span class="input-group-btn ml-2">
	                	<button type="button" class="quantity-right-plus btn" data-type="plus" data-field="">
	                     <i class="ion-ios-add"></i>
	                 </button>
	             	</span>
	          	</div>
	          	<div class="w-100"></div>

          	</div>
          	<p><a onClick="addToCart()" href="#" class="btn btn-black py-3 px-5">Add to Cart</a></p>
    			</div>
    		</div>
    	</div>
    </section>
<script>
function addToCart()
{
    $("#messageReturn").text("");
    var quantity = document.querySelector("#quantity").value;
    var id = document.querySelector("#idProduct").value;
    var formData = {'id' : id, 'quantity': quantity};
    console.log(formData);
    $.ajax({
        url: 'product?action=addToCart',
        type: 'POST',
        data: formData
    }).then(function(data){
        $("#messageReturn").text("Add thành công");
    })
    .fail(function(jqXHR, textStatus, errorThrown) {
        console.log("AJAX Request Failed:", textStatus, errorThrown);
        $("#messageReturn").text("Có lỗi xảy ra !");
    });
}
</script>
	<%@ include file="/common/footer.jsp"%>
</body>
</html>