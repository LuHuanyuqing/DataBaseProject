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
          管理员个人中心
        </div>
        <div class="card-body">
          <form qw-c="operationform" action="#" method="post" enctype="multipart/form-data">
            <div style="display:none;" class="form-group" qw-c="forminputcomponent">
              <label qw-c="forminputtext">管理员id</label>
              <input maxlength="-1" name="id" id="id" v-model="userinfo.id" type="text" qw-c="forminput"
                     class="form-control">
            </div>
            <div class="form-group" qw-c="forminputcomponent">
              <label qw-c="forminputtext">账号</label>
              <input maxlength="-1" v-model="userinfo.username" name="username" id="username" type="text" readonly
                     qw-c="forminput" class="form-control">
            </div>
            <div class="form-group" qw-c="forminputcomponent">
              <label qw-c="forminputtext">密码</label>
              <input maxlength="-1" v-model="userinfo.password" name="password" id="password" type="password"
                     qw-c="forminput" class="form-control">
            </div>


            <button class="btn btn-primary" type="button" v-on:click="addadminact()">修改</button>
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
    name: "AdminIndex",
    components: {Htmenu},
    data() {
      return {
        userinfo: {},
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
      }, updateadminact: function () {
        let _this = this;
        this.$axios.post("/updateadminactjson.action", _this.serializeForm())
          .then(res => {
            console.log(res.data);
            var obj = res.data;
            this.$axios.post("/admindetailsjson.action?id=" + _this.userinfo['id'], _this.serializeForm())
              .then(res => {
                console.log(res);
                var obj = res.data;
                _this.userinfo = obj['admin'];
                sessionStorage.setItem("userinfo", JSON.stringify(_this.userinfo));
                this.$message({
                  message: '修改个人信息成功',
                  type: 'success'
                });
              })
              .catch(err => {
                console.log(err)
                this.$message({
                  message: '获取管理员信息失败',
                  type: 'error'
                });
              })
          })
          .catch(err => {
            console.log(err)
            this.$message({
              message: '修改管理员信息失败',
              type: 'error'
            });
          })
      }, admindetailsjson(id) {
        let _this = this;
        this.$axios.post("/admindetailsjson.action?id=" + id)
          .then(res => {

            if (res.data == "请先登录") {
              this.$message({
                message: '请先登录',
                type: 'success'
              });
              _this.$router.push('/Login');
            }

            console.log(res.data);
            _this.userinfo = res.data.admin;
          })
          .catch(err => {
            console.log(err)
            this.$message({
              message: '获取管理员信息失败',
              type: 'error'
            });
          })
      },
    },
    created() {
      let _this = this;
      _this.identity = sessionStorage.getItem("identity");
      _this.admindetailsjson(sessionStorage.getItem("id"));
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

