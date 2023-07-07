
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
  <title>添加家族</title> 
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
     添加家族
    </div> 
    <div class="card-body"> 
     <form qw-c="operationform" action="tianjiafortact.action" method="post" enctype="multipart/form-data">
      <div class="form-group" qw-c="forminputcomponent"> 
 <label qw-c="forminputtext">名称</label> 
  <!-- 定义 名称输入框 -->  

<input name="name" qw-c="forminput" class="form-control"> 
</div><div class="form-group" qw-c="forminputcomponent"> 
 <label qw-c="forminputtext">账号</label> 
  <!-- 定义 账号输入框 -->  

<input name="username" qw-c="forminput" class="form-control"> 
</div><div class="form-group" qw-c="forminputcomponent"> 
 <label qw-c="forminputtext">密码</label> 
  <!-- 定义 密码输入框 -->  

<input name="password" qw-c="forminput" class="form-control"> 
</div><div class="form-group" qw-c="formtextareacomponent"> 
 <label for="textareaContent" qw-c="formtextareatext">描述</label> 
  <!-- 定义描述本文输入框  -->  

<textarea name="infoo" class="form-control" rows="3" qw-c="formtextarea"></textarea> 
</div>
       
       
       
      <button type="submit" class="btn btn-primary">添加</button>
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


