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

	<section class="ftco-section ftco-cart">
		<div class="container">
			<div class="row">
				<div class="col-md-12 ftco-animate fadeInUp ftco-animated">
					<div class="cart-list">
						<table class="table">
							<thead class="thead-primary">
								<tr class="text-center">
									<th>&nbsp;</th>
									<th>Image</th>
									<th>Product name</th>
									<th>Price</th>
									<th>Quantity</th>
									<th>Total</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${cartProductDTOs}" var="item">
									<tr class="text-center">
										<td class="product-remove"><input
											class="form-check-input" type="checkbox"
											style="margin-top: 0px; margin-left: 0px; position: inherit;"
											value="${item.getProductID()}"></td>

										<td class="image-prod"><div class="img"
												style="background-image:url(files/product/${item.getImage()});"></div></td>

										<td class="product-name">
										
											<h3>${item.getProductName()}</h3>
										
											<p>Far far away, behind the word mountains, far from the
												countries</p>
										</td>

										<td class="price">${item.getUnitPrice()}$</td>

										<td class="quantity">
											<div class="input-group mb-3">
												<input type="text" name="quantityinp"
													class="quantityinp form-control input-number" value="${item.getQuantity()}"
													min="1" max="100">
											</div>
										</td>

										<td class="total">${item.getTotal()}$</td>
									</tr>
									<!-- END TR-->
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-xl-7 ftco-animate fadeInUp ftco-animated">
					
					<!-- END -->
				</div>
				<div class="col-xl-5">
					<div class="row mt-5 pt-3">
						<div class="col-md-12 d-flex mb-5">
							<div class="cart-detail cart-total p-3 p-md-4">
								<h3 class="billing-heading mb-4">Cart Total</h3>
								<hr>
								<p class="d-flex total-price">
									<span>Total</span> <span id="total-price">$17.60</span>
								</p>
							</div>
						</div>
						<div class="col-md-12">
							<div class="cart-detail p-3 p-md-4">

							
								<h5 id="messageReturnH5"></h5>
									<a id="orderButton" href="#" class="btn btn-primary py-3 px-4">Place
										an order</a>
								
							</div>
						</div>
					</div>
				</div>
				<!-- .col-md-8 -->
			</div>
		</div>
	</section>

	<%@ include file="/common/footer.jsp"%>
<script>
      var productList = [];
      var idList = [];
      var checkboxes = document.querySelectorAll(".form-check-input");
      checkboxes.forEach(function (checkbox) {
        checkbox.checked = true;
        checkbox.disabled = true;
      });
      checkboxes.forEach(function (checkbox) {

            var row = checkbox.closest("tr");
            var priceCell = row.querySelector(".price");
            var totalItemCell = row.querySelector(".total");
            var quantityInp = row.querySelector(".quantityinp");
            var totalCell = document.querySelector("#total-price");

            var price = parseInt(priceCell.textContent.replace("$", ""));
            var total = parseInt(totalItemCell.textContent.replace("$", ""));
            var id = checkbox.value;
            var quantity = quantityInp.value;

            if (checkbox.checked) {
              productList.push({
                id: id,
                price: price,
                quantity: quantity,
                total: total,
              });

            } else {
              var index = productList.findIndex(function (product) {
                return product.id === id;
              });
              if (index !== -1) {
                productList.splice(index, 1);
              }
            }

            var totalPrice = productList.reduce(function (total, product) {
              return total + product.total;
            }, 0);

            totalCell.textContent = totalPrice.toFixed(2) + "$";
            console.log(totalPrice);
            console.log(productList);

        });

      var checkoutLink = document.getElementById("orderButton");
      checkoutLink.href = "javascript:void(0);";

      function placeanorder() {
    	    var formData = { productList: productList }; 
    	    console.log(formData);
    	    $.ajax({
    	        url: 'placeanorder',
    	        type: 'POST',
    	        contentType: 'application/json', 
    	        data: JSON.stringify(formData), 
    	        success: function(data) {
    	            $("#messageReturnH5").text("Order thành công");
    		        setTimeout(function(){
    		            window.location.href="http://localhost:8080/DemoSTS/index";
    		        }, 3000);
    	        },
    	        error: function(jqXHR, textStatus, errorThrown) {
    	            console.log("AJAX Request Failed:", textStatus, errorThrown);
    	            $("#messageReturn").text("Có lỗi xảy ra !");
    	        }
    	    });
    	}
      checkoutLink.addEventListener("click", function () {
        placeanorder();
      });
    </script>
</body>
</html>