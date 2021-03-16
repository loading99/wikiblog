<template>
  <a-layout style="padding: 24px 0; background: #fff">
    <a-layout-sider width="200" style="background: #fff">
      <a-menu
          mode="inline"
          style="height: 100%"
      >
        <a-sub-menu v-for="item in level1" :key="item.name">
          <template v-slot:title>
            <span>
              <MenuUnfoldOutlined />
              {{item.name}}
            </span>
          </template>
          <a-menu-item v-for="child in item.children" :key="child.name">
            <MailOutlined /><span>{{child.name}}</span>
          </a-menu-item>
        </a-sub-menu>
      </a-menu>
    </a-layout-sider>
    <a-layout-content :style="{ padding: '0 24px', minHeight: '280px' }">
      <a-list item-layout="vertical" size="large" :pagination="pagination" :data-source="ebook">
        <template #renderItem="{ item }">
          <a-list-item key="item.name">
            <template #actions>
          <span v-for="{ type, text } in actions" :key="type">
            <component v-bind:is="type" style="margin-right: 8px" />
            {{ text }}
          </span>
            </template>
            <template #extra>
              <img
                  width="272"
                  alt="logo"
                  src="https://gw.alipayobjects.com/zos/rmsportal/mqaQswcyDLcXyDKnZfES.png"
              />
            </template>
            <a-list-item-meta :description="item.description">
              <template #title>
                <a :href="item.href">{{ item.name }}</a>
              </template>
<!--              <template #avatar><a-avatar :src="item.cover" /></template>-->
            </a-list-item-meta>
          </a-list-item>
        </template>
      </a-list>
    </a-layout-content>
  </a-layout>
</template>

<script lang="ts">
import { defineComponent, onMounted, ref} from 'vue';
import axios from 'axios';
import {message} from "ant-design-vue";
import {Tool} from "@/util/tools";


export default defineComponent({
  name: 'Home',
  setup(){
    const ebook=ref();
    const pagination = {
      onChange: (page: number) => {
        console.log(page);
      },
      pageSize: 4,
    };
    const actions: Record<string, string>[] = [
      { type: 'StarOutlined', text: '156' },
      { type: 'LikeOutlined', text: '156' },
      { type: 'MessageOutlined', text: '2' },
    ];

    /**
     * Query Ebook Data
     * Put Behind the handleCategoryQuery to avoid async error
    */
    const handleEbookQuery=()=>{
      axios.get("/ebook/search", {
        params:{
          page:1,
          size:20
        }
      }).then((response)=>{
        const data=response.data
        ebook.value=data.content.list
      });
    }

    /**
     * 定义侧边栏分类
     * return level1
     */
    const level1=ref();
    const categorys = ref();
    const handleCategoryQuery = () => {
      // 如果不清空现有数据，则编辑保存重新加载数据后，再点编辑，则列表显示的还是编辑前的数据
      categorys.value = [];
      axios.get("/category/list").then((response) => {
        const data = response.data;
        if (data.success) {
          categorys.value=data.content
          level1.value=[];
          level1.value=Tool.array2Tree(categorys.value,0)
          console.log("Tree Structure",level1.value)
          handleEbookQuery()
        } else {
          message.error(data.message);
        }
      });
    };

    const onClick=()=>{
      console.log("------执行点击菜单---------")
    }


    // const ebook2=reactive({books:[]});
    onMounted(()=>{
      handleCategoryQuery();

    });
  return {
    ebook,
    pagination,
    actions,
    onClick,
    level1,
  }

  }
});
</script>
