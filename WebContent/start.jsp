<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>并行决策系统</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>

<script language="javascript">
	$(function(){
    $('.loginbox0').css({'position':'absolute','left':($(window).width()-810)/2});
	$(window).resize(function(){  
    $('.loginbox0').css({'position':'absolute','left':($(window).width()-810)/2});
    })  
});  
</script> 

</head>
<body style="background-color:#1c77ac; background-image:url(images/light1.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">
  <div class="logintop">    
    <span>欢迎进入并行决策系统</span>    
    <ul>
    <li><a href="start.jsp">回首页</a></li>
    <li><a href="http://192.168.1.105:8080/introduction/index.html" target="_blank">帮助</a></li>
    <li><a href="http://192.168.1.105:8080/introduction/index.html#about" target="_blank">关于</a></li>
    </ul>    
  </div>
  <div class="loginbody1">
    <span class="systemlogo"></span> 
    <div class="loginbox0">
	    <ul class="loginlist">
	    <li><a href="http://192.168.1.105:8080/introduction/index.html" target="_blank"><img src="images/l01.png"  alt="介绍"/><p>系统介绍</p></a></li>
	    <li><a href="http://192.168.1.105:8080/introduction/index.html#about" target="_blank"><img src="images/l02.png"  alt="使用"/><p>使用方法</p></a></li>
	    <li><a href="login.jsp"><img src="images/l03.png"  alt="系统"/><p>决策系统</p></a></li>
	    <li><a href="http://192.168.1.105:8080/introduction/index.html#contact" target="_blank"><img src="images/l04.png"  alt="关于"/><p>关于我们</p></a></li>
	    </ul>
    </div>
  </div>
  <div class="loginbm">版权所有  2016&nbsp;&nbsp;&nbsp; <strong>王志昊</strong> &nbsp;&nbsp;&nbsp;西南交通大学信息学院本科毕业设计作品</div>
	
</html>