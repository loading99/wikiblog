<template>
  <div class="design-nav">
    <menu-unfold-outlined
        @click="collapse"
    />
    <div class="design-menu" :style="styleObject">
      <li><router-link to="/design/cyber">Cyber</router-link></li>
      <li><router-link to="/design/cybercity">Cyber City</router-link></li>
      <li><a href="#">Spring</a></li>
      <li><a href="#">Spring</a></li>
    </div>
  </div>
</template>

<script lang="ts">

import {defineComponent,ref} from "vue";
import {MenuUnfoldOutlined} from '@ant-design/icons-vue';
export default defineComponent({
  name:'Navigation',
  setup(){
    const styleObject=ref(
        {width: '480px'
        });
    const openKeys=ref();
    openKeys.value=true;

    const collapse=()=>{
      if(openKeys.value){
        styleObject.value.width='0px';
      }else {
        styleObject.value.width='480px';
      }
      openKeys.value=!openKeys.value;
    }

    return{
      collapse,
      styleObject
    }
  },
  components: {
    MenuUnfoldOutlined,
  },
})
</script>

<style>
.design-menu{
  display: flex;
  justify-content: center;
  align-items: center;
}

.design-nav{
  display: inline-flex;
  left:35%;
  height:30px;
  padding: 0 10px 0px 10px;
  justify-content: center;
  align-items: center;
  position: relative;
  background-color: #fff;
  z-index: 2;
  border-radius: 50px;
  overflow: hidden;
  opacity: 0.7;
}
.design-menu{
  margin: 0;
  padding: 0;
  height: 100%;
  overflow: hidden;
  transition: 0.5s;
}
.design-menu li{
  list-style: none;
  padding: 0 20px 0px 20px;
}
.design-menu li a{
  color: #666;
}
.design-menu li:hover{
  height: 100%;
  border-radius: 50px;
  background-color: #eb9c26;
}
</style>