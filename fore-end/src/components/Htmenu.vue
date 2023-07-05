<template>
    <div>
        <ul class="metismenu" id="menu" qw-c="menu" v-if="identity === '管理员'">
            <li qw-c="menuitem">
                <a
                        class="has-arrow ai-icon"
                        href="javascript:void()"
                        aria-expanded="false"
                >
                    <i class="flaticon-381-layer-1"></i>
                    <span class="nav-text" qw-c="menuitematext">个人中心</span>
                </a>
                <ul aria-expanded="false" qw-c="menuitemselect">
                    <li><a href="/#/AdminIndex">个人中心</a></li>
                </ul>
            </li>

            <li qw-c="menuitem">
                <a
                        class="has-arrow ai-icon"
                        href="javascript:void()"
                        aria-expanded="false"
                >
                    <i class="flaticon-381-layer-1"></i>
                    <span class="nav-text" qw-c="menuitematext">管理员管理</span>
                </a>
                <ul aria-expanded="false" qw-c="menuitemselect">
                    <li><a href="/#/AddAdmin">添加管理员</a></li>
                    <li><a href="/#/AdminManage">管理员管理</a></li>
                </ul>
            </li>

            <li qw-c="menuitem">
                <a
                        class="has-arrow ai-icon"
                        href="javascript:void()"
                        aria-expanded="false"
                >
                    <i class="flaticon-381-layer-1"></i>
                    <span class="nav-text" qw-c="menuitematext">家族管理</span>
                </a>
                <ul aria-expanded="false" qw-c="menuitemselect">
                    <li><a href="/#/AddFamily">添加家族</a></li>
                    <li><a href="/#/FamilyManage">家族管理</a></li>
                </ul>
            </li>

            <li qw-c="menuitem">
                <a
                        class="has-arrow ai-icon"
                        href="javascript:void()"
                        aria-expanded="false"
                >
                    <i class="flaticon-381-layer-1"></i>
                    <span class="nav-text" qw-c="menuitematext">家庭成员管理</span>
                </a>
                <ul aria-expanded="false" qw-c="menuitemselect">
                    <li><a href="/#/AddMember">添加家庭成员</a></li>
                    <li><a href="/#/MemberManage">家庭成员管理</a></li>
                </ul>
            </li>

            <li qw-c="menuitem">
                <a
                        class="has-arrow ai-icon"
                        href="javascript:void()"
                        aria-expanded="false"
                >
                    <i class="flaticon-381-layer-1"></i>
                    <span class="nav-text" qw-c="menuitematext">人员事件管理</span>
                </a>
                <ul aria-expanded="false" qw-c="menuitemselect">
                    <li><a href="/#/AddIncident">添加人员事件</a></li>
                    <li><a href="/#/IncidentManage">人员事件管理</a></li>
                </ul>
            </li>

            <li qw-c="menuitem">
                <a
                        class="has-arrow ai-icon"
                        href="javascript:void()"
                        aria-expanded="false"
                >
                    <i class="flaticon-381-layer-1"></i>
                    <span class="nav-text" qw-c="menuitematext">退出系统</span>
                </a>
                <ul aria-expanded="false" qw-c="menuitemselect">
                    <li><a @click="exitsystem">退出系统</a></li>
                </ul>
            </li>
        </ul>

        <ul class="metismenu" id="menu" qw-c="menu" v-if="identity === '家族'">
            <li qw-c="menuitem">
                <a
                        class="has-arrow ai-icon"
                        href="javascript:void()"
                        aria-expanded="false"
                >
                    <i class="flaticon-381-layer-1"></i>
                    <span class="nav-text" qw-c="menuitematext">个人中心</span>
                </a>
                <ul aria-expanded="false" qw-c="menuitemselect">
                    <li><a href="/#/FamilyIndex">个人中心</a></li>
                </ul>
            </li>

            <li qw-c="menuitem">
                <a
                        class="has-arrow ai-icon"
                        href="javascript:void()"
                        aria-expanded="false"
                >
                    <i class="flaticon-381-layer-1"></i>
                    <span class="nav-text" qw-c="menuitematext">家庭成员管理</span>
                </a>
                <ul aria-expanded="false" qw-c="menuitemselect">
                    <li><a href="/#/FamilyAddMember">添加家庭成员</a></li>
                    <li><a href="/#/FamilyMemberManage">家庭成员管理</a></li>
                </ul>
            </li>

            <li qw-c="menuitem">
                <a
                        class="has-arrow ai-icon"
                        href="javascript:void()"
                        aria-expanded="false"
                >
                    <i class="flaticon-381-layer-1"></i>
                    <span class="nav-text" qw-c="menuitematext">人员事件管理</span>
                </a>
                <ul aria-expanded="false" qw-c="menuitemselect">
                    <li><a href="/#/FamilyAddIncident">添加人员事件</a></li>
                    <li><a href="/#/FamilyIncidentManage">人员事件管理</a></li>
                </ul>
            </li>

            <li qw-c="menuitem">
                <a
                        class="has-arrow ai-icon"
                        href="javascript:void()"
                        aria-expanded="false"
                >
                    <i class="flaticon-381-layer-1"></i>
                    <span class="nav-text" qw-c="menuitematext">家族树</span>
                </a>
                <ul aria-expanded="false" qw-c="menuitemselect">
                    <li><a href="/#/FamilyFamilyTree">家族树</a></li>
                </ul>
            </li>

            <li qw-c="menuitem">
                <a
                        class="has-arrow ai-icon"
                        href="javascript:void()"
                        aria-expanded="false"
                >
                    <i class="flaticon-381-layer-1"></i>
                    <span class="nav-text" qw-c="menuitematext">退出系统</span>
                </a>
                <ul aria-expanded="false" qw-c="menuitemselect">
                    <li><a @click="exitsystem">退出系统</a></li>
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
            };
        },
        methods: {
            exitsystem() {
                sessionStorage.clear();
                this.$router.push("/Login");
            },
        },
        created() {
            let _this = this;
            this.identity = window.sessionStorage.getItem("identity");
            this.userinfo = JSON.parse(window.sessionStorage.getItem("userinfo"));

            console.log(this.identity);
            console.log(this.userinfo);

            if (!this.identity) {
                this.$message({
                    message: "请先登录",
                    type: "success",
                });
                this.$router.push("/Login");
            }
        },
        mounted() {
        },
    };
</script>

