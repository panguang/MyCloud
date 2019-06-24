<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8"></meta>
<meta name="renderer" content="webkit|ie-comp|ie-stand"></meta>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"></meta>
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"></meta>
<meta http-equiv="Cache-Control" content="no-siteapp"></meta>
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
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
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>Desktop</title>
</head>
<body>

	<div class="page-container">
		<p class="f-20 text-success">
			欢迎使用后台管理系统 <span class="f-14">v1.0</span>
		</p>
		
			
		<p>登录次数： ${sessionScope.count}</p>
		<p>上次登录IP： ${sessionScope.ip} 上次登录时间：
			${sessionScope.lasttime}</p>
		<table class="table table-border table-bordered table-bg">
			<thead>
				<tr>
					<th colspan="7" scope="col">信息统计</th>
				</tr>
				<tr class="text-c">
					<th>统计</th>
					<th>用户</th>
					<th>管理员</th>
				</tr>
			</thead>
			<tbody>
				<tr class="text-c">
					<td>总数</td>
					<td>${sessionScope.sum}</td>
					<td>${sessionScope.sum}</td>

				</tr>

			</tbody>
		</table>
		<table class="table table-border table-bordered table-bg mt-20">
			<thead>
				<tr>
					<th colspan="2" scope="col">服务器信息</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th width="30%">服务器计算机名</th>
					<td><span id="lbServerName">${sessionScope.hostname}</span></td>
				</tr>
				<tr>
					<td>服务器IP地址</td>
					<td>${sessionScope.hostIp}</td>
				</tr>
				<tr>
					<td>服务器端口</td>
					<td>${sessionScope.port}</td>
				</tr>

				<tr>
					<td>服务器当前时间</td>
					<td>${sessionScope.currenttime}</td>
				</tr>
				<tr>
					<td>当前系统用户名</td>
					<td>NETWORK SERVICE</td>
				</tr>
			</tbody>
		</table>
	</div>
	<script src="/h-ui/js/jquery-3.2.1.min.js"></script>
	<script>
		
	</script>

	<script type="text/javascript" src="/h-ui/js/H-ui.min.js"></script>

</body>
</html>