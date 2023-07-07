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
          修改成员事件
        </div>
        <div class="card-body">
          <form qw-c="operationform" action="#" method="post" enctype="multipart/form-data">
            <div style="display:none;" class="form-group" qw-c="forminputcomponent">
              <label qw-c="forminputtext">事件id</label>
              <input maxlength="-1" name="id" id="id" v-model="taste.id" type="text" qw-c="forminput"
                     class="form-control">
            </div>
            <div class="form-group" qw-c="formselectcomponent">
              <label qw-c="formselecttext">成员</label>
              <input maxlength="-1" type="hidden" name="waterdrop" id="waterdrop" v-model="taste.waterdrop"><select
              v-model="taste.waterdropid" v-on:change="waterdropchange()" name="waterdropid" id="waterdropid"
              class="form-control" qw-c="formselect">
              <option v-for="item in waterdropall" :key="item.id" :value="item.id">{{item.name}}</option>
            </select>
            </div>
            <div class="form-group" qw-c="formtextareacomponent">
              <label for="textareaContent" qw-c="formtextareatext">内容</label>
              <textarea v-model="taste.content" name="content" id="contentt" class="form-control" rows="3"
                        qw-c="formtextarea"></textarea>
            </div>
            <div class="form-group" qw-c="formselectcomponent" style="display: none;">
              <label qw-c="formselecttext">家族</label>
              <input maxlength="-1" type="hidden" name="fort" id="fort" v-model="taste.fort"><select
              v-model="taste.fortid" v-on:change="fortchange()" name="fortid" id="fortid" class="form-control"
              qw-c="formselect">
              <option v-for="item in fortall" :key="item.id" :value="item.id">{{item.name}}</option>
            </select>
            </div>


            <button class="btn btn-primary" type="button" v-on:click="updatetasteact()">修改</button>
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
    name: "UpdateTaste",
    components: {Htmenu},
    data() {
      return {
        taste: {},
        identity: '',
        waterdropall: [],
        fortall: [],
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
      }, searchwaterdrop() {
        let _this = this;
        this.$axios.post("/searchwaterdropjson.action", "")
          .then(res => {
            _this.waterdropall = res.data.waterdropall;
            var waterdropid = _this.$route.query.waterdropid;
            if (waterdropid != null) {
              _this.waterdropall = _this.waterdropall.filter(function (item) {
                return item.id == waterdropid;
              })
            }
            ;
          })
          .catch(err => {
            console.log(err)
          })
      },
      waterdropchange: function () {
        let _this = this;
        _this.taste.waterdrop = _this.waterdropall.filter(function (item) {
          return item.id == _this.taste.waterdropid;
        })[0]["name"];
        _this.$forceUpdate();
      },
      searchfort() {
        let _this = this;
        this.$axios.post("/searchfortjson.action", "")
          .then(res => {
            _this.fortall = res.data.fortall;
            var fortid = _this.$route.query.fortid;
            if (fortid != null) {
              _this.fortall = _this.fortall.filter(function (item) {
                return item.id == fortid;
              })
            }
            ;
          })
          .catch(err => {
            console.log(err)
          })
      },
      fortchange: function () {
        let _this = this;
        _this.taste.fort = _this.fortall.filter(function (item) {
          return item.id == _this.taste.fortid;
        })[0]["name"];
        _this.$forceUpdate();
      },
      tastedetailsjson: function (id) {
        let _this = this;
        this.$axios.post("/tastedetailsjson.action?id=" + id, "")
          .then(res => {
            var obj = res['data'];
            console.log(obj)
            _this.taste = obj['taste'];
          })
          .catch(err => {
            console.log(err)
          })
      },
      updatetasteact: function () {
        let _this = this;
        this.$axios.post("/updatetasteactjson.action", _this.serializeForm())
          .then(res => {
            console.log(res.data);
            var obj = res.data;
            _this.$message({
              message: '修改成员事件成功',
              type: 'success'
            });
            _this.$router.push('/TasteManage');
          })
          .catch(err => {
            console.log(err)
            _this.$message({
              message: '修改成员事件失败',
              type: 'error'
            });
          })
      },
    },
    created() {
      let _this = this;
      _this.identity = sessionStorage.getItem("identity");
      _this.userinfo = JSON.parse(sessionStorage.getItem("userinfo"));
      _this.searchwaterdrop();
      _this.searchfort();
      var id = _this.$route.query.id
      _this.tastedetailsjson(id);
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

