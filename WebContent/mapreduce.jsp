<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>M/P</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="place">
    	<span>位置：</span>
    	<ul class="placeul">
    	<li><a href="default.html">首页</a></li>
    	<li><a href="#">任务Map/Reduce执行</a></li>
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
    <div class="formtitle"><span>任务执行</span></div>    
    <ul class="forminfo">
      <li><label>&nbsp;</label><img src="images/hadoop.jpg" width="383" height="296" alt="Hadoop" /></li>
      <li><label><b>注意 ：</b></label></li>
      <li><label>&nbsp;</label>开始执行之前，请确定已经将分割好的文件上传至Hadoop！</li>
      <li></li>
      <form action="RunHadoopHandle?do=run" method="post">
      <li><label>&nbsp;</label><label>&nbsp;</label><input type="submit" name="mapreduce" id="mp" class="btn" value="开始执行"/></li>
      </form>
    </ul>
    </div>
</body>
</html>