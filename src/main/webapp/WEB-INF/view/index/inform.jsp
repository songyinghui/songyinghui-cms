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
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="/resource/bootstrap.min.css" />
<script type="text/javascript" src="/resource/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/bootstrap.min.js"></script>
<meta name="keywords" content="${article.keywords }">

</head>
<body>
	<div class="container-fulid">
		<div class='row'>
			<div class="col-md-12"
				style="background-color: #222222; height: 34px">
				<font color="white" size="2px" style="margin-left: 10px">下载APP</font>
			</div>
		</div>
		<div class="row">
			<div class='col-md-1'></div>
			<div class='col-md-7'>
				<h2>${article.title }</h2>
				<p>文章来源:${article.origin }</p>
				<p>${article.user.username}
					<fmt:formatDate value="${article.created}"
						pattern="yyyy-MM-dd HH:mm:ss" />
				</p>
				<c:if test="${collect!=null }">
				 <button type="button" onclick="deleteCollect()" class="btn btn-link">★&nbsp;  取消收藏</button>
				</c:if>
				<c:if test="${collect==null }">
				 <button type="button" onclick="collect(1)" class="btn btn-link">☆ &nbsp;  未收藏</button>
				</c:if>
				<hr>
				<p>${article.content }</p>
				<hr>
				<div style="width: 594px; height: 162px">
					<h5>文章评论：</h5>
					<c:if test="${sessionScope.user!=null }">
						<textarea rows="8" cols="20" style="width: 753px" name="content"></textarea>
						<button type="button" onclick="addComment()" class="btn btn-info">提交评论</button>
					</c:if>
					<div>
						<c:forEach items="${info.list}" var="comment">
							<h6>${comment.user.username}
								<fmt:formatDate value="${comment.created}" />
							</h6>
				    ${comment.content }
				    
				  <hr>
						</c:forEach>
						<jsp:include page="/WEB-INF/view/common/pages.jsp"></jsp:include>
					</div>
				</div>

			</div>
			<div class='col-md-4'>
				<div class="card" style="width: 20rem; margin-top: 15px;">
					<div class="card-header">评论排行榜</div>
					<div class="card-body">
						<c:forEach items="${info2.list }" varStatus="i" var="a">
							<p>${i.count }:<a href="/articleDetail?id=${a.id }" target="_blank">${a.title }</a></p>
							<hr>
						</c:forEach>
					</div>



				</div>
			</div>

		</div>
	</div>

	</div>
</body>
<script type="text/javascript">
     $.ajax({
    	 url:"/updateHit?id=${article.id}",
    	 success:function(flag){
    		 if(flag){
    			 alert(hit+1)
    		 }
    	 }
     })
</script>
<script type="text/javascript">
	function addComment() {
		var articleId = '${article.id}';
		var content = $("[name='content']").val();
		$.post("/addComment", {
			articleId : articleId,
			content : content
		}, function(flag) {
			if (flag) {
				alert("评论成功");
				window.location.reload();
			} else {
				alert("评论失败，需要登录后才能评论,亲进入首页登录")
				location = "/"
			}
		})
	}
	function goPage(page) {
		location = "articleDetail?page=" + page + "&id=${article.id}";
	}
	function collect(id){
		//文章标题
		var title ='${article.title}';
		//文章的url
		
		var url=window.location.href;
		$.post("/collect",{text:title,url:url},function(flag){
			if(flag){
				alert("收藏成功");
				window.location.reload();
			}else{
				alert("收藏失败，需要登录后才能收藏")
			}
		})
	}
	function deleteCollect(){
		var id ='${collect.id}';
		$.post("/deleteCollect",{id:id},function(flag){
			if(flag){
				alert("收藏已取消");
				window.location.reload();
			}else{
				alert("失败")
			}
		})
	}
</script>
</html>