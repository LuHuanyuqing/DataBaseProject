
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!doctype html>
<html lang="en">
 <head> 
  <meta charset="UTF-8"> 
  <title>修改家庭成员</title> 
  <!--<link href="css/bootstrap.min.css" rel="stylesheet">--> 
  <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"> 
  <link href="resource/houtai/css/config.css" rel="stylesheet"> 
  <script src="resource/houtai/js/jquery.min.js"></script> 
  <script src="resource/houtai/js/bootstrap.min.js"></script> 
  <link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css"> 
  <link href="resource/houtai/css/css.css" rel="stylesheet"> 
 </head> 
 <body> 
  <!-- HTML代码开始 --> 
  <div id="sidebar"> 
   <div class="sidebar-header"> 
    <h3>后台管理</h3> 
   </div> 
   
    <c:import url="htmenu.jsp"></c:import>
    
  </div> 
  <div id="content"> 
   <div class="card"> 
    <div class="card-header" qw-c="operationname">
     修改家庭成员
    </div> 
    <div class="card-body"> 
     <form qw-c="operationform" action="fortxiugaiwaterdropact.action" method="post" enctype="multipart/form-data">
      <input name='id' style='display:none;' value="${waterdrop.id}"><div class="form-group" qw-c="forminputcomponent"> 
 <label qw-c="forminputtext">头像</label> 
  <!-- 定义头像文件选择框 -->  

<input type="file" name="imageefile" value="${waterdrop.imagee}" qw-c="forminput" class="form-control"> 
</div> <!-- 设置div display属性为none，将其隐藏 -->  

<div style='display:none;' class="form-group" qw-c="forminputcomponent"> 
 <label qw-c="forminputtext">家族</label> 
 <input value="${sessionScope.userinfo.name}" name="fort" qw-c="forminput" class="form-control"> 
</div> <!-- 设置div display属性为none，将其隐藏 -->  

<div style='display:none;' class="form-group" qw-c="forminputcomponent"> 
 <label qw-c="forminputtext">家族id</label> 
 <input value="${sessionScope.userinfo.id}" name="fortid" qw-c="forminput" class="form-control"> 
</div><div class="form-group" qw-c="forminputcomponent"> 
 <label qw-c="forminputtext">姓名</label> 
  <!-- 定义姓名输入框并赋值 -->  

<input name="name" value="${waterdrop.name}" qw-c="forminput" class="form-control"> 
</div><div class="form-group" qw-c="forminputcomponent"> 
 <label qw-c="forminputtext">性别</label> 
  <!-- 定义性别输入框并赋值 -->  

<input name="gender" value="${waterdrop.gender}" qw-c="forminput" class="form-control"> 
</div><div class="form-group" qw-c="forminputcomponent"> 
 <label qw-c="forminputtext">生日</label> 
  <!-- 定义生日时间输入框 -->  

<input type="date" name="birthday" value="${waterdrop.birthday}" qw-c="forminput" class="form-control"> 
</div><div class="form-group" qw-c="formselectcomponent"> 
 <label qw-c="formselecttext">父辈</label> 
  <!-- 定义父辈下拉框，并定义其onchange事件 -->  

<select id='father' onchange="waterdropchange(this)"name="father" class="form-control" qw-c="formselect">  <!-- 使用c标签的if表达式判断 waterdropall是否为空 -->  

<c:if test="${ !empty waterdropall}">

 <!-- 使用c标签的forEach表达式循环输入 waterdropall -->  

							<c:forEach items="${ waterdropall}" var="item">

							

								<option value="${item.name }">${item.name }</option>

							</c:forEach>

				</c:if>

                                                	

                                                </select>

<script>

 <!-- 定义waterdropchange方法 -->  

                                                	function waterdropchange(select){

 <!-- 将id为waterdropid的项数设置为select的选中项的项数 -->  

                                           $("#waterdropid").val($("#waterdropid option:eq("+select.selectedIndex+")").val());                                                	}

                                                </script>
<script>
 <!-- 将id为father值设置为request中的waterdrop.father -->  

$("#father").val("${waterdrop.father}")</script>
 
</div> <!-- 设置div的display为none，将其进行隐藏 -->  

<div style='display:none;' class="form-group" qw-c="formselectcomponent"> 
 <label qw-c="formselecttext">父辈id</label> 
  <!-- 定义父辈id下拉框，并定义其onchange事件 -->  

<select id='fatherid' onchange="waterdropchange(this)"name="fatherid" class="form-control" qw-c="formselect">  <!-- 使用c标签的if表达式判断 waterdropall是否为空 -->  

<c:if test="${ !empty waterdropall}">

 <!-- 使用c标签的forEach表达式循环输入 waterdropall -->  

							<c:forEach items="${ waterdropall}" var="item">

							

								<option value="${item.id }">${item.id }</option>

							</c:forEach>

				</c:if>

                                                	

                                                </select>

<script>

 <!-- 定义waterdropchange方法 -->  

                                                	function waterdropchange(select){

 <!-- 将id为waterdropid的项数设置为select的选中项的项数 -->  

                                           $("#waterdropid").val($("#waterdropid option:eq("+select.selectedIndex+")").val());                                                	}

                                                </script>
<script>
 <!-- 将id为fatherid值设置为request中的waterdrop.fatherid -->  

$("#fatherid").val("${waterdrop.fatherid}")</script>
 
</div>
       
       
       
      <button type="submit" class="btn btn-primary">修改</button>
     </form> 
    </div> 
   </div> 
  </div> 
  <!-- HTML代码结束 -->  
  <script src="resource/houtai/js/js.js"></script>  
  <script>
  if("${message}"){
    alert("${message}");
  }
</script>
 </body>
</html>


