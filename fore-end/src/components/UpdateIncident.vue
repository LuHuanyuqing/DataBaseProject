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
                        <h4 qw-c="operationname">修改人员事件</h4>
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
                                                       qw-c="forminputtext">事件id</label>
                                                <input maxlength="-1" name="id" id="id" v-model="incident.id"
                                                       type="text" class="form-control input-default" qw-c="forminput">
                                            </div>
                                            <div class="form-group" qw-c="formselectcomponent">
                                                <label class="col-form-label" style="margin-bottom: 5px;"
                                                       qw-c="formselecttext">成员</label>
                                                <input maxlength="-1" type="hidden" name="memberr" id="memberr"
                                                       v-model="incident.memberr"><select v-model="incident.memberrid"
                                                                                          v-on:change="memberrchange()"
                                                                                          name="memberrid"
                                                                                          id="memberrid"
                                                                                          class="form-control default-select"
                                                                                          qw-c="formselect">
                                                <option v-for="item in memberall" :key="item.id" :value="item.id">
                                                    {{item.name}}
                                                </option>
                                            </select>
                                            </div>
                                            <div class="form-group" qw-c="formtextareacomponent">
                                                <label class="col-form-label" style="margin-bottom: 5px;"
                                                       qw-c="formtextareatext">描述</label>
                                                <textarea v-model="incident.eventdescription" name="eventdescription"
                                                          id="eventdescription" class="form-control" rows="4"
                                                          qw-c="formtextarea"></textarea>
                                            </div>
                                            <div class="form-group" qw-c="formselectcomponent">
                                                <label class="col-form-label" style="margin-bottom: 5px;"
                                                       qw-c="formselecttext">家族</label>
                                                <input maxlength="-1" type="hidden" name="family" id="family"
                                                       v-model="incident.family"><select v-model="incident.familyid"
                                                                                         v-on:change="familychange()"
                                                                                         name="familyid" id="familyid"
                                                                                         class="form-control default-select"
                                                                                         qw-c="formselect">
                                                <option v-for="item in familyall" :key="item.id" :value="item.id">
                                                    {{item.name}}
                                                </option>
                                            </select>
                                            </div>


                                            <div class="form-group mb-0">
                                                <button type="button" @click="updateincidentact()"
                                                        class="btn btn-primary">修改
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
        name: "UpdateIncident",
        components: {Htmenu},
        data() {
            return {
                incident: {},
                identity: '',
                memberall: [],
                familyall: [],
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
            }, searchmember() {
                let _this = this;
                this.$axios.post("/searchmemberjson.action", "")
                    .then(res => {
                        _this.memberall = res.data.memberall;
                        var memberrid = _this.$route.query.memberrid;
                        if (memberrid != null) {
                            _this.memberall = _this.memberall.filter(function (item) {
                                return item.id == memberrid;
                            })
                        }
                        ;
                    })
                    .catch(err => {
                        console.log(err)
                    })
            },
            memberrchange: function () {
                let _this = this;
                _this.incident.memberr = _this.memberrall.filter(function (item) {
                    return item.id == _this.incident.memberrid;
                })[0]["name"];
                _this.$forceUpdate();
            },
            searchfamily() {
                let _this = this;
                this.$axios.post("/searchfamilyjson.action", "")
                    .then(res => {
                        _this.familyall = res.data.familyall;
                        var familyid = _this.$route.query.familyid;
                        if (familyid != null) {
                            _this.familyall = _this.familyall.filter(function (item) {
                                return item.id == familyid;
                            })
                        }
                        ;
                    })
                    .catch(err => {
                        console.log(err)
                    })
            },
            familychange: function () {
                let _this = this;
                _this.incident.family = _this.familyall.filter(function (item) {
                    return item.id == _this.incident.familyid;
                })[0]["name"];
                _this.$forceUpdate();
            },
            incidentdetailsjson: function (id) {
                let _this = this;
                this.$axios.post("/incidentdetailsjson.action?id=" + id, "")
                    .then(res => {
                        var obj = res['data'];
                        console.log(obj)
                        _this.incident = obj['incident'];
                    })
                    .catch(err => {
                        console.log(err)
                    })
            },
            updateincidentact: function () {
                let _this = this;
                this.$axios.post("/updateincidentactjson.action", _this.serializeForm())
                    .then(res => {
                        console.log(res.data);
                        var obj = res.data;
                        _this.$message({
                            message: '修改人员事件成功',
                            type: 'success'
                        });
                        _this.$router.push('/IncidentManage');
                    })
                    .catch(err => {
                        console.log(err)
                        _this.$message({
                            message: '修改人员事件失败',
                            type: 'error'
                        });
                    })
            },
        },
        created() {
            let _this = this;
            _this.identity = sessionStorage.getItem("identity");
            _this.userinfo = JSON.parse(sessionStorage.getItem("userinfo"));
            _this.searchmember();
            _this.searchfamily();
            var id = _this.$route.query.id
            _this.incidentdetailsjson(id);
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

