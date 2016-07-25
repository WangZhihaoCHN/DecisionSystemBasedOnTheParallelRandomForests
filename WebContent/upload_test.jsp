<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test Data</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="place">
      <span>位置：</span>
      <ul class="placeul">
      	<li><a href="default.html">首页</a></li>
      	<li><a href="#">上传测试集</a></li>
      </ul>
    </div>
    
    <ul class="project">
   	  <div class="proleft">执行步骤</div>
   	  <li class="profinish prover"><span>&nbsp;</span><b>1</b>提交数据<i>&nbsp;</i></li>
   	  <li class="profinish prover"><span>&nbsp;</span><b>2</b>文件分割<i>&nbsp;</i></li>
      <li class="profinish prover"><span>&nbsp;</span><b>3</b>训练模型<i>&nbsp;</i></li>
      <li class="profinish"><span>&nbsp;</span><b>4</b>查看模型<i>&nbsp;</i></li>
      <li class="start"><span>&nbsp;</span><b>5</b>分类测试<i>&nbsp;</i></li>
      <li><span>&nbsp;</span><b>6</b>完成任务<i>&nbsp;</i></li>
   	</ul> 
    
    <div class="formbody">
      <div class="formtitle"><span>数据集</span></div>    
    	<ul class="forminfo">
    	<form action="UploadHandle?type=test" method="post" enctype="multipart/form-data">
    	<li><label>测试集名称</label><input name="" type="text" class="dfinput" value="TestData" /><i>标题不能超过30个字符</i></li>
    	<li><label>关键字</label><input name="" type="text" class="dfinput" /><i>多个关键字用,隔开</i></li> 
    	<li><label>数据来源</label><input name="" type="text" class="dfinput" value="http://www.uci.edu" /></li>
    	<li><label>选择文件<b>*</b></label><input class="dfinput" type="file" name="file" size="50" /></li><br>
    	<li><label>&nbsp;</label><input type="submit"  class="btn" value="确认上传"/></li>
    	</form>
     	</ul>
      </div>

</body>
</html>