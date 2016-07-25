<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>

<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson .header").click(function(){
		var $parent = $(this).parent();
		$(".menuson>li.active").not($parent).removeClass("active open").find('.sub-menus').hide();
		
		$parent.addClass("active");
		if(!!$(this).next('.sub-menus').size()){
			if($parent.hasClass("open")){
				$parent.removeClass("open").find('.sub-menus').hide();
			}else{
				$parent.addClass("open").find('.sub-menus').show();	
			}
			
			
		}
	});
	
	// 三级菜单点击
	$('.sub-menus li').click(function(e) {
        $(".sub-menus li.active").removeClass("active")
		$(this).addClass("active");
    });
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('.menuson').slideUp();
		if($ul.is(':visible')){
			$(this).next('.menuson').slideUp();
		}else{
			$(this).next('.menuson').slideDown();
		}
	});
})	
</script>

</head>
<body style="background:#f0f9fd;">
	<div class="lefttop"><span></span>任务流程</div>
    
    <dl class="leftmenu">
     
    <dd>
    <div class="title">
    <span><img src="images/leftico01.png" /></span>提交训练集
    </div>
    	<ul class="menuson">
        <li><cite></cite><a href="data_info.html" target="rightFrame">文件格式</a><i></i></li>
        <li><cite></cite><a href="upload_data.jsp" target="rightFrame">上传数据文件</a><i></i></li>
        <li><cite></cite><a href="upload_att.jsp" target="rightFrame">上传属性文件</a><i></i></li>
    </ul>     
    </dd> 
        
    
    <dd><div class="title">
    <span><img src="images/leftico02.png" /></span>数据分割</div>
    <ul class="menuson">
        <li><cite></cite><a href="split_info.html" target="rightFrame">参数详情</a><i></i></li>
        <li><cite></cite><a href="split_program.jsp" target="rightFrame">输入分片参数</a><i></i></li>
        <li><cite></cite><a href="split_list.jsp" target="rightFrame">分割片信息</a><i></i></li>
    </ul>     
    </dd> 
    
    
    <dd><div class="title"><span>
    <img src="images/leftico03.png" /></span>执行M/R任务</div>
    <ul class="menuson">
        <li><cite></cite><a href="hdfs.jsp" target="rightFrame">任务文件提交</a><i></i></li>
        <li><cite></cite><a href="mapreduce.jsp" target="rightFrame">运行Map/Reduce</a><i></i></li>
    </ul>    
    </dd> 
    
    
    <dd><div class="title"><span>
    <img src="images/leftico03.png" /></span>分类预测</div>
    <ul class="menuson">
        <li><cite></cite><a href="analysis_info.html" target="rightFrame">预测说明</a><i></i></li>
        <!--    <li><cite></cite><a href="class_1.html" target="rightFrame">单一样例预测</a><i></i></li>         -->
        <li><cite></cite><a href="upload_test.jsp" target="rightFrame">测试集预测分析</a><i></i></li>
    </ul>    
    </dd> 
    
    
    <dd><div class="title"><span>
    <img src="images/leftico03.png" /></span>Hadoop运行情况</div>
    <ul class="menuson">
        <li><cite></cite><a href="http://192.168.1.105:50070" target="rightFrame">集群概况</a><i></i></li>
        <li><cite></cite><a href="http://192.168.1.105:8088/cluster" target="rightFrame">Map/Reduce任务</a><i></i></li>
        <li><cite></cite><a href="http://192.168.1.105:50070/explorer.html#/user/hadoop" target="rightFrame">文件系统</a><i></i></li>
    </ul>    
    </dd> 

    
    <dd><div class="title"><span><img src="images/info.png" /></span><a href="support.jsp" target="rightFrame">技术支持</a></div></dd>  
    
    </dl>
    
</body>
</html>