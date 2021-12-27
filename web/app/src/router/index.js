import Vue from "vue";
import VueRouter from "vue-router";
import JourneyModal from "../views/JourneyModal";
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
  {
    path: "/journey",
    name: "JourneyModal",
    component: JourneyModal,
    props: (route) => ({ ...route.params }),
  },
];

const router = new VueRouter({
  routes,
});

export default router;
