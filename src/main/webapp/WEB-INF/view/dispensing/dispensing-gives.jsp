<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 引入格式化标签库 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>发药more</title>
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

        @media (max-width: 980px) {
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

<form action="${pageContext.request.contextPath}/dispensing/sendDrugs" method="get">   
<table class="table table-bordered table-hover definewidth m10" >
   <tr>
        <td width="10%" class="tableleft">病历号</td>
        <td><textarea readonly="readonly" >${id }</textarea>
        <input type="hidden" value="${id }" name="id"/>
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">姓名</td>
        <td><textarea readonly="readonly" >${name }</textarea></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">药品名称</td>
        <td><select name="drug_num">
        <option value="06a120190223501111">大力丸一号</option>
        <option value="06a12019022351">大力丸二号</option>
        <option value="12312345645">大力丸三号</option>
        </select></td>
    </tr>
     <tr>
        <td width="10%" class="tableleft">发药数量</td>
        <td><input type="text" name="dispens_num"/></td>
    </tr>
  </table>
	<button type="submit" class="btn btn-success" >保存</button>
	${msg }
    <button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
	</form>

	 
<script type="text/javascript">
    $(function () {       
		$('#backid').click(function(){
				window.location.href="${pageContext.request.contextPath}/dispensing/index";
		 });
    });
    </script>		                                                                                           
</body>
</html>