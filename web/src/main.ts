import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import Antd, {notification} from 'ant-design-vue'
import "ant-design-vue/dist/antd.css"
import * as Icons from '@ant-design/icons-vue';
import axios from 'axios';
import i18n from './language/i18n';
import { FontAwesomeIcon } from "../plugins/font-awesome";
import {Tool} from "@/util/tools";

axios.defaults.baseURL=process.env.VUE_APP_SERVER;
/**
 * axios拦截器
 */
axios.interceptors.request.use(function (config) {
    console.log('Request Parameters：', config);
    const token=store.state.userstatus.token;
    if(Tool.isNotEmpty(token)){
        config.headers.token=token;
    }
    return config;
}, error => {
    return Promise.reject(error);
});
axios.interceptors.response.use(function (response) {
    console.log('Result：', response.data);
    return response;
}, error => {
    console.log("ERROR CODE",error.response.status);
    if(error.response.status==401){
        notification['error']({
            message:i18n.global.t('message.invalid'),
        });
        console.log("-----Automatically sign out-------");
        store.commit('setUser',{});
        window.location.href='/login'
    }
    router.push({name:"Page500"})
});


const app = createApp(App);
app.use(store).use(router).use(Antd).component("fa", FontAwesomeIcon).use(i18n).mount('#app');


//icons
const icons: any=Icons;
for (const i in icons){
    app.component(i,icons[i]);
}

console.log('Env: ',process.env.NODE_ENV)
console.log('Server: ',process.env.VUE_APP_SERVER)