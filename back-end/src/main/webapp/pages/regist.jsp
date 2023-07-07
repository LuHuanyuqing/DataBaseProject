
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
  <title>注册</title> 
  <!--<link href="css/bootstrap.min.css" rel="stylesheet">--> 
  <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"> 
  <link href="resource/houtai/css/config.css" rel="stylesheet"> 
  <script src="resource/houtai/js/jquery.min.js"></script> 
  <script src="resource/houtai/js/bootstrap.min.js"></script> 
  <link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css"> 
  <link href="resource/houtai/css/css.css" rel="stylesheet"> 
 </head> 
 <body> 
  <!-- 登录框 --> 
  <div class="container"> 
   <div class="row"> 
    <div class="col-md-4 col-md-offset-4 login-box"> 
     <h2 class="text-center" qw-c="operationname">注册</h2> 
     <form qw-c="form" action="registact.action" method="post"> 
      <div class="form-group"> 
       <label for="username">账号</label> 
       <input type="text" qw-c="username" name="username" class="form-control" id="username" placeholder="请输入用户名"> 
      </div> 
      <div class="form-group"> 
       <label for="password">密码</label> 
       <input type="password" qw-c="password" name="password" class="form-control" id="password" placeholder="请输入密码"> 
      </div> 

<div class="form-group" qw-c="passwordcomponent">  <label for="password">确认密码</label>  <input type="password" class="form-control" name="repassword" id="repassword" placeholder="请确认密码"> </div>
 
       
      <div class="form-group"> 
       <label for="identity">身份</label> 
       <select class="form-control" id="identity" qw-c="identity" name="shenfen"><option>家族</option></select> 
      </div> 
      <div class="form-group"> 
       <button type="submit" class="btn btn-block btn-lg" qw-c="operationbutton">注册</button> 
      </div> 
      <div class="text-center" qw-c="infotext">
       已有账号，点击<a href="login.action">登录</a>
      </div> 
     </form> 
    </div> 
   </div> 
  </div> 
  <!-- 背景图片 --> 
  <div class="background"> 
   <img src="https://via.placeholder.com/2000x1000" alt="背景图片"> 
  </div>  
  <script src="resource/houtai/js/js.js"></script>  
  <script>
  if("${message}"){
    alert("${message}");
  }
</script>
 </body>
</html>


