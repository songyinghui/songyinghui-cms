<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!--支持缩放 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>今日头条--个人中心</title>
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

			<div class="col-md-12"
				style="background-color: #563D7C; height: 60px">
				<img alt="" src="/resource/image/eight.jpg"
					style="height: 55px; padding-top: 2px; padding-left: 2px">
				 <span style="color: white">今日头条-个人中心</span>
			
			<c:if test="${sessionScope.user!=null }">
					<div class="dropdown">
						<button class="btn btn-sm btn-secondary dropdown-toggle" type="button"
							id="dropdownMenuButton" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false" style="float: right;margin-top: -44px;margin-right: 10px;">
						 ${sessionScope.user.username}</button>
						<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
							<a class="dropdown-item" href="/my">个人中心</a> <a
								class="dropdown-item" href="/passport/logout">注销</a> 	
						</div>
					</div>
				</c:if>
				</div>
		</div>
		<!-- body -->
		<div class="row" style="padding-top: 5px">
			<!--  左侧菜单 -->
			<div class="col-md-2">

				<ul class="list-group">
					<li class="list-group-item active"><a href="#"
						data="/my/articles"><font color="red">我的文章</font></a></li>
					<li class="list-group-item"><a href="#" data="/my/publish"><font color="red">发布文章</font></a></li>
					<li class="list-group-item"><a href=""><font color="red">我的收藏</font></a></li>
					<li class="list-group-item"><a href=""><font color="red">我的评论</font></a></li>
					<li class="list-group-item"><a href=""><font color="red">个人信息</font></a></li>
				</ul>

			</div>
			<!-- 内容显示区域 -->
			<div class="col-md-10" id="center">
			 <!-- 先加载kindeditor的样式 -->
			  <div style="display: none">
			    <jsp:include page="/resource/kindeditor/jsp/demo.jsp"></jsp:include>
			  </div>
		</div>


	</div>

	<script type="text/javascript">
		//默认加载我的文章页面
		$("#center").load("/my/articles")
		//为 li 添加点击事件
		$(function() {
			$("li").click(function() {
				var url = $(this).children().attr("data");
				//去除样式
				$("li").removeClass("active");
				//让当前点击的li 添加选中样式
				$(this).addClass("list-group-item active")
				//在中间区域显示url的内容
				$("#center").load(url);
			})
		})
	</script>
</body>
</body>
</html>