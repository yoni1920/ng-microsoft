import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/form',
    name: 'Form',
    component: () => import('../views/FormPage.vue')
  }
]

const router = new VueRouter({
  routes
})

export default router
