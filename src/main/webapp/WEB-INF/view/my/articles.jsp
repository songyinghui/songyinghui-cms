<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
</head>
<body>
	<c:forEach items="${info.list}" var="article">
		<div class="media">
			<img src="/pic/${article.picture }" class="mr-3 rounded" alt="..."
				style="width: 100px; height: 100px">
			<div class="media-body">
				<h5 class="mt-0">${article.title }</h5>
				<div style="float: right; padding-top: 60px;">
					<button onclick="articleDetail(${article.id})" type="button"
						class="btn btn-primary" data-toggle="modal"
						data-target="#exampleModalLong">详情</button>

				</div>
			</div>
		</div>
		<hr />
	</c:forEach>
	<!-- Modal -->
	<div class="modal fade" id="exampleModalLong" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLongTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header" >
					<h5 class="modal-title" id="exampleModalLongTitle"><span id="title"></span></h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body" id="content"></div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	<!--引入分页  -->
	<jsp:include page="/WEB-INF/view/common/pages.jsp" />
</body>
<script type="text/javascript">
function articleDetail(id){
	$.ajax({
		url:"/my/articleDetail",
		data:{id:id},
		dataType:"json",
		type:"post",
		success:function(obj){
			$("#title").empty();
			$("#title").append(obj.title);
			$("#content").empty();
			$("#content").append(obj.content);
		}
		
	})
}
	function goPage(page) {
		$("#center").load("/my/articles?page=" + page);
	}
</script>
</html>