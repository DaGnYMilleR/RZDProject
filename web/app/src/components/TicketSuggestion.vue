<template>
  <v-container fluid class="wrapper">
    <v-card class="mt-1 pa-2">
      <v-card-title>Билет</v-card-title>
      <v-card-subtitle
        >Суммарная стоимость <strong>{{ getCost() }}</strong></v-card-subtitle
      >
      <TicketSpan
        :city="cityFrom"
        :date-range="travellingTime.fromPlace"
        :url="urlFrom"
      />
      <v-spacer></v-spacer>
      <TicketSpan
        :city="cityTo"
        :date-range="travellingTime.toPlace"
        :url="urlTo"
      />
    </v-card>
  </v-container>
</template>

<script>
import { City } from "../models/entity/City";
import { TravellingTime } from "../models/entity/TravellingTime";
import { MoneyFormatter } from "../utils/MoneyFormatter";
import TicketSpan from "./TicketSpan";

export default {
  name: "TicketSuggestion",
  components: { TicketSpan },
  props: {
    cityFrom: {
      type: City,
      default: () => City.Null,
    },
    cityTo: {
      type: City,
      default: () => City.Null,
    },
    urlTo: {
      type: String,
      default: "",
    },
    urlFrom: {
      type: String,
      default: "",
    },
    travellingTime: {
      type: TravellingTime,
      default: () => TravellingTime.Null,
    },
    cost: {
      type: Number,
      default: 0,
    },
  },
  methods: {
    getCost() {
      return MoneyFormatter.format(this.cost);
    },
  },
};
</script>

<style scoped></style>
