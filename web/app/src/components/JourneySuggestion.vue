<template>
  <v-container fluid>
    <v-row no-gutters>
      <v-col cols="4" align-self="center" align="center" class="pa-6">
        <img :src="imageUrl" alt="" />
        <v-rating readonly :length="maxRating" :value="rating"></v-rating>
      </v-col>
      <v-col style="position: relative">
        <v-card-title>{{ name }}</v-card-title>
        <v-card-text> Цена: {{ formatMoney(price) }} </v-card-text>
        <v-btn min-width="100%" class="button-select" @click="select"
          >Хочу!</v-btn
        >
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import { MoneyFormatter } from "../utils/MoneyFormatter";

export default {
  name: "JourneySuggestion",
  props: {
    name: {
      type: String,
      default: "",
    },
    imageUrl: {
      type: String,
      default: "",
    },
    rating: {
      type: Number,
      default: 0,
    },
    price: {
      type: Number,
      default: 0,
    },
  },
  data: () => ({
    maxRating: 5,
  }),
  methods: {
    select(ev) {
      this.$emit("click", ev);
    },
    formatMoney(price) {
      return MoneyFormatter.format(price);
    },
  },
};
</script>

<style scoped></style>
