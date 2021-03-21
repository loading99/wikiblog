import { createStore} from 'vuex'

declare let SessionStorage: any;
const USER='USER';
const store=createStore({
  state: {
    userstatus:SessionStorage.get(USER) || {}
  },
  mutations: {
    setUser(state,user){
      console.log("---Set User---")
      state.userstatus=user;
      SessionStorage.set(USER,user);
    },
  },
  actions: {
  },
  modules: {
  }
})
export default store;