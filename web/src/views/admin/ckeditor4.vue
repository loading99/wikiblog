<template>
  <textarea id = 'editor1' name="editor1">

  </textarea>
</template>
<script lang="ts">

import {defineComponent, onMounted, ref,toRef} from "vue";
declare const window: any;
export default defineComponent({
  name:'ckeditor',
  props:["content"],
  setup(props,{emit}){
    console.log("---start child component----")
    let ckEditor: any;
    onMounted(()=>{
      ckEditor = window.CKEDITOR.replace("editor1");
      console.log('----start to set data-------')
      setTimeout(()=>{
        const t = ref(props.content);
        console.log('props',props.content)
        ckEditor.setData(t.value)
      }, 1000);

      ckEditor.on('change', ()=>{
        emit('sendContent', ckEditor.getData())
      })
    })
  }
})
</script>


<style>
</style>