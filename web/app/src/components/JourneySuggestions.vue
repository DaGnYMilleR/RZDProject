<template>
  <div class="wrapper">
    <div class="header">Какой-то ссаный заголовок</div>
    <div class="suggestions">
      <div
        class="suggestion"
        v-for="suggestion in suggestions"
        :key="suggestion.id"
      >
        {{ suggestion.name }}
      </div>
    </div>
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
