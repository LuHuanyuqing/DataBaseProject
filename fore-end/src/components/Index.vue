<template>
    <div>

        <div style="height: 104px;line-height: 104px;">
            <div style="width: 1200px;margin: 0 auto;" id="menu">
                <!--<a><img src="1.jpg" style="width: 216px;height: 65px;vertical-align:middle;"></a>-->
                <qtmenu></qtmenu>
            </div>
        </div>


        <div id="jmdiv" style="position: relative;overflow: hidden">
            <a class="sxa" style="left: 30px;top: 50%;" onclick="shangyizhang()"><i class="fa fa-arrow-left"></i></a>
            <div id="lbdiv">
                <img class="lbimg" src="/static/qianduan/1.jpg">
                <img class="lbimg" src="/static/qianduan/1.jpg">
                <img class="lbimg" src="/static/qianduan/1.jpg">
            </div>
            <a class="sxa" style="right: 30px;top: 50%;" onclick="xiayizhang()"><i class="fa fa-arrow-right"></i></a>
        </div>


        <div style="clear: both"></div>


        <!---展示栏开始---->


        <!---展示栏结束---->


        <div style="background-color: #29adeb;margin-top: 100px;">
            <div style="width: 1200px;margin: 0 auto;height: 60px;line-height: 60px;color: white;font-weight: bold;font-weight: 20px;">
                <a style="padding: 0 10px;">全微程序设计</a>
                <a style="padding: 0 10px;">蜀ICP备1515151515号</a>
                <a style="padding: 0 10px;">联系我们</a>
            </div>
        </div>


    </div>
</template>
<script>
    import Qtmenu from "./Qtmenu.vue";

    export default {
        name: "Index",
        components: {Qtmenu},
        data() {
            return {
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
            }, indexjson: function () {
                let _this = this;
                this.$axios.post("/indexjson.action", '')
                    .then(res => {
                        console.log(res);
                        var obj = res['data'];
                    })
                    .catch(err => {
                        console.log(err)
                        this.$message({
                            message: '获取信息失败',
                            type: 'error'
                        });
                    });
            },
        },
        created() {
            let _this = this;
            _this.identity = sessionStorage.getItem("identity");
            _this.indexjson();
        },
        beforeCreate() {

            $("#cssdiv").html("");

            var cssstr = "<link href=\"https://cdn.bootcdn.net/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\" rel=\"stylesheet\"> "
            ;

            $("#cssdiv").html(cssstr);
            $("#jsdiv").html("");

            var jsstr = "<script src=\"http://libs.baidu.com/jquery/1.10.2/jquery.min.js\"><\/script> ";
            setTimeout(function () {
                $("#jsdiv").html(jsstr);
            }, 100);

        },
        mounted() {
            let _this = this;


            setTimeout(function () {

                $(document).ready(function () {
                    $('#menu a').each(function () {
                        if ($($(this))[0].href == String(window.location)) {
                            $(this).css({"color": "white"})
                            $(this).css({"background-color": "#29adeb"})
                        }
                    });
                })

                var state = true;
                var dangqian = 1;
                $("#lbdiv").append($($("#lbdiv .lbimg")[0]).clone(true));
                $("#lbdiv").prepend($($("#lbdiv .lbimg")[$("#lbdiv .lbimg").length - 2]).clone(true));
                $(".lbimg").width($("#jmdiv").width());
                $("#lbdiv").width($("#jmdiv").width() * $("#lbdiv .lbimg").length);
                $("#lbdiv").css({"left": $("#jmdiv").width() * (-1) + "px"});

                function xiayizhang() {
                    if (state) {
                        state = false;
                        var zhangshu = $("#lbdiv .lbimg").length - 2;
                        var imgwidth = $($("#lbdiv .lbimg")[0]).width();
                        if (dangqian == zhangshu) {
                            $("#lbdiv").animate({"left": $('#lbdiv').offset().left - imgwidth}, function () {
                                $("#lbdiv").css({"left": imgwidth * (-1) + "px"});
                                state = true;
                            })
                            dangqian = 1;
                        } else {
                            $("#lbdiv").animate({"left": $('#lbdiv').offset().left - imgwidth}, function () {
                                state = true;
                            })
                            dangqian++
                        }
                    }
                }

                function shangyizhang() {
                    if (state) {
                        state = false;
                        var zhangshu = $("#lbdiv .lbimg").length - 2;
                        var imgwidth = $("#jmdiv").width();
                        if (dangqian == 1) {
                            $("#lbdiv").animate({"left": $('#lbdiv').offset().left + imgwidth}, function () {
                                console.log(-imgwidth * (zhangshu + 1))
                                $("#lbdiv").css({"left": -imgwidth * (zhangshu) + "px"});
                                state = true;
                            })
                            dangqian = zhangshu;
                        } else {
                            $("#lbdiv").animate({"left": $('#lbdiv').offset().left + imgwidth}, function () {
                                state = true;
                            })
                            dangqian--
                        }
                    }
                }

                // setInterval(function () {
                //     xiayizhang();
                // },5000)

                if ("") {
                    alert("");
                }

            }, 20)
        }
    }
</script>
<style>
    * {
        margin: 0;
        padding: 0;
        list-style-type: none;
    }

    a {
        text-decoration: unset;
        color: unset;
        cursor: pointer;
    }
</style>
<style>
    .dhla {
        padding: 15px 25px;
        color: #1b1d21;
        font-size: 16px;
        font-weight: 700;
        transition: 0.3s;
    }

    .dhla:hover {
        color: white;
        background-color: #29adeb;
    }
</style>
<style>
    #jmdiv {
        position: relative;
        overflow: hidden;
        height: 500px;
    }

    #lbdiv {
        position: absolute;
        font-size: 0px;
    }

    .lbimg {
        position: relative;
        height: 500px;
        box-sizing: border-box;
    }

    .sxa {
        position: absolute;
        z-index: 100;
        width: 70px;
        height: 70px;
        line-height: 70px;
        text-align: center;
        border-radius: 50px;
        display: inline-block;
        background-color: white;
        transition: .3s;
    }

    .sxa:hover {
        cursor: pointer;
        color: white;
        background-color: #29adeb;
    }
</style>
<style>
    .cditem {
        position: relative;
        width: 100%;
        margin-bottom: 30px;
        box-sizing: border-box;
        transition: all .2s;
        position: relative;
        border: 1px solid #e6e6e6;
    }

    .cditem:hover {
        box-shadow: 0px 3px 3px 0px rgba(98, 98, 98, 0.62);
        cursor: pointer;
    }
</style>


