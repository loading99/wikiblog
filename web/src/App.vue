<template>
  <a-layout>
    <TheHeader></TheHeader>
    <a-layout-content style="padding: 0 0px">
      <router-view/>
    </a-layout-content>
    <TheFooter></TheFooter>
  </a-layout>
</template>

<script lang="ts">
import { UserOutlined, LaptopOutlined, NotificationOutlined } from '@ant-design/icons-vue';
import { defineComponent, ref } from 'vue';
import TheHeader from '@/components/TheHeader.vue';
import TheFooter from '@/components/TheFooter.vue';
export default defineComponent({
  name:"app",
  components: {
    UserOutlined,
    LaptopOutlined,
    NotificationOutlined,
    TheHeader,
    TheFooter,
  },
  setup() {

    return {
      selectedKeys1: ref<string[]>(['2']),
      selectedKeys2: ref<string[]>(['1']),
      openKeys: ref<string[]>(['sub1']),
    };
  },
});
</script>
<style>
#components-layout-demo-top-side .logo {
  float: left;
  width: 120px;
  height: 31px;
  margin: 16px 24px 16px 0;
  background: rgba(255, 255, 255, 0.3);
}

.ant-row-rtl #components-layout-demo-top-side .logo {
  float: right;
  margin: 16px 0 16px 24px;
}

.site-layout-background {
  background: #fff;
}
</style>
