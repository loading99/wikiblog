<template>
  <a-layout-header class="header" v-if="collapse">
    <a-row type="flex">
      <a-col :flex="16">
        <a-menu
            theme="dark"
            mode="horizontal"
            :style="{ lineHeight: '64px'}"
        >
          <a-menu-item key="home">
            <router-link to="/">{{ $t('header.main') }}</router-link>
          </a-menu-item>
          <a-menu-item key="admin-user" v-if="!!user.account && show">
            <router-link to="/admin/user">{{ $t('header.user') }}</router-link>
          </a-menu-item>
          <a-menu-item key="admin-ebook" v-if="!!user.account && show">
            <router-link to="/admin/ebook">{{ $t('header.admin') }}</router-link>
          </a-menu-item>
          <a-menu-item key="admin-category" v-if="!!user.account && show">
            <router-link to="/admin/category">{{ $t('header.cate') }}</router-link>
          </a-menu-item>
          <a-menu-item key="about">
            <router-link to="/about">{{ $t('header.me') }}</router-link>
          </a-menu-item>
<!--          <a-menu-item key="stats" v-if="show">-->
<!--            <router-link to="/stats">{{ $t('header.stats') }}</router-link>-->
<!--          </a-menu-item>-->
          <a-menu-item key="design" v-if="show">
            <router-link to="/design/cyber">{{ $t('header.design') }}</router-link>
          </a-menu-item>
          <a-menu-item key="Home" style="float:right;right: 30%;">
            <router-link to="/"><fa icon="home" type="fas" class="HOME"></fa></router-link>
          </a-menu-item>
        </a-menu>
      </a-col>
      <a-col :flex="2">
        <a class="login-menu" href="/login" v-show="!user.account">
          <span>{{ $t('header.login') }}</span>
        </a>
        <a class="login-menu"  v-show="!!user.account" >
          <span>{{ $t('message.hello') }}{{ user.name }}| </span>
        </a>
        <a-popconfirm
            title="Confirm Logout?"
            ok-text="Yes"
            cancel-text="No"
            @confirm="logout"
        >
          <a class="login-menu"  v-show="!!user.account" >
            <span>{{ $t('header.logout') }}</span>
          </a>
        </a-popconfirm>
      </a-col>
      <a-col :flex="4">
        <a-dropdown>
          <template #overlay>
            <a-menu @click="onClick">
              <a-menu-item key="en">
                English
              </a-menu-item>
              <a-menu-item key="ch">
                中文
              </a-menu-item>
              <a-menu-item key="jp">
                日本語
              </a-menu-item>
            </a-menu>
          </template>
          <a-button style="position: absolute;top: 16px">
            {{ $t('header.lang') }}
            <DownOutlined/>
          </a-button>
        </a-dropdown>

      </a-col>
    </a-row>
</a-layout-header>
  <div id="CollapseBar" @click="toggle">
    <ArrowUpOutlined
        style="left:50%;top:50%;
        position: absolute;
        transform: scale(2);
        color: #e8e8e8;"

        v-if="collapse"
    />
    <ArrowDownOutlined
        style="left:50%;top:50%;
        position: absolute;
        transform: scale(2);
        color: #e8e8e8;"
        v-if="!collapse"
    />
  </div>
</template>

<script lang="ts">
import {defineComponent, VNodeChild, computed,ref} from 'vue';
import { DownOutlined,ArrowUpOutlined, ArrowDownOutlined} from '@ant-design/icons-vue';
import i18n from "@/language/i18n";
import store from "@/store";
import axios from "axios";

import {message} from "ant-design-vue";
interface MenuInfo {
  key: string;
  keyPath: string[];
  item: VNodeChild;
  domEvent: MouseEvent;
}
export default defineComponent({
  name: 'TheHeader',

  setup(){
    const collapse=ref(true);
    const toggle=()=>{
      collapse.value=!collapse.value;
    };

    /**
     * Header 显示栏目
     * 在About里面 栏目都不显示，在其他URL里都显示
     */
    const show=computed(()=>store.state.page);
    console.log("show 变量",show);

    const user=computed(()=> store.state.userstatus);
    const onClick = ({key}: MenuInfo) => {
      console.log(`switch to language ${key}`);
      i18n.global.locale=key;
    };

    const logout=()=>{
      console.log("-----Start to log out-----")
      axios.get('user/logout/'+user.value.token).then((response)=>{
        const data=response.data;
        if(data.success){
          message.success(i18n.global.t('message.logoutSuccess'));
          console.log("---Reset global value by vuex---");
          store.commit("setUser",{});
          window.location.href='/';
        }else{
          message.error(data.message);
        }
      })
    }
    return {
      user,
      show,
      logout,
      onClick,

      toggle,
      collapse,
    };
  },
  components: {
    ArrowUpOutlined,
    DownOutlined,
    ArrowDownOutlined
  },
});
</script>

<style>
.login-menu
{
  float: left;
  color: white;
}

</style>