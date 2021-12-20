<template>
  <v-container fluid class="wrapper">
    <v-card>
      <v-row no-gutters>
        <v-col cols="4" align-self="center" align="center" class="pa-6">
          <img :src="imageUrl" alt="" style="height: 14vh" />
          <v-rating readonly :length="maxRating" :value="rating"></v-rating>
        </v-col>
        <v-col style="position: relative">
          <v-card-title>{{ name }}</v-card-title>
          <v-card-text>
            Цена за весь период: <strong>{{ formatMoney(price) }}</strong>
          </v-card-text>
        </v-col>
      </v-row>
    </v-card>
  </v-container>
</template>

<script>
import { MoneyFormatter } from "../utils/MoneyFormatter";

export default {
  name: "HotelSuggestion",
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
