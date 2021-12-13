<template>
  <v-card class="suggestion">
    <v-card-title>{{ journey.city.name }}</v-card-title>
    <v-card-text>
      <div class="description">
        <div>
          Отелей найдено: <strong>{{ journey.hotels.length }}</strong>
        </div>
        <span>
          Стоимость: <strong>{{ journey.ticket.cost }}RUB</strong>
        </span>
        <span>
          Дата отправления:
          <strong>{{ journey.ticket.travellingTime.fromPlace.start }}</strong>
        </span>
        <span>
          Дата прибытия:
          <strong>{{ journey.ticket.travellingTime.toPlace.start }}</strong>
        </span>
        <div class="tags">
          <span>Теги: </span>
          <TagComponent
            v-for="tag in journey.city.tags"
            :key="tag.value"
            :value="tag.value"
            class="ml-1"
          />
        </div>
        <v-btn color="blue" class="ma-2 mt-5" @click="openModal">
          Подробнее
        </v-btn>
      </div>
    </v-card-text>
  </v-card>
</template>

<script>
import { JourneyResponse } from "../models/response/JourneyResponse";
import TagComponent from "./TagComponent";

export default {
  name: "JourneySuggestion",
  components: { TagComponent },
  props: {
    journey: {
      type: JourneyResponse,
      default: JourneyResponse.Null,
    },
  },
  methods: {
    openModal() {},
  },
};
</script>

<style scoped lang="scss">
.suggestion {
  padding: 1vh;
  background: wheat;
  margin: 2% 3% 3% 2%;
  height: 30vh;

  img {
    height: 20vh;
  }
}

.content {
}

.description {
  display: flex;
  flex-direction: column;
}

.tags {
}
</style>
