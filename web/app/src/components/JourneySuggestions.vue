<template>
  <div class="wrapper">
    <v-card class="fill-height">
      <div v-if="suggestions.length > 0">
        <JourneySuggestion
          v-for="(journey, id) in suggestions"
          :key="id"
          :journey="journey"
          @click="select(journey)"
        />
      </div>
      <div v-else class="justify-center flex">
        <v-card-title class="justify-center pa-8">
          Предложения не найдены. Попробуйте изменить запрос.
        </v-card-title>
        <div class="justify-center align-self-center" style="display: flex">
          <v-btn @click="openSettings()">Найти предложения</v-btn>
        </div>
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

    openSettings() {
      this.$emit("open-settings");
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
