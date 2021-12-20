<template>
  <v-container fluid style="height: 100%">
    <v-card min-height="100%" align="center">
      <v-img src="@/assets/logo2.png" max-width="40%"></v-img>
      <v-card-title
        class="align-self-center align-center"
        style="width: fit-content"
      >
        <span>
          Вас приветствует приложение РЖД-путешествия. Начните свой путь вместе
          с нами!
        </span>
      </v-card-title>
      <router-link to="journeys" class="text-decoration-none">
        <v-btn height="7vh" width="19vw"> Начать путешествие </v-btn>
      </router-link>
    </v-card>
  </v-container>
</template>

<script>
export default {
  name: "MainPage",
  methods: {},
};
</script>

<style scoped lang="scss">
.main {
  display: flex;
  background: black;
  width: 100%;
  height: 100%;
}
</style>
