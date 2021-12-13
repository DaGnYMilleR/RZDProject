<template>
  <div class="wrapper">
    <v-card class="fill-height">
      <div v-if="suggestions.length > 0">
        <v-card
          v-for="suggestion in suggestions"
          :key="suggestion.id"
          class="suggestion"
        >
          <JourneySuggestion />
        </v-card>
      </div>
      <div v-else class="justify-center flex">
        <v-card-title>
          Предложения не найдены. Попробуйте изменить запрос.
        </v-card-title>
      </div>
    </v-card>
  </div>
</template>

<script>
import { MoneyFormatter } from "../utils/MoneyFormatter";
import JourneySuggestion from "./JourneySuggestion";

export default {
  name: "JourneySuggestions",
  components: {
    JourneySuggestion,
  },
  props: {
    suggestions: {
      type: Array,
      default: () => [],
    },
  },
  data: () => ({
    maxRate: 5,
  }),
  methods: {
    formatMoney(value) {
      return MoneyFormatter.format(value);
    },

    select(suggestion) {
      this.$emit("select", suggestion);
    },
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
  margin: 2% 3% 3% 2%;
  height: 30vh;

  img {
    height: 20vh;
  }
}

.button-select {
  position: absolute;
  bottom: 0;
  margin-bottom: 5%;
}
</style>
