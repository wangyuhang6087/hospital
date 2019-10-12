<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<select name="section" id="s1">
		<option value="1">骨科</option>
		<option value="2">急诊科</option>
		<option value="3">妇科</option>
	</select>
	<select name="doctor" id="d1">
		
	</select>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/Js/jquery.js"></script>
<script type="text/javascript">
$("#s1").change(function(){
	// 获得输入的值
	 var sectionId = $("#s1").val();
	// 异常发送请求:ajax
	 $.ajax({
		url:"/hospital/findDoctorBySectionId.do",
		type:"GET",
		data:{"sectionId":sectionId},
		success:function(parameter){ 
			$("#d1").empty();
			for (var i = 0; i < parameter.obj.length; i++) {
				$("#d1").append("<option>"+parameter.obj[i].name+"</option>");
			}
		}	
	}); 
});


</script>
</html>