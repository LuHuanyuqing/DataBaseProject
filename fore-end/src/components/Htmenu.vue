<template>
  <div>


    <ul class="components" qw-c="menu" v-if="identity === '管理员'">
      <li class="active" qw-c="menuitem"><a href="#homeSubmenu1" data-toggle="collapse" aria-expanded="false"
                                            qw-c="menuitematext">个人中心</a>
        <ul class="collapse" id="homeSubmenu1" qw-c="menuitemselect">

          <li qw-c="menuitemselectitem"><a href="/#/AdminIndex" qw-c="menuitemselectitema menuitemselectitematext">个人中心</a>
          </li>
        </ul>
      </li>

      <li class="active" qw-c="menuitem"><a href="#homeSubmenu2" data-toggle="collapse" aria-expanded="false"
                                            qw-c="menuitematext">管理员管理</a>
        <ul class="collapse" id="homeSubmenu2" qw-c="menuitemselect">

          <li qw-c="menuitemselectitem"><a href="/#/AddAdmin"
                                           qw-c="menuitemselectitema menuitemselectitematext">添加管理员</a></li>
          <li qw-c="menuitemselectitem"><a href="/#/AdminManage" qw-c="menuitemselectitema menuitemselectitematext">管理员管理</a>
          </li>
        </ul>
      </li>

      <li class="active" qw-c="menuitem"><a href="#homeSubmenu3" data-toggle="collapse" aria-expanded="false"
                                            qw-c="menuitematext">家族管理</a>
        <ul class="collapse" id="homeSubmenu3" qw-c="menuitemselect">

          <li qw-c="menuitemselectitem"><a href="/#/AddFort" qw-c="menuitemselectitema menuitemselectitematext">添加家族</a>
          </li>
          <li qw-c="menuitemselectitem"><a href="/#/FortManage"
                                           qw-c="menuitemselectitema menuitemselectitematext">家族管理</a></li>
        </ul>
      </li>

      <li class="active" qw-c="menuitem"><a href="#homeSubmenu4" data-toggle="collapse" aria-expanded="false"
                                            qw-c="menuitematext">家庭成员管理</a>
        <ul class="collapse" id="homeSubmenu4" qw-c="menuitemselect">

          <li qw-c="menuitemselectitem"><a href="/#/AddWaterdrop" qw-c="menuitemselectitema menuitemselectitematext">添加家庭成员</a>
          </li>
          <li qw-c="menuitemselectitem"><a href="/#/WaterdropManage" qw-c="menuitemselectitema menuitemselectitematext">家庭成员管理</a>
          </li>
        </ul>
      </li>

      <li class="active" qw-c="menuitem"><a href="#homeSubmenu5" data-toggle="collapse" aria-expanded="false"
                                            qw-c="menuitematext">成员事件管理</a>
        <ul class="collapse" id="homeSubmenu5" qw-c="menuitemselect">

          <li qw-c="menuitemselectitem"><a href="/#/AddTaste"
                                           qw-c="menuitemselectitema menuitemselectitematext">添加成员事件</a></li>
          <li qw-c="menuitemselectitem"><a href="/#/TasteManage" qw-c="menuitemselectitema menuitemselectitematext">成员事件管理</a>
          </li>
        </ul>
      </li>


      <li class="active" qw-c="menuitem"><a href="#homeSubmenu6" data-toggle="collapse" aria-expanded="false"
                                            qw-c="menuitematext">退出系统</a>
        <ul class="collapse" id="homeSubmenu6" qw-c="menuitemselect">
          <li qw-c="menuitemselectitem"><a @click="exitsystem"
                                           qw-c="menuitemselectitema menuitemselectitematext">退出系统</a></li>
        </ul>
      </li>

    </ul>


    <ul class="components" qw-c="menu" v-if="identity === '家族'">
      <li class="active" qw-c="menuitem"><a href="#homeSubmenu7" data-toggle="collapse" aria-expanded="false"
                                            qw-c="menuitematext">个人中心</a>
        <ul class="collapse" id="homeSubmenu7" qw-c="menuitemselect">

          <li qw-c="menuitemselectitem"><a href="/#/FortIndex" qw-c="menuitemselectitema menuitemselectitematext">个人中心</a>
          </li>
        </ul>
      </li>

      <li class="active" qw-c="menuitem"><a href="#homeSubmenu9" data-toggle="collapse" aria-expanded="false"
                                            qw-c="menuitematext">家庭成员管理</a>
        <ul class="collapse" id="homeSubmenu9" qw-c="menuitemselect">

          <li qw-c="menuitemselectitem"><a href="/#/FortAddWaterdrop" qw-c="menuitemselectitema menuitemselectitematext">添加家庭成员</a>
          </li>
          <li qw-c="menuitemselectitem"><a href="/#/FortWaterdropManage" qw-c="menuitemselectitema menuitemselectitematext">家庭成员管理</a>
          </li>
        </ul>
      </li>

      <li class="active" qw-c="menuitem"><a href="#homeSubmenu10" data-toggle="collapse" aria-expanded="false"
                                            qw-c="menuitematext">成员事件管理</a>
        <ul class="collapse" id="homeSubmenu10" qw-c="menuitemselect">

          <li qw-c="menuitemselectitem"><a href="/#/FortAddTaste"
                                           qw-c="menuitemselectitema menuitemselectitematext">添加成员事件</a></li>
          <li qw-c="menuitemselectitem"><a href="/#/FortTasteManage" qw-c="menuitemselectitema menuitemselectitematext">成员事件管理</a>
          </li>
        </ul>
      </li>

      <li class="active" qw-c="menuitem"><a href="#homeSubmenu11" data-toggle="collapse" aria-expanded="false"
                                            qw-c="menuitematext">族谱查看</a>
        <ul class="collapse" id="homeSubmenu11" qw-c="menuitemselect">

          <li qw-c="menuitemselectitem"><a href="/#/FortFamilytree" qw-c="menuitemselectitema menuitemselectitematext">族谱查看</a>
          </li>
        </ul>
      </li>


      <li class="active" qw-c="menuitem"><a href="#homeSubmenu8" data-toggle="collapse" aria-expanded="false"
                                            qw-c="menuitematext">退出系统</a>
        <ul class="collapse" id="homeSubmenu8" qw-c="menuitemselect">
          <li qw-c="menuitemselectitem"><a @click="exitsystem"
                                           qw-c="menuitemselectitema menuitemselectitematext">退出系统</a></li>
        </ul>
      </li>

    </ul>


  </div>
</template>
<script>
  export default {
    name: "Htmenu",
    data() {
      return {
        identity: "",
        userinfo: {},
      }
    },
    methods: {
      exitsystem() {
        sessionStorage.clear();
        this.$router.push('/Login');
      }
    },
    created() {
      let _this = this;
      this.identity = window.sessionStorage.getItem("identity");
      this.userinfo = JSON.parse(window.sessionStorage.getItem("userinfo"));

      console.log(this.identity);
      console.log(this.userinfo);

      if (!this.identity) {
        this.$message({
          message: '请先登录',
          type: 'success'
        });
        this.$router.push('/Login');
      }

    },
    mounted() {
    }
  }
</script>

