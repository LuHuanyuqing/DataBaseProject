<template>
    <div>
        <div id="main-wrapper">
            <div class="nav-header">
                <a href="" class="brand-logo"> <span style="font-size: 22px;color: #000;">家谱管理系统</span> </a>
            </div>
            <div class="deznav">
                <div class="deznav-scroll">

                    <htmenu></htmenu>

                </div>
            </div>
            <div class="content-body" style="padding-top: 0;">
                <div class="container-fluid">
                    <div class="page-titles">
                        <h4 qw-c="operationname">家族查看</h4>
                    </div>
                    <div class="row">
                        <div class="col-12">
                            <div class="card">
                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table id="example" class="display min-w850" qw-c="table">
                                            <thead>
                                            <tr>
                                                <th>名称</th>
                                                <th>账号</th>
                                                <th>密码</th>
                                                <th>描述</th>
                                                <th>创建时间</th>
                                                <td>操作</td>
                                            </tr>
                                            </thead>
                                            <tbody id="tbody">
                                            <tr v-for="item in familyall" :key="item.id">
                                                <td>{{item.name}}</td>
                                                <td>{{item.username}}</td>
                                                <td>{{item.password}}</td>
                                                <td>{{item.intro}}</td>
                                                <td>{{item.createtime}}</td>
                                            </tr>
                                            </tbody>
                                        </table>
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


        <span id="el-dialog"></span>
    </div>
</template>
<script>
    import Htmenu from "./Htmenu.vue";

    export default {
        name: "FamilyView",
        components: {Htmenu},
        data() {
            return {
                familyall: [],
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
            }, searchfamily: function () {
                let _this = this;
                this.$axios.post("/searchfamilyjson.action", "")
                    .then(res => {
                        var obj = res['data'];
                        console.log(obj);
                        _this.familyall = obj['familyall'];
                        _this.familyall = _this.familyall.filter(function (item) {
                            return item;
                        });
                        var search = $("#search").val();
                        if (search) {
                            _this.familyall = _this.familyall.filter(function (item) {
                                return item.null.indexOf(search) >= 0;
                            });
                        }
                        //$("tbody").html("");
                        //for (var i = 0; i < _this.familyall.length; i++){
                        //var item = _this.familyall[i];
                        //$("tbody").append(
                        //"                <tr>" +
                        //"                    <td>"+ item['name'] +"</td>" +
                        //"                    <td>"+ item['username'] +"</td>" +
                        //"                    <td>"+ item['password'] +"</td>" +
                        //"                    <td>"+ item['intro'] +"</td>" +
                        //"                    <td>"+ item['createtime'] +"</td>" +
                        //"                </tr>"
                        //)
                        //}
                        //表单数据更新处理部分
                        //$('#example').DataTable().destroy();
                        //setTimeout(function () {
                        //$('#example').DataTable();
                        //},20);
                    })
                    .catch(err => {
                        console.log(err)
                    })
            },
            deletefamilyjson: function (id) {
                let _this = this;
                this.$axios.post("/deletefamilyjson.action?id=" + id, "")
                    .then(res => {
                        this.$message({
                            message: '删除家族信息成功',
                            type: 'success'
                        });
                        _this.searchfamily();
                    })
                    .catch(err => {
                        console.log(err)
                    })
            },
        },
        created() {
            let _this = this;
            _this.identity = sessionStorage.getItem("identity");
            _this.userinfo = JSON.parse(sessionStorage.getItem("userinfo"));
            _this.searchfamily();
        },
        beforeCreate() {

            $("#cssdiv").html("");

            var cssstr = "<link rel=\"icon\" type=\"image/png\" sizes=\"16x16\" href=\"https://www.17sucai.com/2021/6/khlrr10467/images/favicon.png\"> " +
                "<link href=\"/static/houtai/css/jquery.dataTables.min.css\" rel=\"stylesheet\"> " +
                "<link href=\"/static/houtai/css/bootstrap-select.min.css\" rel=\"stylesheet\"> " +
                "<link href=\"/static/houtai/css/style.css\" rel=\"stylesheet\"> " +
                "<link href=\"/static/houtai/css/css2.css\" rel=\"stylesheet\"> "
            ;

            $("#cssdiv").html(cssstr);
            $("#jsdiv").html("");

            var jsstr = "<script src=\"/static/houtai/js/global.min.js\"><\/script> " +
                "<script src=\"/static/houtai/js/bootstrap-select.min.js\"><\/script> " +
                "<script src=\"/static/houtai/js/custom.min.js\"><\/script> " +
                "<script src=\"/static/houtai/js/deznav-init.js\"><\/script> " +
                "<script src=\"/static/houtai/js/jquery.dataTables.min.js\"><\/script> " +
                "<script src=\"/static/houtai/js/datatables.init.js\"><\/script> ";
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

