<template>
    <div>
        <div id="main-wrapper">
            <div class="nav-header">
                <a href="manageye.html" class="brand-logo">
                    <span style="font-size: 22px; color: #000">家谱管理系统</span>
                </a>
            </div>
            <div class="deznav">
                <div class="deznav-scroll">
                    <htmenu></htmenu>
                </div>
            </div>
            <div class="content-body" style="padding-top: 0">
                <div class="container-fluid">
                    <div class="page-titles">
                        <h4 qw-c="operationname">家族树展示</h4>
                    </div>
                    <div class="row">
                        <div class="col-xl-9 col-lg-9">
                            <div class="card">
                                <div class="card-body">
                                    <div class="basic-form">

                                        <div id="FamilyChart" class="f3"></div>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="footer">
                <div class="copyright">
                    <p>© 家谱管理系统</p>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
    import Htmenu from "./Htmenu.vue";
    import f3 from "family-chart";
    import "../../public/static/css/family-chart.css";

    export default {
        name: "AddAdmin",
        components: {Htmenu},
        data() {
            return {
                admin: {},
                identity: "",
                memberall: [],
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

            searchmember: function () {
                let _this = this;
                this.$axios
                    .post("/searchmemberjson.action", "")
                    .then((res) => {
                        var obj = res["data"];
                        _this.memberall = obj["memberall"];
                        var familyid = _this.$route.query.familyid;
                        _this.memberall = _this.memberall.filter(function (item) {
                            return item.familyid == familyid;
                        });
                    })
                    .catch((err) => {
                        console.log(err);
                    });
            },

        },
        created() {
            let _this = this;
            _this.identity = sessionStorage.getItem("identity");
            _this.userinfo = JSON.parse(sessionStorage.getItem("userinfo"));
            _this.searchmember();
        },
        beforeCreate() {
            $("#cssdiv").html("");

            var cssstr =
                '<link rel="icon" type="image/png" sizes="16x16" href="https://www.17sucai.com/2021/6/khlrr10467/images/favicon.png"> ' +
                '<link href="/static/houtai/css/bootstrap-select.min.css" rel="stylesheet"> ' +
                '<link href="/static/houtai/css/style.css" rel="stylesheet"> ' +
                '<link href="/static/houtai/css/css2.css" rel="stylesheet"> ';
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
                const store = f3.createStore({
                        data: data(),
                        node_separation: 250,
                        level_separation: 150,
                    }),
                    view = f3.d3AnimationView({
                        store,
                        cont: document.querySelector("#FamilyChart"),
                    }),
                    Card = f3.elements.Card({
                        store,
                        svg: view.svg,
                        card_dim: {
                            w: 220,
                            h: 70,
                            text_x: 75,
                            text_y: 15,
                            img_w: 60,
                            img_h: 60,
                            img_x: 5,
                            img_y: 5,
                        },
                        card_display: [
                            (d) => `${d.data["first name"] || ""} ${d.data["last name"] || ""}`,
                            (d) => `${d.data["birthday"] || ""}`,
                        ],
                        mini_tree: true,
                        link_break: false,
                    });

                view.setCard(Card);
                store.setOnUpdate((props) => view.update(props || {}));
                store.update.tree({initial: true});

                function data() {
                    let alterationArr = _this.memberall.map((item) => {
                        let tJson = {
                            id: item.id,
                            data: {
                                gender: item.gender === "男" ? "M" : "F",
                                "first name": item.name,
                                "last name": "",
                                birthday: item.birthday,
                                avatar: "http://localhost:8081/familytree/resource/uploads/" + item.avatar,
                            },
                            rels: {
                                children: [],
                                spouses: [],
                            },
                        };

                        _this.memberall.forEach((itemm) => {
                            if (itemm.id === item.id) return;
                            if (itemm.fatherid === item.id) tJson.rels.children.push(itemm.id);
                            if (item.fatherid === itemm.id) tJson.rels.father = itemm.id;
                            if (itemm.motherid === item.id) tJson.rels.children.push(itemm.id);
                            if (item.motherid === itemm.id) tJson.rels.mother = itemm.id;
                            if (item.spousesid === itemm.id) tJson.rels.spouses.push(itemm.id);
                        });

                        return tJson;
                    });

                    return alterationArr;
                }
            }, 1000);

            setTimeout(function () {
                const cardMaleAll = document.querySelectorAll('.card-male');
                cardMaleAll.forEach(item => {
                    console.log(item);
                    item.addEventListener('click', function (e) {
                        const dataId = e.currentTarget.getAttribute('data-id');
                        console.log(dataId);
                        if (dataId.length > 5) {
                            alert('请刷新后重试');
                            return;
                        }
                        _this.$router.push('/FamilyUpdateMember?id=' + dataId);
                    });
                })

                const cardFemaleAll = document.querySelectorAll('.card-female');
                cardFemaleAll.forEach(item => {
                    console.log(item);
                    item.addEventListener('click', function (e) {
                        const dataId = e.currentTarget.getAttribute('data-id');
                        console.log(dataId);
                        if (dataId.length > 5) {
                            alert('请刷新后重试');
                            return;
                        }
                        _this.$router.push('/FamilyUpdateMember?id=' + dataId);
                    });
                })
                alert('页面加载完成');
            }, 10000)

            setTimeout(function () {
                if ("") {
                    alert("");
                }
            }, 20);
        },
    };
</script>

