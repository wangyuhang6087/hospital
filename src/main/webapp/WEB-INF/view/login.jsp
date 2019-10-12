<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>xx市第二人民医院信息管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="${pageContext.request.contextPath }/assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath }/assets/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="${pageContext.request.contextPath }/assets/css/main-min.css" rel="stylesheet" type="text/css" />
</head>
<body>

<div class="header">

    <div class="dl-title">
    </div>

    <div class="dl-log">欢迎您，<span class="dl-log-user">${user.real_name }</span>
	
	<a href="${pageContext.request.contextPath}/login.out" title="退出系统" class="dl-log-quit">[退出]</a>
    </div>
</div>
<div class="content">
    <div class="dl-main-nav">
        <div class="dl-inform"><div class="dl-inform-title"><s class="dl-inform-icon dl-up"></s></div></div>
        <ul id="J_Nav"  class="nav-list ks-clear">
            <li class="nav-item dl-selected"><div class="nav-item-inner nav-home">医院管理系统</div></li>

		</ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-conten">
    </ul>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/jquery-1.6.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/bui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/common/main-min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/assets/js/config-min.js"></script>
<script>
    BUI.use('common/main',function(){
        var config = [
			{id:'1',menu:[
		
				
	{text:'快速通道',items:[
		<c:forEach items="${list }" var="h">
		{id:'${h.id}',text:'${h.resource_name}',href:'${pageContext.request.contextPath}${h.resource_url}'},
		</c:forEach> 
		]}		
			]}		
		];
        new PageUtil.MainPage({
            modulesConfig : config
        });
    });
</script>
                                                                                            
</body>
</html>    