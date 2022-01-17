<template>
  <div class="wrapper">
    <v-card-title class="justify-center">Настройки</v-card-title>
    <CitiesFilter
      v-model="cityName"
      :cities="cities"
      label="Город отправления"
    ></CitiesFilter>
    <PriceFilter v-model="budget" title="Бюджет на билеты"></PriceFilter>
    <v-content class="pa-0">
      <v-card-title>Тип вагона</v-card-title>
      <v-select
        v-model="trainName"
        :items="trainTypes.map((c) => c.name)"
        label="Тип вагона"
        placeholder="Выберите тип вагона"
        dense
        outlined
        clearable
        color="blue"
        item-color="blue"
        class="ml-3 mr-3"
      ></v-select>
    </v-content>
    <v-content class="pa-0" style="margin-left: 1%">
      <v-checkbox
        v-model="useHotels"
        label="Найти отели"
        value="Найти отели"
      ></v-checkbox>
    </v-content>
    <transition name="fade">
      <PriceFilter
        v-if="useHotels"
        v-model="hotelsBudget"
        title="Бюджет на отели"
      ></PriceFilter>
    </transition>
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
import store from "../store";
import { SET_JOURNEY_FILTERS } from "../store/mutations-types";
import { TrainCarType } from "../utils/TrainCarType";
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
    trainTypes: {
      type: Array,
      default: () => [],
    },
  },
  data() {
    return {
      cityName: undefined,
      budget: undefined,
      hotelsBudget: undefined,
      dateFrom: undefined,
      dateTo: undefined,
      tags: [],
      trainType: TrainCarType.Plazcard,

      useHotels: false,
      timeout: 3000,
      error: "",
      hasError: false,
      store,
    };
  },
  computed: {
    trainName: {
      get() {
        return (
          this.trainTypes.find((x) => x.type === this.trainType)?.name ??
          "Не выбрано"
        );
      },
      set(value) {
        this.trainType =
          this.trainTypes.find((x) => x.name === value)?.type ?? -1;
      },
    },
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
      } else if (
        this.useHotels &&
        (isNaN(+this.hotelsBudget) || +this.hotelsBudget <= 0)
      ) {
        this.setError("Вы неправильно указали бюджет на отели");
      } else if (this.trainType === undefined) {
        this.setError("Вы не указали тип вагона");
      } else {
        const request = new JourneyRequest();
        request.cityName = this.cityName;
        request.trainsBudget = this.budget;
        request.dateFrom = this.dateFrom;
        request.dateTo = this.dateTo;
        request.tags = this.tags;
        request.hotelsBudget = this.useHotels ? this.hotelsBudget : null;
        request.typeOfTrainCar = this.trainType;
        if (request.typeOfTrainCar === undefined) {
          this.setError("Вы указали неправильный тип вагона");
        } else {
          this.$store.commit(SET_JOURNEY_FILTERS, request);
          this.$emit("onrequest", request);
        }
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
@import "../assets/css/Transition.css";

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
