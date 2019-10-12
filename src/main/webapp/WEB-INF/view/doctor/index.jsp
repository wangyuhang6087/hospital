<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 引入格式化标签库 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>门诊医生---2015</title>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/Css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/Css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/Css/style.css" />
<link href="${pageContext.request.contextPath}/dist/css/bootstrap.min.css" rel="stylesheet">

<style type="text/css">
body {
	padding-bottom: 40px;
}

.sidebar-nav {
	padding: 9px 0;
}

@media ( max-width : 980px) {
	/* Enable use of floated navbar text */
	.navbar-text.pull-right {
		float: none;
		padding-left: 5px;
		padding-right: 5px;
	}
}
</style>

</head>
<body>

	<form action="${pageContext.request.contextPath}/doctor/index" method="post" class="definewidth m20">
		<table class="table table-bordered table-hover definewidth m10">

			<tr>
				<td>名字<input type="text" name="keyword" value="${map.keyword }"></td>
			</tr>
			<tr>
				<td colspan="6"><center>
						<button type="submit" class="btn btn-primary" type="button">查询</button>
						<button type="reset" class="btn btn-primary" type="button">清空</button>
					</center></td>
			</tr>
		</table>	
	</form>

<form action="${pageContext.request.contextPath}/doctor/findDoctorByIds" method="post" class="definewidth m20">
	<table class="table table-bordered table-hover definewidth m10">
		
			<tr>
				<td><input type="checkbox" id="all" onclick="checkall()" />全选/不选</td>
				<td>医生编号</td>
				<td>医生姓名</td>
				<td>入院时间</td>
				<td>所属科室</td>
				<td>操作</td>
			</tr>
		
		<c:forEach items="${lists }" var="d">
			<tr>
				<td><input value="${d.id }" name="id" type="checkbox"></td>
				<td>${d.id }</td>
				<td>${d.name }</td>
				<td><fmt:formatDate value="${d.time }" pattern="yyyy-MM-dd" />
				<td style="vertical-align:middle;">
					${d.section.secco_name }
				</td>
			
				<td><a 
					href="${pageContext.request.contextPath}/doctor/look?id=${d.id }">详情</a>|
					<a class="glyphicon glyphicon-repeat"
					href="${pageContext.request.contextPath}/doctor/edit?id=${d.id }"></a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<!-- <input type="submit" value="批量删除" > -->
	<input type="button" id="exportExccel" class="btn btn-success" value="导出Excel"/>
	<button type="button" class="btn btn-success" id="newNav">添加新医生</button>
	<input type="button" class="btn btn-success" id="deteleMore" value="批量删除" />
</form>

<br>
	<p>共${total }条记录,当前${page.pageNum }/${page.pages }页</p>	
	
<div style="size: 50px">		
<nav aria-label="Page navigation">
  <ul class="pagination">
    <li>
      <a href="${pageContext.request.contextPath}/doctor/index?pageNo=${page.pageNum - 1}&keyword=${map.keyword}" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
   <c:forEach var="i" begin="1" end="${page.pages }" step="1">
   		<li><a href="${pageContext.request.contextPath}/doctor/index?pageNo=${i}&keyword=${map.keyword}">${i}</a></li>
   </c:forEach>
    <li>
      <a href="${pageContext.request.contextPath}/doctor/index?pageNo=${page.pageNum + 1}&keyword=${map.keyword}" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>
</div>

<script type="text/javascript"
	src="${pageContext.request.contextPath }/Js/jquery.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/Js/jquery.sorted.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/Js/bootstrap.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/Js/ckform.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/Js/common.js"></script>
	
	
	
<script type="text/javascript">
function checkall() {
	// var allNode = document.getElementsByName("all")[0];
	var allNode = document.getElementById("all");
	var idNodes = document.getElementsByName("id");
	for (i = 0; i < idNodes.length; i++) {
		idNodes[i].checked = allNode.checked;
	}
}
	 $(function () {
		$('#newNav').click(function(){
				window.location.href="${pageContext.request.contextPath}/doctor/add";
		 });
	 });	
</script>


<script type="text/javascript">

$("#deteleMore").click(function(){
	var idNodes = document.getElementsByName("id");
	var idArr = new Array();
	for (var i = 0; i < idNodes.length; i++) {
		if(idNodes[i].checked){
			idArr.push(idNodes[i].value);
		}
	}
	$.ajax({
		url:"/hospital/doctor/deleteMore",
		type:"POST",
		data:{"id":idArr},
		traditional:true,
		success:function(){
			window.location.href="${pageContext.request.contextPath}/doctor/index";
		}
	});
});


</script>

<script type="text/javascript">
$("#exportExccel").click(function(){
	var idNodes = document.getElementsByName("id");
	var str = "?"; 
	for (var i = 0; i < idNodes.length ; i++) {
		if(idNodes[i].checked){
			if(i != idNodes.length - 1){
				str = str + "id=" + idNodes[i].value + "&" }
			else{
				str = str + "id=" + idNodes[i].value
			}
		}
	}
	if(str != "?"){
		alert(str);
		window.location.href="${pageContext.request.contextPath}/doctor/exportExcel" + str;
	}else{
		alert(str);
	}
});
</script> 
</body>
</html>