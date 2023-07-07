<template>
  <div>
    <!-- 登录框 -->
    <div class="container">
      <div class="row">
        <div class="col-md-4 col-md-offset-4 login-box">
          <h2 class="text-center" qw-c="operationname">注册</h2>
          <form qw-c="form" action="#" method="post">
            <div class="form-group">
              <label for="username">账号</label>
              <input maxlength="-1" type="text" qw-c="username" name="username" class="form-control" id="username"
                     placeholder="请输入用户名">
            </div>
            <div class="form-group">
              <label for="password">密码</label>
              <input maxlength="-1" type="password" qw-c="password" name="password" class="form-control" id="password"
                     placeholder="请输入密码">
            </div>

            <div class="form-group" qw-c="passwordcomponent"><label for="password">确认密码</label> <input maxlength="-1"
                                                                                                       type="password"
                                                                                                       class="form-control"
                                                                                                       name="repassword"
                                                                                                       id="repassword"
                                                                                                       placeholder="请确认密码">
            </div>


            <div class="form-group">
              <label for="identity">身份</label>
              <select class="form-control" id="identity" qw-c="identity" name="identity">
                <option>家族</option>
              </select>
            </div>
            <div class="form-group">
              <button class="btn btn-block btn-lg" type="button" @click="registact">注册</button>
            </div>
            <div class="text-center" qw-c="infotext">
              已有账号，点击<a href="/#/Login">登录</a>
            </div>
          </form>
        </div>
      </div>
    </div>
    <!-- 背景图片 -->
    <div class="background">
      <img src="../../public/static/houtai/img/16pic_5791374_b.jpg" alt="背景图片">
    </div>


  </div>
</template>
<script>
  import Htmenu from "./Htmenu.vue";

  export default {
    name: "Regist",
    components: {Htmenu},
    data() {
      return {
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
      }, registact() {
        let _this = this;

        console.log(_this.serializeForm());
        this.$axios.post("/registactjson.action", _this.serializeForm())
          .then(res => {

            if (res.data == "请先登录") {
              this.$message({
                message: '请先登录',
                type: 'success'
              });
              _this.$router.push('/Login');
            }


            console.log(res.data);

            var obj = res.data;

            var message = obj['message'];

            if (message) {
              this.$message({
                message: message,
                type: 'success'
              });
            }

            if (message == "注册成功，请登录") {
              _this.$router.push('/Login');
            }

          })
          .catch(err => {
            console.log(err)
            this.$message({
              message: '注册失败',
              type: 'error'
            });
          })


      },
    },
    created() {

      let _this = this;
      _this.identity = window.sessionStorage.getItem("identity");
      _this.userinfo = JSON.parse(window.sessionStorage.getItem("userinfo"));

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

