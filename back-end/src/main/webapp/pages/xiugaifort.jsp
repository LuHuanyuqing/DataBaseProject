
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
  <title>修改家族</title> 
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
     修改家族
    </div> 
    <div class="card-body"> 
     <form qw-c="operationform" action="xiugaifortact.action" method="post" enctype="multipart/form-data">
      <input name='id' style='display:none;' value="${fort.id}"><div class="form-group" qw-c="forminputcomponent"> 
 <label qw-c="forminputtext">名称</label> 
  <!-- 定义名称input输入框，并从request中取值fort.name赋值  -->  

<input name="name" value="${fort.name}" qw-c="forminput" class="form-control"> 
</div><div class="form-group" qw-c="forminputcomponent"> 
 <label qw-c="forminputtext">账号</label> 
  <!-- 定义username的输入框，并设置其为只读  -->  

<input readonly name="username" value="${fort.username}" qw-c="forminput" class="form-control"> 
</div><div class="form-group" qw-c="forminputcomponent"> 
 <label qw-c="forminputtext">密码</label> 
  <!-- 定义密码input输入框，并从request中取值fort.password赋值  -->  

<input name="password" value="${fort.password}" qw-c="forminput" class="form-control"> 
</div><div class="form-group" qw-c="formtextareacomponent"> 
 <label for="textareaContent" qw-c="formtextareatext">描述</label> 
 <textarea name="infoo" class="form-control" rows="3" qw-c="formtextarea">${fort.infoo}</textarea> 
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


