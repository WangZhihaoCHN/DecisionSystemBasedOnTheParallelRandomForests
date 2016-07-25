<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Result</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">测试集</a></li>
    </ul>
    </div>   
    
	<ul class="project">
   	  <div class="proleft">执行步骤</div>
   	  <li class="profinish prover"><span>&nbsp;</span><b>1</b>提交数据<i>&nbsp;</i></li>
   	  <li class="profinish prover"><span>&nbsp;</span><b>2</b>文件分割<i>&nbsp;</i></li>
      <li class="profinish prover"><span>&nbsp;</span><b>3</b>训练模型<i>&nbsp;</i></li>
      <li class="profinish prover"><span>&nbsp;</span><b>4</b>查看模型<i>&nbsp;</i></li>
      <li class="profinish"><span>&nbsp;</span><b>5</b>分类测试<i>&nbsp;</i></li>
      <li class="start"><span>&nbsp;</span><b>6</b>完成任务<i>&nbsp;</i></li>
   	</ul>
    
<div class="formtitle"><span>测试结果</span></div>
    
    <div id="usual1" class="usual">
      <table width="80%" border="5">
      <tr>
        <th colspan="2" rowspan="2" bgcolor="#669999" scope="col">混淆矩阵</th>
        <th width="67%" height="69" bgcolor="#00CCFF" scope="col">预测分类</th>
      </tr>
      <tr>
        <th bgcolor="#00CCFF" scope="col"><table width="100%" height="61" border="1">
          <tr>
          	<%
          	//混淆矩阵的行名称 
          	String[] classValue = (String[])request.getAttribute("classValue");
          	for(int i=0;i<classValue.length;i++){
          		out.print("<td width='25%' align='center' valign='middle'>");
          		out.print(classValue[i]);
          		out.print("</td>"); 
          	}
          	%>
          </tr>
        </table></th>
      </tr>
      <tr>
        <th width="12%" bgcolor="#00CC66" scope="row">实际类</th>
        <th width="21%" scope="row"><table width="100%" height="244" border="1">
          <%
          	//混淆矩阵的列名称 
          	for(int i=0;i<classValue.length;i++){
          		out.print("<tr><td align='center' valign='middle' bgcolor='#00CC66'>");
          		out.print("<td align='center' valign='middle' bgcolor='#00CC66'>");
          		out.print(classValue[i]);
          		out.print("</td></tr>"); 
          	}
          %>
        </table></th>
        <td align="center" valign="middle"><table width="100%" height="237" border="1">
          <%
          //用于在表格中打印混淆矩阵 
          int[][] matrix = (int[][])request.getAttribute("matrix");
          for(int i=0;i<matrix.length;i++){
          	out.print("<tr>"); 
          	for(int j=0;j<matrix[i].length;j++){
          		out.print("<td width='25%' align='center' valign='middle' bgcolor='#FFFFCC'>"); 
          		out.print(matrix[i][j]);
          		out.print("</td>"); 
          	}
          	out.print("<tr>"); 
          }
          %>
        </table></td>
      </tr>
	</table>
</div>   
</body>
</html>