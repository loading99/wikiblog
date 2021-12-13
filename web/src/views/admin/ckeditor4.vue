<template>
  <textarea id = 'editor1' name="editor1">

  </textarea>
</template>
<script lang="ts">

import {defineComponent, onMounted, reactive, ref,} from "vue";
import {message} from "ant-design-vue";
declare const window: any;
export default defineComponent({
  name:'ckeditor',
  props:["content", 'flag'],
  setup(props,{emit}){
    console.log("---start child component----")
    let ckEditor: any;
    onMounted(()=>{
      console.log(props.flag)
      ckEditor = window.CKEDITOR.replace("editor1");
      const fun = async ()=>{
        const res = await props.flag[0];
        const t = ref(props.content);
        console.log('----start to set data-------')
        ckEditor.setData(t.value)
      }
      fun();
      ckEditor.on('change', ()=>{
        emit('sendContent', ckEditor.getData())

      })
    })
  }
})
</script>


<style>
</style>