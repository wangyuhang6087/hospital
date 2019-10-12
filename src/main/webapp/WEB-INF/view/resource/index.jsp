<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 引入格式化标签库 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/Css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/Css/bootstrap-responsive.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/Css/style.css" />
<link href="${pageContext.request.contextPath}/dist/css/bootstrap.min.css" rel="stylesheet">
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
	<form action="${pageContext.request.contextPath}/resource/index" method="post" class="definewidth m20">
	<table class="table table-bordered table-hover definewidth m10">

			<tr>
				<td>资源名称<input type="text" name="resource_name" ></td>
			</tr>
			<tr>
				<td colspan="6"><center>
						<button type="submit" class="btn btn-primary" type="button">查询</button>
					</center></td>
			</tr>
		</table>
	</form>
	
	<form action="${pageContext.request.contextPath}/resource/index" method="post" class="definewidth m20">
		<table class="table table-bordered table-hover definewidth m10">
    <thead>
    <tr>
    	<td width="5%"><input type="checkbox" id="all" onclick="checkall()" />全选/不选</td>
        <td>资源名称</td>
        <td>路径Url</td>
        <td>是否有效</td>
        <td  width="10%">操作</td>
    </tr>
    </thead>
	    <c:forEach items="${lists }" var="d">
			<tr>
			<td style="vertical-align:middle;"><input value="${d.id }" name="id" type="checkbox"></td>
            <td>${d.resource_name }</td>
            <td>${d.resource_url }</td>
            <td>${d.status }</td>
            <td>
                <a href="${pageContext.request.contextPath}/resource/edit?id=${d.id }">编辑</a> 
                <a href="${pageContext.request.contextPath}/resource/delete?id=${d.id }">删除</a>             
            </td>
			</tr>
		</c:forEach>
	</table>
	<button type="button" class="btn btn-success" id="newNav">资源添加</button>
	<button type="submit" class="btn btn-success"  onclick="delAll()" >批量删除</button>
</form>

<br>
	<p>共${total }条记录,当前${page.pageNum }/${page.pages }页</p>	
	
<div style="size: 50px">		
<nav aria-label="Page navigation">
  <ul class="pagination">
    <li>
      <a href="${pageContext.request.contextPath}/resource/index?pageNo=${page.pageNum - 1}&keyword=${map.resource_name}" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
   <c:forEach var="i" begin="1" end="${page.pages }" step="1">
   		<li><a href="${pageContext.request.contextPath}/resource/index?pageNo=${i}&keyword=${map.resource_name}">${i}</a></li>
   </c:forEach>
    <li>
      <a href="${pageContext.request.contextPath}/resource/index?pageNo=${page.pageNum + 1}&keyword=${map.resource_name}" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>
</div>
	 
<script type="text/javascript">
	function checkall() {
		var allNode = document.getElementById("all");
		var itemNodes = document.getElementsByName("id");
		for (i = 0; i < itemNodes.length; i++) {
			itemNodes[i].checked = allNode.checked;
		}
	}
		
		 $(function () {
				$('#newNav').click(function(){
						window.location.href="${pageContext.request.contextPath}/resource/add";
				 });
		 });
		
</script>
</body>
</html>