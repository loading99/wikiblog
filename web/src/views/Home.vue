<template>
  <div class="background" v-show="showWelcome" @click="onClick">
    <div class="message-welcome">
      Hello
    </div>
    <div class="message-click">
      click to start
    </div>
    <div class="clock">
      <span class="hour">{{now.hour}}</span>
      <a-divider style="height: 2px"></a-divider>
      {{now.day}}
    </div>
    <svg class="snowflakes" width="100%" height="100%" preserveAspectRatio="none">
      <circle class="snowflake" cx="79.86%" cy="0%" r="2"></circle>
      <circle class="snowflake" cx="19.29%" cy="0%" r="2.2"></circle>
      <circle class="snowflake" cx="91.72%" cy="0%" r="1.2"></circle>
      <circle class="snowflake" cx="75.4%" cy="0%" r="1.2"></circle>
      <circle class="snowflake" cx="88.52%" cy="0%" r="3.3"></circle>
      <circle class="snowflake" cx="55.08%" cy="29.27%" r="4.2"></circle>
      <circle class="snowflake" cx="51.53%" cy="56.16%" r="1.3"></circle>
      <circle class="snowflake" cx="44.55%" cy="25.24%" r="4.1"></circle>
      <circle class="snowflake" cx="8.43%" cy="27.96%" r="2.3"></circle>
      <circle class="snowflake" cx="52.44%" cy="24.63%" r="2.5"></circle>
      <circle class="snowflake" cx="4.7%" cy="63.74%" r="6.1"></circle>
      <circle class="snowflake" cx="39%" cy="99.29%" r="4.2"></circle>
      <circle class="snowflake" cx="14.95%" cy="14.38%" r="3.2"></circle>
      <circle class="snowflake" cx="68.5%" cy="54.22%" r="1.5"></circle>
      <circle class="snowflake" cx="21.21%" cy="33.18%" r="2.1"></circle>
      <circle class="snowflake" cx="33.14%" cy="55.59%" r="2.2"></circle>
      <circle class="snowflake" cx="99.97%" cy="62.11%" r="2.1"></circle>
      <circle class="snowflake" cx="4.06%" cy="66.49%" r="1.5"></circle>
      <circle class="snowflake" cx="18.14%" cy="36.09%" r="3.2"></circle>
      <circle class="snowflake" cx="45.66%" cy="28.22%" r="2.2"></circle>
      <circle class="snowflake" cx="2.94%" cy="29.84%" r="1.3"></circle>
      <circle class="snowflake" cx="9.41%" cy="61.17%" r="2.0"></circle>
      <circle class="snowflake" cx="43.57%" cy="26.48%" r="1.1"></circle>
      <circle class="snowflake" cx="45.66%" cy="28.22%" r="2.2"></circle>
      <circle class="snowflake" cx="45.66%" cy="28.22%" r="2.2"></circle>
      <circle class="snowflake" cx="43.99%" cy="72.58%" r="1.1"></circle>
      <circle class="snowflake" cx="42.03%" cy="28.39%" r="1.1"></circle>
      <circle class="snowflake" cx="54.78%" cy="20.07%" r="1.3"></circle>
      <circle class="snowflake" cx="3.2%" cy="15.9%" r="1.3"></circle>
      <circle class="snowflake" cx="54.5%" cy="3.22%" r="1.2"></circle>
      <circle class="snowflake" cx="26.2%" cy="62.95%" r="1.2"></circle>
      <circle class="snowflake" cx="39.79%" cy="95.28%" r="0.8"></circle>
      <circle class="snowflake" cx="0.06%" cy="21.82%" r="1.3"></circle>
      <circle class="snowflake" cx="4.6%" cy="1.16%" r="1.5"></circle>
      <circle class="snowflake" cx="68.61%" cy="21.14%" r="1.2"></circle>
      <circle class="snowflake" cx="39.35%" cy="96.96%" r="1.1"></circle>
      <circle class="snowflake" cx="26.71%" cy="73.54%" r="1.2"></circle>
      <circle class="snowflake" cx="25.71%" cy="79.36%" r="1.2"></circle>
      <circle class="snowflake" cx="19.47%" cy="0.01%" r="0.8"></circle>
      <circle class="snowflake" cx="6.65%" cy="39.76%" r="0.9"></circle>
      <circle class="snowflake" cx="0.96%" cy="75.77%" r="1.2"></circle>
      <circle class="snowflake" cx="78.42%" cy="0.84%" r="1.5"></circle>
      <circle class="snowflake" cx="36.08%" cy="18.75%" r="1.1"></circle>
      <circle class="snowflake" cx="13.93%" cy="3.23%" r="0.9"></circle>
      <circle class="snowflake" cx="11.24%" cy="27.98%" r="0.9"></circle>
      <circle class="snowflake" cx="58.55%" cy="54.11%" r="1.2"></circle>
      <circle class="snowflake" cx="13.06%" cy="21.92%" r="1.2"></circle>
      <circle class="snowflake" cx="1.24%" cy="18.93%" r="2.2"></circle>
      <circle class="snowflake" cx="1.19%" cy="32.03%" r="1.7"></circle>
      <circle class="snowflake" cx="20.87%" cy="25.85%" r="2.0"></circle>
      <circle class="snowflake" cx="22.01%" cy="26.54%" r="1.2"></circle>
      <circle class="snowflake" cx="92.34%" cy="22.93%" r="1.3"></circle>
      <circle class="snowflake" cx="55.22%" cy="32.45%" r="1.5"></circle>
      <circle class="snowflake" cx="48.74%" cy="22.8%" r="1.1"></circle>
      <circle class="snowflake" cx="0.41%" cy="79.66%" r="1.1"></circle>
      <circle class="snowflake" cx="46.14%" cy="12.78%" r="1.1"></circle>
      <circle class="snowflake" cx="91.14%" cy="40.32%" r="0.8"></circle>
      <circle class="snowflake" cx="24.03%" cy="20.22%" r="2.0"></circle>
      <circle class="snowflake" cx="13.43%" cy="91.02%" r="1.2"></circle>
      <circle class="snowflake" cx="11.19%" cy="98.08%" r="2.0"></circle>
      <circle class="snowflake" cx="8.9%" cy="96.71%" r="0.8"></circle>
      <circle class="snowflake" cx="77.8%" cy="3.37%" r="1.1"></circle>
      <circle class="snowflake" cx="54.32%" cy="36.79%" r="0.9"></circle>
      <circle class="snowflake" cx="51.7%" cy="27.9%" r="1.1"></circle>
      <circle class="snowflake" cx="32.7%" cy="38.76%" r="1.5"></circle>
      <circle class="snowflake" cx="21.52%" cy="71.59%" r="1.1"></circle>
      <circle class="snowflake" cx="24.8%" cy="57.75%" r="1.2"></circle>
      <circle class="snowflake" cx="3.83%" cy="26.68%" r="1"></circle>
      <circle class="snowflake" cx="71.87%" cy="64.94%" r="0.8"></circle>
      <circle class="snowflake" cx="10.86%" cy="90.31%" r="2.0"></circle>
      <circle class="snowflake" cx="68.11%" cy="70.83%" r="2.0"></circle>
      <circle class="snowflake" cx="28.58%" cy="48.05%" r="1"></circle>
      <circle class="snowflake" cx="18.69%" cy="23.07%" r="1.2"></circle>
      <circle class="snowflake" cx="23%" cy="79.48%" r="1.3"></circle>
      <circle class="snowflake" cx="51.02%" cy="96.91%" r="2.0"></circle>
      <circle class="snowflake" cx="55.17%" cy="32.23%" r="1.2"></circle>
      <circle class="snowflake" cx="23.8%" cy="17.25%" r="1"></circle>
      <circle class="snowflake" cx="55.59%" cy="62.92%" r="1"></circle>
      <circle class="snowflake" cx="44.97%" cy="23.52%" r="1"></circle>
      <circle class="snowflake" cx="16.89%" cy="98.27%" r="1.2"></circle>
      <circle class="snowflake" cx="13.34%" cy="53.01%" r="1.3"></circle>
      <circle class="snowflake" cx="86.01%" cy="25.91%" r="0.8"></circle>
      <circle class="snowflake" cx="66.01%" cy="13.81%" r="1.1"></circle>
      <circle class="snowflake" cx="1.15%" cy="37.27%" r="0.9"></circle>
      <circle class="snowflake" cx="48.03%" cy="51.31%" r="0.8"></circle>
      <circle class="snowflake" cx="59.79%" cy="3.13%" r="2.0"></circle>
      <circle class="snowflake" cx="20.49%" cy="44.72%" r="1.3"></circle>
      <circle class="snowflake" cx="45.01%" cy="4%" r="1.1"></circle>
      <circle class="snowflake" cx="93.93%" cy="22.52%" r="0.9"></circle>
      <circle class="snowflake" cx="98.42%" cy="93.45%" r="1.2"></circle>
      <circle class="snowflake" cx="76.62%" cy="49.08%" r="1.5"></circle>
      <circle class="snowflake" cx="14.82%" cy="91.31%" r="0.8"></circle>
      <circle class="snowflake" cx="92.75%" cy="18.02%" r="1.2"></circle>
      <circle class="snowflake" cx="26.94%" cy="99.64%" r="2.0"></circle>
      <circle class="snowflake" cx="94.68%" cy="38.64%" r="0.9"></circle>
      <circle class="snowflake" cx="16.16%" cy="93.16%" r="0.8"></circle>
      <circle class="snowflake" cx="19.99%" cy="71.84%" r="1.2"></circle>
      <circle class="snowflake" cx="41.02%" cy="90.25%" r="1.2"></circle>
      <circle class="snowflake" cx="7.86%" cy="43.31%" r="0.8"></circle>
      <circle class="snowflake" cx="58.83%" cy="28.92%" r="1"></circle>
      <circle class="snowflake" cx="67.9%" cy="6.74%" r="1"></circle>
      <circle class="snowflake" cx="24.83%" cy="29.36%" r="1.1"></circle>
      <circle class="snowflake" cx="93.41%" cy="26.16%" r="0.9"></circle>
      <circle class="snowflake" cx="72.73%" cy="64.13%" r="0.8"></circle>
      <circle class="snowflake" cx="74.18%" cy="74.75%" r="1.3"></circle>
      <circle class="snowflake" cx="24.38%" cy="22.22%" r="1.2"></circle>
      <circle class="snowflake" cx="44.07%" cy="47.28%" r="1.1"></circle>
      <circle class="snowflake" cx="6.29%" cy="76.22%" r="1.2"></circle>
      <circle class="snowflake" cx="84.06%" cy="16.82%" r="1.2"></circle>
      <circle class="snowflake" cx="3.21%" cy="9.83%" r="1.2"></circle>
      <circle class="snowflake" cx="74.27%" cy="79.13%" r="0.9"></circle>
      <circle class="snowflake" cx="89.7%" cy="14.84%" r="1.3"></circle>
      <circle class="snowflake" cx="71.26%" cy="35.82%" r="1.2"></circle>
      <circle class="snowflake" cx="43.42%" cy="27.18%" r="1.5"></circle>
      <circle class="snowflake" cx="33.09%" cy="79.25%" r="1.3"></circle>
      <circle class="snowflake" cx="12.79%" cy="38.54%" r="1"></circle>
      <circle class="snowflake" cx="5.99%" cy="55.62%" r="0.8"></circle>
      <circle class="snowflake" cx="72.49%" cy="34.76%" r="0.9"></circle>
      <circle class="snowflake" cx="92.94%" cy="62.73%" r="1.2"></circle>
      <circle class="snowflake" cx="97.57%" cy="90.31%" r="2.0"></circle>
      <circle class="snowflake" cx="13.65%" cy="54.31%" r="1.3"></circle>
      <circle class="snowflake" cx="33.95%" cy="72.71%" r="1.1"></circle>
      <circle class="snowflake" cx="81.57%" cy="22.64%" r="1"></circle>
      <circle class="snowflake" cx="64.56%" cy="61.32%" r="1.1"></circle>
      <circle class="snowflake" cx="44.95%" cy="20.38%" r="1.3"></circle>
      <circle class="snowflake" cx="48.21%" cy="43.15%" r="1.1"></circle>
      <circle class="snowflake" cx="14.63%" cy="39.86%" r="1"></circle>
      <circle class="snowflake" cx="24.79%" cy="43.18%" r="1.1"></circle>
      <circle class="snowflake" cx="49.71%" cy="93.15%" r="2.0"></circle>
      <circle class="snowflake" cx="53.42%" cy="24.49%" r="1.2"></circle>
      <circle class="snowflake" cx="64.8%" cy="62.2%" r="1.1"></circle>
      <circle class="snowflake" cx="63.05%" cy="78.68%" r="1.1"></circle>
      <circle class="snowflake" cx="35.67%" cy="28.3%" r="1.1"></circle>
      <circle class="snowflake" cx="35.87%" cy="19.09%" r="1.2"></circle>
      <circle class="snowflake" cx="16.26%" cy="24.52%" r="1.5"></circle>
      <circle class="snowflake" cx="23.06%" cy="67.94%" r="3.2"></circle>
      <circle class="snowflake" cx="9.21%" cy="28.23%" r="1.5"></circle>
      <circle class="snowflake" cx="17.2%" cy="79.86%" r="2.0"></circle>
      <circle class="snowflake" cx="18.45%" cy="15.75%" r="1.3"></circle>
      <circle class="snowflake" cx="85.18%" cy="26.27%" r="2.0"></circle>
      <circle class="snowflake" cx="22.07%" cy="67.07%" r="1"></circle>
      <circle class="snowflake" cx="36.07%" cy="29.12%" r="1.1"></circle>
      <circle class="snowflake" cx="26.52%" cy="66.91%" r="1.3"></circle>
      <circle class="snowflake" cx="12.29%" cy="76.19%" r="1.2"></circle>
      <circle class="snowflake" cx="29.53%" cy="53.13%" r="1.1"></circle>
      <circle class="snowflake" cx="89.73%" cy="12.05%" r="0.8"></circle>
      <circle class="snowflake" cx="16.31%" cy="10.21%" r="0.9"></circle>
      <circle class="snowflake" cx="13.25%" cy="24.11%" r="1.2"></circle>
      <circle class="snowflake" cx="82.96%" cy="65.39%" r="1.1"></circle>
      <circle class="snowflake" cx="20.02%" cy="42.16%" r="0.8"></circle>
      <circle class="snowflake" cx="27.95%" cy="75.92%" r="1.2"></circle>
      <circle class="snowflake" cx="14.93%" cy="71.12%" r="1.2"></circle>
      <circle class="snowflake" cx="85.64%" cy="38.3%" r="1.2"></circle>
      <circle class="snowflake" cx="67.39%" cy="97.64%" r="1.2"></circle>
      <circle class="snowflake" cx="51.13%" cy="62.3%" r="1.1"></circle>
      <circle class="snowflake" cx="47.08%" cy="53.92%" r="1.1"></circle>
      <circle class="snowflake" cx="21.26%" cy="91.68%" r="0.9"></circle>
      <circle class="snowflake" cx="9.04%" cy="44.16%" r="0.8"></circle>
      <circle class="snowflake" cx="88.6%" cy="6.06%" r="1.2"></circle>
      <circle class="snowflake" cx="37.63%" cy="62.48%" r="0.9"></circle>
      <circle class="snowflake" cx="21.98%" cy="76.4%" r="1.1"></circle>
      <circle class="snowflake" cx="16.34%" cy="41.54%" r="1.1"></circle>
      <circle class="snowflake" cx="29.08%" cy="39.5%" r="1.1"></circle>
      <circle class="snowflake" cx="21.68%" cy="13.77%" r="1.3"></circle>
      <circle class="snowflake" cx="4.97%" cy="55.77%" r="0.9"></circle>
      <circle class="snowflake" cx="2.84%" cy="28.99%" r="1.3"></circle>
      <circle class="snowflake" cx="6.88%" cy="6.38%" r="1"></circle>
      <circle class="snowflake" cx="34.29%" cy="27.53%" r="1.2"></circle>
      <circle class="snowflake" cx="68.8%" cy="9.07%" r="1"></circle>
      <circle class="snowflake" cx="47.36%" cy="5.98%" r="0.8"></circle>
      <circle class="snowflake" cx="9.62%" cy="4.22%" r="1"></circle>
      <circle class="snowflake" cx="18.85%" cy="73.03%" r="2.0"></circle>
      <circle class="snowflake" cx="51.25%" cy="70.49%" r="0.8"></circle>
      <circle class="snowflake" cx="95.39%" cy="42.76%" r="1.2"></circle>
      <circle class="snowflake" cx="57.28%" cy="64.38%" r="1"></circle>
      <circle class="snowflake" cx="31.72%" cy="55.67%" r="1.1"></circle>
      <circle class="snowflake" cx="4.9%" cy="31.02%" r="1.2"></circle>
      <circle class="snowflake" cx="0.45%" cy="54.46%" r="1"></circle>
      <circle class="snowflake" cx="58.96%" cy="56.45%" r="1.2"></circle>
      <circle class="snowflake" cx="18%" cy="70.8%" r="1.2"></circle>
      <circle class="snowflake" cx="29.87%" cy="58.15%" r="1.1"></circle>
      <circle class="snowflake" cx="21.15%" cy="20.97%" r="1.1"></circle>
      <circle class="snowflake" cx="7.59%" cy="22.37%" r="1.1"></circle>
      <circle class="snowflake" cx="34.01%" cy="6.05%" r="1.5"></circle>
      <circle class="snowflake" cx="73.12%" cy="54.07%" r="2.0"></circle>
      <circle class="snowflake" cx="35.58%" cy="26.63%" r="2.0"></circle>
      <circle class="snowflake" cx="47%" cy="14.45%" r="1.2"></circle>
      <circle class="snowflake" cx="93.16%" cy="34.29%" r="1.1"></circle>
      <circle class="snowflake" cx="85.98%" cy="56.31%" r="1.2"></circle>
      <circle class="snowflake" cx="39.52%" cy="93.16%" r="1.2"></circle>
      <circle class="snowflake" cx="76.41%" cy="96.88%" r="1.1"></circle>
      <circle class="snowflake" cx="56.59%" cy="44.04%" r="1.2"></circle>
      <circle class="snowflake" cx="65.39%" cy="39.4%" r="1.2"></circle>
      <circle class="snowflake" cx="85.72%" cy="41.72%" r="1.1"></circle>
      <circle class="snowflake" cx="91.58%" cy="64.21%" r="1.2"></circle>
      <circle class="snowflake" cx="50.45%" cy="29.47%" r="1"></circle>
      <circle class="snowflake" cx="4.47%" cy="64.67%" r="1.5"></circle>
      <circle class="snowflake" cx="94.77%" cy="66.64%" r="1.3"></circle>
      <circle class="snowflake" cx="33.93%" cy="60.08%" r="1"></circle>
      <circle class="snowflake" cx="76.57%" cy="74.4%" r="3.2"></circle>
      <circle class="snowflake" cx="98.65%" cy="55.48%" r="2.0"></circle>
      <circle class="snowflake" cx="48.42%" cy="0.02" r="3.2"></circle>
      <circle class="snowflake" cx="45.32%" cy="0.02" r="3.2"></circle>
      <circle class="snowflake" cx="42.12%" cy="0.02" r="3.2"></circle>
      <circle class="snowflake" cx="53.13%" cy="0.02" r="2.7"></circle>
      <circle class="snowflake" cx="62.58%" cy="0.02" r="2.7"></circle>
      <circle class="snowflake" cx="50.23%" cy="0.02" r="2.7"></circle>
      <circle class="snowflake" cx="48.23%" cy="0.02" r="1.6"></circle>
      <circle class="snowflake" cx="45.23%" cy="0.02" r="1.6"></circle>
      <circle class="snowflake" cx="42.23%" cy="0.02" r="1.6"></circle>
      <circle class="snowflake" cx="51.58%" cy="0.02" r="1.6"></circle>
      <circle class="snowflake" cx="62.78%" cy="0.02" r="2.3"></circle>
      <circle class="snowflake" cx="49.89%" cy="20" r="2.3"></circle>

    </svg>
  </div>
  <a-layout v-show="!showWelcome" style="padding: 24px 0; background: #fff">
    <a-layout-sider width="200" style="background: #fff">
      <a-menu
          mode="inline"
          style="height: 100%"
          @click="handleClick"
      >
        <a-menu-item :key="0">
          {{ $t('sider.allcategory') }}
        </a-menu-item>
        <template v-for="item in level1" :key="item.id">
          <template v-if="!item.children">
            <a-menu-item :key="item.id">
              <span>{{ item.name }}</span>
            </a-menu-item>
          </template>
          <template v-else>
            <sub-menu :menu="item" :key="item.id" />
          </template>
        </template>

      </a-menu>
    </a-layout-sider>
    <a-layout-content :style="{ padding: '0 24px', minHeight: '280px' }">
      <h3 v-if="ebook.length==0">{{ $t('message.nothing') }}</h3>
      <a-list item-layout="vertical" size="large" :pagination="pagination" :data-source="ebook">
        <template #renderItem="{ item }">
          <a-list-item key="item.name">
            <template #actions>
              <span>
            <component v-bind:is="'ProfileOutlined'" style="margin-right: 8px"/>
            {{ item.docCount }}
          </span>
              <span>
            <component v-bind:is="'LikeOutlined'" style="margin-right: 8px"/>
            {{ item.voteCount }}
          </span>
              <span>
            <component v-bind:is="'UserOutlined'" style="margin-right: 8px"/>
            {{ item.viewCount }}
          </span>

            </template>
            <template #extra>
              <img
                  width="272"
                  alt="logo"
                  style="width:207.75px;height:137.25px"
                  :src="item.cover || '/cover/emptyCover.png'"
              />
            </template>
            <a-list-item-meta :description="item.description">
              <template #title>
                <router-link :to="'/docpage?ebookId='+item.id">{{ item.name }}</router-link>
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

import {useRoute} from "vue-router";
import store from "@/store";
import moment from 'moment';
import {
  MenuFoldOutlined,
  MenuUnfoldOutlined,
  PieChartOutlined,
  MailOutlined,
} from '@ant-design/icons-vue';
import SubMenu from "@/views/submenu.vue";

export default defineComponent({
  name: 'Home',
  setup(){
    /**
     * First Get route information
     * check if menu item is showed
     */
    const route=useRoute();
    console.log("----Curent----",route.path)
    store.commit("setPage",route.path);

    /**
     * Time Locale render
     */
    const now = ref();
    now.value =
        {
          day: moment(Date.now()).format('MMM DD, YYYY'),
          hour: moment(Date.now()).format('HH:mm')
        }

    setInterval(() => {
      now.value.hour = moment(Date.now()).format('HH:mm')
    }, 1000*58);

    const ebook=ref();
    ebook.value=[];
    const pagination = {
      onChange: (page: number) => {
        console.log(page);
      },
      pageSize: 8,
    };
    // const actions: Record<string, string>[] = [
    //   { type: 'StarOutlined', text: '156' },
    //   { type: 'LikeOutlined', text: '156' },
    //   { type: 'MessageOutlined', text: '2' },
    // ];

    /**
     * Query Ebook Data
     * Put Behind the handleCategoryQuery to avoid async error
    */

    const showWelcome=ref();
    showWelcome.value=true;
    const handleEbookQuery=()=>{
      axios.get("/ebook/search", {
        params:{
          page:1,
          size:100
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
          handleEbookQuery()
        } else {
          message.error(data.message);
        }
      });
    };

    const onClick=()=>{
      console.log("-------欢迎页面进入书籍分类页面--------")
      showWelcome.value=false;
    }

    const handleClick=(value:any)=>{
      console.log("-----Handleclick 参数-----",value);
      axios.get("/ebook/search", {

        params:{
          page: 1,
          size: 100,
          categoryid: value.key
        }
      }).then((response)=>{
        const data=response.data
        if (data.success) {
          ebook.value=data.content.list;
        }else{
          message.error(data.message);
        }
      });
    };

    /**
     * 统计访问数据相关代码
     */
    const visit=()=>{
      axios.post('/stats/add',{
        web: "homepage"
      })
    }


    // const ebook2=reactive({books:[]});
    onMounted(()=>{
      visit();
      handleCategoryQuery();

    });
  return {
    now,
    ebook,
    pagination,
    // actions,

    /**
     * 侧边栏sider
     */
    level1,

    /**
     * 主页和ebook list切换
     */
    onClick,
    showWelcome,

    handleClick,
  }
  },
  components: {
    'sub-menu': SubMenu,
    MenuFoldOutlined,
    MenuUnfoldOutlined,
    PieChartOutlined,
}
});
</script>

<style scoped>
@import "../assets/css/home.css";
</style>
