<template>
  <v-app>
    <v-app-bar app color="white" dark>
      <div class="d-flex align-center" style="color: red">РЖД проект</div>

      <v-spacer></v-spacer>

      <v-btn href="https://www.rzd.ru/" target="_blank" text>
        <v-img
          src="@/assets/images/rzd_icon.png"
          contain
          max-width="70"
          max-height="70"
        ></v-img>
      </v-btn>
    </v-app-bar>
    <v-main>
      <transition name="fade">
        <router-view />
      </transition>
    </v-main>
    <v-footer app>Курсовая работа</v-footer>
  </v-app>
</template>

<script>
export default {
  name: "App",

  data: () => ({
    //
  }),
};
</script>

<style lang="scss">
@import "./assets/css/Transition";
*::-webkit-scrollbar {
  width: 0;
}
</style>
