<template>
      <div class="CyberBack">
        <Navigation title="Sakura"/>
          <div class="ui">
            <p>Please wait...</p>
            <svg class="CyberSVG">
              <path fill="transparent" stroke="#FFFFFF" stroke-width="2" d="M 157.5 145.5 L 307 0 L 614 0"
                    class="path"></path>
            </svg>
            <div class="loader-circle">
              <p>Loading...</p>
            </div>
          </div>
          <div class="loader-bar">
            <svg class="CyberSVG">
              <path d="M1 77H234.226 L270 42 H500" stroke="#e5e9ef" stroke-width="2" fill="transparent"/>
              <path d="M0 107H233.035 L280.72 65 H600" stroke="#e5e9ef" stroke-width="2" fill="transparent"/>
              <path d="M1 177H234.226 L280.72 210 H600" stroke="#e5e9ef" stroke-width="2" fill="transparent"/>
              <path d="M0 205H233.035 L270.72 230 H500" stroke="#e5e9ef" stroke-width="2" fill="transparent"/>
              <rect y="130" width="236" height="20" fill="#e5e9ef"/>
              <ellipse cx="500" cy="42" rx="13" ry="13" fill="#e5e9ef"/>
              <circle r="8" transform="matrix(1 0 0 -1 500 42)" fill="white"/>
              <ellipse cx="600" cy="210" rx="15" ry="15" fill="#e5e9ef"/>
              <circle r="8" transform="matrix(1 0 0 -1 600 210)" fill="white"/>
            </svg>
          </div>
          <div id="mask">
            <svg class="CyberSVG">
              <path d="M1 77H234.226 L270 42 H500" stroke="#f25d8e" stroke-width="2" fill="transparent"/>
              <path d="M0 107H233.035 L280.72 65 H600" stroke="#9B4587" stroke-width="2" fill="transparent"/>
              <path d="M1 177H234.226 L280.72 210 H600" stroke="#f25d8e" stroke-width="2" fill="transparent"/>
              <path d="M0 205H233.035 L270.72 230 H500" stroke="#f25d8e" stroke-width="2" fill="transparent"/>
              <rect y="130" width="236" height="20" fill="#f25d8e"/>
              <ellipse cx="500" cy="42" rx="13" ry="13" fill="#f25d8e"/>
              <circle r="8" transform="matrix(1 0 0 -1 500 42)" fill="white"/>
              <ellipse cx="600" cy="210" rx="15" ry="15" fill="#f25d8e"/>
              <circle r="8" transform="matrix(1 0 0 -1 600 210)" fill="white"/>
            </svg>
          </div>
    </div>



</template>
<script lang="ts">

import {defineComponent,onMounted} from "vue";
import Navigation from "@/components/Navigation.vue";
import axios from "axios";
export default defineComponent({
  name:'CyberLoading',

  setup(){
    const visit=()=>{
      axios.post('/stats/add',{
        web: "design"
      });
      console.log("---send visit info-----");
    }
    onMounted(()=>{
      visit();
    });
  },

  components: {
    Navigation
  },
})
</script>


<style scoped>

@import "../../assets/css/cyberloading.scss";
</style>
