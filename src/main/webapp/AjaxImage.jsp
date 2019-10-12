<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
	
	<form action="#" id="formId" >
		<input type="file" name="img"><br>
		<input type="button" value="上传" onclick="doUpload()" >
	</form>
	<div>
		<img id="i1"  alt="" src="" width="200px" height="200px">
	</div>
	
</body>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/Js/jquery.js"></script> 
<script type="text/javascript">
	function doUpload(){
		// 创建Form表单对象
		var formData = new FormData($("#formId")[0]);
		// ajax 发送请求,返回图片地址,赋值给img标签
		$.ajax({
			url:"/hospital/upload.do",
			type:"POST",
			data:formData,
			async:false,
			contentType:false,
			processData:false,
			success:function(data){
				alert(data.obj);
				$("#i1").attr("src","${pageContext.request.contextPath}"+data.obj);
			}
		});
	}

</script>

</html>