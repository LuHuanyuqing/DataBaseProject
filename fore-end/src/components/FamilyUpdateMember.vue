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
                        <h4 qw-c="operationname">修改家庭成员</h4>
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
                                                       qw-c="forminputtext">成员id</label>
                                                <input maxlength="-1" name="id" id="id" v-model="member.id" type="text"
                                                       class="form-control input-default" qw-c="forminput">
                                            </div>
                                            <div class="form-group" qw-c="forminputcomponent">
                                                <label class="col-form-label" style="margin-bottom: 5px;"
                                                       qw-c="forminputtext">头像</label>

                                                <img onerror='src="/static/error.jpg"'
                                                     :src="'http://localhost:8081/familytree/resource/uploads/' + member.avatar"
                                                     id="avatarimg"
                                                     style="width: 100px;height: 100px;margin-bottom: 10px;">
                                                <input maxlength="-1" type="hidden" v-model="member.avatar"
                                                       name="avatar" id="avatar">
                                                <input maxlength="-1" type="file" name="avatarfile" id="avatarfile"
                                                       v-on:change="uploadfile($event,'member','avatar')"
                                                       class="form-control input-default" qw-c="forminput">
                                            </div>
                                            <div style="display:none;" class="form-group" qw-c="forminputcomponent">
                                                <label class="col-form-label" style="margin-bottom: 5px;"
                                                       qw-c="forminputtext">家族</label>
                                                <input maxlength="-1" name="family" id="family" v-model="member.family"
                                                       type="text" class="form-control input-default" qw-c="forminput">
                                            </div>
                                            <div style="display:none;" class="form-group" qw-c="forminputcomponent">
                                                <label class="col-form-label" style="margin-bottom: 5px;"
                                                       qw-c="forminputtext">家族id</label>
                                                <input maxlength="-1" name="familyid" id="familyid"
                                                       v-model="member.familyid" type="text"
                                                       class="form-control input-default" qw-c="forminput">
                                            </div>
                                            <div class="form-group" qw-c="forminputcomponent">
                                                <label class="col-form-label" style="margin-bottom: 5px;"
                                                       qw-c="forminputtext">姓名</label>
                                                <input maxlength="-1" v-model="member.name" name="name" id="name"
                                                       type="text" class="form-control input-default" qw-c="forminput">
                                            </div>
                                            <div class="form-group" qw-c="formselectcomponent">
                                                <label class="col-form-label" style="margin-bottom: 5px;"
                                                       qw-c="formselecttext">性别</label>
                                                <select v-model="member.gender" name="gender" id="gender"
                                                        class="form-control default-select" qw-c="formselect">
                                                    <option>男</option>
                                                    <option>女</option>
                                                </select>
                                            </div>
                                            <div class="form-group" qw-c="forminputcomponent">
                                                <label class="col-form-label" style="margin-bottom: 5px;"
                                                       qw-c="forminputtext">生日</label>
                                                <input maxlength="-1" v-model="member.birthday" name="birthday"
                                                       id="birthday" type="date" class="form-control input-default"
                                                       qw-c="forminput">
                                            </div>
                                            <div class="form-group" qw-c="formselectcomponent">
                                                <label class="col-form-label" style="margin-bottom: 5px;"
                                                       qw-c="formselecttext">父亲</label>
                                                <input maxlength="-1" type="hidden" name="father" id="father"
                                                       v-model="member.father"><select v-model="member.fatherid"
                                                                                       v-on:change="fatherchange()"
                                                                                       name="fatherid" id="fatherid"
                                                                                       class="form-control default-select"
                                                                                       qw-c="formselect">
                                                <option v-for="item in memberall" :key="item.id" :value="item.id">
                                                    {{item.name}}
                                                </option>
                                            </select>
                                            </div>
                                            <div class="form-group" qw-c="formselectcomponent">
                                                <label class="col-form-label" style="margin-bottom: 5px;"
                                                       qw-c="formselecttext">母亲</label>
                                                <input maxlength="-1" type="hidden" name="mother" id="mother"
                                                       v-model="member.mother"><select v-model="member.motherid"
                                                                                       v-on:change="motherchange()"
                                                                                       name="motherid" id="motherid"
                                                                                       class="form-control default-select"
                                                                                       qw-c="formselect">
                                                <option v-for="item in memberall" :key="item.id" :value="item.id">
                                                    {{item.name}}
                                                </option>
                                            </select>
                                            </div>
                                            <div class="form-group" qw-c="formselectcomponent">
                                                <label class="col-form-label" style="margin-bottom: 5px;"
                                                       qw-c="formselecttext">配偶</label>
                                                <input maxlength="-1" type="hidden" name="spouses" id="spouses"
                                                       v-model="member.spouses"><select v-model="member.spousesid"
                                                                                        v-on:change="spouseschange()"
                                                                                        name="spousesid" id="spousesid"
                                                                                        class="form-control default-select"
                                                                                        qw-c="formselect">
                                                <option v-for="item in memberall" :key="item.id" :value="item.id">
                                                    {{item.name}}
                                                </option>
                                            </select>
                                            </div>


                                            <div class="form-group mb-0">
                                                <button type="button" @click="updatememberact()"
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
        name: "FamilyUpdateMember",
        components: {Htmenu},
        data() {
            return {
                member: {'avatar': '', gender: '男',},
                identity: '',
                memberall: [],
                memberall: [],
                memberall: [],
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
                        var fatherid = _this.$route.query.fatherid;
                        if (fatherid != null) {
                            _this.memberall = _this.memberall.filter(function (item) {
                                return item.id == fatherid;
                            })
                        }
                        ;
                    })
                    .catch(err => {
                        console.log(err)
                    })
            },
            fatherchange: function () {
                let _this = this;
                _this.member.father = _this.fatherall.filter(function (item) {
                    return item.id == _this.member.fatherid;
                })[0]["name"];
                _this.$forceUpdate();
            },
            searchmember() {
                let _this = this;
                this.$axios.post("/searchmemberjson.action", "")
                    .then(res => {
                        _this.memberall = res.data.memberall;
                        var motherid = _this.$route.query.motherid;
                        if (motherid != null) {
                            _this.memberall = _this.memberall.filter(function (item) {
                                return item.id == motherid;
                            })
                        }
                        ;
                    })
                    .catch(err => {
                        console.log(err)
                    })
            },
            motherchange: function () {
                let _this = this;
                _this.member.mother = _this.motherall.filter(function (item) {
                    return item.id == _this.member.motherid;
                })[0]["name"];
                _this.$forceUpdate();
            },
            searchmember() {
                let _this = this;
                this.$axios.post("/searchmemberjson.action", "")
                    .then(res => {
                        _this.memberall = res.data.memberall;
                        var spousesid = _this.$route.query.spousesid;
                        if (spousesid != null) {
                            _this.memberall = _this.memberall.filter(function (item) {
                                return item.id == spousesid;
                            })
                        }
                        ;
                    })
                    .catch(err => {
                        console.log(err)
                    })
            },
            spouseschange: function () {
                let _this = this;
                _this.member.spouses = _this.spousesall.filter(function (item) {
                    return item.id == _this.member.spousesid;
                })[0]["name"];
                _this.$forceUpdate();
            },
            memberdetailsjson: function (id) {
                let _this = this;
                this.$axios.post("/memberdetailsjson.action?id=" + id, "")
                    .then(res => {
                        var obj = res['data'];
                        console.log(obj)
                        _this.member = obj['member'];
                    })
                    .catch(err => {
                        console.log(err)
                    })
            },
            updatememberact: function () {
                let _this = this;
                this.$axios.post("/updatememberactjson.action", _this.serializeForm())
                    .then(res => {
                        console.log(res.data);
                        var obj = res.data;
                        this.$message({
                            message: '修改家庭成员信息成功',
                            type: 'success'
                        });
                        _this.$router.push('/FamilyMemberManage');
                    })
                    .catch(err => {
                        console.log(err)
                        this.$message({
                            message: '修改家庭成员信息失败',
                            type: 'error'
                        });
                    })
            },
        },
        created() {
            let _this = this;
            _this.identity = sessionStorage.getItem("identity");
            _this.userinfo = JSON.parse(sessionStorage.getItem("userinfo"));
            _this.$set(_this.member, 'family', _this.userinfo.name);
            _this.$set(_this.member, 'familyid', _this.userinfo.id);
            _this.$set(_this.member, 'gender', '男');
            _this.searchmember();
            _this.searchmember();
            _this.searchmember();
            var id = _this.$route.query.id
            _this.memberdetailsjson(id);
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

