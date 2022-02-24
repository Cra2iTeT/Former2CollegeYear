import Vue from 'vue'
import router from 'vue-router'

import Login from '../components/Login'

Vue.use(router);

export default new router({
  routes: [
    {
      path: '/',
      component: Login
    }
  ]
});