import Vue from 'vue'
import VueRouter from 'vue-router'
import SearchJourneys from "../views/SearchJourneys";

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'SearchJourneys',
    component: SearchJourneys
  },
]

const router = new VueRouter({
  routes
})

export default router
