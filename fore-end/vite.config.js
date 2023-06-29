import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],
  // 配置server实现外部ip访问
  server:{
    host:"0.0.0.0"
  }
})
