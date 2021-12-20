import Vue from "vue";
import VueRouter from "vue-router";
import MainPage from "../views/MainPage";
import SearchJourneys from "../views/SearchJourneys";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "MainPage",
    component: MainPage,
  },
  {
    path: "/journeys",
    name: "SearchJourneys",
    component: SearchJourneys,
  },
];

const router = new VueRouter({
  routes,
});

export default router;
