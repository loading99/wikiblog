import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import Home from '../views/Home.vue'

import AdminEbook from '../views/admin/admin-ebook.vue';
import AdminCategory from '../views/admin/admin-category.vue';
import AdminDoc from '../views/admin/admin-doc.vue';
import AdminUser from '../views/admin/admin-user.vue';
import Login from '../views/login.vue';
import DocPage from '../views/doc.vue';
import About from '../views/about.vue';
import Stats from '../views/stats.vue';
import CyberLoading from '../views/designs/cyber.vue';
import CyberCity from '../views/designs/cybercity.vue';
import CyberMessage from '../views/designs/msgbox.vue';
import Page500 from '../views/error/500.vue';
import Page404 from '../views/error/404.vue';
import store from "@/store";
import {Tool} from "@/util/tools";
import {notification} from "ant-design-vue";
import i18n from "@/language/i18n";

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    name: 'Home',
    component: Home,
  },
  {
    path: '/admin/ebook',
    name: 'AdminEbook',
    component: AdminEbook,
  },
  {
    path: '/admin/category',
    name: 'AdminCategory',
    component: AdminCategory,
    meta:{
      loginRequired:true
    }
  },
  {
    path: '/admin/doc',
    name: 'AdminDoc',
    component: AdminDoc,
    meta:{
      loginRequired:true
    }
  },
  {
    path: '/admin/user',
    name: 'AdminUser',
    component: AdminUser,
    meta:{
      loginRequired:true
    }
  },
  {
    path: '/docpage',
    name: 'DocPage',
    component: DocPage
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/about',
    name: 'about',
    component: About
  },
  {
    path: '/stats',
    name: 'Stats',
    component: Stats
  },
  {
    path: '/design/cyber',
    name: 'CyberLoading',
    component: CyberLoading
  },
  // {
  //   path: '/design/cybercity',
  //   name: 'CyberCity',
  //   component: CyberCity
  // },
  {
    path: '/design/cybermsg',
    name: 'CyberMsg',
    component: CyberMessage
  },
  {
    path: '/500',
    name: 'Page500',
    component: Page500
  },
  {
    name: '404',
    path: '/404',
    component: Page404
  },
  {
    path: '/:pathMatch(.*)*',
    redirect: '/404'
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})
/**
 * @param
 * to: 要导去的路由
 * from：从哪个路由来
 * next：要redirect的路由，或者不拦截
 */

router.beforeEach((to, from, next) => {
  // 要不要对meta.loginRequired属性做监控拦截
  if (to.matched.some(function (item) {
    console.log(item, "是否需要登录校验：", item.meta.loginRequired);
    return item.meta.loginRequired
  })) {
    const loginUser = store.state.userstatus;
    if (Tool.isEmpty(loginUser)) {
      notification['error']({
        message:i18n.global.t('message.loginRequired'),
      })
      console.log("用户未登录!");
      next('/login');
    } else {
      next();
    }
  } else {
    next();
  }
});

export default router
