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
          查看族谱
        </div>
        <div class="card-body">

          <div id="FamilyChart" class="f3"></div>

        </div>
      </div>
    </div>
    <!-- HTML代码结束 -->


  </div>
</template>
<script>
  import Htmenu from "./Htmenu.vue";
  import f3 from "family-chart";
  import "../../public/static/css/family-chart.css";

  export default {
    name: "Familytree",
    components: {Htmenu},
    data() {
      return {
        admin: {},
        identity: '',
        waterdropall: [],
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

      searchwaterdrop: function () {
        let _this = this;
        this.$axios.post("/searchwaterdropjson.action", "")
                .then(res => {
                  var obj = res['data'];
                  _this.waterdropall = obj['waterdropall'];
                  var fortid = _this.$route.query.id;
                  _this.waterdropall = _this.waterdropall.filter(function (item) {
                    return item.fortid == fortid;
                  });
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
        try {
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
            let alterationArr = _this.waterdropall.map((item) => {
              let tJson = {
                id: item.id,
                data: {
                  gender: item.gender === "男" ? "M" : "F",
                  "first name": item.name,
                  "last name": "",
                  birthday: item.birthday,
                  avatar: "http://localhost:8080/patriarchalclan/resource/uploads/" + item.imagee,
                },
                rels: {
                  children: [],
                  spouses: [],
                },
              };

              _this.waterdropall.forEach((itemm) => {
                if (itemm.id === item.id) return;
                if (itemm.fatherid === item.id) tJson.rels.children.push(itemm.id);
                if (item.fatherid === itemm.id) tJson.rels.father = itemm.id;
                if (itemm.motherid === item.id) tJson.rels.children.push(itemm.id);
                if (item.motherid === itemm.id) tJson.rels.mother = itemm.id;
                if (item.id === itemm.consortid) tJson.rels.spouses.push(itemm.id);
              });

              return tJson;
            });

            return alterationArr;
          }

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
              _this.$router.push('/UpdateWaterdrop?id=' + dataId);
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
              _this.$router.push('/UpdateWaterdrop?id=' + dataId);
            });
          })
        } catch(error) {
          alert("暂未发现家谱数据");
        }
      }, 1000);

      setTimeout(function () {

        if ("") {
          alert("");
        }

      }, 20)
    }
  }
</script>

