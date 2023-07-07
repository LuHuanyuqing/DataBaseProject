import { createRouter, createWebHashHistory } from "vue-router"

import Login from '@/components/Login'
import Regist from '@/components/Regist'
import AddAdmin from '@/components/AddAdmin'
import AdminManage from '@/components/AdminManage'
import AdminView from '@/components/AdminView'
import UpdateAdmin from '@/components/UpdateAdmin'
import AdminIndex from '@/components/AdminIndex'
import AddTaste from '@/components/AddTaste'
import TasteManage from '@/components/TasteManage'
import TasteView from '@/components/TasteView'
import UpdateTaste from '@/components/UpdateTaste'
import FortTasteManage from '@/components/FortTasteManage'
import FortAddTaste from '@/components/FortAddTaste'
import FortUpdateTaste from '@/components/FortUpdateTaste'
import AddFort from '@/components/AddFort'
import FortManage from '@/components/FortManage'
import FortView from '@/components/FortView'
import UpdateFort from '@/components/UpdateFort'
import FortIndex from '@/components/FortIndex'
import AddWaterdrop from '@/components/AddWaterdrop'
import WaterdropManage from '@/components/WaterdropManage'
import WaterdropView from '@/components/WaterdropView'
import UpdateWaterdrop from '@/components/UpdateWaterdrop'
import FortWaterdropManage from '@/components/FortWaterdropManage'
import FortAddWaterdrop from '@/components/FortAddWaterdrop'
import FortUpdateWaterdrop from '@/components/FortUpdateWaterdrop'
import Familytree from '@/components/Familytree'
import FortFamilytree from '@/components/FortFamilytree'

const routes = [
    {
        path: '/',
        name: 'Moren',
        component: Login
    },
    {
        path: '/Login',
        name: 'Login',
        component: Login
    },
    {
        path: '/Regist',
        name: 'Regist',
        component: Regist
    },
    {
        path: '/AddAdmin',
        name: 'AddAdmin',
        component: AddAdmin
    },
    {
        path: '/AdminManage',
        name: 'AdminManage',
        component: AdminManage
    },
    {
        path: '/AdminView',
        name: 'AdminView',
        component: AdminView
    },
    {
        path: '/UpdateAdmin',
        name: 'UpdateAdmin',
        component: UpdateAdmin
    },
    {
        path: '/AdminIndex',
        name: 'AdminIndex',
        component: AdminIndex
    },
    {
        path: '/AddTaste',
        name: 'AddTaste',
        component: AddTaste
    },
    {
        path: '/TasteManage',
        name: 'TasteManage',
        component: TasteManage
    },
    {
        path: '/TasteView',
        name: 'TasteView',
        component: TasteView
    },
    {
        path: '/UpdateTaste',
        name: 'UpdateTaste',
        component: UpdateTaste
    },
    {
        path: '/FortTasteManage',
        name: 'FortTasteManage',
        component: FortTasteManage
    },
    {
        path: '/FortAddTaste',
        name: 'FortAddTaste',
        component: FortAddTaste
    },
    {
        path: '/FortUpdateTaste',
        name: 'FortUpdateTaste',
        component: FortUpdateTaste
    },
    {
        path: '/AddFort',
        name: 'AddFort',
        component: AddFort
    },
    {
        path: '/FortManage',
        name: 'FortManage',
        component: FortManage
    },
    {
        path: '/FortView',
        name: 'FortView',
        component: FortView
    },
    {
        path: '/UpdateFort',
        name: 'UpdateFort',
        component: UpdateFort
    },
    {
        path: '/FortIndex',
        name: 'FortIndex',
        component: FortIndex
    },
    {
        path: '/AddWaterdrop',
        name: 'AddWaterdrop',
        component: AddWaterdrop
    },
    {
        path: '/WaterdropManage',
        name: 'WaterdropManage',
        component: WaterdropManage
    },
    {
        path: '/WaterdropView',
        name: 'WaterdropView',
        component: WaterdropView
    },
    {
        path: '/UpdateWaterdrop',
        name: 'UpdateWaterdrop',
        component: UpdateWaterdrop
    },
    {
        path: '/FortWaterdropManage',
        name: 'FortWaterdropManage',
        component: FortWaterdropManage
    },
    {
        path: '/FortAddWaterdrop',
        name: 'FortAddWaterdrop',
        component: FortAddWaterdrop
    },
    {
        path: '/FortUpdateWaterdrop',
        name: 'FortUpdateWaterdrop',
        component: FortUpdateWaterdrop
    },
    {
        path: '/Familytree',
        name: 'Familytree',
        component: Familytree
    },
    {
        path: '/FortFamilytree',
        name: 'FortFamilytree',
        component: FortFamilytree
    }
]
export const router = createRouter({
    history: createWebHashHistory(),
    routes: routes
})

export default router