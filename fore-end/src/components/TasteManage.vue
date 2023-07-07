<template>
  <div>
    <!-- HTML代码开始 -->
    <div id="sidebar">
      <div class="sidebar-header">
        <h3>家谱管理系统</h3>
      </div>

      <htmenu></htmenu>

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
                <input maxlength="-1" type="text" class="form-control mb-2 mr-sm-2" id="search" placeholder="请输入关键字">
                <button type="button" id="searchbtn" class="btn btn-primary mb-2">搜索</button>
              </div>
            </div>
          </div>
          <table qw-c="table">
            <thead>
            <tr>
              <th>成员</th>
              <th>内容</th>
              <th>家族</th>
              <th>创建时间</th>
              <th>修改时间</th>
              <td>操作</td>
            </tr>
            </thead>
            <tbody id="tbody">
            <tr v-for="item in tasteall" :key="item.id">
              <td>{{item.waterdrop}}</td>
              <td>{{item.content}}</td>
              <td>{{item.fort}}</td>
              <td>{{item.createtime}}</td>
              <td>{{item.updatetime}}</td>
              <td><a :href="'/#/UpdateTaste?id=' + item.id">修改</a><a href="javascript:;;"
                                                                     @click="deletetastejson(item.id)">删除</a></td>
            </tr>
            </tbody>
          </table>
          <div class="row">
            <div class="col-md-6">
              <nav aria-label="分页">
                <ul class="pagination justify-content-end">
                  <li class="page-item"><span class="page-link" id="shangyiye">上一页</span></li>
                  <li class="active page-item"><a class="page-link" href="#" id="dangqianye">1</a></li>
                  <li class="page-item"><a class="page-link" href="javascript:;" id="xiayiye">下一页</a></li>
                </ul>
              </nav>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- HTML代码结束 -->


    <span id="el-dialog"></span>
  </div>
</template>
<script>
  import Htmenu from "./Htmenu.vue";

  export default {
    name: "TasteManage",
    components: {Htmenu},
    data() {
      return {
        tasteall: [],
        identity: "",
        userinfo: {},
      }
    },
    methods: {
      uploadfile(file, itemname, attr) {
        console.log(file)
        let _this = this;
        var forms = new FormData()
        var configs = {
          headers: {'Content-Type': 'multipart/form-data'}
        };
        forms.append('file', file.target.files[0])
        this.$axios.post("/addfilejson.action", forms, configs).then(res => {
          console.log(res);
          //$(".fileimg").attr("src","http://localhost:8080/patriarchalclan/resource/uploads/" + res.data);
          _this.$forceUpdate();
          _this[itemname][attr] = res.data;
        })
      },
      getNowTime() {
        return new Date(+new Date() + 8 * 3600 * 1000).toJSON().substr(0, 19).replace("T", " ");
      },
      serializeForm(formid) {
        var fields;
        if (formid) {
          fields = $('#' + formid).serializeArray();
        } else {
          fields = $("form").serializeArray();
        }
        var obj = {}; //声明一个对象
        $.each(fields, function (index, field) {
          obj[field.name] = field.value; //通过变量，将属性值，属性一起放到对象中
        })
        return obj;
      }, searchtaste: function () {
        let _this = this;
        this.$axios.post("/searchtastejson.action", "")
          .then(res => {
            var obj = res['data'];
            console.log(obj);
            _this.tasteall = obj['tasteall'];
            _this.tasteall = _this.tasteall.filter(function (item) {
              return item;
            });
            //$("tbody").html("");
            //for (var i = 0; i < _this.tasteall.length; i++){
            //var item = _this.tasteall[i];
            //$("tbody").append(
            //"                <tr>" +
            //"                    <td>"+ item['waterdrop'] +"</td>" +
            //"                    <td>"+ item['content'] +"</td>" +
            //"                    <td>"+ item['fort'] +"</td>" +
//"                    <td><a href='updatetaste.html?id=" + item['id'] + "'>修改</a> <a href='javascript:;;' onclick='deletetastejson(" + item['id'] + ")'>删除</a></td>"+
            //"                </tr>"
            //)
            //}
            //表单数据更新处理部分
            // try {
            //     $('#example').DataTable().destroy();
            // }catch (e) {
            //
            // }
            // setTimeout(function () {
            //     $('#example').DataTable({
            //         "language": {
            //             "lengthMenu": "每页显示 _MENU_记录",
            //             "zeroRecords": "没有匹配的数据",
            //             "info": "第_PAGE_页/共 _PAGES_页 ( 共\_TOTAL\_条记录 )",
            //             "infoEmpty": "没有符合条件的记录",
            //             "search": "查找",
            //             "infoFiltered": "(从 _MAX_条记录中过滤)",
            //             "paginate": {"first": "首页 ", "last": "末页", "next": "下一页", "previous": "上一页"}
            //         }
            //     });
            // },20)
          })
          .catch(err => {
            console.log(err)
          })
      },
      deletetastejson: function (id) {
        let _this = this;
        this.$axios.post("/deletetastejson.action?id=" + id, "")
          .then(res => {
            this.$message({
              message: '删除成员事件信息成功',
              type: 'success'
            });
            _this.searchtaste();
          })
          .catch(err => {
            console.log(err)
          })
      },
    },
    created() {
      let _this = this;
      _this.identity = sessionStorage.getItem("identity");
      _this.searchtaste();
    },
    beforeCreate() {

      $("#cssdiv").html("");

      var cssstr = "<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\"> " +
        "<link href=\"https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css\" rel=\"stylesheet\"> " +
        "<link href=\"/static/houtai/css/config.css\" rel=\"stylesheet\"> " +
        "<link rel=\"stylesheet\" href=\"https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css\"> " +
        "<link href=\"/static/houtai/css/css.css\" rel=\"stylesheet\"> "
      ;

      $("#cssdiv").html(cssstr);
      $("#jsdiv").html("");

      var jsstr = "<script src=\"/static/houtai/js/jquery.min.js\"><\/script> " +
        "<script src=\"/static/houtai/js/bootstrap.min.js\"><\/script> " +
        "<script src=\"/static/houtai/js/js.js\"><\/script> ";
      setTimeout(function () {
        $("#jsdiv").html(jsstr);
      }, 100);

    },
    mounted() {
      let _this = this;


      setTimeout(function () {

        if ("") {
          alert("");
        }

        goTablePage(1, 10);


      }, 100)
    }
  }
</script>

