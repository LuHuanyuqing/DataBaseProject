
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
  <title>成员事件管理</title> 
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
     成员事件管理
    </div> 
    <div class="card-body"> 
     <div class="row" style="margin-bottom: 40px;"> 
      <div class="col-md-6"> 
       <div class="form-inline mb-5"> 
        <label for="search" class="mr-2">搜索:</label> 
        <input type="text" class="form-control mb-2 mr-sm-2" id="search" placeholder="请输入关键字">
        <button type="button" id="searchbtn" class="btn btn-primary mb-2">搜索</button>
       </div> 
      </div> 
     </div> 
     <table qw-c="table">
       <thead><th>成员

                    </th><th>成员id

                    </th><th>内容

                    </th><th>家族

                    </th><th>家族id

                    </th><th>操作</th></thead> <tbody>

                    

                    

                    <c:if test="${ !empty tasteall}">

							<c:forEach items="${ tasteall}" var="item">

							

								<tr><td>                        ${item.waterdrop }

                      </td><td>                        ${item.waterdropid }

                      </td><td>                        ${item.content }

                      </td><td>                        ${item.fort }

                      </td><td>                        ${item.fortid }

                      </td><td>

	<!--  定义修改成员事件按钮和删除成员事件按钮，修改提交地址为xiugaitaste.action?id=${item.id}，删除提交地址为 shanchutaste.action?id=${item.id}-->

                          <a href="xiugaitaste.action?id=${item.id}">修改</a>   <a href="shanchutaste.action?id=${item.id}">删除</a>

                      </td>                    </tr>

							</c:forEach>

				</c:if>

                  </tbody> 
     </table> 
     <div class="row"> 
      <div class="col-md-6"> 
       <nav aria-label="分页"> 
        <ul class="pagination justify-content-end"> 
         <li class="page-item"> <span class="page-link" id="shangyiye">上一页</span> </li>
         <li class="active page-item"><a class="page-link" href="#" id="dangqianye">1</a></li>
         <li class="page-item"> <a class="page-link" href="#" id="xiayiye">下一页</a> </li>
        </ul> 
       </nav> 
      </div> 
     </div> 
    </div> 
   </div> 
  </div> 
  <!-- HTML代码结束 -->  
  <script src="resource/houtai/js/js.js"></script>  
  <script>
  if("${message}"){
    alert("${message}");
  }

  goTablePage(1,10);

</script>
 </body>
</html>


