<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="">
	用户名:<input type="text" name="username" id="i1">
	<br>
	密码:<input type="password" name="password" id="i2">
	<br>
	<input type="submit" value="注册" id="i3">
	</form>
</body>
 <script type="text/javascript" src="${pageContext.request.contextPath }/Js/jquery.js"></script>
<script type="text/javascript">
	// 绑定失去焦点事件
	/* $("#i1").blur(function(){
		// 获得输入的值
		 var val = $("#i1").val();
		// 异常发送请求:ajax
		$.ajax({
			url:"/hospital/checkUser",
			type:"POST",
			data:{"usernameJsonkey":val},
			success:function(msg){  // 返回状态码
				if(JSON.parse(msg).code == 200) {
					// 没查到,可以注册
					$("#s1").remove();
					$("#i3").removeAttr("disabled");
					$("#i1").after("<span id='s1'>该用户名可以注册</span>")
					$("#s1").css("color","green");
				}else{
					// 查到该用户,说明已注册
					$("#s1").remove();
					$("#i1").after("<span id='s1'>该用户名已经被注册</span>")
					$("#s1").css("color","red");
					// 禁止提交
					$("#i3").attr("disabled","disabled")
				}
			},
			error:function(){
				alert("服务器忙,稍后尝试!")
			}
		}); 
	}); */
	
	$("#i1").blur(function(){
		// 获得输入的值
		 var val = $("#i1").val();
		// 异常发送请求:ajax
		$.ajax({
			url:"/hospital/checkUser2",
			type:"POST",
			data:{"usernameJsonkey":val},
			success:function(msg){  // 返回状态码
				 alert(msg.code + " - " +msg.message ) 
			},
			error:function(){
				alert("服务器忙,稍后尝试!")
			}
		}); 
	});
	
	
	
	
</script>
</html>