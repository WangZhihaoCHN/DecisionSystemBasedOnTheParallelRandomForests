<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>File</title>
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
    <li><a href="#">文件管理</a></li>
    </ul>
    </div>
    
    <div class="comtitle">
    <span><img src="images/clist.png" /></span>
    <h2>资料(6)</h2>
    <div class="rline"></div>
    </div>
    
    
    <ul class="disklist">
    
    <li>
    <a href="upload_list.jsp">
    <div class="dleft"></div>    
    <div class="dright">
    <h2>训练集</h2>
    <div class="dinfo"><span style="width:100px;"></span></div>
    <p>34 MB 空间,共 253 个文件</p>    
    </div>
    </a>
    </li>
    
    <li>
    <a href="split_list.jsp">
    <div class="dleft"></div>    
    <div class="dright">
    <h2>数据分隔片</h2>
    <div class="dinfo"><span style="width:38px;"></span></div>
    <p>500 MB 空间,共 12 个文件</p>    
    </div>
    </a>
    </li>
    
    <li>
    <a href="rule_list.jsp">
    <div class="dleft"></div>    
    <div class="dright">
    <h2>决策规则</h2>
    <div class="dinfo"><span style="width:38px;"></span></div>
    <p>500 MB 空间,共 12 个文件</p>    
    </div>
    </a>
    </li>
    
    <li>
    <a href="test_list.jsp">
    <div class="dleft"></div>    
    <div class="dright">
    <h2>测试集</h2>
    <div class="dinfo"><span style="width:38px;"></span></div>
    <p>500 MB 空间,共 12 个文件</p>    
    </div>
    </a>
    </li>
    
    <li>
    <a href="picture_list.jsp">
    <div class="dleft"></div>    
    <div class="dright">
    <h2>图片</h2>
    <div class="dinfo"><span style="width:50px;"></span></div>
    <p>120 MB 空间,共 5100 个文件</p>    
    </div>
    </a>
    </li> 
    
    <li>
    <a href="result_list.jsp">
    <div class="dleft1"></div>    
    <div class="dright">
    <h2>分类结果</h2>
    <div class="dinfo"><span style="width:38px;"></span></div>
    <p>500 MB 空间,共 12 个文件</p>    
    </div>
    </a>
    </li>   
    
    </ul>

</body>

</html>