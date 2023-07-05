const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  lintOnSave: false,
  publicPath: process.env.BASE_URL,
  configureWebpack: {
    devServer: {
      proxy: {
        "/api":{
          target: 'http://localhost:8081/familytree',
          changeOrigin: true,
          pathRewrite: {
            '^/api': '/'
          }
        }
      },
    },
  },
})
