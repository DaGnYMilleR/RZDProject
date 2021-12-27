import Vue from "vue";
import Vuex from "vuex";
import { JourneyResponse } from "../models/response/JourneyResponse";
import {
  SET_JOURNEY,
  SET_JOURNEY_FILTERS,
  SET_SUGGESTIONS,
} from "./mutations-types";

Vue.use(Vuex);

const store = new Vuex.Store({
  state: {
    selectedJourney: JourneyResponse.Null,
    journeyFilters: {
      fromCityName: undefined,
      price: undefined,
      startDate: undefined,
      endDate: undefined,
      tags: [],
    },
    suggestions: [],
  },
  mutations: {
    [SET_JOURNEY](state, journey) {
      state.selectedJourney = journey;
    },

    [SET_JOURNEY_FILTERS](state, filters) {
      state.journeyFilters = filters;
      console.log(state.journeyFilters);
    },

    [SET_SUGGESTIONS](state, suggestions) {
      state.suggestions = suggestions;
    },
  },
});

export default store;
