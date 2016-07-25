<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎使用</title>
</head>
<body>
	<center>
		<h1>登陆成功，欢迎你！</h1>
	</center>
	<p style="text-align:right;">
		<a href="Login.jsp">注销</a>
	</p>
	<hr><hr>
	
	<form action="FileHandle" method="post" enctype="multipart/form-data">
		<h2>数据文件：</h2>
		<%
			String s1=(String)request.getAttribute("show");
			if(s1!=null){
				out.print("<font color=\"red\">"+s1+"</font><br/>");
			}
		%>
		选择一个您需要上传的文件：<br/>
		<input type="file" name="file" size="50"/><br/><br/>
		<input type="submit" value="上传"/><br/><br/>
	</form>
	<form action="AttrHanle" method="post">
		<h2>属性：</h2>
		请按照数据文件的顺序依次输入属性，以空格作为分隔 <br/>
		<input type="text" name="attr" style="width: 712px; "/><br/><br/>
		请输入其中为连续性取值的属性，以空格作为分隔：<br/>	
		<input type="text" name="isCon" style="width: 360px; "/><br><br/>
		连续性取值的数据类型为：<br/>
		<label><input name="data" value="Dint" type="radio"/>整数</label> 
    	<label><input name="data" value="Ddouble" type="radio"/>浮点数</label>
    	<br><br/>
    	<% 
			String Path=(String)request.getAttribute("fPath");
			if(Path!=null)
				out.print("");
    	%>
    	<input type="hidden" name="tPath" value=<%=Path%>>
    	<input type="submit" value="确认">
		<input type="reset" value="重置">
	</form>
</body>
</html>