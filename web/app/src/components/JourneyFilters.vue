<template>
  <div class="wrapper">
    <v-card-title class="justify-center">Настройки</v-card-title>
    <CitiesFilter
      v-model="cityName"
      :cities="cities"
      label="Город отправления"
    ></CitiesFilter>
    <PriceFilter v-model="budget"></PriceFilter>
    <DateFilter
      v-model="dateFrom"
      label="Дата отправления"
      :allowed-dates="canStart"
    ></DateFilter>
    <DateFilter
      v-model="dateTo"
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
import { store } from "../store";
import { SET_JOURNEY_FILTERS } from "../store/mutations-types";
import CitiesFilter from "./Filters/CitiesFilter";
import DateFilter from "./Filters/DateFilter";
import PriceFilter from "./Filters/PriceFilter";
import TagsFilter from "./Filters/TagsFilter";

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
  },
  data() {
    return {
      cityName: undefined,
      budget: undefined,
      dateFrom: undefined,
      dateTo: undefined,
      tags: [],

      timeout: 3000,
      error: "",
      hasError: false,
      store,
    };
  },
  methods: {
    applyFilters() {
      if (this.cityName === undefined) {
        this.setError("Вы не указали город");
      } else if (this.budget === undefined) {
        this.setError("Вы не указали бюджет");
      } else if (this.dateFrom === undefined) {
        this.setError("Вы не указали дату отправления");
      } else if (this.dateTo === undefined) {
        this.setError("Вы не указали дату вовзращения");
      } else if (this.budget <= 0) {
        this.setError("Цена должна быть больше 0");
      } else if (Date.parse(this.dateFrom) > Date.parse(this.dateTo)) {
        this.setError("Дата отправления должна быть раньше даты возвращения");
      } else if (Date.now() > Date.parse(this.dateFrom)) {
        this.setError("Дата отправления должна быть не раньше текущей даты");
      } else {
        const request = new JourneyRequest();
        request.cityName = this.cityName;
        request.budget = this.budget;
        request.dateFrom = this.dateFrom;
        request.dateTo = this.dateTo;
        request.tags = this.tags;
        this.$store.commit(SET_JOURNEY_FILTERS, request);
        this.$emit("onrequest", request);
      }
    },

    setError(message) {
      this.error = message;
      this.hasError = true;
    },

    setFilters(filters) {
      this.cityName = filters.cityName;
      this.budget = filters.budget;
      this.dateFrom = filters.dateFrom;
      this.dateTo = filters.dateTo;
      this.tags = filters.tags;
    },

    canStart(date) {
      return Date.parse(date) > Date.now();
    },

    canEnd(date) {
      return this.dateFrom
        ? Date.parse(this.dateFrom) + 1000 * 60 * 24 < Date.parse(date)
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
