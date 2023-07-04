<template>
  <div>
    <el-card class="box-card">
      <div slot="header" class="clearfix">
        <span style="width:40px;height:40px;line-height: 40px;">用户信息</span>
        <el-button type="primary" icon="el-icon-edit" circle style="float:right" />
      </div>
      <el-row :gutter="20">
        <el-col :span="4">
          <div class="text item" style="line-height:2; box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04); font-size:20px; text-align: center">
            姓名
          </div>
        </el-col>
        <el-col :span="20">
          <div class="text item" style="line-height:2; box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04); font-size:20px">
            张三
          </div>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="4">
          <div class="text item" style="line-height:2; box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04); font-size:20px; text-align: center">
            性别
          </div>
        </el-col>
        <el-col :span="20">
          <div class="text item" style="line-height:2; box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04); font-size:20px">
            男
          </div>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="4">
          <div class="text item" style="line-height:2; box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04); font-size:20px; text-align: center">
            电话
          </div>
        </el-col>
        <el-col :span="20">
          <div class="text item" style="line-height:2; box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04); font-size:20px">
            11111111111
          </div>
        </el-col>
      </el-row>
      <el-row :gutter="20">
        <el-col :span="4">
          <div class="text item" style="line-height:2; box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04); font-size:20px; text-align: center">
            邮箱
          </div>
        </el-col>
        <el-col :span="20">
          <div class="text item" style="line-height:2; box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04); font-size:20px">
            zhangsan@qq.com
          </div>
        </el-col>
      </el-row>
    </el-card>
  </div>
</template>

<script>

</script>

<style>
.text {
  font-size: 14px;
}

.item {
  margin-bottom: 18px;
}

.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}
.clearfix:after {
  clear: both
}

.box-card {
  width: 480px;
}
</style>
