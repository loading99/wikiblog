<template>
  <textarea id = 'editor1' name="editor1">

  </textarea>
</template>
<script lang="ts">

import {defineComponent, onMounted, ref} from "vue";
declare const window: any;
export default defineComponent({
  name:'ckeditor',
  props:["content"],
  setup(props){
    const content = ref(props.content);
    let ckEditor;
    onMounted(()=>{
      ckEditor = window.CKEDITOR.replace("editor1");
      ckEditor.setData(content.value)
    })
  }
})
</script>


<style>
</style>