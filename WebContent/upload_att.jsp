<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Att</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="default.html">首页</a></li>
    <li><a href="#">上传属性集</a></li>
    </ul>
    </div>
    
    <ul class="project">
   	  <div class="proleft">执行步骤</div>
   	  <li class="start"><span>&nbsp;</span><b>1</b>提交数据<i>&nbsp;</i></li>
   	  <li><span>&nbsp;</span><b>2</b>文件分割<i>&nbsp;</i></li>
      <li><span>&nbsp;</span><b>3</b>训练模型<i>&nbsp;</i></li>
      <li><span>&nbsp;</span><b>4</b>查看模型<i>&nbsp;</i></li>
      <li><span>&nbsp;</span><b>5</b>分类测试<i>&nbsp;</i></li>
      <li><span>&nbsp;</span><b>6</b>完成任务<i>&nbsp;</i></li>
   	</ul>    
    
    <div class="formbody">
    <div class="formtitle"><span>属性集</span></div>    
    <ul class="forminfo">
    <form action="UploadHandle?type=att" method="post" enctype="multipart/form-data">
    <li><label>属性名称</label><input name="" type="text" class="dfinput" value="TrainingAtt" /><i>应与上传的数据集合同名，且不能超过30个字符</i></li>
    <li><label>关键字</label><input name="" type="text" class="dfinput" /><i>多个关键字用,隔开</i></li>
    <li><label>数据来源</label><input name="" type="text" class="dfinput" value="http://www.uci.edu" /></li>
    <li><label>选择文件<b>*</b></label><input class="dfinput" type="file" name="file" size="50" /></li><br>
    <li><label>&nbsp;</label><input type="submit" name="UploadFile" id="UploadFile" class="btn" value="确认上传"/></li>
    </form>
    </ul>
    </div>
    <!-- 该段java代码用于反馈文件上传情况。 -->
    <%
		if(request.getAttribute("result")!=null){
			out.println("<script>alert('"+request.getAttribute("result")+"');</script>");
		} 
 	%>

</body>
</html>