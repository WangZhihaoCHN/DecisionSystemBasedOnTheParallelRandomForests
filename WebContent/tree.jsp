<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tree</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="place">
      <span>位置：</span>
      <ul class="placeul">
      	<li><a href="default.html">首页</a></li>
      	<li><a href="#">决策树算法</a></li>
      </ul>
    </div>
    <%
    	String attRes=(String)request.getAttribute("attRes");
    	String dataRes=(String)request.getAttribute("dataRes");
    %>
    <div class="formbody">
      <div class="formtitle"><span>传统串行C4.5决策树</span></div>
      <div class="formtext">Hi，<b>admin</b>，欢迎使用C4.5决策树算法相关功能！</div>
    	<ul class="forminfo">
    	<form action="TreeHandle?type=att" method="post" enctype="multipart/form-data">
    	<li><label>属性集<b>*</b></label><input class="dfinput" type="file" name="file" size="50" />&nbsp;
    		<input type="submit" name="UploadFile" id="UploadFile" class="btn" value="确定"/>
    		<%
    			if(attRes!=null){
    				out.print("<i>"+attRes+"</i>");
    			}
    		%>
    	</li>
    	</form>
    	<form action="TreeHandle?type=data" method="post" enctype="multipart/form-data">
    	<li><label>数据集<b>*</b></label><input class="dfinput" type="file" name="file" size="50" />&nbsp;
    		<input type="submit" name="UploadFile" id="UploadFile" class="btn" value="确定"/>
    		<%
    			if(dataRes!=null){
    				out.print("<i>"+dataRes+"</i>");
    			}
    		%>
    	</li>
    	</form>
    	<li>&nbsp;</li>
    	<form action="DrawTreeHandle" method="post">
    	<li><label>&nbsp;</label><input type="submit" name="RunTree" id="RunTree" class="btn" value="开始训练决策树"/></li>
     	</form>
     	</ul>
      </div>
      
      
		<%
			String picture = request.getParameter("picture");
			if(picture!=null && picture.equals("yes")){
				out.print("<ul class='forminfo'>");
				out.print("<li><label>&nbsp;</label><label>&nbsp;</label></li>");
				out.print("<li><label>&nbsp;</label><b>注：下图即为决策树生成的属性规则</b>");
				out.print(" <li><label>&nbsp;</label><label>&nbsp;</label></li>");
				out.print("<li><label>&nbsp;</label><img src='images/tree.gif' width='383' height='296' alt='C45' /></li>");
				out.print("<li></li></ul>");
			}
		%>
    </div>
</body>
</html>