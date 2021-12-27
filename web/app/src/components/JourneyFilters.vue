<template>
  <div class="wrapper">
    <v-card-title class="justify-center">Настройки</v-card-title>
    <CitiesFilter
      v-model="fromCityName"
      :cities="cities"
      label="Город отправления"
    ></CitiesFilter>
    <PriceFilter v-model="price"></PriceFilter>
    <DateFilter
      v-model="startDate"
      label="Дата отправления"
      :allowed-dates="canStart"
    ></DateFilter>
    <DateFilter
      v-model="endDate"
      label="Дата возвращения"
      :allowed-dates="canEnd"
    ></DateFilter>
    <TagsFilter
      v-model="tags"
      :tags-collection="tagsCollection.map((t) => t.name)"
    ></TagsFilter>
    <v-btn
      style="margin: 2%"
      min-width="96%"
      color="blue"
      @click="applyFilters()"
    >
      Принять
    </v-btn>

    <v-snackbar v-model="hasError" :timeout="timeout">
      {{ error }}
      <template #action="{ attrs }">
        <v-btn color="blue" text v-bind="attrs" @click="snackbar = false">
          ЗАКРЫТЬ
        </v-btn>
      </template>
    </v-snackbar>
  </div>
</template>

<script>
import { JourneyRequest } from "../models/request/JourneyRequest";
import CitiesFilter from "./Filters/CitiesFilter";
import DateFilter from "./Filters/DateFilter";
import PriceFilter from "./Filters/PriceFilter";
import TagsFilter from "./Filters/TagsFilter";

function transformToLocalDate(dateStr) {
  return dateStr;
}

export default {
  name: "JourneyFilters",
  components: { TagsFilter, DateFilter, PriceFilter, CitiesFilter },
  props: {
    tagsCollection: {
      type: Array,
      default: () => [],
    },
    cities: {
      type: Array,
      default: () => [],
    },
    cachedRequest: {
      type: JourneyRequest,
      default: () => new JourneyRequest(),
    },
  },
  data() {
    return {
      fromCityName: undefined,
      price: undefined,
      startDate: undefined,
      endDate: undefined,
      tags: [],

      timeout: 3000,
      error: "",
      hasError: false,
    };
  },
  mounted() {
    if (this.cachedRequest) {
      this.fromCityName = this.cachedRequest.cityName;
      this.price = this.cachedRequest.budget;
      this.startDate = this.cachedRequest.dateFrom;
      this.endDate = this.cachedRequest.dateTo;
      this.tags = this.cachedRequest.tags;
    }
  },
  methods: {
    applyFilters() {
      if (this.fromCityName === undefined) {
        this.setError("Вы не указали город");
      } else if (this.price === undefined) {
        this.setError("Вы не указали бюджет");
      } else if (this.startDate === undefined) {
        this.setError("Вы не указали дату отправления");
      } else if (this.endDate === undefined) {
        this.setError("Вы не указали дату вовзращения");
      } else if (this.price <= 0) {
        this.setError("Цена должна быть больше 0");
      } else if (Date.parse(this.startDate) > Date.parse(this.endDate)) {
        this.setError("Дата отправления должна быть раньше даты возвращения");
      } else if (Date.now() > Date.parse(this.startDate)) {
        this.setError("Дата отправления должна быть не раньше текущей даты");
      } else {
        const request = new JourneyRequest();
        request.cityName = this.fromCityName;
        request.budget = this.price;
        request.dateFrom = transformToLocalDate(this.startDate);
        request.dateTo = transformToLocalDate(this.endDate);
        request.tags = this.tags;
        this.$emit("onrequest", request);
      }
    },

    setError(message) {
      this.error = message;
      this.hasError = true;
    },

    canStart(date) {
      return Date.parse(date) > Date.now();
    },

    canEnd(date) {
      return this.startDate
        ? Date.parse(this.startDate) + 1000 * 60 * 24 < Date.parse(date)
        : true;
    },
  },
};
</script>

<style scoped lang="scss">
.wrapper {
  .header {
    padding: 0.3vmax;
  }
  .tags {
    display: flex;
    flex-direction: row;
    justify-content: space-evenly;
    .tag {
      display: flex;
      width: fit-content;
      &.active {
      }
    }
  }
}
</style>
