<template>
    <div>
        <div id="main-wrapper">
            <div class="nav-header">
                <a href="manageye.html" class="brand-logo"> <span style="font-size: 22px;color: #000;">家谱管理系统</span>
                </a>
            </div>
            <div class="deznav">
                <div class="deznav-scroll">

                    <htmenu></htmenu>

                </div>
            </div>
            <div class="content-body" style="padding-top: 0;">
                <div class="container-fluid">
                    <div class="page-titles">
                        <h4 qw-c="operationname">添加家族</h4>
                    </div>
                    <div class="row">
                        <div class="col-xl-9 col-lg-9">
                            <div class="card">
                                <div class="card-body">
                                    <div class="basic-form">
                                        <form qw-c="operationform" action="#" method="post"
                                              enctype="multipart/form-data">
                                            <div style="display:none;" class="form-group" qw-c="forminputcomponent">
                                                <label class="col-form-label" style="margin-bottom: 5px;"
                                                       qw-c="forminputtext">家族id</label>
                                                <input maxlength="-1" name="id" id="id" v-model="family.id" type="text"
                                                       class="form-control input-default" qw-c="forminput">
                                            </div>
                                            <div class="form-group" qw-c="forminputcomponent">
                                                <label class="col-form-label" style="margin-bottom: 5px;"
                                                       qw-c="forminputtext">名称</label>
                                                <input maxlength="-1" v-model="family.name" name="name" id="name"
                                                       type="text" class="form-control input-default" qw-c="forminput">
                                            </div>
                                            <div class="form-group" qw-c="forminputcomponent">
                                                <label class="col-form-label" style="margin-bottom: 5px;"
                                                       qw-c="forminputtext">账号</label>
                                                <input maxlength="-1" v-model="family.username" name="username"
                                                       id="username" type="text" class="form-control input-default"
                                                       qw-c="forminput">
                                            </div>
                                            <div class="form-group" qw-c="forminputcomponent">
                                                <label class="col-form-label" style="margin-bottom: 5px;"
                                                       qw-c="forminputtext">密码</label>
                                                <input maxlength="-1" v-model="family.password" name="password"
                                                       id="password" type="password" class="form-control input-default"
                                                       qw-c="forminput">
                                            </div>
                                            <div class="form-group" qw-c="formtextareacomponent">
                                                <label class="col-form-label" style="margin-bottom: 5px;"
                                                       qw-c="formtextareatext">描述</label>
                                                <textarea v-model="family.intro" name="intro" id="intro"
                                                          class="form-control" rows="4" qw-c="formtextarea"></textarea>
                                            </div>


                                            <div class="form-group mb-0">
                                                <button type="button" @click="addfamilyact()" class="btn btn-primary">
                                                    添加
                                                </button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="footer">
                <div class="copyright">
                    <p> © 家谱管理系统</p>
                </div>
            </div>
        </div>


    </div>
</template>
<script>
    import Htmenu from "./Htmenu.vue";

    export default {
        name: "AddFamily",
        components: {Htmenu},
        data() {
            return {
                family: {},
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
                    //$(".fileimg").attr("src","http://localhost:8081/familytree/resource/uploads/" + res.data);
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
            }, addfamilyact: function () {
                let _this = this;
                this.$axios.post("/addfamilyactjson.action", _this.serializeForm())
                    .then(res => {
                        console.log(res.data);
                        var obj = res.data;
                        _this.$message({
                            message: '添加家族成功',
                            type: 'success'
                        });
                        _this.$router.push('/FamilyManage');
                    })
                    .catch(err => {
                        console.log(err)
                        _this.$message({
                            message: '添加家族失败',
                            type: 'error'
                        });
                    })
            },
        },
        created() {
            let _this = this;
            _this.identity = sessionStorage.getItem("identity");
            _this.userinfo = JSON.parse(sessionStorage.getItem("userinfo"));
            _this.$set(_this.family, 'createtime', new Date(+new Date() + 8 * 3600 * 1000).toJSON().substr(0, 19).replace("T", " "));
        },
        beforeCreate() {

            $("#cssdiv").html("");

            var cssstr = "<link rel=\"icon\" type=\"image/png\" sizes=\"16x16\" href=\"https://www.17sucai.com/2021/6/khlrr10467/images/favicon.png\"> " +
                "<link href=\"/static/houtai/css/bootstrap-select.min.css\" rel=\"stylesheet\"> " +
                "<link href=\"/static/houtai/css/style.css\" rel=\"stylesheet\"> " +
                "<link href=\"/static/houtai/css/css2.css\" rel=\"stylesheet\"> "
            ;

            $("#cssdiv").html(cssstr);
            $("#jsdiv").html("");

            var jsstr = "<script src=\"/static/houtai/js/global.min.js\"><\/script> " +
                "<script src=\"/static/houtai/js/bootstrap-select.min.js\"><\/script> " +
                "<script src=\"/static/houtai/js/custom.min.js\"><\/script> " +
                "<script src=\"/static/houtai/js/deznav-init.js\"><\/script> ";
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

