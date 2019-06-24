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
<title>折线图</title>
</head>
<body>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>
		统计登陆管理 <span class="c-gray en">&gt;</span> 折线图 <a
			class="btn btn-success radius r"
			style="line-height: 1.6em; margin-top: 3px"
			href="javascript:location.replace(location.href);" title="刷新"><i
			class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<div class="page-container">

		<div id="container" style="min-width: 700px; height: 400px">

			<div id="chart1"></div>
			
		</div>
	</div>
	<script type="text/javascript" src="/cloud-login/js/jquery.min.js"></script>
	<script type="text/javascript" src="/chart/jqplot.js"></script>
	<script type="text/javascript"
		src="/jqplot/plugins/jqplot.barRenderer.min.js"></script>
	<script type="text/javascript"
		src="/jqplot/plugins/jqplot.categoryAxisRenderer.min.js"></script>

	<script>
		$(document).ready(
				function() {
					var a=${dataMap.panguang};
					var b=${dataMap.panxiaoan};
					var c=${dataMap.xiayu};
					var d=${dataMap.lijing};
					var e=${dataMap.wenjing};
					
					var data = [ [ c, e, d, b, a,] ];
					var data_max = 200; //Y轴最大刻度
					var line_title = [ "用户", "管理员" ]; //曲线名称
					var y_label = "访问量"; //Y轴标题
					var x_label = "账户名字(只有注册并登陆才有该账户记录显示否则默认为零)"; //X轴标题
					var x = [ "夏瑜","文静", "李静", "潘晓安", "潘广"]; //定义X轴刻度值
					j.jqplot.diagram.base("chart1", data, line_title,
							"后台超级管理员访问量", x, x_label, y_label, data_max, 1);
				});
	</script>


	<script type="text/javascript" src="/lib/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="/h-ui/js/H-ui.min.js"></script>
	<script type="text/javascript" src="/h-ui.admin/js/H-ui.admin.js"></script>

	<script type="text/javascript"
		src="/lib/hcharts/Highcharts/5.0.6/js/highcharts.js"></script>
	<script type="text/javascript"
		src="/lib/hcharts/Highcharts/5.0.6/js/modules/exporting.js"></script>
	<script type="text/javascript">
		
	</script>
</body>
</html>