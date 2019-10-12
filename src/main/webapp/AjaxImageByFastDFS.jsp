<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="#" id="formId">
		<input type="file" name="img">
		<input type="button" value="上传" onclick="upload()">
		<input type="button" value="下载" onclick="download()">
		<input type="hidden" value="" id="hid">
	</form>
	<div>
		<img alt="" id="img1" width="300px" height="300px" src="">
	</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath }/Js/jquery.js"></script>
<script type="text/javascript">
	
	function upload(){
		var formData = new FormData($("#formId")[0]);
		$.ajax({
			url:"/hospital/uploadByFastDFS.do",
			type:"POST",
			data:formData,
			async:false,
			contentType:false,
			processData:false,
			success:function(data){
				 alert(data.obj);
				 $("#img1").attr("src",data.obj.path);
				 $("#hid").val(data.obj.fid);
			}
		});
	}
	
	
	function download(){
		 var fid = $("#hid").val();
	/* 	 alert(src);
		 var str1 = "?fid="+src; */
		window.open("http://localhost:8080/hospital/downloadByFastDFS.do?fid=" + fid);
	}
	

</script>
</html>