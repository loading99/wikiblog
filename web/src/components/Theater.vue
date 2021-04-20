<template>
  <div id="pinter">
    {{text}}
  </div>
</template>
<script lang="ts">

import {defineComponent,ref} from "vue";
export default defineComponent({
  name:'Theater',
  setup(){
    console.log("----Theater----");
    const s="Cybernetics is a transdisciplinary approach for exploring regulatory and purposive " +
        "systems—their structures, constraints, and possibilities. The core concept of the discipline is circular causality or feedback—that is, where the outcomes of actions are taken as inputs for further action. Cybernetics is concerned with such processes however they are embodied,[2] including in environmental, technological, biological, cognitive, and social systems, and in the context of practical activities such as designing, learning, managing, and conversation."
    const text=ref("");
    let index=0;

    const print=setInterval(()=>{
      if(s.length==index){
        clearInterval(print);
        console.log("----停止-----");
      }
      text.value=text.value+s.charAt(index);
      index=index+1;
    },200);



    return{
      text
    }

  }
})
</script>


<style>
.ityped-cursor{
  font-size: 2.2rem;
  opacity: 1;
  -webkit-animation: blink 0.3s infinite;
  -moz-animation: blink 0.3s infinite;
  animation: blink 0.3s infinite;
  animation-direction: alternate;
}
@keyframes blink {
  100% {
    opacity: 0;
  }
}

@-webkit-keyframes blink {
  100% {
    opacity: 0;
  }
}

@-moz-keyframes blink {
  100% {
    opacity: 0;
  }
}
</style>