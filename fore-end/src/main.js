import { createApp } from 'vue'
import App from './App.vue'

import router from './router'



// step1：引入 axios
import Axios from 'axios'

// Axios.defaults.baseURL='http://localhost:8081/fphsxt'
Axios.defaults.withCredentials = true;

// step3：使每次请求都会带一个 /api 前缀
Axios.defaults.baseURL = '/api'


// Axios.interceptors.request.use(
//     config => {
//
//       const token = sessionStorage.getItem("token")
//       const username = sessionStorage.getItem("username")
//
//       console.log(username)
//
//       if(config.url.indexOf("?") > 0){
//         config.url = config.url + "&token=" + token + "&username=" + username;
//       }else{
//         config.url = config.url + "?token=" + token + "&username=" + username;
//       }
//
//
//
//       console.log(config.url);
//
//       return config
//     },
//     error => {
//       return Promise.reject(error)
//     })

import ElementPlus from 'element-plus';
import 'element-plus/theme-chalk/index.css';
// import locale from 'element-plusb/locale/lang/zh-cn'

const app = createApp(App)

app.config.errorHandler = function (err, vm, info) {
  console.error(err);
  console.error(vm);
  console.error(info);
  // 忽略错误，不向用户显示
};

app.use(router)
app.use(ElementPlus)

app.config.globalProperties.$axios = Axios

try {
  // 运行可能会抛出错误的代码
  app.mount('#app')
} catch (err) {
  // 处理错误
  console.error(err);
  // 忽略错误，不向用户显示
}






