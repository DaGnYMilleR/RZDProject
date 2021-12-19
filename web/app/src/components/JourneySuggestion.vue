<template>
  <v-container>
    <div class="suggestion">
      <div class="title">{{ journey.city.name }}</div>
      <v-container>
        <div class="description">
          <img :src="journey.city.imageUrl" alt="" />
          <div>
            Отелей найдено: <strong>{{ journey.hotels.length }}</strong>
          </div>
          <div class="tags">
            <span>Теги: </span>
            <TagComponent
              v-for="tag in journey.city.tags"
              :key="tag.value"
              :value="tag.value"
              class="ml-1"
            />
          </div>
          <v-btn color="blue" class="ma-2 mt-5" @click="selectSuggestion">
            Подробнее
          </v-btn>
        </div>
      </v-container>
    </div>
  </v-container>
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
      default: () => JourneyResponse.Null,
    },
  },
  methods: {
    selectSuggestion(e) {
      this.$emit("click", e);
    },
  },
};
</script>

<style scoped lang="scss">
.suggestion {
  padding: 1vh;
  border-radius: 0.5em;
  margin: 1%;
  box-shadow: 1px 1px 10px black;
  transition: all 0.2s linear;

  &:hover {
    box-shadow: 4px 4px 30px black;
    transition: all 0.2s linear;
  }
  & img {
    width: 50%;
    display: flex;
    align-items: center;
    margin-left: 25%;
    margin-bottom: 3%;
  }

  .title {
    display: flex;
    text-align: center;
    flex-direction: column;
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
