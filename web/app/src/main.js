import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import Vuex from "vuex";
import vuetify from "./plugins/vuetify";
import "./plugins/vuetify-money.js";

Vue.config.productionTip = false;

new Vue({
  router,
  Vuex,
  vuetify,
  render: (h) => h(App),
}).$mount("#app");
