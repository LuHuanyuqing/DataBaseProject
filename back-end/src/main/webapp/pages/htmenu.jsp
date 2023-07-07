
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>菜单栏</title>
</head>
<body>
<c:if test="${sessionScope.shenfen == '管理员' }">
<body>
 <ul class="components" qw-c="menu"> 
  
    <li class="active" qw-c="menuitem"> <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false" qw-c="menuitematext">管理员管理</a> 
 <ul class="collapse" id="homeSubmenu" qw-c="menuitemselect"> 
  
   <li qw-c="menuitemselectitem"><a href="tianjiaadmin.action" qw-c="menuitemselectitema menuitemselectitematext">添加管理员</a></li> 
   <li qw-c="menuitemselectitem"><a href="adminguanli.action" qw-c="menuitemselectitema menuitemselectitematext">管理员管理</a></li>
 </ul> </li>

<li class="active" qw-c="menuitem"> <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false" qw-c="menuitematext">成员事件管理</a> 
 <ul class="collapse" id="homeSubmenu" qw-c="menuitemselect"> 
  
   <li qw-c="menuitemselectitem"><a href="tianjiataste.action" qw-c="menuitemselectitema menuitemselectitematext">添加成员事件</a></li> 
   <li qw-c="menuitemselectitem"><a href="tasteguanli.action" qw-c="menuitemselectitema menuitemselectitematext">成员事件管理</a></li>
 </ul> </li>

<li class="active" qw-c="menuitem"> <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false" qw-c="menuitematext">家族管理</a> 
 <ul class="collapse" id="homeSubmenu" qw-c="menuitemselect"> 
  
   <li qw-c="menuitemselectitem"><a href="tianjiafort.action" qw-c="menuitemselectitema menuitemselectitematext">添加家族</a></li> 
   <li qw-c="menuitemselectitem"><a href="fortguanli.action" qw-c="menuitemselectitema menuitemselectitematext">家族管理</a></li>
 </ul> </li>

<li class="active" qw-c="menuitem"> <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false" qw-c="menuitematext">家庭成员管理</a> 
 <ul class="collapse" id="homeSubmenu" qw-c="menuitemselect"> 
  
   <li qw-c="menuitemselectitem"><a href="tianjiawaterdrop.action" qw-c="menuitemselectitema menuitemselectitematext">添加家庭成员</a></li> 
   <li qw-c="menuitemselectitem"><a href="waterdropguanli.action" qw-c="menuitemselectitema menuitemselectitematext">家庭成员管理</a></li>
 </ul> </li>

 
   <li class="active" qw-c="menuitem"> <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false" qw-c="menuitematext">退出系统</a> 
    <ul class="collapse" id="homeSubmenu" qw-c="menuitemselect"> 
     <li qw-c="menuitemselectitem"><a href="tuichuxitong.action" qw-c="menuitemselectitema menuitemselectitematext">退出系统</a></li> 
    </ul> </li>
   
 </ul>
</body>
</c:if><c:if test="${sessionScope.shenfen == '家族' }">
<body>
 <ul class="components" qw-c="menu"> 
  
     
   <li class="active" qw-c="menuitem"> <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false" qw-c="menuitematext">退出系统</a> 
    <ul class="collapse" id="homeSubmenu" qw-c="menuitemselect"> 
     <li qw-c="menuitemselectitem"><a href="tuichuxitong.action" qw-c="menuitemselectitema menuitemselectitematext">退出系统</a></li> 
    </ul> </li>
   
 </ul>
</body>
</c:if>
</body>
</html>


