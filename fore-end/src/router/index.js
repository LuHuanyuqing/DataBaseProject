import { createRouter, createWebHashHistory } from "vue-router"

import Login from '@/components/Login'
import Regist from '@/components/Regist'
import AddAdmin from '@/components/AddAdmin'
import AdminManage from '@/components/AdminManage'
import AdminView from '@/components/AdminView'
import UpdateAdmin from '@/components/UpdateAdmin'
import AdminIndex from '@/components/AdminIndex'
import AddIncident from '@/components/AddIncident'
import IncidentManage from '@/components/IncidentManage'
import IncidentView from '@/components/IncidentView'
import UpdateIncident from '@/components/UpdateIncident'
import FamilyIncidentManage from '@/components/FamilyIncidentManage'
import FamilyAddIncident from '@/components/FamilyAddIncident'
import FamilyUpdateIncident from '@/components/FamilyUpdateIncident'
import AddFamily from '@/components/AddFamily'
import FamilyManage from '@/components/FamilyManage'
import FamilyView from '@/components/FamilyView'
import UpdateFamily from '@/components/UpdateFamily'
import FamilyIndex from '@/components/FamilyIndex'
import AddMember from '@/components/AddMember'
import MemberManage from '@/components/MemberManage'
import MemberView from '@/components/MemberView'
import UpdateMember from '@/components/UpdateMember'
import FamilyMemberManage from '@/components/FamilyMemberManage'
import FamilyAddMember from '@/components/FamilyAddMember'
import FamilyUpdateMember from '@/components/FamilyUpdateMember'
import FamilyTree from '@/components/FamilyTree'
import FamilyFamilyTree from '@/components/FamilyFamilyTree'

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
        path: '/AddIncident',
        name: 'AddIncident',
        component: AddIncident
    },
    {
        path: '/IncidentManage',
        name: 'IncidentManage',
        component: IncidentManage
    },
    {
        path: '/IncidentView',
        name: 'IncidentView',
        component: IncidentView
    },
    {
        path: '/UpdateIncident',
        name: 'UpdateIncident',
        component: UpdateIncident
    },
    {
        path: '/FamilyIncidentManage',
        name: 'FamilyIncidentManage',
        component: FamilyIncidentManage
    },
    {
        path: '/FamilyAddIncident',
        name: 'FamilyAddIncident',
        component: FamilyAddIncident
    },
    {
        path: '/FamilyUpdateIncident',
        name: 'FamilyUpdateIncident',
        component: FamilyUpdateIncident
    },
    {
        path: '/AddFamily',
        name: 'AddFamily',
        component: AddFamily
    },
    {
        path: '/FamilyManage',
        name: 'FamilyManage',
        component: FamilyManage
    },
    {
        path: '/FamilyView',
        name: 'FamilyView',
        component: FamilyView
    },
    {
        path: '/UpdateFamily',
        name: 'UpdateFamily',
        component: UpdateFamily
    },
    {
        path: '/FamilyIndex',
        name: 'FamilyIndex',
        component: FamilyIndex
    },
    {
        path: '/AddMember',
        name: 'AddMember',
        component: AddMember
    },
    {
        path: '/MemberManage',
        name: 'MemberManage',
        component: MemberManage
    },
    {
        path: '/MemberView',
        name: 'MemberView',
        component: MemberView
    },
    {
        path: '/UpdateMember',
        name: 'UpdateMember',
        component: UpdateMember
    },
    {
        path: '/FamilyMemberManage',
        name: 'FamilyMemberManage',
        component: FamilyMemberManage
    },
    {
        path: '/FamilyAddMember',
        name: 'FamilyAddMember',
        component: FamilyAddMember
    },
    {
        path: '/FamilyUpdateMember',
        name: 'FamilyUpdateMember',
        component: FamilyUpdateMember
    },
    {
        path: '/FamilyTree',
        name: 'FamilyTree',
        component: FamilyTree
    },
    {
        path: '/FamilyFamilyTree',
        name: 'FamilyFamilyTree',
        component: FamilyFamilyTree
    }
]
export const router = createRouter({
    history: createWebHashHistory(),
    routes: routes
})

export default router