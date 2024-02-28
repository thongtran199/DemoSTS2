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
									<th>&nbsp;</th>
									<th>&nbsp;</th>
									<th>Product name</th>
									<th>Price</th>
									<th>Quantity</th>
									<th>Total</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${cartProductDTOs}" var="item">
									<tr class="text-center">
									
										<td class="product-remove"><a
											href="#" onclick="removeFromCart(this)">
											<input type="hidden" value="${item.getProductID()}">
											<span
												class="ion-ios-close"></span></a>
												</td>
												
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
			<div class="row justify-content-end">
				

				<div
					class="col-lg-4 mt-5 cart-wrap ftco-animate fadeInUp ftco-animated">
					<div class="cart-total mb-3">
						<h3>Cart Totals</h3>

						<hr>
						<p class="d-flex total-price">
							<span>Total</span> <span id="total-price"></span>
						</p>
					</div>
					<p>
					
						<a id="checkoutButton" href="#" class="btn btn-primary py-3 px-4">Proceed
							to Checkout</a>
					</p>
				</div>
			</div>
		</div>
	</section>

	<%@ include file="/common/footer.jsp"%>
	<script>

// Lấy thẻ a theo id
var checkoutLink = document.getElementById("checkoutButton");

// Vô hiệu hóa thuộc tính href
checkoutLink.href = "javascript:void(0);";

        var productList = [];
        var idList =[];
        var checkboxes = document.querySelectorAll('.form-check-input');
        checkboxes.forEach(function(checkbox) {
            checkbox.checked = false;
        });
        checkboxes.forEach(function(checkbox) {
            checkbox.addEventListener('change', function() {
                var row = checkbox.closest('tr'); 
                var priceCell = row.querySelector('.price'); 
                var totalItemCell = row.querySelector('.total'); 
                var quantityInp = row.querySelector('.quantityinp'); 
                var totalCell = document.querySelector('#total-price'); 

                var price = parseFloat(priceCell.textContent.replace('$', ''));
                var total = parseFloat(totalItemCell.textContent.replace('$', ''));
                var id = checkbox.value;
                var quantity = quantityInp.value;

                if (checkbox.checked) {
                    productList.push({ id: id, price: price, quantity: quantity,total: total });
                    idList.push({ id: id, quantity: quantity });
                } else {
                    var index = productList.findIndex(function(product) {
                        return product.id === id;
                    });
                    if (index !== -1) {
                        productList.splice(index, 1);
                        idList.splice(index, 1);
                    }
                }

                
                var totalPrice = productList.reduce(function(total, product) {
                    return total + product.total;
                }, 0);

                
                totalCell.textContent = totalPrice.toFixed(2) + '$';
                console.log(totalPrice);
                //console.log(productList);
                console.log(idList);
            });
        });
        function checkout(){
        	var jsonData = JSON.stringify(idList);
        	
        	window.location.href = "/DemoSTS/checkout?data=" + encodeURIComponent(jsonData);
        }
        function removeFromCart(link) {
            var inputElement = link.querySelector('input');
            if (inputElement) {
                var productId = inputElement.value;
                var formData = {'id' : productId};
        	    $.ajax({
        	        url: 'product?action=removeFromCart',
        	        type: 'POST',
        	        data: formData
        	    }).then(function(data){
        	    	console.log('Sản phẩm có ID ' + productId + ' đã được xóa khỏi giỏ hàng.');
        	        window.location.href="http://localhost:8080/DemoSTS/cart";
        	    })
        	    .fail(function(jqXHR, textStatus, errorThrown) {
        	        console.log("AJAX Request Failed:", textStatus, errorThrown);
        	    });
            }
        }

        checkoutLink.addEventListener("click", function() {
            checkout();
        });
    </script>
</body>
</html>