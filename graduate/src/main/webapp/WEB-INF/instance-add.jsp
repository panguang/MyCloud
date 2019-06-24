<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8"></meta>
<meta name="renderer" content="webkit|ie-comp|ie-stand"></meta>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"></meta>
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
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
<title>添加实例</title>
<link href="/lib/webuploader/0.1.5/webuploader.css" rel="stylesheet"
	type="text/css" />
</head>
<body>
	<div class="page-container">
		<form class="form form-horizontal" id="form-article-add">
			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2"><span
					class="c-red">*</span>实例名称：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<input type="text" class="input-text" value="" placeholder=""
						id="instanceName" name="">
				</div>
			</div>

			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2"><span
					class="c-red">*</span>image：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<span class="select-box"> <select id="image_select"
						class="select">
							<c:forEach items="${images}" var="im">
								<option value="${im.id}">名称 ${im.name} 状态 ${im.status}
									类型 ${im.diskFormat}</option>
							</c:forEach>
					</select>
					</span>
				</div>
			</div>

			<div class="row cl">
				<label class="form-label col-xs-4 col-sm-2"><span
					class="c-red">*</span>flavor：</label>
				<div class="formControls col-xs-8 col-sm-9">
					<span class="select-box"> <select id="flavor_select"
						class="select">
							<c:forEach items="${flavors}" var="fl">
								<option value="${fl.id}">名称 ${fl.name} VCPU数
									${fl.vcpus} 磁盘总计 ${fl.disk} RAM ${fl.ram}</option>
							</c:forEach>
					</select>
					</span>
				</div>
			</div>



			<div class="row cl">
				<div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
					<center>
						<button onClick="" class="btn btn-primary radius" type="button"
							id="create">
							<i class="Hui-iconfont">&#xe632;</i>创建实例
						</button>
						<center>
				</div>
			</div>
		</form>
	</div>


	<!--_footer 作为公共模版分离出去-->
	<script type="text/javascript" src="/lib/jquery/1.9.1/jquery.min.js"></script>
	<script type="text/javascript" src="/lib/layer/2.4/layer.js"></script>
	<script type="text/javascript" src="/h-ui/js/H-ui.min.js"></script>
	<script type="text/javascript" src="/h-ui.admin/js/H-ui.admin.js"></script>
	<!--/_footer /作为公共模版分离出去-->

	<!--请在下方写此页面业务相关的脚本-->
	<script type="text/javascript"
		src="/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
	<script type="text/javascript"
		src="/lib/jquery.validation/1.14.0/validate-methods.js"></script>
	<script type="text/javascript"
		src="/lib/jquery.validation/1.14.0/messages_zh.js"></script>
	<script type="text/javascript"
		src="/lib/webuploader/0.1.5/webuploader.min.js"></script>
	<script type="text/javascript">
		$("#create").click(function() {
			var name = $("#instanceName").val();
			var sel = document.getElementById("flavor_select");
			var selected_val = sel.options[sel.selectedIndex].value;
			var sel1 = document.getElementById("image_select");
			var selected_val1 = sel1.options[sel1.selectedIndex].value;
			$.ajax({
				url : "/project/instance_addRel",
				type : "post",
				data : {
					"name" : name,
					"flavor" : selected_val,
					"image" : selected_val1
				},
				dataType : "json",
				success : function(data) {
					layer.msg('创建成功,请刷新子页面进行查看', {
						icon : 1,
						time : 1000
					});
					//var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
					//parent.layer.close(index);

				},
				error : function(data) {
					console.log(data.msg);
				}

			})

		});
		function article_save() {
			alert("刷新父级的时候会自动关闭弹层。")
			window.parent.location.reload();
		}
	</script>
</body>
</html>