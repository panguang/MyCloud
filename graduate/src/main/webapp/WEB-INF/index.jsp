<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8"></meta>
<meta name="renderer" content="webkit|ie-comp|ie-stand"></meta>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"></meta>
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"></meta>
<meta http-equiv="Cache-Control" content="no-siteapp"></meta>
<link rel="Bookmark" href="/favicon.ico"></link>
<link rel="Shortcut Icon" href="/favicon.ico"></link>
<!--[if lt IE 9]>
<script type="text/javascript" src="/lib/html5shiv.js"></script>
<script type="text/javascript" src="/lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="/h-ui/css/H-ui.min.css"></link>
<link rel="stylesheet" type="text/css"
	href="/h-ui.admin/css/H-ui.admin.css"></link>
<link rel="stylesheet" type="text/css"
	href="/lib/Hui-iconfont/1.0.8/iconfont.css"></link>
<link rel="stylesheet" type="text/css"
	href="/h-ui.admin/skin/default/skin.css" id="skin"></link>
<link rel="stylesheet" type="text/css" href="/h-ui.admin/css/style.css"></link>
<!--[if IE 6]>
<script type="text/javascript" src="/lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>Cloud</title>
<meta name="keywords" content=""></meta>
<meta name="description" content=""></meta>
<!-- apiignore-->
</head>
<body>
	<header class="navbar-wrapper">
		<div class="navbar navbar-fixed-top">
			<div class="container-fluid cl">
				<a class="logo navbar-logo f-l mr-10 hidden-xs" href="#">后台管理系统</a>
				<span class="logo navbar-slogan f-l mr-10 hidden-xs">v1.0</span>
				<!-- APIIGNORE-->

				<nav id="Hui-userbar"
					class="nav navbar-nav navbar-userbar hidden-xs">
					<ul class="cl">
						<li>管理员</li>
						<li class="dropDown dropDown_hover"><a href="#"
							class="dropDown_A">${sessionScope.account} <i
								class="Hui-iconfont">&#xe6d5;</i></a>
							<ul class="dropDown-menu menu radius box-shadow">
								<li><a href="/admin/loginout">退出</a></li>
							</ul></li>
					</ul>
				</nav>
			</div>
		</div>
	</header>
	<aside class="Hui-aside">
		<div class="menu_dropdown bk_2">
			<dl id="menu-picture">
				<dt>
					<i class="Hui-iconfont">&#xe613;</i> 项目<i
						class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
				</dt>
				<dd>
					<ul>
						<li><a data-href="/project/instance" data-title="实例管理"
							href="javascript:void(0)">实例</a></li>
					</ul>

					<ul>
						<li><a data-href="/project/neutron" data-title="网络管理"
							href="javascript:void(0)">网络</a></li>
					</ul>

					<ul>
						<li><a data-href="/project/glance" data-title="镜像管理"
							href="javascript:void(0)">镜像</a></li>
					</ul>
				</dd>

			</dl>

			<dl id="menu-admin">
				<dt>
					<i class="Hui-iconfont">&#xe62d;</i> 管理员管理<i
						class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
				</dt>
				<dd>
					<ul>
						<li><a data-href="/Super/role" data-title="角色管理"
							href="javascript:void(0)">角色管理</a></li>
					</ul>
					<ul>
						<li><a data-href="/Super/admin" data-title="项目管理"
							href="javascript:void(0)">项目管理</a></li>
					</ul>
					<ul>
						<li><a data-href="/Super/user" data-title="项目管理"
							href="javascript:void(0)">用户管理</a></li>
					</ul>
				</dd>
			</dl>
			<dl id="menu-tongji">
				<dt>
					<i class="Hui-iconfont">&#xe61a;</i> 系统统计<i
						class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
				</dt>
				<dd>
					<ul>
						<li><a data-href="/main/chart" data-title="折线图"
							href="javascript:void(0)">折线图</a></li>
					</ul>
				</dd>
			</dl>
			<dl id="menu-system">
				<dt>
					<i class="Hui-iconfont">&#xe62e;</i> 系统管理<i
						class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i>
				</dt>
				<dd>
					<ul>

						<li><a data-href="/main/Systemlogin" data-title="系统日志"
							href="javascript:void(0)">系统日志</a></li>
					</ul>
				</dd>
			</dl>
		</div>
	</aside>

	<div class="dislpayArrow hidden-xs">
		<a class="pngfix" href="javascript:void(0);"
			onClick="displaynavbar(this)"></a>
	</div>


	<section class="Hui-article-box">
		<div id="Hui-tabNav" class="Hui-tabNav hidden-xs">
			<div class="Hui-tabNav-wp">
				<ul id="min_title_list" class="acrossTab cl">
					<li class="active"><span title="Desktop" data-href="">Desktop</span>
						<em></em></li>
				</ul>
			</div>
			<div class="Hui-tabNav-more btn-group">
				<a id="js-tabNav-prev" class="btn radius btn-default size-S"
					href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a><a
					id="js-tabNav-next" class="btn radius btn-default size-S"
					href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i></a>
			</div>
		</div>
		<div id="iframe_box" class="Hui-article">
			<div class="show_iframe">
				<div style="display: none" class="loading"></div>
				<iframe scrolling="yes" frameborder="0" src="/main/welcomepage"></iframe>
			</div>
		</div>
	</section>

	<!-- <input type="hidden" th:value="${po}" id="po" /> -->
	<div class="contextMenu" id="Huiadminmenu">
		<ul>
			<li id="closethis">关闭当前</li>
			<li id="closeall">关闭全部</li>
		</ul>
	</div>
	<!--_footer 作为公共模版分离出去-->

	<script type="text/javascript" src="/lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="/lib/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="/h-ui/js/H-ui.min.js"></script>
	<script type="text/javascript" src="/h-ui.admin/js/H-ui.admin.js"></script>
	<!--/_footer 作为公共模版分离出去-->

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript"
		src="/lib/jquery.contextmenu/jquery.contextmenu.r2.js"></script>

	<script type="text/javascript">
		
	</script>
</body>
</html>