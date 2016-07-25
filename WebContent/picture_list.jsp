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
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="index.jsp">首页</a></li>
    <li><a href="file_manager.jsp">文件管理</a></li>
    <li><a href="#">训练集文件</a></li>
    </ul>
    </div>
    
    <div class="comtitle">
    <span><img src="images/clist.png" /></span>
    <h2>C4.5决策树(1)</h2>
    <div class="rline"></div>
    </div>
    
    <ul class="disklist">
    <li>
      <a href="DownloadHandle?type=picture">
    	<div class="dleftpicture"></div>       
    	<div class="dright">
    	<h3>tree.gif</h3>
    	<p>树结构</p> 
    	</div>
      </a>
    </li>
    
	</ul>
</body>
</html>