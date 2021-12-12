<template>
  <div class="wrapper">
    <v-card>
      <v-card-title>Настройки</v-card-title>
        <CitiesFilter v-model="fromCityName" :cities="cities" label="Город отправления"></CitiesFilter>
        <PriceFilter v-model="price"></PriceFilter>
        <DateFilter v-model="startDate" label="Дата отправления"></DateFilter>
        <DateFilter v-model="endDate" label="Дата прибытия"></DateFilter>
        <TagsFilter v-model="tags" :tags-collection="tagsCollection.map(t => t.name)"></TagsFilter>
        <v-btn  @click="applyFilters()" class="v-picker--full-width" color="blue">Принять</v-btn>
    </v-card>
  </div>
</template>

<script>
import { JourneyParametersRequest } from "../models/JourneyParametersRequest";
import CitiesFilter from "./Filters/CitiesFilter";
import DateFilter from "./Filters/DateFilter";
import PriceFilter from "./Filters/PriceFilter";
import TagsFilter from "./Filters/TagsFilter";

export default {
  name: "JourneyFilters",
  components: {TagsFilter, DateFilter, PriceFilter, CitiesFilter},
  props: {
    tagsCollection: Array,
    cities: Array,
  },
  data() {
    return {
      fromCityName: "",
      price: 100,
      startDate: "",
      endDate: "",
      tags: [],
    };
  },
  methods: {
    toggleTag(tagName) {
      const tags = this.tags;
      const idx = tags.indexOf(tagName);
      if (idx === -1) {
        tags.push(tagName);
      } else {
        tags.splice(idx, 1);
      }
    },
    isTagActive(tagName) {
      return this.tags.includes(tagName);
    },
    applyFilters() {
      const request = new JourneyParametersRequest();
      request.cityName = this.fromCityName;
      request.budget = this.price;
      request.dateFrom = this.startDate;
      request.dateTo = this.endDate;
      request.tags = this.tags;
      this.$emit("onrequest", request);
    },
  },
};
</script>

<style scoped lang="scss">
.wrapper {
  background: #39b54a;
  .header {
    background: brown;
    padding: 0.3vmax;
  }
  .tags {
    display: flex;
    flex-direction: row;
    justify-content: space-evenly;
    .tag {
      background: green;
      display: flex;
      width: fit-content;
      &.active {
        background: blue;
      }
    }
  }
}
</style>
