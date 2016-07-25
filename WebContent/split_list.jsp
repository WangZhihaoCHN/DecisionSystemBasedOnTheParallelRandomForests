<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script language="javascript">
$(function(){	
	//导航切换
	$(".disklist li").click(function(){
		$(".disklist li.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>
</head>

<body>
    <%
	    Cookie[] cookies = request.getCookies();
		String treeNumString=null;
		for(int i=0;i<cookies.length;i++){
	        if(cookies[i].getName().equals("myDecisionSystem"))
	        	treeNumString = cookies[i].getValue();
    	}
		int treeNum = 0;
		if(treeNumString!=null)
			treeNum= Integer.parseInt(treeNumString);
		//out.print(treeNum);
    %>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index.jsp">首页</a></li>
    <li><a href="file_manager.jsp">文件管理</a></li>
    <li><a href="#">数据分片管理</a></li>
    </ul>
    </div>
    
    <div class="comtitle">
    <span><img src="images/clist.png" /></span>
    <h2>数据分片(<%=treeNum%>)</h2>
    <div class="rline"></div>
    </div>
    
    <ul class="disklist">
 	<%
	  for(int i=0;i<treeNum;i++){
		  out.print("<li><a href='DownloadHandle?type=data&count=" + i + "'>");
		  out.print("<div class='dlefttxt3'></div><div class='dright'><h3>");
	      out.print("data_"+i+".txt");
	      out.print("</h3><p>文本文档</p></div></a></li>");
	  }
	%>
	</ul>
	
	<div class="comtitle">
    <span><img src="images/clist.png" /></span>
    <h2>属性分片(<%=treeNum%>)</h2>
    <div class="rline"></div>
    </div>
    
    <ul class="disklist">
	<%
	  //显示分割片数量的数据文件图标
 	  for(int i=0;i<treeNum;i++){
 	  	  //添加相应下载的超链接
		  out.print("<li><a href='DownloadHandle?type=att&count=" + i + "'>");
		  out.print("<div class='dlefttxt3'></div><div class='dright'><h3>");
	      out.print("att_"+i+".txt");
	      out.print("</h3><p>文本文档</p></div></a></li>");
	  }
	%>
	</ul>
</body>
</html>