<template>
  <div class="wrapper">
    <v-card class="fill-height">
      <v-card v-for="suggestion in suggestions" :key="suggestion.id" class="mt-3 ml-3 mr-3">
        <v-card-title>{{suggestion.name}}</v-card-title>
      </v-card>
    </v-card>
  </div>
</template>

<script>
export default {
  name: "JourneySuggestions",
  props: {
    suggestions: Array,
  },
};
</script>

<style scoped lang="scss">
.wrapper {
  display: flex;
  height: 100%;
  flex-direction: column;
}

.header {
  background: white;
  color: black;
  padding: 0.3vmax;
  display: flex;
  justify-content: center;
}

.suggestion {
  padding: 1vh;
  background: wheat;
  margin: 1vw;
}
</style>
