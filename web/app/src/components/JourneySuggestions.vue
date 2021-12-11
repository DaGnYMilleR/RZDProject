<template>
  <div class="wrapper">
    <v-card class="fill-height">
      <v-card v-for="suggestion in suggestions" :key="suggestion.id" class="suggestion">
        <v-container fluid>
          <v-row no-gutters>
            <v-col cols="4" align-self="center" align="center" class="pa-6">
              <img :src="suggestion.imageUrl"/>
              <v-rating readonly :length="maxRate" :value="suggestion.rating"></v-rating>
            </v-col>
            <v-col style="position: relative">
                  <v-card-title>{{ suggestion.name }}</v-card-title>
                  <v-card-text>
                    Цена: {{ formatMoney(suggestion.price) }}
                  </v-card-text>
                <v-btn @click="select(suggestion)" min-width="100%" class="button-select">Хочу!</v-btn>
            </v-col>
          </v-row>
        </v-container>
      </v-card>
    </v-card>
  </div>
</template>

<script>
import {MoneyFormatter} from "../utils/MoneyFormatter";

export default {
  name: "JourneySuggestions",
  props: {
    suggestions: Array,
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
    }
  }
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
