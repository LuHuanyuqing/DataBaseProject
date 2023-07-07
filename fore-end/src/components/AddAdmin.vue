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
          添加管理员
        </div>
        <div class="card-body">
          <form qw-c="operationform" action="#" method="post" enctype="multipart/form-data">
            <div style="display:none;" class="form-group" qw-c="forminputcomponent">
              <label qw-c="forminputtext">管理员id</label>
              <input maxlength="-1" name="id" id="id" v-model="admin.id" type="text" qw-c="forminput"
                     class="form-control">
            </div>
            <div class="form-group" qw-c="forminputcomponent">
              <label qw-c="forminputtext">账号</label>
              <input maxlength="-1" v-model="admin.username" name="username" id="username" type="text" qw-c="forminput"
                     class="form-control">
            </div>
            <div class="form-group" qw-c="forminputcomponent">
              <label qw-c="forminputtext">密码</label>
              <input maxlength="-1" v-model="admin.password" name="password" id="password" type="password"
                     qw-c="forminput" class="form-control">
            </div>


            <button type="button" v-on:click="addadminact()" class="btn btn-primary">添加</button>
          </form>
        </div>
      </div>
    </div>
    <!-- HTML代码结束 -->


  </div>
</template>
<script>
  import Htmenu from "./Htmenu.vue";

  export default {
    name: "AddAdmin",
    components: {Htmenu},
    data() {
      return {
        admin: {},
        identity: '',
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
      }, addadminact: function () {
        let _this = this;
        this.$axios.post("/addadminactjson.action", _this.serializeForm())
          .then(res => {
            console.log(res.data);
            var obj = res.data;
            _this.$message({
              message: '添加管理员成功',
              type: 'success'
            });
            _this.$router.push('/AdminManage');
          })
          .catch(err => {
            console.log(err)
            _this.$message({
              message: '添加管理员失败',
              type: 'error'
            });
          })
      },
    },
    created() {
      let _this = this;
      _this.identity = sessionStorage.getItem("identity");
      _this.userinfo = JSON.parse(sessionStorage.getItem("userinfo"));
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

      }, 20)
    }
  }
</script>

