<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Preloader -->
<div
	class="preloader flex-column justify-content-center align-items-center">
	<img class="animation__shake"
		src="<c:url value='/templates/admin/dist/img/AdminLTELogo.png'/> "
		alt="AdminLTELogo" height="60" width="60" />
</div>

<!-- Navbar -->
<nav class="main-header navbar navbar-expand navbar-white navbar-light">
	<!-- Left navbar links -->
	<ul class="navbar-nav">
		<li class="nav-item"><a class="nav-link" data-widget="pushmenu"
			href="#" role="button"><i class="fas fa-bars"></i></a></li>
		<li class="nav-item d-none d-sm-inline-block"><a
			href="index3.html" class="nav-link">Home</a></li>
		<li class="nav-item d-none d-sm-inline-block"><a href="#"
			class="nav-link">Contact</a></li>
	</ul>

	<!-- Right navbar links -->
	<ul class="navbar-nav ml-auto">
		<!-- Navbar Search -->
		<li class="nav-item"><a class="nav-link"
			data-widget="navbar-search" href="#" role="button"> <i
				class="fas fa-search"></i>
		</a>
			<div class="navbar-search-block">
				<form class="form-inline">
					<div class="input-group input-group-sm">
						<input class="form-control form-control-navbar" type="search"
							placeholder="Search" aria-label="Search" />
						<div class="input-group-append">
							<button class="btn btn-navbar" type="submit">
								<i class="fas fa-search"></i>
							</button>
							<button class="btn btn-navbar" type="button"
								data-widget="navbar-search">
								<i class="fas fa-times"></i>
							</button>
						</div>
					</div>
				</form>
			</div></li>

		<!-- Messages Dropdown Menu -->
		<li class="nav-item dropdown"><a class="nav-link"
			data-toggle="dropdown" href="#"> <i class="far fa-comments"></i>
				<span class="badge badge-danger navbar-badge">3</span>
		</a>
			<div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
				<a href="#" class="dropdown-item"> <!-- Message Start -->
					<div class="media">
						<img
							src="<c:url value='/templates/admin/dist/img/user1-128x128.jpg'/> "
							alt="User Avatar" class="img-size-50 mr-3 img-circle" />
						<div class="media-body">
							<h3 class="dropdown-item-title">
								Brad Diesel <span class="float-right text-sm text-danger"><i
									class="fas fa-star"></i></span>
							</h3>
							<p class="text-sm">Call me whenever you can...</p>
							<p class="text-sm text-muted">
								<i class="far fa-clock mr-1"></i> 4 Hours Ago
							</p>
						</div>
					</div> <!-- Message End -->
				</a>
				<div class="dropdown-divider"></div>
				<a href="#" class="dropdown-item"> <!-- Message Start -->
					<div class="media">
						<img
							src="<c:url value='/templates/admin/dist/img/user8-128x128.jpg'/> "
							alt="User Avatar" class="img-size-50 img-circle mr-3" />
						<div class="media-body">
							<h3 class="dropdown-item-title">
								John Pierce <span class="float-right text-sm text-muted"><i
									class="fas fa-star"></i></span>
							</h3>
							<p class="text-sm">I got your message bro</p>
							<p class="text-sm text-muted">
								<i class="far fa-clock mr-1"></i> 4 Hours Ago
							</p>
						</div>
					</div> <!-- Message End -->
				</a>
				<div class="dropdown-divider"></div>
				<a href="#" class="dropdown-item"> <!-- Message Start -->
					<div class="media">
						<img
							src="<c:url value='/templates/admin/dist/img/user3-128x128.jpg'/> "
							alt="User Avatar" class="img-size-50 img-circle mr-3" />
						<div class="media-body">
							<h3 class="dropdown-item-title">
								Nora Silvester <span class="float-right text-sm text-warning"><i
									class="fas fa-star"></i></span>
							</h3>
							<p class="text-sm">The subject goes here</p>
							<p class="text-sm text-muted">
								<i class="far fa-clock mr-1"></i> 4 Hours Ago
							</p>
						</div>
					</div> <!-- Message End -->
				</a>
				<div class="dropdown-divider"></div>
				<a href="#" class="dropdown-item dropdown-footer">See All
					Messages</a>
			</div></li>
		<!-- Notifications Dropdown Menu -->
		<li class="nav-item dropdown"><a class="nav-link"
			data-toggle="dropdown" href="#"> <i class="far fa-bell"></i> <span
				class="badge badge-warning navbar-badge">15</span>
		</a>
			<div class="dropdown-menu dropdown-menu-lg dropdown-menu-right">
				<span class="dropdown-item dropdown-header">15 Notifications</span>
				<div class="dropdown-divider"></div>
				<a href="#" class="dropdown-item"> <i
					class="fas fa-envelope mr-2"></i> 4 new messages <span
					class="float-right text-muted text-sm">3 mins</span>
				</a>
				<div class="dropdown-divider"></div>
				<a href="#" class="dropdown-item"> <i class="fas fa-users mr-2"></i>
					8 friend requests <span class="float-right text-muted text-sm">12
						hours</span>
				</a>
				<div class="dropdown-divider"></div>
				<a href="#" class="dropdown-item"> <i class="fas fa-file mr-2"></i>
					3 new reports <span class="float-right text-muted text-sm">2
						days</span>
				</a>
				<div class="dropdown-divider"></div>
				<a href="#" class="dropdown-item dropdown-footer">See All
					Notifications</a>
			</div></li>
		<li class="nav-item"><a class="nav-link" data-widget="fullscreen"
			href="#" role="button"> <i class="fas fa-expand-arrows-alt"></i>
		</a></li>
		<li class="nav-item"><a class="nav-link"
			data-widget="control-sidebar" data-controlsidebar-slide="true"
			href="#" role="button"> <i class="fas fa-th-large"></i>
		</a></li>
	</ul>
</nav>
<!-- /.navbar -->

<!-- Main Sidebar Container -->
<aside class="main-sidebar sidebar-dark-primary elevation-4">
	<!-- Brand Logo -->
	<a href="index3.html" class="brand-link"> <img
		src="<c:url value='/templates/admin/dist/img/AdminLTELogo.png'/>"
		alt="AdminLTE Logo" class="brand-image img-circle elevation-3"
		style="opacity: 0.8" /> <span class="brand-text font-weight-light">AdminLTE
			3</span>
	</a>

	<!-- Sidebar -->
	<div class="sidebar">
		<!-- Sidebar user panel (optional) -->
		<div class="user-panel mt-3 pb-3 mb-3 d-flex">
<c:choose>
    <c:when test="${not empty sessionScope.currentAdmin}">
        <div class="image">
            <img src="files/imageuser/${sessionScope.currentAdmin.image}" class="img-circle elevation-2" alt="User Image" style="width: 50px;height: 50px;"/>
        </div>
        <div class="info">
            <a href="#" class="d-block">${sessionScope.currentAdmin.fullName}</a>
        </div>
        <div class="info">
            <a href="adlogout" class="d-block">Logout</a>
        </div>
    </c:when>
    <c:otherwise>
        <div class="image">
            <img src="" class="img-circle elevation-2" alt="User Image" />
        </div>
        <div class="info">
            <a href="#" class="d-block">UserTest</a>
        </div>
        <div class="info">
            <a href="#" class="d-block">Logout</a>
        </div>
    </c:otherwise>
</c:choose>




		</div>

		<!-- SidebarSearch Form -->
		<div class="form-inline">
			<div class="input-group" data-widget="sidebar-search">
				<input class="form-control form-control-sidebar" type="search"
					placeholder="Search" aria-label="Search" />
				<div class="input-group-append">
					<button class="btn btn-sidebar">
						<i class="fas fa-search fa-fw"></i>
					</button>
				</div>
			</div>
		</div>
		<nav class="mt-2">
			<ul class="nav nav-pills nav-sidebar flex-column"
				data-widget="treeview" role="menu" data-accordion="false">
				<!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
				<li class="nav-item menu-open"><a href="#"
					class="nav-link active"> <i
						class="nav-icon fas fa-tachometer-alt"></i>
						<p>
							Dashboard <i class="right fas fa-angle-left"></i>
						</p>
				</a>
					<ul class="nav nav-treeview">
						<li class="nav-item"><a href="addashboard"
							class="nav-link active"> <i class="far fa-circle nav-icon"></i>
								<p>Dashboard v1</p>
						</a></li>
					</ul></li>

				<li class="nav-header">ADMIN <span
					class="right badge badge-danger">Only admin</span></li>
				<li class="nav-item"><a href="#" class="nav-link"> <i
						class="nav-icon fas fa-chart-pie"></i>
						<p>
							View <i class="right fas fa-angle-left"></i>
						</p>
				</a>
					<ul class="nav nav-treeview">
						<li class="nav-item"><a href="adproduct?action=view"
							class="nav-link"> <i class="far fa-circle nav-icon"></i>
								<p>Products</p>
						</a></li>
						<li class="nav-item"><a href="adcategory?action=view"
							class="nav-link"> <i class="far fa-circle nav-icon"></i>
								<p>Categories</p>
						</a></li>
						<li class="nav-item"><a href="adorder?action=view"
							class="nav-link"> <i class="far fa-circle nav-icon"></i>
								<p>Orders</p>
						</a></li>
						<li class="nav-item"><a href="adaccount?action=view"
							class="nav-link"> <i class="far fa-circle nav-icon"></i>
								<p>Accounts</p>
						</a></li>
						<li class="nav-item"><a href="adsupplier?action=view"
							class="nav-link"> <i class="far fa-circle nav-icon"></i>
								<p>Suppliers</p>
						</a></li>
					</ul></li>

				<li class="nav-item"><a href="#" class="nav-link"> <i
						class="nav-icon fas fa-chart-pie"></i>
						<p>
							Create <i class="right fas fa-angle-left"></i>
						</p>
				</a>
					<ul class="nav nav-treeview">
						<li class="nav-item"><a href="adproduct?action=create"
							class="nav-link"> <i class="far fa-circle nav-icon"></i>
								<p>Products</p>
						</a></li>
						<li class="nav-item"><a href="adcategory?action=create"
							class="nav-link"> <i class="far fa-circle nav-icon"></i>
								<p>Categories</p>
						</a></li>
						<li class="nav-item"><a href="adorder?action=create"
							class="nav-link"> <i class="far fa-circle nav-icon"></i>
								<p>Orders</p>
						</a></li>
						<li class="nav-item"><a href="adaccount?action=create"
							class="nav-link"> <i class="far fa-circle nav-icon"></i>
								<p>Accounts</p>
						</a></li>
						<li class="nav-item"><a href="adsupplier?action=create"
							class="nav-link"> <i class="far fa-circle nav-icon"></i>
								<p>Suppliers</p>
						</a></li>
					</ul></li>

				<li class="nav-header">SELLER</li>

				<li class="nav-item"><a href="#" class="nav-link"> <i
						class="nav-icon fas fa-chart-pie"></i>
						<p>
							View <i class="right fas fa-angle-left"></i>
						</p>
				</a>
					<ul class="nav nav-treeview">
						<li class="nav-item"><a href="adproduct?action=view"
							class="nav-link"> <i class="far fa-circle nav-icon"></i>
								<p>Products</p>
						</a></li>
						<li class="nav-item"><a href="adorder?action=view"
							class="nav-link"> <i class="far fa-circle nav-icon"></i>
								<p>Orders</p>
						</a></li>
					</ul></li>
				<li class="nav-header">STATS</li>

				<li class="nav-item"><a href="#" class="nav-link"> <i
						class="nav-icon fas fa-chart-pie"></i>
						<p>
							View <i class="right fas fa-angle-left"></i>
						</p>
				</a>
					<ul class="nav nav-treeview">
						<li class="nav-item"><a href="adstats?action=top5customers"
							class="nav-link"> <i class="far fa-circle nav-icon"></i>
								<p>TOP 5 Customers</p>
						</a></li>
						<li class="nav-item"><a href="adstats?action=top5sellers"
							class="nav-link"> <i class="far fa-circle nav-icon"></i>
								<p>TOP 5 Sellers</p>
						</a></li>
						<li class="nav-item"><a href="adstats?action=top10products"
							class="nav-link"> <i class="far fa-circle nav-icon"></i>
								<p>TOP 10 Products</p>
						</a></li>
						<li class="nav-item"><a href="adstats?action=print"
							class="nav-link"> <i class="far fa-circle nav-icon"></i>
								<p>Print</p>
						</a></li>
						<li class="nav-item"><a href="adstats?action=bytime"
							class="nav-link"> <i class="far fa-circle nav-icon"></i>
								<p>By Time</p>
						</a></li>
					</ul></li>

			</ul>
		</nav>
		<!-- Sidebar Menu -->

		<!-- /.sidebar-menu -->
	</div>
	<!-- /.sidebar -->

</aside>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<div class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1 class="m-0">Dashboard</h1>
				</div>
				<!-- /.col -->
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active">Dashboard v1</li>
					</ol>
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container-fluid -->
	</div>
	<!-- /.content-header -->