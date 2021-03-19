<template>
  <a-layout-header class="header">
  <div class="logo" />
    <a-row type="flex">
      <a-col :flex="9">
        <a-menu
            theme="dark"
            mode="horizontal"
            :style="{ lineHeight: '64px'}"
        >
          <a-menu-item key="home">
            <router-link to="/">{{ $t('header.main') }}</router-link>
          </a-menu-item>
          <a-menu-item key="admin-user">
            <router-link to="/admin/user">{{ $t('header.user') }}</router-link>
          </a-menu-item>
          <a-menu-item key="admin-ebook">
            <router-link to="/admin/ebook">{{ $t('header.admin') }}</router-link>
          </a-menu-item>
          <a-menu-item key="admin-category">
            <router-link to="/admin/category">{{ $t('header.cate') }}</router-link>
          </a-menu-item>
          <a-menu-item key="about">
            <router-link to="/">{{ $t('header.me') }}</router-link>
          </a-menu-item>
        </a-menu>
      </a-col>
      <a-col :flex="1">
        <a-dropdown>
          <template #overlay>
            <a-menu @click="onClick">
              <a-menu-item key="en">
                <ProfileOutlined />
                English
              </a-menu-item>
              <a-menu-item key="ch">
                <ProfileOutlined />
                中文
              </a-menu-item>
              <a-menu-item key="jp">
                <ProfileOutlined />
                日本語
              </a-menu-item>
            </a-menu>
          </template>
          <a-button style="position: absolute;right: 1px;top: 16px">
            {{ $t('header.lang') }}
            <DownOutlined/>
          </a-button>
        </a-dropdown>
      </a-col>
    </a-row>
</a-layout-header>
</template>

<script lang="ts">
import { defineComponent, VNodeChild} from 'vue';
import { DownOutlined } from '@ant-design/icons-vue';
import i18n from "@/language/i18n";
interface MenuInfo {
  key: string;
  keyPath: string[];
  item: VNodeChild;
  domEvent: MouseEvent;
}
export default defineComponent({
  name: 'TheHeader',

  setup(){
    const onClick = ({key}: MenuInfo) => {
      console.log(`click on item ${key}`);
      i18n.global.locale=key;
    };
    return {
      onClick
    };
  },
  components: {
    DownOutlined,
  },
});
</script>

<style lang="less">
@import "../assets/css/common.less";
</style>