<template>
  <div>
    <a-card style="width: 100%">
          <a-row>
            <a-col :span="6">
              <a-statistic title="total Visits" :value="statistic.totalView">
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
              <a-statistic title="Doc Views" :value="statistic.viewCount">
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
import {message} from "ant-design-vue";

declare let echarts: any;
export default defineComponent({
  name:'Stats',
  setup(){
    const statistic=ref();
    statistic.value={};

    /**
     * Get Total Web visits overall including doc+ homepage.
     */
    axios.get('/stats/list').then((response)=>{
      const data=response.data;
      if(data.success){
        statistic.value.totalView=data.content;
      }else{
        message.error(data.message);
      }
    })

    axios.get('/ebook-snapshot/get-statistic').then((response)=>{
      const data =response.data;
      if(data.success){
        const statisticResp = data.content;
        //Today is index with 1
        statistic.value.viewCount = statisticResp[1].viewCount;
        statistic.value.voteCount = statisticResp[1].voteCount;
      }
    });


    const initEcharts=(list:any)=>{
      const chartDom = document.getElementById('main');
      const myChart = echarts.init(chartDom);

      const xAxis=[];
      const seriesView=[];
      const seriesVote=[];
      for (let i=0;i<list.length;i++){
        const record=list[i];
        xAxis.push(record.date);
        seriesView.push(record.viewIncrease);
        seriesVote.push(record.voteIncrease);
      }


      const option = {
        title: {
          text: '30天趋势图'
        },
        tooltip: {
          trigger: 'axis'
        },
        legend: {
          data: ['总阅读量','总点赞量']
        },
        grid: {
          left: '1%',
          right: '4%',
          bottom: '3%',
          containLabel: true
        },
        toolbox: {
          feature: {
            saveAsImage: {}
          }
        },
        xAxis: {
          type: 'category',
          boundaryGap: false,
          data: xAxis
        },
        yAxis: {
          type: 'value'
        },
        series: [
          {
            name: '总阅读量',
            type: 'line',
            data: seriesView,
            smooth: true
          },
          {
            name: '总点赞量',
            type: 'line',
            data: seriesVote,
            smooth:true
          },
        ]
      };

      option && myChart.setOption(option);
    };

    const get30DayStats=()=>{
      axios.get('ebook-snapshot/get-30-statistic').then((response)=>{
        const data=response.data;
        if(data.success){
          if(data.success){
            const ststisticList=data.content;
            initEcharts(ststisticList);
          }
        }
      })
    }
    onMounted(()=>{
      get30DayStats();
      statistic.value.docCount="20+";
      //Temporarily set doc count as "20+"
    })

    return {
      statistic,
    }
  }

})
</script>

<style scoped>

</style>