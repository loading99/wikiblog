<template>

  <body>
  <aside class="sidebar">
    <div class="avatar">
      <img src="../assets/images/avatar.jpg" title="保罗酱"/>
    </div>
    <nav class="nav">
      <a href="#info">Info</a>
      <a href="#skills">Skills</a>
      <a href="#story">Experience</a>
      <a href="#works">Creation</a>
      <a href="#team">Social Media</a>

    </nav>
  </aside>
  <main>
    <section id="info">
      <div class="wrap">
        <h2 class="title">Basic Information</h2>
        <div class="row">
          <div class="col-l-4">
            <p>Name:Zhijian Hu</p>
            <p>English Name：Calum</p>
            <p>Gender: Male</p>
            <p>Address: 400W 113th St. New York, NY</p>
          </div>
          <div class="col-l-4">
            <p>Education: Masters</p>
            <p>GitHub：<a href="/">Link</a></p>
            <p>Email: <a href="zhij311@gmail.com">zhij311@gmail.com</a></p>
          </div>
<!--          <div class="col-l-4">-->
<!--            <p>我是一个热爱钻研计算机技术的青少年，从小开始对计算机有极大的兴趣。目前我专注网站开发领域。我还自己发起建立了一个制作游戏的团队，希望能和大家合作，一同创造出属于我们自己的原创作品。</p>-->
<!--          </div>-->
        </div>
      </div>
    </section>
    <section id="skills">
      <div class="wrap">
        <h2 class="title">Professional Skills</h2>
        <div class="row-scrollable">
          <p>

            <strong class="title3"><fa icon="code" type="fas" class="icons"></fa> Programming Language: </strong>
            <span>Java, Python, R, Matlab, SQL, JavaScript, HTML, CSS3</span>
          </p>
          <p><strong class="title3"><fa icon="tools" type="fas" class="icons"></fa> Frameworks: </strong>
            <span>Hadoop, Flume, Kafka, Spark, Spring Boot/MVC, MyBatis, Vue, Flask, TensorFlow</span>
          </p>
          <p><strong class="title3"><fa icon="database" type="fas" class="icons"></fa> Database/Tools: </strong>
            <span>PostgreSQL, MySQL, HBase, Redis, AWS, IDEA, Docker, Git, Maven.</span>
          </p>
        </div>
      </div>


    </section>

    <section id="story">
      <div class="wrap">
        <h2 class="title">Experience</h2>
        <div class="row">
          <div class="col-m-8">
            <ul class="timeline">
              <li>2021.02: Graduated From Columbia University </li>
              <li>2021.01: Personal Web blog v1.0 Published </li>
              <li>2020.12: Implemented CNN Models to build projects: Neural Style Transfer</li>
              <li>2020.09: Developed Spark Streaming based real time data analysis. See <a href="https://github.com/loading99/big-data" target="_blank">details</a></li>
              <li>2020.06: Joined Inossem Inc. as Full Stack Engineer, developed online consulting web service</li>
              <li>2020.05: Python Flask Based Book trading web development deployed on <a href="https://fisher-book.herokuapp.com/" target="_blank">Heroku</a></li>
              <li>2019.09: Started Graduate University. </li>
              <li>2019.05: Graduation Worldwide Trip. Let's take a break! <a href="/journey" target="_blank">My Journey</a></li>
              <li>2019.03: Graduated From University of California, San Diego</li>
              <li>2019.02-04: MNIST Handwrittern Digit Rcognition RESTful API Deployed in
                <a href="https://hub.docker.com/r/kyurem/handwritten_digit_recognition" target="_blank">Docker</a>
              </li>
              <li>2018.12: Joined Eyecredit Data Service Co. as Data Engineer, implemented ETL with Hadoop</li>
              <li>2015.09.24: Started my journey. Entered University of California, San Diego</li>
            </ul>
          </div>
          <div class="col-m-4 center-fixed">
            <img src="../assets/images/banner4.jpg"/>
          </div>
        </div>
      </div>
    </section>
    <section id="works">
      <div class="wrap">
        <h2 class="title">个人作品</h2>
        <div class="row">
          <div class="col-s-6">
            <div class="works-item">
              <img src="../assets/images/works/binkic-2017.jpg"/>
              <p>缤奇团队 2017 官网</p>
            </div>
          </div>
          <div class="col-s-6">
            <div class="works-item">
              <img src="../assets/images/works/space.jpg"/>
              <p>个人博客</p>
            </div>
          </div>
          <div class="col-s-6">
            <div class="works-item">
              <img src="../assets/images/works/dream.jpg"/>
              <p>梦想主题班会</p>
            </div>
          </div>
          <div class="col-s-6">
            <div class="works-item">
              <img src="../assets/images/works/kico-style.jpg"/>
              <p>Kico Style 响应式框架</p>
            </div>
          </div>
          <div class="col-s-6">
            <div class="works-item">
              <img src="../assets/images/works/robots.jpg"/>
              <p>小缤机器人</p>
            </div>
          </div>
          <div class="col-s-6">
            <div class="works-item">
              <img src="../assets/images/works/single.jpg"/>
              <p>Single 博客主题</p>
            </div>
          </div>
          <div class="col-s-6">
            <div class="works-item">
              <img src="../assets/images/works/kico-player.jpg"/>
              <p>Kico Player 播放器</p>
            </div>
          </div>
          <div class="col-s-6">
            <div class="works-item">
              <img src="../assets/images/works/sweet.jpg"/>
              <p>个人主页 Sweet</p>
            </div>
          </div>
          <div class="col-s-6">
            <div class="works-item">
              <img src="../assets/images/works/binkic-2018.jpg"/>
              <p>缤奇团队 2018 官网</p>
            </div>
          </div>
        </div>
      </div>
    </section>
    <section class="content-d" id="team">
      <div class="wrap">
        <h2 class="title">我的团队</h2>
        <div class="row">
          <div class="col-m-6">
            <p>我的团队 - 缤奇团队由一群热爱科技创新的年轻人所组成，做到了“实际”与“创新”的结合。奇思妙想不乏真正落实。集思广益，生动有趣的创意，尽在缤奇。缤奇团队如今有超过30名成员，各个部门互帮互助，同为一个目标而努力进取着。</p>
            <p>缤奇团队致力于开发原创游戏、动漫等项目。目前我们已完成项目有手机游戏“色块冲刺”、聊天娱乐项目“小缤机器人”等。正在创作项目有解密游戏“月亮湖的秘密”、VR 项目“梦想码头”等。缤奇官网 &amp; 社区已陆续开放。网站采用团队成员自主编写的 CSS3 自适应框架，针对移动设备有布局优化，缤奇团队有着丰富的网站建设技术能力、有独立的画师以及文编。</p>
            <p>团队官网：<a href="XXX">XXX</a></p>
          </div>
          <div class="col-m-6 center">
            <img src="../assets/images/team.png"/>
          </div>
        </div>
      </div>
    </section>
  </main>
  </body>
</template>

<script lang="ts">

import {defineComponent} from "vue";
import {useRoute} from "vue-router";
import store from "@/store";
export default defineComponent({
  name:'About',
  setup(){
    /**
     * First Get route information
     * check if menu item is showed
     */
    const route=useRoute();
    store.commit("setPage",route.path);
  }
})
</script>

<style>
/*定义icon大小*/
i{
  font-size: 1.5em;
}
.icons{
  width: 20px;
}
.HOME{
  top: 18px;
  position: absolute;
  width: 30px;
}
.title3{
  font-family: "Times New Roman", "Times New Roman";
  font-size: 1.2em;
}
</style>

<style scoped>
@import "https://cdn.jsdelivr.net/gh/devicons/devicon@v2.10.1/devicon.min.css";
@import "https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css";
</style>

<style scoped src="../assets/css/kico.css">
</style>
<style scoped src="../assets/css/moreduo.css">
</style>

