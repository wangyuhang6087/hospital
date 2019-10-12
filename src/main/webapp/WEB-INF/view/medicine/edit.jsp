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
				window.location.href="${pageContext.request.contextPath}/medicine/index";
		 });
    });
    </script>
</head>
<body>
<form action="${pageContext.request.contextPath }/medicine/edit" method="post" class="definewidth m20"
enctype="multipart/form-data">
		
	<table class="table table-bordered table-hover definewidth m10">
    
    <tr>
        <td width="10%" class="tableleft">售价</td>
        <td><input type="text" name="sale_price"  value="${drug.sale_price }" /></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">药品名称</td>
        <td><input type="text" name="drug_name"  value="${drug.drug_name }"/></td>
    </tr>
    <tr>
      <td width="10%" class="tableleft">更新图片</td>
        <td><input type="file" name="img" src="${pageContext.request.contextPath }${drug.drug_url}" /></td>
     </tr>
    <tr>
        <td width="10%" class="tableleft">药品类型</td>
        <td>
        <input type="radio" name="drug_type" value="1" checked/>中药
        &nbsp;&nbsp;&nbsp;
        <input type="radio" name="drug_type" value="2"/>西药
         &nbsp;&nbsp;&nbsp;
        <input type="radio" name="drug_type" value="3"/>处方药   
         &nbsp;&nbsp;&nbsp;
        <input type="radio" name="drug_type" value="4"/>非处方药
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">简单描述</td>
        <td><input type="text" name="simple_detail" value="${drug.simple_detail }"/>
        	<input type="hidden" value="${drug.drug_num }" name="drug_num">
        </td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">生产日期</td>
        <td><input type="text" value="${drug.prodeced_date}" name="prodeced_date"  /></td>
    </tr>  
     <tr>
        <td width="10%" class="tableleft">过期日期</td>
        <td><input type="text" value="${drug.expiration_date}" readonly="readonly" /></td>
    </tr>  
    <tr>
        <td width="10%" class="tableleft">保质期</td>
       <td><input type="text" name="quality_date" value="${drug.quality_date}"/>天</td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">详细描述</td>
        <td><textarea name="detail">${drug.detail }</textarea></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">生产厂商</td>
        <td><textarea name="manufacture">${drug.manufacture }</textarea></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">服用说明</td>
        <td><textarea  name="use_infor" >${drug.use_infor}</textarea></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">总的进货量</td>
        <td><input type="text" name="total_stock" value="${drug.total_stock }" /></td>
    </tr>
    <tr>
        <td width="10%" class="tableleft">剩余量</td>
        <td><input type="text" name="surplus" readonly="readonly" value="${drug.surplus }"/></td>
    </tr>
	<tr>
        <td width="10%" class="tableleft">备注</td>
        <td><textarea name="noted">${drug.noted}</textarea></td>
	</tr>
    <tr>
        <td colspan="2">
			<center>
				<button type="submit" class="btn btn-primary" type="button">保存</button> 
				&nbsp;&nbsp;
				<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
			</center>
		</td>
    </tr> 
</table>
</form>
</body>
</html>