import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Login from '@/components/Login'
import SignUp from '@/components/SignUp'
Vue.use(VueRouter)

const routes = [
  {
    path: '/hello',
    name: 'Home',
    component: Home
  },
  {
    path: '/login',
    name : 'Login',
    component : Login

  },
  {
    path : '/signUp',
    name : 'SignUp',
    component : SignUp
  }
 
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
