<template>
  <textarea id = 'editor1' name="editor1">
  </textarea>
</template>
<script lang="ts">

import {defineComponent, onMounted, onUpdated, ref, watch} from "vue";
declare const window: any;
export default defineComponent({
  name:'ckeditor',
  props:["content", 'flag','save'],
  emits:["sendContent"],
  setup(props,{emit}){
    let ckEditor: any;
    onMounted(()=>{
      console.log(props.flag)
      ckEditor = window.CKEDITOR.replace("editor1");
    })
    onUpdated(()=>{
      const fun = async ()=> {
        console.log("执行setData！")
        await props.flag[0];
        const t = ref(props.content);
        ckEditor.setData(t.value)
      }
      fun();
      console.log("take a look",props.save)
      const s = ref(props.save);

      if(s.value){
        console.log("emit!")
        emit("sendContent",ckEditor.getData())
      }
    })
  }
})
</script>


<style>
</style>