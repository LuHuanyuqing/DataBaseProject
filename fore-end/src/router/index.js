import { createRouter, createWebHashHistory } from 'vue-router'
import login from '../views/login.vue'

const routes = [
    {
        path: '/',
        component: login
    }
]

const router = createRouter({
    history: createWebHashHistory(),
    routes
})

export default router