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
	<section id="home-section" class="hero">
	<div class="home-slider owl-carousel">
		<div class="slider-item"
			style="background-image: url(<c:url value='/templates/user/images/bg_1.jpg'/>);">
			<div class="overlay"></div>
			<div class="container">
				<div
					class="row slider-text justify-content-center align-items-center"
					data-scrollax-parent="true">

					<div class="col-md-12 ftco-animate text-center">
						<h1 class="mb-2">We Are Leading Supplier In Our Industry</h1>
						<h2 class="subheading mb-4">We deliver reasonable technology equipments
							&amp; fruits</h2>
						<p>
							<a href="#" class="btn btn-primary">View Details</a>
						</p>
					</div>

				</div>
			</div>
		</div>

		<div class="slider-item"
			style="background-image: url(<c:url value='/templates/user/images/bg_2.jpg'/>);">
			<div class="overlay"></div>
			<div class="container">
				<div
					class="row slider-text justify-content-center align-items-center"
					data-scrollax-parent="true">

					<div class="col-sm-12 ftco-animate text-center">
						<h1 class="mb-2">100% High Qualified Technology Supplies</h1>
						<h2 class="subheading mb-4">We offer reasonable technology equipments
							&amp; fruits</h2>
						<p>
							<a href="#" class="btn btn-primary">View Details</a>
						</p>
					</div>

				</div>
			</div>
		</div>
	</div>
</section>
	
<section class="ftco-section">
      <div class="container">
        <div class="row no-gutters ftco-services">
          <div
            class="col-md-3 text-center d-flex align-self-stretch ftco-animate"
          >
            <div class="media block-6 services mb-md-0 mb-4">
              <div
                class="icon bg-color-1 active d-flex justify-content-center align-items-center mb-2"
              >
                <span class="flaticon-shipped"></span>
              </div>
              <div class="media-body">
                <h3 class="heading">Free Shipping</h3>
                <span>On order over $100</span>
              </div>
            </div>
          </div>
          <div
            class="col-md-3 text-center d-flex align-self-stretch ftco-animate"
          >
            <div class="media block-6 services mb-md-0 mb-4">
              <div
                class="icon bg-color-2 d-flex justify-content-center align-items-center mb-2"
              >
                <span class="flaticon-diet"></span>
              </div>
              <div class="media-body">
                <h3 class="heading">Always Fresh</h3>
                <span>Product well package</span>
              </div>
            </div>
          </div>
          <div
            class="col-md-3 text-center d-flex align-self-stretch ftco-animate"
          >
            <div class="media block-6 services mb-md-0 mb-4">
              <div
                class="icon bg-color-3 d-flex justify-content-center align-items-center mb-2"
              >
                <span class="flaticon-award"></span>
              </div>
              <div class="media-body">
                <h3 class="heading">Superior Quality</h3>
                <span>Quality Products</span>
              </div>
            </div>
          </div>
          <div
            class="col-md-3 text-center d-flex align-self-stretch ftco-animate"
          >
            <div class="media block-6 services mb-md-0 mb-4">
              <div
                class="icon bg-color-4 d-flex justify-content-center align-items-center mb-2"
              >
                <span class="flaticon-customer-service"></span>
              </div>
              <div class="media-body">
                <h3 class="heading">Support</h3>
                <span>24/7 Support</span>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>

    <section class="ftco-section ftco-category ftco-no-pt">
      <div class="container">
        <div class="row">
          <div class="col-md-8">
            <div class="row">
              <div class="col-md-6 order-md-last align-items-stretch d-flex">
                <div
                  class="category-wrap-2 ftco-animate img align-self-stretch d-flex"
                  style="background-image: url(<c:url value='/templates/user/images/category.jpg'/>)"
                >
                  <div class="text text-center">
                    <h2>Po27Shop</h2>
                    <p>We provide high qualified technology equipment</p>
                    <p><a href="category?name=all" class="btn btn-primary">Shop now</a></p>
                  </div>
                </div>
              </div>
              <div class="col-md-6">
                <div
                  class="category-wrap ftco-animate img mb-4 d-flex align-items-end"
                  style="background-image: url(<c:url value='/templates/user/images/category-1.jpg'/>)"
                >
                  <div class="text px-3 py-1">
                    <h2 class="mb-0"><a href="http://localhost:8080/DemoSTS/product?action=view&category=1">Điện thoại</a></h2>
                  </div>
                </div>
                <div
                  class="category-wrap ftco-animate img d-flex align-items-end"
                  style="background-image: url(<c:url value='/templates/user/images/category-2.jpg'/>)"
                >
                  <div class="text px-3 py-1">
                    <h2 class="mb-0"><a href="http://localhost:8080/DemoSTS/product?action=view&category=2">Laptop</a></h2>
                  </div>
                </div>
              </div>
            </div>
          </div>

          <div class="col-md-4">
            <div
              class="category-wrap ftco-animate img mb-4 d-flex align-items-end"
              style="background-image: url(<c:url value='/templates/user/images/category-3.jpg'/>)"
            >
              <div class="text px-3 py-1">
                <h2 class="mb-0"><a href="http://localhost:8080/DemoSTS/product?action=view&category=3">Đồng hồ</a></h2>
              </div>
            </div>
            <div
              class="category-wrap ftco-animate img d-flex align-items-end"
              style="background-image: url(<c:url value='/templates/user/images/category-4.jpg'/>)"
            >
              <div class="text px-3 py-1">
                <h2 class="mb-0"><a href="http://localhost:8080/DemoSTS/product?action=view&category=4">Tai nghe</a></h2>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>

  
    <section
      class="ftco-section img"
      style="background-image: url(<c:url value='/templates/user/images/bg_3.jpg'/>)"
    >
      <div class="container">
        <div class="row justify-content-end">
          <div
            class="col-md-6 heading-section ftco-animate deal-of-the-day ftco-animate"
          >
            <span class="subheading">Best Price For You</span>
            <h2 class="mb-4">Deal of the day</h2>
            <p>
              Far far away, behind the word mountains, far from the countries
              Vokalia and Consonantia
            </p>
            <h3><a href="#">Spinach</a></h3>
            <span class="price">$10 <a href="#">now $5 only</a></span>
            <div id="timer" class="d-flex mt-5">
              <div class="time" id="days"></div>
              <div class="time pl-3" id="hours"></div>
              <div class="time pl-3" id="minutes"></div>
              <div class="time pl-3" id="seconds"></div>
            </div>
          </div>
        </div>
      </div>
    </section>

    <section class="ftco-section testimony-section">
      <div class="container">
        <div class="row justify-content-center mb-5 pb-3">
          <div class="col-md-7 heading-section ftco-animate text-center">
            <span class="subheading">Testimony</span>
            <h2 class="mb-4">Our satisfied customer says</h2>
            <p>
              Far far away, behind the word mountains, far from the countries
              Vokalia and Consonantia, there live the blind texts. Separated
              they live in
            </p>
          </div>
        </div>
        <div class="row ftco-animate">
          <div class="col-md-12">
            <div class="carousel-testimony owl-carousel">
              <div class="item">
                <div class="testimony-wrap p-4 pb-5">
                  <div
                    class="user-img mb-5"
                    style="background-image: url('templates/user/images/person_1.jpg')"
                  >
                    <span
                      class="quote d-flex align-items-center justify-content-center"
                    >
                      <i class="icon-quote-left"></i>
                    </span>
                  </div>
                  <div class="text text-center">
                    <p class="mb-5 pl-4 line">
                      Far far away, behind the word mountains, far from the
                      countries Vokalia and Consonantia, there live the blind
                      texts.
                    </p>
                    <p class="name">Garreth Smith</p>
                    <span class="position">Marketing Manager</span>
                  </div>
                </div>
              </div>
              <div class="item">
                <div class="testimony-wrap p-4 pb-5">
                  <div
                    class="user-img mb-5"
                    style="background-image: url(templates/user/images/person_2.jpg)"
                  >
                    <span
                      class="quote d-flex align-items-center justify-content-center"
                    >
                      <i class="icon-quote-left"></i>
                    </span>
                  </div>
                  <div class="text text-center">
                    <p class="mb-5 pl-4 line">
                      Far far away, behind the word mountains, far from the
                      countries Vokalia and Consonantia, there live the blind
                      texts.
                    </p>
                    <p class="name">Garreth Smith</p>
                    <span class="position">Interface Designer</span>
                  </div>
                </div>
              </div>
              <div class="item">
                <div class="testimony-wrap p-4 pb-5">
                  <div
                    class="user-img mb-5"
                    style="background-image: url(templates/user/images/person_3.jpg)"
                  >
                    <span
                      class="quote d-flex align-items-center justify-content-center"
                    >
                      <i class="icon-quote-left"></i>
                    </span>
                  </div>
                  <div class="text text-center">
                    <p class="mb-5 pl-4 line">
                      Far far away, behind the word mountains, far from the
                      countries Vokalia and Consonantia, there live the blind
                      texts.
                    </p>
                    <p class="name">Garreth Smith</p>
                    <span class="position">UI Designer</span>
                  </div>
                </div>
              </div>
              <div class="item">
                <div class="testimony-wrap p-4 pb-5">
                  <div
                    class="user-img mb-5"
                    style="background-image: url(templates/user/images/person_1.jpg)"
                  >
                    <span
                      class="quote d-flex align-items-center justify-content-center"
                    >
                      <i class="icon-quote-left"></i>
                    </span>
                  </div>
                  <div class="text text-center">
                    <p class="mb-5 pl-4 line">
                      Far far away, behind the word mountains, far from the
                      countries Vokalia and Consonantia, there live the blind
                      texts.
                    </p>
                    <p class="name">Garreth Smith</p>
                    <span class="position">Web Developer</span>
                  </div>
                </div>
              </div>
              <div class="item">
                <div class="testimony-wrap p-4 pb-5">
                  <div
                    class="user-img mb-5"
                    style="background-image: url(templates/user/images/person_1.jpg)"
                  >
                    <span
                      class="quote d-flex align-items-center justify-content-center"
                    >
                      <i class="icon-quote-left"></i>
                    </span>
                  </div>
                  <div class="text text-center">
                    <p class="mb-5 pl-4 line">
                      Far far away, behind the word mountains, far from the
                      countries Vokalia and Consonantia, there live the blind
                      texts.
                    </p>
                    <p class="name">Garreth Smith</p>
                    <span class="position">System Analyst</span>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>

    <hr />

    
	
	<%@ include file="/common/footer.jsp"%>
</body>
</html>