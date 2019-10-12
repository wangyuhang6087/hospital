<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="2"> 
	<tr>
		<td>编号</td>
		<td><input type="text" id="i1" value="1"></td>
	</tr>
	<tr>
		<td>用户名</td>
		<td><input type="text" id="i3"></td>
	</tr>
	<tr>
		<td>密码</td>
		<td><input type="text" id="i4"></td>
	</tr>
	<tr>
		<td>邮箱</td>
		<td><input type="text" id="i5"></td>
	</tr>
	</table>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/Js/jquery.js"></script>
<script type="text/javascript">
	$("#i1").blur(function(){
		var val = $("#i1").val();
		$.ajax({
			url:"/hospital/findUserById.do",
			data:{"id":val},
			type:"GET",
			success:function(data){
			 	$("#i3").val(data.obj.user_name);
 				$("#i4").val(data.obj.password);
				$("#i5").val(data.obj.email);
			}
		});
	});


</script>
</html>