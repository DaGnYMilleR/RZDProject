<template>
  <div class="wrapper">
    <v-card class="fill-height">
      <div v-if="suggestions.length > 0">
        <JourneySuggestion
          v-for="(journey, id) in suggestions"
          :key="id"
          :journey="journey"
        />
      </div>
      <div v-else class="justify-center flex">
        <v-card-title class="justify-center pa-8">
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

.button-select {
  position: absolute;
  bottom: 0;
  margin-bottom: 5%;
}
</style>
