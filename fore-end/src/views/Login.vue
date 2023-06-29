<script setup>
import { reactive } from 'vue'

const form = reactive({
  username: '',
  password: ''
})
</script>

<template>
  <div class="title-container">
    <h3 class="title">用户登录</h3>
  </div>
  <el-form :model="form" label-width="120px">
    <el-form-item label="用户名">
      <el-input v-model="form.username" />
    </el-form-item>
    <el-form-item label="密码">
      <el-input v-model="form.password" type="password" />
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="onSubmit">登 录</el-button>
    </el-form-item>
  </el-form>
</template>

<style scoped>

</style>