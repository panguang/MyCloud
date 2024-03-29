﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>系统日志</title>
</head>
<body>
	<nav class="breadcrumb">
		<i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span>
		系统管理 <span class="c-gray en">&gt;</span> 系统日志 <a
			class="btn btn-success radius r"
			style="line-height: 1.6em; margin-top: 3px"
			href="javascript:location.replace(location.href);" title="刷新"><i
			class="Hui-iconfont">&#xe68f;</i></a>
	</nav>
	<div class="page-container">
		<div class="cl pd-5 bg-1 bk-gray mt-20">
			<span class="r">共有数据：<strong>${number}</strong> 条
			</span>
		</div>
		<table
			class="table table-border table-bordered table-bg table-hover table-sort">
			<thead>
				<tr class="text-c">
					<th width="25"><input type="checkbox" name="" value=""></th>
					<th width="100">类型</th>
					<th width="80">ID</th>
					<th>内容</th>
					<th width="17%">用户名</th>
					<th width="120">客户端IP</th>
					<th width="120">时间</th>
					<th width="70">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${slList}" var="list">
					<tr class="text-c">

						<td><input type="checkbox" value="" name=""></td>
						<td>1</td>
						<td>${list.id}</td>
						<td>${list.content}</td>
						<td>${list.username}</td>
						<td>${list.clientip}</td>
						<td>${list.time}</td>
						<td><a title="详情" href="javascript:;"
							onclick="system_log_show(this,'10001')" class="ml-5"
							style="text-decoration: none"><i class="Hui-iconfont">&#xe665;</i></a>
							<a title="删除" href="javascript:;"
							onclick="system_log_del(this,'${list.id}')" class="ml-5"
							style="text-decoration: none"><i class="Hui-iconfont">&#xe6e2;</i></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div id="pageNav" class="pageNav"></div>
	</div>
	<!--_footer 作为公共模版分离出去-->
	<script src="/cloud-login/js/jquery-3.2.1.min.js"></script>

	<script type="text/javascript" src="/lib/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="/h-ui/js/H-ui.min.js"></script>
	<script type="text/javascript" src="/h-ui.admin/js/H-ui.admin.js"></script>
	<!--/_footer 作为公共模版分离出去-->

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript"
		src="/lib/My97DatePicker/4.8/WdatePicker.js"></script>
	<script type="text/javascript" src="/lib/laypage/1.2/laypage.js"></script>
	<script type="text/javascript"
		src="/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>


	<script type="text/javascript">
		$('.table-sort').dataTable({
			"lengthMenu" : false,//显示数量选择 
			"bFilter" : false,//过滤功能
			"bPaginate" : false,//翻页信息
			"bInfo" : false,//数量信息
			"aaSorting" : false,//默认第几个排序
			"bStateSave" : true,//状态保存
			"aoColumnDefs" : [ {
				//"bVisible": false, 
				//"aTargets": [ 3 ], //控制列的隐藏显示
				"orderable" : false,
				"aTargets" : [ 0, 7 ]
			} // 制定列不参与排序
			]
		});

		/*查看日志*/
		function system_log_show() {

		}
		/*日志-删除*/
		function system_log_del(obj, id) {
			layer.confirm('确认要删除吗？', function(index) {
				$.ajax({
					type : 'POST',
					url : '/main/deleteSystem',
					dataType : 'json',
					data : {
						"id" : id
					},
					success : function(data) {
						$(obj).parents("tr").remove();
						layer.msg('已删除!', {
							icon : 1,
							time : 1000
						});
					},
					error : function(data) {
						console.log(data.error);
					},
				});
			});
		}
	</script>
</body>
</html>