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
                    添加家庭成员
                </div>
                <div class="card-body">
                    <form qw-c="operationform" action="#" method="post" enctype="multipart/form-data">
                        <div style="display:none;" class="form-group" qw-c="forminputcomponent">
                            <label qw-c="forminputtext">成员id</label>
                            <input maxlength="-1" name="id" id="id" v-model="waterdrop.id" type="text" qw-c="forminput"
                                   class="form-control">
                        </div>
                        <div class="form-group" qw-c="forminputcomponent">
                            <label qw-c="forminputtext">头像</label>

                            <img onerror='src="/static/error.jpg"'
                                 :src="'http://localhost:8080/patriarchalclan/resource/uploads/' + waterdrop.imagee"
                                 id="imageeimg"
                                 style="width: 100px;height: 100px;margin-bottom: 10px;">
                            <input maxlength="-1" type="hidden" v-model="waterdrop.imagee" name="imagee" id="imagee">
                            <input maxlength="-1" type="file" name="imageefile" id="imageefile"
                                   v-on:change="uploadfile($event,'waterdrop','imagee')" qw-c="forminput"
                                   class="form-control">
                        </div>
                        <div class="form-group" qw-c="formselectcomponent">
                            <label qw-c="formselecttext">家族</label>
                            <input maxlength="-1" type="hidden" name="fort" id="fort" v-model="waterdrop.fort"><select
                                v-model="waterdrop.fortid" v-on:change="fortchange()" name="fortid" id="fortid"
                                class="form-control"
                                qw-c="formselect">
                            <option v-for="item in fortall" :key="item.id" :value="item.id">{{item.name}}</option>
                        </select>
                        </div>
                        <div class="form-group" qw-c="forminputcomponent">
                            <label qw-c="forminputtext">姓名</label>
                            <input maxlength="-1" v-model="waterdrop.name" name="name" id="name" type="text"
                                   qw-c="forminput"
                                   class="form-control">
                        </div>
                        <div class="form-group" qw-c="formselectcomponent">
                            <label qw-c="formselecttext">性别</label>
                            <select v-model="waterdrop.gender" name="gender" id="gender" class="form-control"
                                    qw-c="formselect">
                                <option>男</option>
                                <option>女</option>
                            </select>
                        </div>
                        <div class="form-group" qw-c="forminputcomponent">
                            <label qw-c="forminputtext">生日</label>
                            <input maxlength="-1" v-model="waterdrop.birthday" name="birthday" id="birthday" type="date"
                                   qw-c="forminput" class="form-control">
                        </div>
                        <div class="form-group" qw-c="formselectcomponent">
                            <label qw-c="formselecttext">父亲</label>
                            <input maxlength="-1" type="hidden" name="father" id="father"
                                   v-model="waterdrop.father"><select v-model="waterdrop.fatherid"
                                                                      v-on:change="fatherchange()" name="fatherid"
                                                                      id="fatherid" class="form-control"
                                                                      qw-c="formselect">
                            <option v-for="item in fatherall" :key="item.id" :value="item.id">{{item.name}}</option>
                        </select>
                        </div>
                        <div class="form-group" qw-c="formselectcomponent">
                            <label qw-c="formselecttext">母亲</label>
                            <input maxlength="-1" type="hidden" name="mother" id="mother"
                                   v-model="waterdrop.mother"><select v-model="waterdrop.motherid"
                                                                      v-on:change="motherchange()" name="motherid"
                                                                      id="motherid" class="form-control"
                                                                      qw-c="formselect">
                            <option v-for="item in motherall" :key="item.id" :value="item.id">{{item.name}}</option>
                        </select>
                        </div>
                        <div class="form-group" qw-c="formselectcomponent">
                            <label qw-c="formselecttext">配偶</label>
                            <input maxlength="-1" type="hidden" name="consort" id="consort" v-model="waterdrop.consort"><select
                                v-model="waterdrop.consortid" v-on:change="consortchange()" name="consortid"
                                id="consortid" class="form-control" qw-c="formselect">
                            <option v-for="item in waterdropall" :key="item.id" :value="item.id">{{item.name}}</option>
                        </select>
                        </div>


                        <button class="btn btn-primary" type="button" v-on:click="addwaterdropact()">添加</button>
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
        name: "AddWaterdrop",
        components: {Htmenu},
        data() {
            return {
                waterdrop: {'imagee': '', gender: '男',},
                identity: '',
                fortall: [],
                waterdropall: [],
                motherall: [],
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
            }, searchfort() {
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
                        _this.waterdrop.fortid = _this.fortall[0]["id"];
                        _this.waterdrop.fort = _this.fortall[0]["name"];
                    })
                    .catch(err => {
                        console.log(err)
                    })
            },
            fortchange: function () {
                let _this = this;
                _this.waterdrop.fort = _this.fortall.filter(function (item) {
                    return item.id == _this.waterdrop.fortid;
                })[0]["name"];
                _this.$forceUpdate();
            },
            searchwaterdrop() {
                let _this = this;
                this.$axios.post("/searchwaterdropjson.action", "")
                    .then(res => {
                        _this.waterdropall = res.data.waterdropall;
                        var fatherid = _this.$route.query.fatherid;
                        if (fatherid != null) {
                            _this.waterdropall = _this.waterdropall.filter(function (item) {
                                return item.id == fatherid;
                            })
                        }
                        ;
                        //_this.waterdrop.fatherid = _this.waterdropall[0]["id"];
                        //_this.waterdrop.father = _this.waterdropall[0]["name"];

                        _this.fatherall = _this.waterdropall.filter(item => {
                            console.log(item.gender);
                            return item.gender === '男';
                        })

                        _this.motherall = _this.waterdropall.filter(item => {
                            return item.gender === '女';
                        })
                    })
                    .catch(err => {
                        console.log(err)
                    })
            },
            fatherchange: function () {
                let _this = this;
                _this.waterdrop.father = _this.waterdropall.filter(function (item) {
                    return item.id == _this.waterdrop.fatherid;
                })[0]["name"];
                _this.$forceUpdate();
            },
            motherchange: function () {
                let _this = this;
                _this.waterdrop.mother = _this.motherall.filter(function (item) {
                    return item.id == _this.waterdrop.motherid;
                })[0]["name"];
                _this.$forceUpdate();
            },
            consortchange: function () {
                let _this = this;
                _this.waterdrop.consort = _this.chengyuanall.filter(function (item) {
                    return item.id == _this.waterdrop.consortid;
                })[0]["name"];
                _this.$forceUpdate();
            },
            addwaterdropact: function () {
                let _this = this;
                console.log(_this.serializeForm());
                this.$axios.post("/addwaterdropactjson.action", _this.serializeForm())
                    .then(res => {
                        console.log(res.data);
                        var obj = res.data;
                        _this.$message({
                            message: '添加家庭成员成功',
                            type: 'success'
                        });
                        _this.$router.push('/WaterdropManage');
                    })
                    .catch(err => {
                        console.log(err)
                        _this.$message({
                            message: '添加家庭成员失败',
                            type: 'error'
                        });
                    })
            },
        },
        created() {
            let _this = this;
            _this.identity = sessionStorage.getItem("identity");
            _this.userinfo = JSON.parse(sessionStorage.getItem("userinfo"));
            _this.searchfort();
            _this.searchwaterdrop();
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

