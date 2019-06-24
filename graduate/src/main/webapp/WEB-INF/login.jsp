<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8"></meta>
<meta http-equiv="X-UA-Compatible" content="IE=edge"></meta>
<title>Cloud</title>
<link href="https://fonts.googleapis.com/css?family=Roboto:300,400,700"
	rel="stylesheet"></link>

<!-- Animate.css -->
<link rel="stylesheet" href="cloud-login/css/animate.css"></link>
<!-- Icomoon Icon Fonts-->
<link rel="stylesheet" href="cloud-login/css/icomoon.css"></link>
<!-- Themify Icons-->
<link rel="stylesheet" href="cloud-login/css/themify-icons.css"></link>
<!-- Bootstrap  -->
<link rel="stylesheet" href="cloud-login/css/bootstrap.css"></link>

<!-- Magnific Popup -->
<link rel="stylesheet" href="cloud-login/css/magnific-popup.css"></link>

<!-- Owl Carousel  -->
<link rel="stylesheet" href="cloud-login/css/owl.carousel.min.css"></link>
<link rel="stylesheet" href="cloud-login/css/owl.theme.default.min.css"></link>

<!-- Theme style  -->
<link rel="stylesheet" href="cloud-login/css/style.css"></link>
<!-- æ¥å-->
<link rel="stylesheet" href="cloud-login/css/calendar.css"></link>

</head>
<body id="gtco-header" class="gtco-cover" role="banner"
	style="background-image: url(cloud-login/images/1.jpg)">

	<div id="calendar" class="calendar"
		style="position: absolute; float: left; height: 390px; width: 400px; margin-top: -40px"></div>

	<div class="gtco-container">
		<div class="row row-mt-15em">
			<div class="col-md-7 mt-text animate-box"
				data-animate-effect="fadeInUp" style="margin-top: 150px;">
				<span class="intro-text-small">Welcome to Cloud</span>
				<h1>Cloud Management System</h1>
			</div>

			<div class="col-md-4 col-md-push-1 animate-box"
				data-animate-effect="fadeInRight" style="margin-top: 70px;">
				<div class="form-wrap">
					<div class="tab">
						<ul class="tab-menu">
							<li class="active gtco-first"><a href="#" data-tab="signup">Sign
									up</a></li>
							<li class="gtco-second"><a href="#" data-tab="login">Login</a></li>
						</ul>

						<div class="tab-content">

							<div class="tab-content-inner active" data-content="signup">

								<div class="row form-group">
									<div class="col-md-12">
										<label>Account</label> <input type="text" class="form-control"
											id="username_s" name="username_s"></input>
									</div>
								</div>
								<div class="row form-group">
									<div class="col-md-12">
										<label>Password</label> <input type="password"
											class="form-control" id="password_s" name="password_s"></input>
									</div>
									<br />
									<p
										style="text-align: right; color: red; position: absolute; left: 150px; margin-top: 80px;"
										id="info1"></p>
								</div>

								<div class="row form-group">
									<div class="col-md-12">
										<input type="button" class="btn btn-primary" value="Sign up"
											id="signup"></input>
									</div>
								</div>

							</div>

							<div class="tab-content-inner" data-content="login">

								<div class="row form-group">
									<div class="col-md-12">
										<label>Account</label> <input type="text" class="form-control"
											id="account" name="account"></input>
									</div>
								</div>
								<div class="row form-group">
									<div class="col-md-12">
										<label>Password</label> <input type="password"
											class="form-control" id="password" name="password"></input>
									</div>
									<br />
									<p
										style="text-align: right; color: red; position: absolute; left: 150px; margin-top: 80px;"
										id="info"></p>
								</div>
								<div class="row form-group">
									<div class="col-md-12">
										<input type="button" class="btn btn-primary" value="Login"
											id="loginButton"></input>
									</div>
								</div>


							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="gototop js-top">
		<a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
	</div>
	<!-- Modernizr JS -->
	<script src="cloud-login/js/modernizr-2.6.2.min.js"></script>
	<script src="cloud-login/js/jquery-3.2.1.min.js"></script>
	<script>
		$("#signup").click(function() {
			if ($("#username_s").val() == '') {
				$("#info1").text("提示:账号不能为空");
			} else if ($("#password_s").val() == '') {
				$("#info1").text("提示:密码不能为空");
			} else {
				var account = $("#username_s").val();
				var password = $("#password_s").val();
				$.ajax({
					url : "/sign",
					type : "post",
					data : {
						"account" : account,
						"password" : password
					},
					dataType : "json",
					success : function(data) {
						if (data.stateCode.trim() == "0") {
							$("#info1").text("提示:注册成功");
							$("#username_s").val("");
							$("#password_s").val("");
							//window.location.href = "/login";
						} else if (data.stateCode.trim() == "1") {
							$("#info1").text("提示:该用户已经存在");
						}
					},
				});

			}
		})

		$("#loginButton").click(function() {
			if ($("#account").val() == '') {
				$("#info").text("提示:账号不能为空");
			} else if ($("#password").val() == '') {
				$("#info").text("提示:密码不能为空");
			} else {
				var account = $("#account").val();
				var password = $("#password").val();
				$.ajax({
					url : "/validation",
					type : "post",
					data : {
						"account" : account,
						"password" : password
					},
					dataType : "json",
					success : function(data) {
						if (data.stateCode.trim() == "0") {
							$("#info").text("提示:该用户不存在");
						} else if (data.stateCode.trim() == "1") {
							$("#info").text("提示:密码错误");
						} else if (data.stateCode.trim() == "2") {
							$("#info").text("提示:登陆成功，跳转中...");
							window.location.href = "/main/manage";
						}
					},
				});
			}
		})
	</script>
	<!-- <script src="/cloud-login/js/jquery.min.js"></script> -->
	<script src="cloud-login/js/calendar.js"></script>

	<!-- jQuery Easing -->
	<script src="cloud-login/js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="cloud-login/js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="cloud-login/js/jquery.waypoints.min.js"></script>
	<!-- Carousel -->
	<script src="cloud-login/js/owl.carousel.min.js"></script>
	<!-- countTo -->
	<script src="cloud-login/js/jquery.countTo.js"></script>
	<!-- Magnific Popup -->
	<script src="cloud-login/js/jquery.magnific-popup.min.js"></script>
	<script src="cloud-login/js/magnific-popup-options.js"></script>
	<!-- Main -->
	<script src="cloud-login/js/main.js"></script>
</body>
</html>
