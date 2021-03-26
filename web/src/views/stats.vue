<template>
  <div>
    <a-card style="width: 100%">
          <a-row>
            <a-col :span="6">
              <a-statistic title="total Views" :value="statistic.totalView">
                <template #prefix>
                  <arrow-up-outlined/>
                </template>
              </a-statistic>
            </a-col>
            <a-col :span="6">
              <a-statistic title="total Likes" :value="statistic.voteCount">
                <template #suffix>
                  <like-outlined />
                </template>
              </a-statistic>
            </a-col>
            <a-col :span="6">
              <a-statistic title="total Views" :value="statistic.viewCount">
                  <UserOutlined />
              </a-statistic>
            </a-col>
            <a-col :span="6">
              <a-statistic title="Doc Contribution" :value="statistic.docCount">
                <template #suffix>
                  <UserOulined/>
                </template>
              </a-statistic>
            </a-col>
          </a-row>
        </a-card>
    <a-row style="background-color: white">
      <a-col :span="24">
        <div id="main" style="width:100%;height: 500px"></div>
      </a-col>

    </a-row>
  </div>

</template>
<script lang="ts">

import {defineComponent,ref,onMounted} from "vue";
import axios from 'axios';

declare let echarts: any;
export default defineComponent({
  name:'Stats',
  setup(){
    const statistic=ref();
    statistic.value={};

    axios.get('/ebook-snapshot/get-statistic').then((response)=>{
      const data =response.data;
      if(data.success){
        const statisticResp = data.content;
        //Today is index with 1
        statistic.value.viewCount = statisticResp[1].viewCount;
        statistic.value.voteCount = statisticResp[1].voteCount;
      }
    });


    const echart=()=>{
      const chartDom = document.getElementById('main');
      const myChart = echarts.init(chartDom);


      const option = {
        xAxis: {
          type: 'category',
          data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
        },
        yAxis: {
          type: 'value'
        },
        series: [{
          data: [150, 230, 224, 218, 135, 147, 260],
          type: 'line'
        }]
      };

      option && myChart.setOption(option);
    };
    onMounted(()=>{
      echart();
    })

    return {
      statistic,
    }
  }

})
</script>

<style scoped>

</style>