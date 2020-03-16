<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!--支持缩放 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>今日头条--管理员中心</title>
<link rel="stylesheet" type="text/css"
	href="/resource/bootstrap.min.css" />
<script type="text/javascript" src="/resource/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/popper.min.js"></script>
<script type="text/javascript" src="/resource/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fulid">
		<!-- 头 -->
		<div class="row">

			<div class="col-md-12" style="background-color: blue; height: 60px">
				<img alt="" src="/resource/image/eight.jpg" class="rounded"
					style="height: 55px; padding-top: 2px; padding-left: 2px;"> <span
					style="color: yellow">今日头条-管理员中心</span>
					<c:if test="${sessionScope.admin!=null }">
					<div class="dropdown">
						<button class="btn btn-sm btn-secondary dropdown-toggle" type="button"
							id="dropdownMenuButton" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false" style="float: right;margin-top: -44px;margin-right: 10px;">
						 ${sessionScope.admin.username}</button>
						<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
						<a class="dropdown-item" href="/passport/logout">注销</a> 	
						</div>
					</div>
				</c:if>
			</div>
		</div>
		<!-- body -->
		<div class="row" style="padding-top: 3px; height: 580px;">
			<!--  左侧菜单 -->
			<div class="col-md-2 rounded"
				style="background-color: #ccc; text-align: center; margin-left: 15px">
				<nav class="nav flex-column">
					<a class="list-group-item active" href="#" data="/admin/articles">文章审核</a>
					<a class="list-group-item" href="#" data="/admin/users">用户管理</a> <a
						class="list-group-item" href="#">栏目管理</a> <a
						class="list-group-item" href="#">分类管理</a> <a
						class="list-group-item" href="#">系统配置</a>
				</nav>
			</div>
			<!-- 内容显示区域 -->
			<div class="col-md-9" id="center">
			
			</div>

		</div>
	</div>

</body>
<script type="text/javascript">
	$("#center").load("/admin/articles")
	$(function() {
		$("a").click(function() {
			var url = $(this).attr("data");
			//去除样式
			$("a").removeClass("active");
			//让当前点击的li 添加选中样式
			$(this).addClass("list-group-item active")
			//在中间区域显示url的内容
			$("#center").load(url);
		})
	})
</script>
</html>