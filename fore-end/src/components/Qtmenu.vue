<template>
    <div>


        <a class="dhla" style="margin-left: 300px;" href="/#/Index">首页</a>
        <a class="dhla" href="searchye.html">搜索页</a>
        <a class="dhla" href="detailsye.html">详情页</a>
        <a class="dhla" href="#">个人中心</a>

        <c:if test="${sessionScope.identity == '管理员'}">
            <a class="dhla" href="/#/AdminIndex">个人中心</a>
        </c:if>

        <c:if
                test="${sessionScope.identity == '' || sessionScope.identity == null}">
            <a class="dhla" href="/#/Login">登录</a>
            <a class="dhla" href="/#/Regist">注册</a>
        </c:if>


    </div>
</template>
<script>
    export default {
        name: "Qtmenu",
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

        },
        mounted() {
        }
    }
</script>


