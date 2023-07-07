
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
  <title>添加家庭成员</title> 
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
     添加家庭成员
    </div> 
    <div class="card-body"> 
     <form qw-c="operationform" action="tianjiawaterdropact.action" method="post" enctype="multipart/form-data">
      <div class="form-group" qw-c="forminputcomponent"> 
 <label qw-c="forminputtext">头像</label> 
  <!-- 定义头像文件选择框  -->  

<input type="file" name="imageefile" qw-c="forminput" class="form-control"> 
</div><div class="form-group" qw-c="formselectcomponent"> 
 <label qw-c="formselecttext">家族</label> 
  <!-- 定义fort下拉框 并定义其onchange方法fortchange(this)" -->  

<select id='fort' onchange="fortchange(this)"name="fort" class="form-control" qw-c="formselect">  <!-- 用c标签的if表达式判断fortall是否为空  -->  

<c:if test="${ !empty fortall}">

 <!-- 用c标签的forEach循环展示 request中的fortall  -->  

							<c:forEach items="${ fortall}" var="item">

							

								<option value="${item.name }">${item.name }</option>

							</c:forEach>

				</c:if>

                                                	

                                                </select>

<script>

 <!-- 定义fortchange方法  -->  

                                                	function fortchange(select){

 <!-- 将fortid"的被选中项数设置为与传入的select.selectedIndex相同  -->  

                                           $("#fortid").val($("#fortid option:eq("+select.selectedIndex+")").val());                                                	}

 <!-- 定义GetQueryString方法获取参数栏中的参数值  -->  

										function GetQueryString(name) { 

											　　　var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)","i");

											     var r = window.location.search.substr(1).match(reg); 

											　　　if (r!=null) return (r[2]); 

											　　　return null; 

											} 

                                                                                           	

 <!-- 若地址栏中存在fortid时获取地址栏中的fortid值  -->  

                                            var fortid = GetQueryString("fortid"); 

 <!-- 判断fortid是否为null  -->  

											if(fortid!=null) { 

 <!-- 将id为fortid的值设置为参数栏中fortid的值  -->  

											　　$("#fortid").val(fortid);

 <!-- 获取id为fortid的select保存为sel变量  -->  

												var sel=document.getElementById("fortid"); 

 <!-- 获取sel的当前的选中值  -->  

												var fortidselectedindex = sel.selectedIndex;

 <!-- 将fort的选中项数设置为sel.selectedIndex的值  -->  

											   $("#fort").val($("#fort option:eq("+fortidselectedindex+")").val());

											}                                                         </script> 
</div> <!-- 设置display为none,设置为不可见 -->  

<div style='display:none;' class="form-group" qw-c="formselectcomponent"> 
 <label qw-c="formselecttext">家族id</label> 
  <!-- 定义fortid下拉框 并定义其onchange方法fortchange(this)" -->  

<select id='fortid' onchange="fortchange(this)"name="fortid" class="form-control" qw-c="formselect">  <!-- 用c标签的if表达式判断fortall是否为空  -->  

<c:if test="${ !empty fortall}">

 <!-- 用c标签的forEach循环展示 request中的fortall  -->  

							<c:forEach items="${ fortall}" var="item">

							

								<option value="${item.id }">${item.id }</option>

							</c:forEach>

				</c:if>

                                                	

                                                </select>

<script>

 <!-- 定义fortchange方法  -->  

                                                	function fortchange(select){

 <!-- 将fortid"的被选中项数设置为与传入的select.selectedIndex相同  -->  

                                           $("#fortid").val($("#fortid option:eq("+select.selectedIndex+")").val());                                                	}

 <!-- 定义GetQueryString方法获取参数栏中的参数值  -->  

										function GetQueryString(name) { 

											　　　var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)","i");

											     var r = window.location.search.substr(1).match(reg); 

											　　　if (r!=null) return (r[2]); 

											　　　return null; 

											} 

                                                                                           	

 <!-- 若地址栏中存在fortid时获取地址栏中的fortid值  -->  

                                            var fortid = GetQueryString("fortid"); 

 <!-- 判断fortid是否为null  -->  

											if(fortid!=null) { 

 <!-- 将id为fortid的值设置为参数栏中fortid的值  -->  

											　　$("#fortid").val(fortid);

 <!-- 获取id为fortid的select保存为sel变量  -->  

												var sel=document.getElementById("fortid"); 

 <!-- 获取sel的当前的选中值  -->  

												var fortidselectedindex = sel.selectedIndex;

 <!-- 将fort的选中项数设置为sel.selectedIndex的值  -->  

											   $("#fort").val($("#fort option:eq("+fortidselectedindex+")").val());

											}                                                         </script> 
</div><div class="form-group" qw-c="forminputcomponent"> 
 <label qw-c="forminputtext">姓名</label> 
  <!-- 定义 姓名输入框 -->  

<input name="name" qw-c="forminput" class="form-control"> 
</div><div class="form-group" qw-c="forminputcomponent"> 
 <label qw-c="forminputtext">性别</label> 
  <!-- 定义 性别输入框 -->  

<input name="gender" qw-c="forminput" class="form-control"> 
</div><div class="form-group" qw-c="forminputcomponent"> 
 <label qw-c="forminputtext">生日</label> 
  <!-- 定义生日时间选择框  -->  

<input type="date" name="birthday" qw-c="forminput" class="form-control"> 
</div><div class="form-group" qw-c="formselectcomponent"> 
 <label qw-c="formselecttext">父辈</label> 
  <!-- 定义father下拉框 并定义其onchange方法waterdropchange(this)" -->  

<select id='father' onchange="waterdropchange(this)"name="father" class="form-control" qw-c="formselect">  <!-- 用c标签的if表达式判断waterdropall是否为空  -->  

<c:if test="${ !empty waterdropall}">

 <!-- 用c标签的forEach循环展示 request中的waterdropall  -->  

							<c:forEach items="${ waterdropall}" var="item">

							

								<option value="${item.name }">${item.name }</option>

							</c:forEach>

				</c:if>

                                                	

                                                </select>

<script>

 <!-- 定义waterdropchange方法  -->  

                                                	function waterdropchange(select){

 <!-- 将waterdropid"的被选中项数设置为与传入的select.selectedIndex相同  -->  

                                           $("#waterdropid").val($("#waterdropid option:eq("+select.selectedIndex+")").val());                                                	}

 <!-- 定义GetQueryString方法获取参数栏中的参数值  -->  

										function GetQueryString(name) { 

											　　　var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)","i");

											     var r = window.location.search.substr(1).match(reg); 

											　　　if (r!=null) return (r[2]); 

											　　　return null; 

											} 

                                                                                           	

 <!-- 若地址栏中存在waterdropid时获取地址栏中的waterdropid值  -->  

                                            var waterdropid = GetQueryString("waterdropid"); 

 <!-- 判断waterdropid是否为null  -->  

											if(waterdropid!=null) { 

 <!-- 将id为waterdropid的值设置为参数栏中waterdropid的值  -->  

											　　$("#waterdropid").val(waterdropid);

 <!-- 获取id为waterdropid的select保存为sel变量  -->  

												var sel=document.getElementById("waterdropid"); 

 <!-- 获取sel的当前的选中值  -->  

												var waterdropidselectedindex = sel.selectedIndex;

 <!-- 将waterdrop的选中项数设置为sel.selectedIndex的值  -->  

											   $("#waterdrop").val($("#waterdrop option:eq("+waterdropidselectedindex+")").val());

											}                                                         </script> 
</div> <!-- 设置display为none,设置为不可见 -->  

<div style='display:none;' class="form-group" qw-c="formselectcomponent"> 
 <label qw-c="formselecttext">父辈id</label> 
  <!-- 定义fatherid下拉框 并定义其onchange方法waterdropchange(this)" -->  

<select id='fatherid' onchange="waterdropchange(this)"name="fatherid" class="form-control" qw-c="formselect">  <!-- 用c标签的if表达式判断waterdropall是否为空  -->  

<c:if test="${ !empty waterdropall}">

 <!-- 用c标签的forEach循环展示 request中的waterdropall  -->  

							<c:forEach items="${ waterdropall}" var="item">

							

								<option value="${item.id }">${item.id }</option>

							</c:forEach>

				</c:if>

                                                	

                                                </select>

<script>

 <!-- 定义waterdropchange方法  -->  

                                                	function waterdropchange(select){

 <!-- 将waterdropid"的被选中项数设置为与传入的select.selectedIndex相同  -->  

                                           $("#waterdropid").val($("#waterdropid option:eq("+select.selectedIndex+")").val());                                                	}

 <!-- 定义GetQueryString方法获取参数栏中的参数值  -->  

										function GetQueryString(name) { 

											　　　var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)","i");

											     var r = window.location.search.substr(1).match(reg); 

											　　　if (r!=null) return (r[2]); 

											　　　return null; 

											} 

                                                                                           	

 <!-- 若地址栏中存在waterdropid时获取地址栏中的waterdropid值  -->  

                                            var waterdropid = GetQueryString("waterdropid"); 

 <!-- 判断waterdropid是否为null  -->  

											if(waterdropid!=null) { 

 <!-- 将id为waterdropid的值设置为参数栏中waterdropid的值  -->  

											　　$("#waterdropid").val(waterdropid);

 <!-- 获取id为waterdropid的select保存为sel变量  -->  

												var sel=document.getElementById("waterdropid"); 

 <!-- 获取sel的当前的选中值  -->  

												var waterdropidselectedindex = sel.selectedIndex;

 <!-- 将waterdrop的选中项数设置为sel.selectedIndex的值  -->  

											   $("#waterdrop").val($("#waterdrop option:eq("+waterdropidselectedindex+")").val());

											}                                                         </script> 
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


