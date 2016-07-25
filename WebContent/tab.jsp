<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<link href="css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="js/select-ui.min.js"></script>
<script type="text/javascript" src="editor/kindeditor.js"></script>

<script type="text/javascript">
    KE.show({
        id : 'content7',
        cssPath : './index.css'
    });
  </script>
  
<script type="text/javascript">
$(document).ready(function(e) {
    $(".select1").uedSelect({
		width : 345			  
	});
	$(".select2").uedSelect({
		width : 167  
	});
	$(".select3").uedSelect({
		width : 100
	});
});
</script>
</head>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="default">首页</a></li>
    <li><a href="#">系统设置</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    
    <div id="usual1" class="usual"> 
    
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">发布通知</a></li> 
    <li><a href="#tab2">自定义</a></li> 
  	</ul>
    </div> 
    
  	<div id="tab1" class="tabson">
    
    <div class="formtext">Hi，<b>admin</b>，欢迎您试用信息发布功能！</div>
    
    <ul class="forminfo">
    <li><label>所属企业<b>*</b></label><input name="" type="text" class="dfinput" value="请填写提出该需求的单位名称"  style="width:518px;"/></li>
   
    <li><label>设计方向<b>*</b></label>  
    

    <div class="vocation">
    <select class="select1">
    <option>词频统计</option>
    <option>PageRank排名</option>
    <option>文献分析</option>
    <option>K-Means聚类算法</option>
    <option>朴素贝叶斯分类算法</option>
    <option>频繁项集挖掘算法</option>
    <option>隐马尔科夫模型</option>
    <option>基因序列化</option>
    <option>路径规划</option>
    </select>
    </div>
    
    </li>
    
    <li><label>招募金额<b>*</b></label>
    
    <div class="vocation">
    <select class="select1">
    <option>3000-5000</option>
    <option>5000-8000</option>
    <option>8000-10000</option>
    <option>10000-15000</option>
    </select>
    </div>
    
    
    
    </li>
    <li><label>工作地点<b>*</b></label>
    
    <div class="usercity">
    
    <div class="cityleft">
    <select class="select2">
    <option>四川</option>
    <option>山东</option>
    <option>上海</option>
    <option>北京</option>
    <option>广东</option>
    </select>
    </div>
    
    <div class="cityright">
    <select class="select2">
    <option>成都</option>
    <option>宜宾</option>
    <option>绵阳</option>
    <option>乐山</option>
    <option>峨眉</option>
    </select>
    </div>
    
    </div>
    
    
    
    </li>
    <li><label>通知内容<b>*</b></label>
    

    <textarea id="content7" name="content" style="width:700px;height:250px;visibility:hidden;"></textarea>
    
    </li>
    <li><label>&nbsp;</label><input name="" type="button" class="btn" value="马上发布"/></li>
    </ul>
    
    </div> 
    
    
  	<div id="tab2" class="tabson">
    
    
    <ul class="seachform">
    
    <li><label>综合查询</label><input name="" type="text" class="scinput" /></li>
    <li><label>设计方向</label>  
    <div class="vocation">
    <select class="select3">
    <option>全部</option>
    <option>其他</option>
    </select>
    </div>
    </li>
    
    <li><label>薪资</label>  
    <div class="vocation">
    <select class="select3">
    <option>全部</option>
    <option>其他</option>
    </select>
    </div>
    </li>
    
    <li><label>需求状态</label>  
    <div class="vocation">
    <select class="select3">
    <option>全部</option>
    <option>其他</option>
    </select>
    </div>
    </li>
    
    <li><label>&nbsp;</label><input name="" type="button" class="scbtn" value="查询"/></li>
    
    </ul>
    
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th><input name="" type="checkbox" value="" checked="checked"/></th>
        <th>编号<i class="sort"><img src="images/px.gif" /></i></th>
        <th>所属公司</th>
        <th>用户</th>
        <th>工作地</th>
        <th>发布时间</th>
        <th>是否审核</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
        
        <tr>
        <td><input name="" type="checkbox" value="" /></td>
        <td>2016042001</td>
        <td>西南交通大学信息学院</td>
        <td>admin</td>
        <td>四川成都</td>
        <td>2016-04-20 14:02</td>
        <td>已审核</td>
        <td><a href="#" class="tablelink">查看</a>     <a href="#" class="tablelink">删除</a></td>
        </tr>
        
        <tr>
        <td><input name="" type="checkbox" value="" /></td>
        <td>2016041901</td>
        <td>江苏南京A公司</td>
        <td>admin</td>
        <td>江苏南京</td>
        <td>2016-04-19 15:05</td>
        <td>未审核</td>
        <td><a href="#" class="tablelink">查看</a>     <a href="#" class="tablelink"> 删除</a></td>
        </tr> 
        
        <tr>
        <td><input name="" type="checkbox" value="" /></td>
        <td>2016041801</td>
        <td>中国社科院</td>
        <td>user</td>
        <td>江苏无锡</td>
        <td>2016-04-18 13:16</td>
        <td>未审核</td>
        <td><a href="#" class="tablelink">查看</a>     <a href="#" class="tablelink">删除</a></td>
        </tr>
        
        <tr>
        <td><input name="" type="checkbox" value="" /></td>
        <td>2016041402</td>
        <td>北京铁路局</td>
        <td>admin</td>
        <td>北京</td>
        <td>2016-04-14 10:36</td>
        <td>已审核</td>
        <td><a href="#" class="tablelink">查看</a>     <a href="#" class="tablelink">删除</a></td>
        </tr>
        
        <tr>
        <td><input name="" type="checkbox" value="" /></td>
        <td>2016041401</td>
        <td>广州地铁</td>
        <td>uimaker</td>
        <td>广东广州</td>
        <td>2016-04-14 14:02</td>
        <td>未审核</td>
        <td><a href="#" class="tablelink">查看</a>     <a href="#" class="tablelink">删除</a></td>
        </tr>
    
        </tbody>
    </table>
    
   
  
    
    </div>  
       
	</div> 
 
	<script type="text/javascript"> 
      $("#usual1 ul").idTabs(); 
    </script>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
    
    
    
    
    
    </div>
</body>
</html>