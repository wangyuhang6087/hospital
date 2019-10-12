<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>修改医生---2015</title>
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
    <script type="text/javascript">
    $(function () {       
		$('#backid').click(function(){
				window.location.href="${pageContext.request.contextPath}/doctor/index";
		 });
    });
    </script>
</head>
<body>
<form action="${pageContext.request.contextPath }/doctor/edit" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">姓名</td>
        <td><input type="text" name="name" value="${doctor.name }"/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">证件类型</td>
        <td><select name="certificate_type">
        <option value="1">身份证</option>
        <option value="2">护照</option>
        <option value="3">军人证</option>
        </select></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">证件号</td>
        <td><input type="text" name="ID_num" value="${doctor.ID_num }"/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">手机</td>
        <td><input type="text" name="phone" value="${doctor.phone }"/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">座机</td>
        <td><input type="text" name="special_plane" value="${doctor.special_plane }"/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">性别</td>
        <td><input type="radio" name="sex" value="1" checked/>男&nbsp;&nbsp;&nbsp;
        <input type="radio" name="sex" value="0"/>女</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">出生年月</td>
        <td><input type="text" name="birther" value="${doctor.birther }"/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">年龄</td>
       <td><input type="text" readonly="readonly" value="${doctor.age }"/></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">电子邮箱</td>
        <td><input type="text" name="email" value="${doctor.email }"/>
        	 <input type="hidden" value="${doctor.id }" name="id">
        </td>
    </tr>
   <tr>
        <td width="10%" class="tableleft">所属科室</td>
        <td><select name="section_id">
        <option value="003">外科</option>
        <option value="004">急诊科</option>
        <option value="002">骨科</option>
        <option value="001">血液科</option>
        <option value="005">妇科</option>
        </select></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">学历</td>
        <td><select name="education">
        <option value="1">专科</option>
        <option value="2">本科</option>
        <option value="3">博士</option>
        <option value="4">博士后</option>
        </select></td>
    </tr>
	<tr>
        <td width="10%" class="tableleft" >备注</td>
        
        <td><textarea name="noted">
        	${doctor.noted}
        </textarea>
       
        </td>
	</tr>
    <tr>
        <td colspan="2">
			<center>
				
				<button type="submit" class="btn btn-primary" type="button">保存</button> &nbsp;&nbsp;<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
			</center>
		</td>
    </tr>
</table>
</form>
                                                                                            
</body>
</html>  