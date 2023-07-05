<template>
    <div class="h-100 body">
        <div class="authincation h-100">
            <div class="container h-100">
                <div class="row justify-content-center h-100 align-items-center">
                    <div class="col-md-6">
                        <div class="authincation-content">
                            <div class="row no-gutters">
                                <div class="col-xl-12">
                                    <div class="auth-form">
                                        <h4
                                                class="text-center mb-4 text-white"
                                                qw-c="operationname"
                                        >
                                            用户登录
                                        </h4>
                                        <form action="#" qw-c="form" method="post">
                                            <div class="form-group">
                                                <label class="mb-1 text-white"
                                                ><strong>账号</strong></label
                                                >
                                                <input
                                                        maxlength="-1"
                                                        qw-c="username"
                                                        name="username"
                                                        class="form-control"
                                                        type="text"
                                                        placeholder="请输入用户名"
                                                />
                                            </div>
                                            <div class="form-group">
                                                <label class="mb-1 text-white"
                                                ><strong>密码</strong></label
                                                >
                                                <input
                                                        maxlength="-1"
                                                        qw-c="password"
                                                        name="password"
                                                        type="password"
                                                        placeholder="请输入密码"
                                                        class="form-control"
                                                />
                                            </div>

                                            <div class="form-group" qw-c="passwordcomponent">
                                                <label class="mb-1 text-white"
                                                ><strong>身份</strong></label
                                                >
                                                <select
                                                        qw-c="identity"
                                                        name="identity"
                                                        class="form-control"
                                                >
                                                    <option>管理员</option>
                                                    <option>家族</option>
                                                </select>
                                            </div>

                                            <br/>
                                            <div class="text-center" style="color: #0d95e8">
                                                <button
                                                        class="btn bg-white text-primary btn-block"
                                                        type="button"
                                                        @click="loginact"
                                                >
                                                    登 录
                                                </button>
                                            </div>
                                        </form>
                                        <div class="new-account mt-3">
                                            <p class="text-white" qw-c="infotext">
                                                没有账号，点击<a href="/#/Regist">注册</a>
                                            </p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
    import Htmenu from "./Htmenu.vue";

    export default {
        name: "Login",
        components: {Htmenu},
        data() {
            return {
                identity: "",
                userinfo: {},
            };
        },
        methods: {
            uploadfile(file, itemname, attr) {
                console.log(file);
                let _this = this;
                var forms = new FormData();
                var configs = {
                    headers: {"Content-Type": "multipart/form-data"},
                };
                forms.append("file", file.target.files[0]);
                this.$axios.post("/addfilejson.action", forms, configs).then((res) => {
                    console.log(res);
                    //$(".fileimg").attr("src","http://localhost:8081/familytree/resource/uploads/" + res.data);
                    _this.$forceUpdate();
                    _this[itemname][attr] = res.data;
                });
            },
            getNowTime() {
                return new Date(+new Date() + 8 * 3600 * 1000)
                    .toJSON()
                    .substr(0, 19)
                    .replace("T", " ");
            },
            serializeForm(formid) {
                var fields;
                if (formid) {
                    fields = $("#" + formid).serializeArray();
                } else {
                    fields = $("form").serializeArray();
                }
                var obj = {}; //声明一个对象
                $.each(fields, function (index, field) {
                    obj[field.name] = field.value; //通过变量，将属性值，属性一起放到对象中
                });
                return obj;
            },
            loginact() {
                let _this = this;

                console.log(_this.serializeForm());
                this.$axios
                    .post("/loginactjson.action", _this.serializeForm())
                    .then((res) => {
                        if (res.data == "请先登录") {
                            this.$message({
                                message: "请先登录",
                                type: "success",
                            });
                            _this.$router.push("/Login");
                        }

                        console.log(res.data);

                        var obj = res.data;

                        var message = obj["message"];

                        var userinfo = obj["userinfo"];
                        var identity = obj["identity"];
                        var token = obj["token"];
                        var mingzi = obj["mingzi"];

                        console.log(token);

                        if (message) {
                            this.$message({
                                message: message,
                                type: "success",
                            });
                        }

                        if (message == "登录成功") {
                            sessionStorage.setItem("identity", identity);
                            sessionStorage.setItem("id", userinfo.id);
                            sessionStorage.setItem("mingzi", mingzi);
                            sessionStorage.setItem("token", token);
                            sessionStorage.setItem("userinfo", JSON.stringify(userinfo));
                            sessionStorage.setItem("username", userinfo.username);

                            if ("管理员" == identity) {
                                _this.$router.push("/AdminIndex");
                            }
                            if ("家族" == identity) {
                                _this.$router.push("/FamilyIndex");
                            }
                        }
                    })
                    .catch((err) => {
                        console.log(err);
                        this.$message({
                            message: "登录失败",
                            type: "error",
                        });
                    });
            },
        },
        created() {
            let _this = this;
            _this.identity = window.sessionStorage.getItem("identity");
            _this.userinfo = JSON.parse(window.sessionStorage.getItem("userinfo"));
        },
        beforeCreate() {
            $("#cssdiv").html("");

            var cssstr =
                '<link rel="icon" type="image/png" sizes="16x16" href="https://www.17sucai.com/2021/6/khlrr10467/images/favicon.png"> ' +
                '<link href="/static/houtai/css/style.css" rel="stylesheet"> ' +
                '<link href="/static/houtai/css/css2.css" rel="stylesheet"> ';
            $("#cssdiv").html(cssstr);
            $("#jsdiv").html("");

            var jsstr = "<script src=\"/static/houtai/js/global.min.js\" /script> " +
                "<script src=\"/static/houtai/js/bootstrap-select.min.js\" /script> " +
                "<script src=\"/static/houtai/js/custom.min.js\" /script> " +
                "<script src=\"/static/houtai/js/deznav-init.js\" /script> ";
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
            }, 20);
        },
    };
</script>


