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

<section class="ftco-section contact-section bg-light">
      <div class="container">
      	
        <div class="row block-9">
          <div class="col-12 order-md-last d-flex">
            <form action="forgotPass" method ="post" class="bg-white p-5 contact-form">
            <h2 class="text-center">Forgot Pass</h2>
              <div class="form-group">
                <input type="email" class="form-control" placeholder="Email" name="email">
              </div>            
              <div class="form-group d-flex justify-content-center">
                <input type="submit" value="Send new pass" class="btn btn-primary py-3 px-5">
              </div>
            </form>
          
          </div>

          <div>
          	<div id="map" class="bg-white" style="position: relative; overflow: hidden;"><div style="height: 100%; width: 100%; position: absolute; top: 0px; left: 0px; background-color: rgb(229, 227, 223);"><div class="gm-err-container"><div class="gm-err-content"><div class="gm-err-icon"><img src="https://maps.gstatic.com/mapfiles/api-3/images/icon_error.png" alt="" draggable="false" style="user-select: none;"></div><div class="gm-err-title">Rất tiếc! Đã xảy ra lỗi.</div><div class="gm-err-message">Trang này đã không tải Google Maps đúng cách. Hãy xem bảng điều khiển JavaScript để biết chi tiết kỹ thuật.</div></div></div></div></div>
          </div>
        </div>
      </div>
    </section>
	<%@ include file="/common/footer.jsp"%>
</body>
</html>