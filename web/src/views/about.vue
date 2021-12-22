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
      <a href="#works">Design</a>
      <a href="#team">Team and Partners</a>
    </nav>
    <p style="padding: 1em;
      display: block;
      text-align: center;">
      <fa icon="weixin" type="fab" class="icons"></fa> &nbsp;&nbsp;
      <fa icon="instagram" type="fab" class="icons"></fa>&nbsp;&nbsp; &nbsp;
      <a href="https://www.linkedin.com/in/zhijian-hu-93a3ab130" target="_blank" style="color: white"><fa icon="linkedin" type="fab" class="icons" ></fa></a></p>
  </aside>
  <main>
    <section id="info">
      <div class="wrap">
        <h2 class="title">Basic Information</h2>
        <div class="row">
          <div class="col-l-4">
            <p>Name：Calum</p>
            <p>Address: New York, NY</p>
          </div>
          <div class="col-l-4">
            <p>Who am I: A passionate Engineer/A Designer </p>
            <p>GitHub：<a href="/">Link</a></p>
            <p>Email: <a href="zhij311@gmail.com">zhij311@gmail.com</a></p>
          </div>
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
          <p><strong class="title3"><fa icon="photo-video" type="fas" class="icons"></fa> Design Tools: </strong>
            <span>Adobe PhotoShop, Illustrator, Premiere</span>
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
              <li>2021.04: Passed CFA Exam, Level 1 </li>
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
        <h2 class="title">Designs</h2>
        <div class="row">
          <div class="col-s-6">
            <div class="works-item">
              <img src="../assets/images/works/wiki.png"/>
              <p>Personal Web Blog @2021</p>
            </div>
          </div>
          <div class="col-s-6">
            <div class="works-item">
              <img src="../assets/images/works/fisherbook.png"/>
              <p>Fisher Book-A Book trading Website based on Python Flask</p>
            </div>
          </div>
          <div class="col-s-6">
            <div class="works-item">
              <img src="../assets/images/works/Mnist.png"/>
              <p>MNIST Digit Recognition MicroApp@2019</p>
            </div>
          </div>
          <div class="col-s-6">
            <div class="works-item">
              <img src="../assets/images/works/spark.png"/>
              <p>Data Analysis and Visualization based on spark streaming</p>
            </div>
          </div>

        </div>
      </div>
    </section>
    <section class="content-d" id="team">
      <div class="wrap">
        <h2 class="title">Team and Partners</h2>
        <div class="row">
          <div class="col-m-6">
            <p>I appreciate those friends who have either given helpful suggestions or engaged in testing.</p>
            <p>KBSSAMA: <br/><fa icon="envelope" type="fas" class="icons"></fa> &nbsp; kbsaama@gmail.com <br/>
              <fa icon="github" type="fab" class="icons"></fa> &nbsp; https://github.com/sunny2012sha</p>

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

import {defineComponent, onMounted} from "vue";
import {useRoute} from "vue-router";
import store from "@/store";
import axios from "axios";
export default defineComponent({
  name:'About',
  setup(){
    /**
     * First Get route information
     * check if menu item is showed
     */
    const route=useRoute();
    store.commit("setPage",route.path);

    const visit=()=>{
      axios.post('/stats/add',{
        web: "about"
      });
    }
    onMounted(()=>{
      visit();
    });
  }
})
</script>

<style>
/*定义icon大小*/
i{
  font-size: 1.5em;
}
.icons{
  width: 22px;
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

