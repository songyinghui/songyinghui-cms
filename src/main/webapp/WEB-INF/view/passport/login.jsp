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
<link rel="stylesheet" type="text/css" href="/resource/index.css" />
<link rel="stylesheet" type="text/css"
	href="/resource/jquery/screen.css" />
<script type="text/javascript" src="/resource/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/resource/jquery.validate.js"></script>
<script type="text/javascript" src="/resource/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
		<form action="" id="form1">

			<div class="form-group">
				<label for="username">用户名</label> <input id="username" type="text"
					class="form-control" name="username">
			</div>
			<div class="form-group">
				<label for="password">密码</label> <input id="password"
					type="password" class="form-control" name="password">
			</div>

			<div class="form-group">
				<button type="submit" class="btn btn-info">登录</button>
				<button type="reset" class="btn btn-warning">重置</button>
			</div>


		</form>
	</div>
</body>
<script type="text/javascript">
	$(function() {

		$("#form1").validate(
				{
					//1 .定义规则
					rules : {
						username : {
							required : true,//用户名不能为空
						},
						password : {
							required : true,//密码不能为空
						},
					},
					//2.定义消息提示
					messages : {
						username : {
							required : "用户名不能为空",
						},
						password : {
							required : "密码不能为空",
						},
					},
					submitHandler : function(flag) {
						//如果校验通过。则执行注册
						$.post("/passport/login", $("#form1").serialize(),
								function(result) {
                                    if(result.code==200){
                                    	location="/";
                                    }else{
                                    	$("#title").html("<font color='red'>"+result.msg+"</font>");
                                    }
								})
					}
				})
	})
</script>
</html>