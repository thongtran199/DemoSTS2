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
			<div class="card card-success">
				<div class="card-header">
					<h3 class="card-title">Thống kê theo tháng</h3>

					<div class="card-tools">
						<button type="button" class="btn btn-tool"
							data-card-widget="collapse">
							<i class="fas fa-minus"></i>
						</button>
						<button type="button" class="btn btn-tool"
							data-card-widget="remove">
							<i class="fas fa-times"></i>
						</button>
					</div>
				</div>
				<div class="card-body">
					<div class="chart">
						<div class="chartjs-size-monitor">
							<div class="chartjs-size-monitor-expand">
								<div class=""></div>
							</div>
							<div class="chartjs-size-monitor-shrink">
								<div class=""></div>
							</div>
						</div>
						<canvas id="barChart"
							style="min-height: 250px; height: 400px; max-height: 400px; max-width: 600px; display: block; width: 600px;"
							width="522" height="312" class="chartjs-render-monitor"></canvas>
					</div>
				</div>
				<!-- /.card-body -->
			</div>
			<!-- form start -->
						<div class="card card-success">
				<div class="card-header">
					<h3 class="card-title">Thống kê theo ngày</h3>

					<div class="card-tools">
						<button type="button" class="btn btn-tool"
							data-card-widget="collapse">
							<i class="fas fa-minus"></i>
						</button>
						<button type="button" class="btn btn-tool"
							data-card-widget="remove">
							<i class="fas fa-times"></i>
						</button>
					</div>
				</div>
				<div class="card-body">
					<div class="chart">
						<div class="chartjs-size-monitor">
							<div class="chartjs-size-monitor-expand">
								<div class=""></div>
							</div>
							<div class="chartjs-size-monitor-shrink">
								<div class=""></div>
							</div>
						</div>
						<canvas id="barChart2"
							style="min-height: 250px; height: 400px; max-height: 400px; max-width: 600px; display: block; width: 600px;"
							width="522" height="312" class="chartjs-render-monitor"></canvas>
					</div>
				</div>
				<!-- /.card-body -->
			</div>
			
		</div>
	</div>
	<!-- /.content-wrapper -->
	<%@ include file="/common/admin/footer.jsp"%>
	<script>
	$.ajax({
	    url: "adstats?action=bytimemonth",
	    type: "POST",
	    contentType: "application/json"
	}).done(function(data){
	    // Xử lý dữ liệu từ bytimeday ở đây và cập nhật biểu đồ barChart
	    var chartData = data; // Điều chỉnh để truy cập dữ liệu thích hợp từ data
	    
	    // Lấy tham chiếu đến canvas của biểu đồ
	    var ctx = document.getElementById('barChart').getContext('2d');
	    
	    // Tạo một đối tượng biểu đồ
	    var myChart = new Chart(ctx, {
	        type: 'bar',
	        data: {
	            labels: chartData.labels, // Tên của các cột
	            datasets: [{
	                label: 'Dữ liệu thứ 1',
	                data: chartData.data, // Dữ liệu tương ứng với các cột
	                backgroundColor: 'rgba(75, 192, 192, 0.2)', // Màu nền của các cột
	                borderColor: 'rgba(75, 192, 192, 1)', // Màu đường viền
	                borderWidth: 1
	            }]
	        },
	        options: {
	            scales: {
	                y: {
	                    beginAtZero: true
	                }
	            }
	        }
	    });
	});

	$.ajax({
	    url: "adstats?action=bytimeday",
	    type: "POST",
	    contentType: "application/json"
	}).done(function(data){
	    var chartData = data; 
	    
	    var ctx2 = document.getElementById('barChart2').getContext('2d');
	    var myChart2 = new Chart(ctx2, {
	        type: 'bar',
	        data: {
	            labels: chartData.labels, // Tên của các cột
	            datasets: [{
	                label: 'Dữ liệu thứ 1',
	                data: chartData.data, // Dữ liệu tương ứng với các cột
	                backgroundColor: 'rgba(75, 192, 192, 0.2)', // Màu nền của các cột
	                borderColor: 'rgba(75, 192, 192, 1)', // Màu đường viền
	                borderWidth: 1
	            }]
	        },
	        options: {
	            scales: {
	                y: {
	                    beginAtZero: true
	                }
	            }
	        }
	    });
	});

	</script>
</body>
</html>
