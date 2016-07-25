<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HDFS</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="place">
      <span>位置：</span>
      <ul class="placeul">
      	<li><a href="default.html">首页</a></li>
      	<li><a href="#">任务文件提交</a></li>
      </ul>
	</div>
    
    <ul class="project">
   	  <div class="proleft">执行步骤</div>
   	  <li class="profinish prover"><span>&nbsp;</span><b>1</b>提交数据<i>&nbsp;</i></li>
   	  <li class="profinish"><span>&nbsp;</span><b>2</b>文件分割<i>&nbsp;</i></li>
      <li class="start"><span>&nbsp;</span><b>3</b>训练模型<i>&nbsp;</i></li>
      <li><span>&nbsp;</span><b>4</b>查看模型<i>&nbsp;</i></li>
      <li><span>&nbsp;</span><b>5</b>分类测试<i>&nbsp;</i></li>
      <li><span>&nbsp;</span><b>6</b>完成任务<i>&nbsp;</i></li>
   	</ul> 
    
    <div class="formbody">
      <div class="formtitle"><span>任务文件提交</span></div>    
    	<ul class="forminfo">
    	<form action="RunHadoopHandle?do=copy" method="post">
    	<li><label>用户名<b>*</b></label><input name="" type="text" class="dfinput" value="hadoop" /><i>执行该任务的Hadoop用户名</i></li>
    	<li><label>数据目录</label><input name="" type="text" class="dfinput" value="data" /><i>所选用户下，用于存放数据的文件夹名称</i></li>
    	<li><label>属性目录</label><input name="" type="text" class="dfinput" value="att"/><i>所选用户下，用于存放属性的文件夹名称</i></li>    
   	 	<li><label>提交审核<b>*</b></label><cite><label><input name="sh" type="radio" value="ysh" checked="checked"/>是&nbsp;&nbsp;&nbsp;&nbsp;<input name="sh" type="radio" value="nsh" />否</label></cite></li>
    	<li><label>&nbsp;</label><br><input type="submit" name="hdfs" id="hdfs" class="btn" value="立即上传"/></li>
    	</form>
     	</ul>
      </div>
</body>
</html>