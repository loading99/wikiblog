<template>
  <a-sub-menu :key="menu.id">
    <template #title>
        <span>
          <MailOutlined /><span>{{ menu.name }}</span>
        </span>
    </template>
    <template v-for="item in menu.children" :key="item.id">
      <template v-if="!item.children">
        <a-menu-item :key="item.id">
          <PieChartOutlined />
          <span>{{ item.name }}</span>
        </a-menu-item>
      </template>
      <template v-else>
        <sub-menu :menu="item" :key="item.key" />
      </template>
    </template>
  </a-sub-menu>

</template>

<script lang="ts">
import { defineComponent } from "vue";
import { SmileOutlined } from "@ant-design/icons-vue";

export default defineComponent({
  name: "SubMenu",
  props: {
    menu: {
      type: Object,
      required: true,
    },
  },
  setup() {
    return {};
  },
  components: {
    SmileOutlined,
  },
});

</script>