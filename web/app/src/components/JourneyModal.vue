<template>
  <v-container
    class="v-menu__content--fixed v-dialog--fullscreen"
    style="z-index: 10"
    fluid
  >
    <v-card>
      <v-card-title> Обзор путешествия </v-card-title>
      <v-card-subtitle>Город: {{ journey.city.name }}</v-card-subtitle>
      <v-card-text>
        <HotelSuggestion
          v-for="(hotel, id) in journey.hotels"
          :key="id"
          :name="hotel.name"
          :image-url="hotel.imageUrl"
          :price="hotel.price"
          :rating="hotel.rating"
        />
      </v-card-text>
    </v-card>
  </v-container>
</template>

<script>
import { JourneyResponse } from "../models/response/JourneyResponse";
import HotelSuggestion from "./HotelSuggestion";

export default {
  name: "JourneyModal",
  components: { HotelSuggestion },
  props: {
    journey: {
      type: JourneyResponse,
      default: JourneyResponse.Null,
    },
  },
};
</script>

<style scoped></style>
