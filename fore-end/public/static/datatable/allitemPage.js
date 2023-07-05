

var search = "";

function tablechushihua() {

  var alldom = document.getElementById("allitems");

  if(!alldom){
    $("tbody").attr("id", "allitems");
    $("tbody tr").attr("class", "oneitem");
  }

}


function goPage(pno,psize){

  tablechushihua();

  var itable = document.getElementById("allitems");
  console.log(itable);
  var num = $("#allitems .oneitem").length;//表格所有行数(所有记录数)
  console.log(num);
  var totalPage = 0;//总页数
  var pageSize = psize;//每页显示行数
  //总共分几页
  if(num/pageSize > parseInt(num/pageSize)){
    totalPage=parseInt(num/pageSize)+1;
  }else{
    totalPage=parseInt(num/pageSize);
  }
  var currentPage = pno;//当前页数
  var startRow = (currentPage - 1) * pageSize+1;//开始显示的行 31
  var endRow = currentPage * pageSize;//结束显示的行  40
  endRow = (endRow > num)? num : endRow;  //40
  console.log(endRow);
  //遍历显示数据实现分页
  for(var i=1;i<(num+1);i++){
    if(i>=startRow && i<=endRow){
      console.log($("#allitems .oneitem")[i-1]);
      $("#allitems .oneitem")[i-1].style.display = "block";
    }else{
      $("#allitems .oneitem")[i-1].style.display = "none";
    }
  }
  var tempStr = "共"+num+"条记录 分"+totalPage+"页 当前第"+currentPage+"页 <br/><br/>";
  if(currentPage>1){
    tempStr += "<a class='btn btn-success' href=\"javascript:;;\" onClick=\"goPage("+(1)+","+psize+")\">首页</a>";
    tempStr += "<a class='btn btn-success' href=\"javascript:;;\" onClick=\"goPage("+(currentPage-1)+","+psize+")\">上一页</a>"
  }else{
    tempStr += "<a style='color: white;' href=\"javascript:;;\" class='btn btn-success'>首页</a>";
    tempStr += "<a style='color: white;' href=\"javascript:;;\" class='btn btn-success'>上一页</a>";
  }
  if(currentPage<totalPage){
    tempStr += "<a class='btn btn-success' href=\"javascript:;;\" href=\"javascript:;;\" onClick=\"goPage("+(currentPage+1)+","+psize+")\">下一页</a>";
    tempStr += "<a class='btn btn-success' href=\"javascript:;;\" href=\"javascript:;;\" onClick=\"goPage("+(totalPage)+","+psize+")\">尾页</a>";
  }else{
    tempStr += "<a style='color: white;' href=\"javascript:;;\" class='btn btn-success'>下一页</a>";
    tempStr += "<a style='color: white;' href=\"javascript:;;\" class='btn btn-success'>尾页</a>";
  }
  document.getElementById("barcon").innerHTML = tempStr;
}




function goTablePage(pno, psize) {

  tablechushihua();

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
    if(tritemdisplay.indexOf("table-row") >= 0){
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


  if (currentPage > 1) {
    //第一页按钮
    tempStr2 += "<button onClick=\"goTablePage(" + (1) + "," + psize + ")\" class=\"btn btn-primary\"><<</button> ";
    //上一页按钮
    tempStr2 += "<button onClick=\"goTablePage(" + ((currentPage - 1)) + "," + psize + ")\" class=\"btn btn-primary\"><</button> ";
    //当前页
    tempStr2 += "<button class=\"btn btn-primary\">" + currentPage + "</button> ";
  } else {
    //第一页按钮
    tempStr2 += "<button class=\"btn btn-primary\"><<</button> ";
    //上一页按钮
    tempStr2 += "<button class=\"btn btn-primary\"><</button> ";
    //当前页
    tempStr2 += "<button class=\"btn btn-primary\">" + currentPage + "</button> ";
  }
  if (currentPage < totalPage) {
    //下一页
    tempStr2 += "<button onClick=\"goTablePage(" + (currentPage + 1) + "," + psize + ")\" class=\"btn btn-primary\">></button> ";
    //最后页
    tempStr2 += "<button onClick=\"goTablePage(" + (totalPage) + "," + psize + ")\" class=\"btn btn-primary\">>></button> ";
  } else {
    //下一页
    tempStr2 += "<button class=\"btn btn-primary\">></button> ";
    //最后页
    tempStr2 += "<button class=\"btn btn-primary\">>></button> ";
  }
  document.getElementById("tempStr1").innerHTML = tempStr1;
  document.getElementById("tempStr2").innerHTML = tempStr2;
}
