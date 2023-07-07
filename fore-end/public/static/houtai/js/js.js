/*搜索分页处理开始*/

$("tbody").attr("id", "allitems");
$("tr").attr("class", "oneitem");
var tablesave = $("#allitems").html();
tablesave = "<tbody id='allitems'>" + tablesave + "</tbody>"
var search = "";

var currentPage = 1;

function goTablePage(pno, psize) {

  search = $("#search").val();


  var numall = $("#allitems .oneitem").length;

  for (var i = 0; i < numall; i++) {
    $("#allitems .oneitem")[i].style.display = "table-row";
  }

  var scindex = [];
  for (var i = 1; i < (numall + 1); i++) {
    if ($("#allitems .oneitem")[i - 1].innerText.indexOf(search) == -1 && search) {
      scindex.push(i - 1);
    }
  }

  for (var i = scindex.length - 1; i >= 0; i--) {
    $("#allitems .oneitem")[scindex[i]].style.display = "none";
    // $("#allitems .oneitem")[scindex[i]].remove();
  }

  var num = $("#allitems .oneitem[style='display: table-row;']").length;

  // alert(num);

  var totalPage = 0;//总页数
  var pageSize = psize;//每页显示行数
  //总共分几页
  if (num / pageSize > parseInt(num / pageSize)) {
    totalPage = parseInt(num / pageSize) + 1;
  } else {
    totalPage = parseInt(num / pageSize);
  }
  var currentPage = pno;//当前页数
  var startRow = (currentPage - 1) * pageSize + 1;//开始显示的行 31
  var endRow = currentPage * pageSize;//结束显示的行  40
  endRow = (endRow > num) ? num : endRow;  //40
  //遍历显示数据实现分页

  var displayindex = [];
  var j = 0;
  for (var i = 0; i < numall; i++) {

    var tritemdisplay = $("#allitems .oneitem")[i].style.display;
    console.log(tritemdisplay);
    console.log(tritemdisplay.indexOf("table-row") >= 0);
    if (tritemdisplay.indexOf("table-row") >= 0) {
      j++;
    }
    if (j < startRow || j > endRow) {
      displayindex.push(i);
    }
  }

  console.log(j)
  console.log(startRow)
  console.log(endRow)
  console.log(displayindex)

  for (var i = displayindex.length - 1; i >= 0; i--) {
    $("#allitems .oneitem")[displayindex[i]].style.display = "none";
  }


  var tempStr1 = "共" + num + "条记录 分" + totalPage + "页 当前第" + currentPage + "页";

  var tempStr2 = "";


  $("#shangyiye").off("click");
  $("#shangyiye").click(function () {
    goTablePage(currentPage - 1, psize)
  });

  $("#xiayiye").off("click");
  $("#xiayiye").click(function () {
    goTablePage(currentPage + 1, psize)
  });

  if (currentPage > 1) {

    $("#shangyiye").off("click");
    $("#shangyiye").click(function () {
      goTablePage(currentPage - 1, psize)
    });


    //第一页按钮
    tempStr2 += "<a href=\"javascript:;;\" onClick=\"goTablePage(" + (1) + "," + psize + ")\"  style=\"margin-left: 10px;\"><i class=\"fa fa-angle-left\"></i><i class=\"fa fa-angle-left\"></i></a>";
    //上一页按钮
    tempStr2 += "<a href=\"javascript:;;\" onClick=\"goTablePage(" + (currentPage - 1) + "," + psize + ")\"  style=\"margin-left: 10px;\"><i class=\"fa fa-angle-left\"></i></a>";
    //当前页
    tempStr2 += "<a style=\"background-color: #6eb7e2;color: #fff;border: none;padding: 0.3rem 0.7rem;background-image: -webkit-linear-gradient(left,#6eb7e2,#6eb7e2);margin-left: 10px;\">" + currentPage + "</a>";
  } else {

    $("#shangyiye").off("click");

    //第一页按钮
    tempStr2 += "<a href=\"javascript:;;\"  style=\"margin-left: 10px;\"><i class=\"fa fa-angle-left\"></i><i class=\"fa fa-angle-left\"></i></a>";
    //上一页按钮
    tempStr2 += "<a href=\"javascript:;;\"  style=\"margin-left: 10px;\"><i class=\"fa fa-angle-left\"></i></a>";
    //当前页
    tempStr2 += "<a style=\"background-color: #6eb7e2;color: #fff;border: none;padding: 0.3rem 0.7rem;background-image: -webkit-linear-gradient(left,#6eb7e2,#6eb7e2);margin-left: 10px;\">" + currentPage + "</a>";
  }
  if (currentPage < totalPage) {

    $("#xiayiye").off("click");
    $("#xiayiye").click(function () {
      goTablePage(currentPage + 1, psize)
    });

    //下一页
    tempStr2 += "<a href=\"javascript:;;\" onClick=\"goTablePage(" + (currentPage + 1) + "," + psize + ")\"  style=\"margin-left: 10px;\"><i class=\"fa fa-angle-right\"></i></a>";
    //最后页
    tempStr2 += "<a href=\"javascript:;;\" onClick=\"goTablePage(" + (totalPage) + "," + psize + ")\"  style=\"margin-left: 10px;\"><i class=\"fa fa-angle-right\"></i><i class=\"fa fa-angle-right\"></i></a>";
  } else {

    $("#xiayiye").off("click");

    //下一页
    tempStr2 += "<a href=\"javascript:;;\" style=\"margin-left: 10px;\"><i class=\"fa fa-angle-right\"></i></a>";
    //最后页
    tempStr2 += "<a href=\"javascript:;;\" style=\"margin-left: 10px;\"><i class=\"fa fa-angle-right\"></i><i class=\"fa fa-angle-right\"></i></a>";
  }


  try {
    document.getElementById("tempStr1").innerHTML = tempStr1;
    document.getElementById("tempStr2").innerHTML = tempStr2;
  } catch (error) {

  }


  $("#dangqianye").html(currentPage);

  $("#searchbtn").off("click");
  $("#searchbtn").prop("type", "button");
  $("#searchbtn").click(function () {
    goTablePage(1, psize)
  });

}

/*搜索分页处理结束*/
