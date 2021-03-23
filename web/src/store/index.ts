import { createStore} from 'vuex'

declare let SessionStorage: any;
const USER='USER';
const store=createStore({
  state: {
    userstatus:SessionStorage.get(USER) || {},
    page:true,
  },
  mutations: {
    setUser(state,user){
      console.log("---Set User---")
      state.userstatus=user;
      SessionStorage.set(USER,user);
    },
    setPage(state,Page){
      console.log("----Set Page---");
      if(Page=='/about'){
        state.page=false;
      }else{
        state.page=true;
      }
    }
  },
  actions: {
  },
  modules: {
  }
})
export default store;