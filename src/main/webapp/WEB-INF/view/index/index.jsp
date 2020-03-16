<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!--支持缩放 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>今日头条</title>
<link rel="stylesheet" type="text/css"
	href="/resource/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/resource/index.css" />
<script type="text/javascript" src="/resource/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/popper.min.js"></script>
<script type="text/javascript" src="/resource/bootstrap.min.js"></script>

</head>
<body>
	<div class="container-fulid">
		<!-- head -->
		<div class="row">
			<div class="col-md-12"
				style="background-color: #222222; height: 34px">
				<font color="white" size="2px" style="margin-left: 10px">下载APP</font>
				<c:if test="${sessionScope.user==null }">
					<button type="button" class="btn btn-link" data-toggle="modal"
						style="margin-left: 1100px" data-target="#exampleModal"
						onclick="reg()">注册</button>
					<button type="button" class="btn btn-link" data-toggle="modal"
						style="float: right; margin-right: 65px"
						data-target="#exampleModal" onclick="login()">登录</button>
				</c:if>
				<c:if test="${sessionScope.user!=null }">
					<div class="dropdown">
						<button class="btn btn-sm btn-secondary dropdown-toggle" type="button"
							id="dropdownMenuButton" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false" style="float: right;margin-right:10px;margin-top: -22px;">
						 ${sessionScope.user.username}</button>
						<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
							<a class="dropdown-item" href="/my">个人中心</a> <a
								class="dropdown-item" href="/passport/logout">注销</a> 	
						</div>
					</div>
				</c:if>
			</div>

		</div>

		<div class="row">
			<div class="col-md-2" style="padding-top: 10px">
				<ul>
					<li><a href="/"> <img alt=""
							src="/resource/image/logo-index.png"
							style="width: 108px; height: 27px; margin-bottom: 10px;'">

					</a></li>
					<li class="channel-item ${article.channelId==null?'active':'' }"><a
						href="/?hot=1">热点文章</a></li>
					<c:forEach items="${channels}" var="channel">
						<li><a href="/?channelId=${channel.id }"
							class="channel-item ${article.channelId==channel.id?'active':'' }">${channel.name }</a></li>
					</c:forEach>
				</ul>



			</div>
			<div class="col-md-7">
				<div class="subchannel">
					<c:if test="${article.channelId==null}">

						<div style="margin: 5px 5px 5px 5px">
							<div id="carouselExampleCaptions" class="carousel slide"
								data-ride="carousel">
								<ol class="carousel-indicators">
									<c:forEach items="${slides}" var="slide" varStatus="i">
										<li data-target="#carouselExampleCaptions"
											data-slide-to="${i.index }" class="active"></li>
									</c:forEach>
								</ol>
								<div class="carousel-inner">
									<!-- 遍历轮播图 -->
									<c:forEach items="${slides}" var="slide" varStatus="i">
										<div class="carousel-item ${i.index==0?"active":"" }">
											<img src="/pic/${slide.url }" class="d-block w-100 rounded"
												alt="..." style="width: 350px; height: 320px">
											<div class="carousel-caption d-none d-md-block">
												<h5>${slide.title }</h5>
											</div>
										</div>
									</c:forEach>
								</div>
								<a class="carousel-control-prev" href="#carouselExampleCaptions"
									role="button" data-slide="prev"> <span
									class="carousel-control-prev-icon" aria-hidden="true"></span> <span
									class="sr-only">Previous</span>
								</a> <a class="carousel-control-next"
									href="#carouselExampleCaptions" role="button" data-slide="next">
									<span class="carousel-control-next-icon" aria-hidden="true"></span>
									<span class="sr-only">Next</span>
								</a>
							</div>

						</div>
						<hr>

					</c:if>
					<!--显示栏目的子分类 -->
					<c:if test="${article.channelId!=null }">
						<ul>
							<li
								class="sub-item ${article.categoryId==null?'sub-selected':'' } "><a
								href="/?channelId=${article.channelId }">全部</a></li>
							<c:forEach items="${categorys }" var="cate">
								<li
									class="sub-item ${article.categoryId==cate.id?'sub-selected':'' }"><a
									href="/?channelId=${article.channelId}&categoryId=${cate.id}">${cate.name }</a></li>
							</c:forEach>
						</ul>
					</c:if>
				</div>
				<div>
					<c:forEach items="${info.list }" var="article">
						<div class="media">
							<img src="/pic/${article.picture}" class="mr-3 rounded" alt="..."
								style="width: 190px; height: 124px">
							<div class="media-body">
								<h5 class="mt-0">
									<a href="/articleDetail?id=${article.id}" target="_blank">${article.title }</a>
								</h5>
								<p>${article.user.username }·
									${article.hits} 浏览 ·
									<fmt:formatDate value="${article.created}"
										pattern="yyyy-MM-dd HH:mm:ss" />
								</p>
							</div>
						</div>
					</c:forEach>
					<jsp:include page="/WEB-INF/view/common/pages.jsp"></jsp:include>

				</div>

			</div>
			<div class="col-md-3">
				<div class="card" style="width: 18rem; margin-top: 15px;">
					<div class="card-header">最新文章</div>
					<div class="card-body">
						<c:forEach items="${lastArticles.list }" var="lastArticle">
							<div class="media">
								<img src="/pic/${lastArticle.picture }" class="mr-3" alt="..."
									style="width: 64px; height: 64px; margin-bottom: 5px;">
								<div class="media-body">
									<p><a href="/articleDetail?id=${lastArticle.id }" target="_blank">${lastArticle.title }</a></p>
								</div>
							</div>


						</c:forEach>
					</div>
				</div>




			</div>

		</div>
	</div>
	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">
						<span id="title"></span>
					</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body" id="cent">...</div>

			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	function goPage(page) {

		location = "/?page="
				+ page
				+ "&channelId=${article.channelId}&categoryId=${article.categoryId}";
	}
	function reg() {
		$("#title").empty();
		$("#title").append("用户注册")
		$("#cent").load("/passport/reg");
	}
	function login() {
		$("#title").empty();
		$("#title").append("用户登录");
		$("#cent").load("/passport/login");
	}
</script>
</html>