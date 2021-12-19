<template>
  <v-container class="modal overflow-y-auto" style="height: 100%">
    <v-card>
      <v-card-title> Обзор путешествия </v-card-title>
      <img class="close" src="../assets/close.png" alt="" @click="close" />
      <v-card-subtitle>Город: {{ journey.city.name }}</v-card-subtitle>
      <v-row class="content">
        <v-col cols="4">
          <img class="city_image" :src="journey.city.imageUrl" alt="" />
        </v-col>
        <v-col cols="8">
          <v-tabs
            v-model="tab"
            background-color="transparent"
            color="basil"
            grow
          >
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
    </v-card>
  </v-container>
</template>

<script>
import { JourneyResponse } from "../models/response/JourneyResponse";
import HotelSuggestion from "./HotelSuggestion";
import TicketSuggestion from "./TicketSuggestion";

const items = [
  { id: 1, name: "Билеты" },
  { id: 2, name: "Отели" },
];
export default {
  name: "JourneyModal",
  components: { TicketSuggestion, HotelSuggestion },
  props: {
    journey: {
      type: JourneyResponse,
      default: JourneyResponse.Null,
    },
  },
  data: () => ({
    tab: 0,
    items,
  }),
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
