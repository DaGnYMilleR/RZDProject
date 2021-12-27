<template>
  <v-container class="modal overflow-y-auto" style="height: 100%">
    <v-card-title> Обзор путешествия </v-card-title>
    <v-card-subtitle>Город: {{ journey.city.name }}</v-card-subtitle>
    <v-row class="content">
      <v-col cols="4" class="flex justify-center" style="display: flex">
        <img class="city_image" :src="journey.city.imageUrl" alt="" />
      </v-col>
      <v-col cols="8">
        <v-tabs v-model="tab" background-color="transparent" color="basil" grow>
          <v-tab v-for="item in items" :key="item.id">
            {{ item.name }}
          </v-tab>
        </v-tabs>
        <div class="tabs">
          <template v-if="items[tab].id === 1">
            <TicketSuggestion
              v-for="(ticket, id) in journey.tickets"
              :key="'tickets' + id"
              :city-from="ticket.cityFrom"
              :city-to="ticket.cityTo"
              :url-to="ticket.urlTo"
              :url-from="ticket.urlFrom"
              :cost="ticket.cost"
              :travelling-time="ticket.travellingTime"
            />
          </template>
          <template v-else-if="items[tab].id === 2">
            <HotelSuggestion
              v-for="(hotel, id) in journey.hotels"
              :key="'hotels' + id"
              :name="hotel.name"
              :image-url="hotel.images.mainImgUrl"
              :price="hotel.price"
              :rating="hotel.rating"
            />
          </template>
        </div>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
// eslint-disable-next-line no-unused-vars
import { JourneyResponse } from "../models/response/JourneyResponse";
import HotelSuggestion from "../components/HotelSuggestion";
import TicketSuggestion from "../components/TicketSuggestion";
import { store } from "../store";

const items = [
  { id: 1, name: "Билеты" },
  { id: 2, name: "Отели" },
];
export default {
  name: "JourneyModal",
  components: { TicketSuggestion, HotelSuggestion },
  data: () => ({
    tab: 0,
    items,
    store,
  }),
  computed: {
    /**
     * @return {JourneyResponse}
     */
    journey() {
      return this.$store.state.selectedJourney;
    },
  },
  methods: {
    close() {
      this.$emit("close");
    },
  },
};
</script>

<style scoped lang="scss">
.wrapper {
  display: flex;
  flex-direction: column;
}

.content {
  overflow: scroll;
  height: 67.5vh;
}

.city_image {
  height: 20vh;
  margin-left: 0.5vh;
}

.right {
  width: 100%;
}

.close {
  display: flex;
  width: 8vh;
  position: absolute;
  top: 1vh;
  right: 1vh;

  &:hover {
    cursor: pointer;
  }
}
</style>
