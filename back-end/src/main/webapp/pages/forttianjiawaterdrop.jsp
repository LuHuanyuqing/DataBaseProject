
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
     <form qw-c="operationform" action="forttianjiawaterdropact.action" method="post" enctype="multipart/form-data">
      <div class="form-group" qw-c="forminputcomponent"> 
 <label qw-c="forminputtext">头像</label> 
 <!-- 定义imagee的文件选择框，并设置name为imageefile-->

<input type="file" name="imageefile" qw-c="forminput" class="form-control"> 
</div><div style='display:none;' class="form-group" qw-c="forminputcomponent"> 
 <label qw-c="forminputtext">家族</label> 
 <!-- 使用el表达式给fort复制，将session中的fort赋值到input中-->

<input value="${sessionScope.userinfo.name}" name="fort" qw-c="forminput" class="form-control"> 
</div><div style='display:none;' class="form-group" qw-c="forminputcomponent"> 
 <label qw-c="forminputtext">家族id</label> 
 <!-- 使用el表达式给fortid复制，将session中的fortid赋值到input中-->

<input value="${sessionScope.userinfo.id}" name="fortid" qw-c="forminput" class="form-control"> 
</div><div class="form-group" qw-c="forminputcomponent"> 
 <label qw-c="forminputtext">姓名</label> 
 <!-- 定义name输入框 -->

<input name="name" qw-c="forminput" class="form-control"> 
</div><div class="form-group" qw-c="forminputcomponent"> 
 <label qw-c="forminputtext">性别</label> 
 <!-- 定义gender输入框 -->

<input name="gender" qw-c="forminput" class="form-control"> 
</div><div class="form-group" qw-c="forminputcomponent"> 
 <label qw-c="forminputtext">生日</label> 
 <!-- 定义birthday时间选择框-->

<input type="date" name="birthday" qw-c="forminput" class="form-control"> 
</div><div class="form-group" qw-c="formselectcomponent"> 
 <label qw-c="formselecttext">父辈</label> 
 <!--  定义 father-->

<select id='father' onchange="waterdropchange(this)"name="father" class="form-control" qw-c="formselect"> <!-- 使用c标签的if表达式判断waterdropall是否为空 -->

<c:if test="${ !empty waterdropall}">

<!-- 使用c标签的forEach表达式循环waterdropall并将其name字段进行展示 -->

							<c:forEach items="${ waterdropall}" var="item">

							

								<option value="${item.name }">${item.name }</option>

							</c:forEach>

				</c:if>

                                                	

                                                </select>

<script>

// 定义waterdropchange方法，当waterdrop改变时执行 

                                                	function waterdropchange(select){

<!-- 将waterdropid"的值改变为与 waterdrop项数相同的值，即waterdrop为第一项则waterdropid为第一项-->

                                           $("#waterdropid").val($("#waterdropid option:eq("+select.selectedIndex+")").val());                                                	}

<!-- 定义GetQueryString方法，该方法目的为获取地址栏中的参数 -->

										function GetQueryString(name) { 

											　　　var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)","i");

											     var r = window.location.search.substr(1).match(reg); 

											　　　if (r!=null) return (r[2]); 

											　　　return null; 

											} 

                                                                                           	

<!-- 若地址栏中存在waterdropid，使用GetQueryString方法获取该值 -->

                                            var waterdropid = GetQueryString("waterdropid"); 

<!-- 如果waterdropid不等于null -->

											if(waterdropid!=null) { 

<!-- 将地址栏中的 waterdropid值赋值给id为waterdropid的项-->

											　　$("#waterdropid").val(waterdropid);

<!-- 获取到id为waterdropid的项-->

												var sel=document.getElementById("waterdropid"); 

<!-- 获取到sel当前的选择项-->

												var waterdropidselectedindex = sel.selectedIndex;

<!-- 将id为waterdrop赋值为与waterdropid相同的项数的值，即当前waterdropid项目为第一项时，waterdrop项为第一项 -->

											   $("#waterdrop").val($("#waterdrop option:eq("+waterdropidselectedindex+")").val());

											}                                                         </script> 
</div><div style='display:none;' class="form-group" qw-c="formselectcomponent"> 
 <label qw-c="formselecttext">父辈id</label> 
 <!--  定义 fatherid-->

<select id='fatherid' onchange="waterdropchange(this)"name="fatherid" class="form-control" qw-c="formselect"> <!-- 使用c标签的if表达式判断waterdropall是否为空 -->

<c:if test="${ !empty waterdropall}">

<!-- 使用c标签的forEach表达式循环waterdropall并将其id字段进行展示 -->

							<c:forEach items="${ waterdropall}" var="item">

							

								<option value="${item.id }">${item.id }</option>

							</c:forEach>

				</c:if>

                                                	

                                                </select>

<script>

// 定义waterdropchange方法，当waterdrop改变时执行 

                                                	function waterdropchange(select){

<!-- 将waterdropid"的值改变为与 waterdrop项数相同的值，即waterdrop为第一项则waterdropid为第一项-->

                                           $("#waterdropid").val($("#waterdropid option:eq("+select.selectedIndex+")").val());                                                	}

<!-- 定义GetQueryString方法，该方法目的为获取地址栏中的参数 -->

										function GetQueryString(name) { 

											　　　var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)","i");

											     var r = window.location.search.substr(1).match(reg); 

											　　　if (r!=null) return (r[2]); 

											　　　return null; 

											} 

                                                                                           	

<!-- 若地址栏中存在waterdropid，使用GetQueryString方法获取该值 -->

                                            var waterdropid = GetQueryString("waterdropid"); 

<!-- 如果waterdropid不等于null -->

											if(waterdropid!=null) { 

<!-- 将地址栏中的 waterdropid值赋值给id为waterdropid的项-->

											　　$("#waterdropid").val(waterdropid);

<!-- 获取到id为waterdropid的项-->

												var sel=document.getElementById("waterdropid"); 

<!-- 获取到sel当前的选择项-->

												var waterdropidselectedindex = sel.selectedIndex;

<!-- 将id为waterdrop赋值为与waterdropid相同的项数的值，即当前waterdropid项目为第一项时，waterdrop项为第一项 -->

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


