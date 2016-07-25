<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Split</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="default.html">首页</a></li>
    <li><a href="#">训练数据分片</a></li>
    </ul>
    </div>
    
    <ul class="project">
   	  <div class="proleft">执行步骤</div>
   	  <li class="profinish"><span>&nbsp;</span><b>1</b>提交数据<i>&nbsp;</i></li>
   	  <li class="start"><span>&nbsp;</span><b>2</b>文件分割<i>&nbsp;</i></li>
      <li><span>&nbsp;</span><b>3</b>训练模型<i>&nbsp;</i></li>
      <li><span>&nbsp;</span><b>4</b>查看模型<i>&nbsp;</i></li>
      <li><span>&nbsp;</span><b>5</b>分类测试<i>&nbsp;</i></li>
      <li><span>&nbsp;</span><b>6</b>完成任务<i>&nbsp;</i></li>
   	</ul>    
    
    <div class="formbody">
    <div class="formtitle"><span>属性集</span></div>    
    <ul class="forminfo">
    <form action="SplitHandle" method="post">
	  <li><label>数据比例<b>*</b></label><input name="DataNum" type="text" class="dfinput" value="0.7"  onkeyup="value=value.replace(/[^0-9.]/g,'')"" /><i>训练每棵决策树时，选取的数据占原始数据集的比例</i></li>
	  <li><label>属性比例<b>*</b></label><input name="AttNum" type="text" class="dfinput" value="0.8" onkeyup="value=value.replace(/[^0-9.]/g,'')" /><i>训练每棵决策树时，选取的属性占原始属性集的比例</i></li>
	  <li><label>分片数<b>*</b></label><input name="TreeNum" type="text" class="dfinput" value="4"  onkeyup="value=value.replace(/[^\d]/g,'') " /><i>即随机森林中决策树的数量</i></li>
	  <li><label>&nbsp;</label><input type="submit" class="btn" value="确认提交"/></li>
    </form>
    </ul>
    </div>
</body>
</html>