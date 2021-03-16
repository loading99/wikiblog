import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import Home from '../views/Home.vue'
import Welcome from '../views/welcome.vue'
import AdminEbook from '../views/admin/admin-ebook.vue'
import AdminCategory from '../views/admin/admin-category.vue'
import Login from '../views/login.vue'
const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/admin-ebook',
    name: 'AdminEbook',
    component: AdminEbook
  },
  {
    path: '/admin-category',
    name: 'AdminCategory',
    component: AdminCategory
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },


]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
