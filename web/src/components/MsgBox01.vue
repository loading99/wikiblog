<template>
    <div id="msgbox01-line">
      <svg
          class="CyberSVG"
          xmlns="http://www.w3.org/2000/svg"
          width="415.5px" height="282.5px">
        <path fill-rule="evenodd"  stroke="rgb(0, 216, 255)" stroke-width="3px" stroke-linecap="butt" stroke-linejoin="miter" fill="none"
              d="M59.363,217.889 L143.292,133.317 L370.412,133.317 "/>
        <path fill-rule="evenodd"  fill="rgb(0, 216, 255)"
              d="M345.111,133.319 L369.765,133.319 L369.765,136.195 L345.111,136.195 L345.111,133.319 Z"/>
        <path fill-rule="evenodd"  fill="rgb(0, 216, 255)"
              d="M274.951,146.127 L307.307,146.127 L307.307,146.773 L274.951,146.773 L274.951,146.127 Z"/>
        <path fill-rule="evenodd"  fill="rgb(0, 216, 255)"
              d="M251.881,140.363 L252.527,140.363 L252.527,147.419 L251.881,147.419 L251.881,140.363 Z"/>
        <path fill-rule="evenodd"  fill="rgb(0, 216, 255)"
              d="M360.162,28.559 L384.829,28.559 L384.829,31.448 L360.162,31.448 L360.162,28.559 Z"/>
        <path fill-rule="evenodd"  fill="rgb(0, 216, 255)"
              d="M81.950,195.182 L123.167,153.963 L125.206,156.001 L83.988,197.220 L81.950,195.182 Z"/>
        <path fill-rule="evenodd"  fill="rgb(0, 216, 255)"
              d="M32.138,251.203 L39.182,251.203 L39.182,251.849 L32.138,251.849 L32.138,251.203 Z"/>
        <path fill-rule="evenodd"  fill="rgb(0, 216, 255)"
              d="M28.286,240.308 L28.932,240.308 L28.932,247.365 L28.286,247.365 L28.286,240.308 Z"/>
      </svg>
    </div>
    <div id="msgbox01-frame">
    </div>

</template>
<script lang="ts">

import {defineComponent} from "vue";

export default defineComponent({
  name:'MsgBox01',
  props:['svgwidth','svgheight',"message"]
})
</script>


<style>

#msgbox01-line{
  position: absolute;
  height: 500px;
  overflow: hidden;
  z-index: 2;
  /*animation: move 4s re;*/
  /*animation-fill-mode: forwards;*/
}
#msgbox01-frame{
  background-image: url("../assets/images/msgbox1.png");
  background-repeat: no-repeat;
  position: absolute;
  width: 100%;
  height: 500px;
  overflow: hidden;
  opacity: 0;
  z-index: 2;
  /*animation: show 4s infinite;*/
}

@keyframes move {
  0%{
    width: 0;
  }
  100%{
    width: 100%;
  }
}
@keyframes contract {
  0%{
    width: 100%;
  }
  100%{
    width: 0%;
  }
}

@keyframes show {
  0%{
    opacity: 0;
  }
  50%{
    opacity: 1;
  }
  100%{
    opacity: 0;
  }
}
</style>