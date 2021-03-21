import { createStore} from 'vuex'

const store=createStore({
  state: {
    userstatus:{}
  },
  mutations: {
    setUser(state,user){
      state.userstatus=user;
    }

  },
  actions: {
  },
  modules: {
  }
})
export default store;