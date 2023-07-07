
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
  <title>修改成员事件</title> 
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
     修改成员事件
    </div> 
    <div class="card-body"> 
     <form qw-c="operationform" action="xiugaitasteact.action" method="post" enctype="multipart/form-data">
      <input name='id' style='display:none;' value="${taste.id}"><div class="form-group" qw-c="formselectcomponent"> 
 <label qw-c="formselecttext">成员</label> 
  <!-- 定义成员下拉框 -->  

<select id='waterdrop' onchange="waterdropchange(this)"name="waterdrop" class="form-control" qw-c="formselect">  <!-- 使用c标签的if表达式判断waterdropall是否为空 -->  

<c:if test="${ !empty waterdropall}">

 <!-- 使用c标签的forEach表达式循环输出waterdropall -->  

							<c:forEach items="${ waterdropall}" var="item">

							

								<option value="${item.name }">${item.name }</option>

							</c:forEach>

				</c:if>

                                                	

                                                </select>

<script>

 <!-- 定义waterdropchange方法 -->  

                                                	function waterdropchange(select){

 <!-- 获取传入的select的选中项的项数， 将id为waterdropid的选中项改变为与其一致  -->  

                                           $("#waterdropid").val($("#waterdropid option:eq("+select.selectedIndex+")").val());                                                	}

                                                </script>
<script>
 <!-- 设置id为waterdrop的值为request中的taste.waterdrop  -->  

$("#waterdrop").val("${taste.waterdrop}")</script>
 
</div><div style='display:none;' class="form-group" qw-c="formselectcomponent"> 
 <label qw-c="formselecttext">成员id</label> 
  <!-- 定义成员id下拉框 -->  

<select id='waterdropid' onchange="waterdropchange(this)"name="waterdropid" class="form-control" qw-c="formselect">  <!-- 使用c标签的if表达式判断waterdropall是否为空 -->  

<c:if test="${ !empty waterdropall}">

 <!-- 使用c标签的forEach表达式循环输出waterdropall -->  

							<c:forEach items="${ waterdropall}" var="item">

							

								<option value="${item.id }">${item.id }</option>

							</c:forEach>

				</c:if>

                                                	

                                                </select>

<script>

 <!-- 定义waterdropchange方法 -->  

                                                	function waterdropchange(select){

 <!-- 获取传入的select的选中项的项数， 将id为waterdropid的选中项改变为与其一致  -->  

                                           $("#waterdropid").val($("#waterdropid option:eq("+select.selectedIndex+")").val());                                                	}

                                                </script>
<script>
 <!-- 设置id为waterdropid的值为request中的taste.waterdropid  -->  

$("#waterdropid").val("${taste.waterdropid}")</script>
 
</div><div class="form-group" qw-c="formtextareacomponent"> 
 <label for="textareaContent" qw-c="formtextareatext">内容</label> 
 <textarea name="content" class="form-control" rows="3" qw-c="formtextarea">${taste.content}</textarea> 
</div><div class="form-group" qw-c="formselectcomponent"> 
 <label qw-c="formselecttext">家族</label> 
  <!-- 定义家族下拉框 -->  

<select id='fort' onchange="fortchange(this)"name="fort" class="form-control" qw-c="formselect">  <!-- 使用c标签的if表达式判断fortall是否为空 -->  

<c:if test="${ !empty fortall}">

 <!-- 使用c标签的forEach表达式循环输出fortall -->  

							<c:forEach items="${ fortall}" var="item">

							

								<option value="${item.name }">${item.name }</option>

							</c:forEach>

				</c:if>

                                                	

                                                </select>

<script>

 <!-- 定义fortchange方法 -->  

                                                	function fortchange(select){

 <!-- 获取传入的select的选中项的项数， 将id为fortid的选中项改变为与其一致  -->  

                                           $("#fortid").val($("#fortid option:eq("+select.selectedIndex+")").val());                                                	}

                                                </script>
<script>
 <!-- 设置id为fort的值为request中的taste.fort  -->  

$("#fort").val("${taste.fort}")</script>
 
</div><div style='display:none;' class="form-group" qw-c="formselectcomponent"> 
 <label qw-c="formselecttext">家族id</label> 
  <!-- 定义家族id下拉框 -->  

<select id='fortid' onchange="fortchange(this)"name="fortid" class="form-control" qw-c="formselect">  <!-- 使用c标签的if表达式判断fortall是否为空 -->  

<c:if test="${ !empty fortall}">

 <!-- 使用c标签的forEach表达式循环输出fortall -->  

							<c:forEach items="${ fortall}" var="item">

							

								<option value="${item.id }">${item.id }</option>

							</c:forEach>

				</c:if>

                                                	

                                                </select>

<script>

 <!-- 定义fortchange方法 -->  

                                                	function fortchange(select){

 <!-- 获取传入的select的选中项的项数， 将id为fortid的选中项改变为与其一致  -->  

                                           $("#fortid").val($("#fortid option:eq("+select.selectedIndex+")").val());                                                	}

                                                </script>
<script>
 <!-- 设置id为fortid的值为request中的taste.fortid  -->  

$("#fortid").val("${taste.fortid}")</script>
 
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


