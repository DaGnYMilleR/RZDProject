<template>
  <v-container fluid style="height: 100%">
    <input id="nav-toggle" type="checkbox" value="false" hidden />
    <transition name="fade" duration="500">
      <div key="content" class="home">
        <div class="header">Выбор путешествия</div>
        <div class="content">
          <div class="left">
            <transition name="fade" mode="in-out">
              <v-progress-circular
                v-if="isLoading"
                key="loading"
                class="justify-center align-self-center"
                style="
                  display: flex;
                  width: 100%;
                  height: 10%;
                  top: 40%;
                  z-index: 10;
                  position: absolute;
                "
                size="50"
                color="blue"
                indeterminate
              ></v-progress-circular>
              <JourneySuggestions
                v-else
                key="content"
                :suggestions="suggestions"
                @select="openModal"
                @open-settings="openSettings"
              />
            </transition>
          </div>
          <div class="right">
            <v-app-bar-nav-icon
              class="v-size--x-large"
              @click.stop="doShowSettings = !doShowSettings"
            ></v-app-bar-nav-icon>
            <v-navigation-drawer
              v-model="doShowSettings"
              fixed
              bottom
              right
              temporary
              height-app
              style="width: 20%"
            >
              <JourneyFilters
                ref="settings"
                :tags-collection="tags"
                :cities="cities"
                :train-types="trainTypes"
                @onrequest="requestApplyFilters"
              />
            </v-navigation-drawer>
          </div>
        </div>
      </div>
    </transition>
  </v-container>
</template>

<script>
import JourneyFilters from "../components/JourneyFilters";
import JourneySuggestions from "../components/JourneySuggestions";
import { JourneyResponse } from "../models/response/JourneyResponse";
import store from "../store";
import { SET_JOURNEY, SET_SUGGESTIONS } from "../store/mutations-types";
import { TrainCarType } from "../utils/TrainCarType";

export default {
  name: "SearchJourneys",
  components: { JourneySuggestions, JourneyFilters },
  data() {
    return {
      tags: [
        { id: 1, name: "амур" },
        { id: 2, name: "архитектура" },
        { id: 3, name: "байкал" },
        { id: 4, name: "война" },
        { id: 5, name: "город" },
        { id: 6, name: "город-герой" },
        { id: 7, name: "горы" },
        { id: 8, name: "есентуки" },
        { id: 9, name: "жара" },
        { id: 10, name: "живопись" },
        { id: 11, name: "заповедники" },
        { id: 12, name: "иконопись" },
        { id: 13, name: "история" },
        { id: 14, name: "кавказ" },
        { id: 15, name: "кенигсберг" },
        { id: 16, name: "корабли" },
        { id: 17, name: "космонавтика" },
        { id: 18, name: "красиво" },
        { id: 19, name: "красота" },
        { id: 20, name: "кремль" },
        { id: 21, name: "культура" },
        { id: 22, name: "курорт" },
        { id: 23, name: "лето" },
        { id: 24, name: "любовь" },
        { id: 25, name: "минеральные воды" },
        { id: 26, name: "море" },
        { id: 27, name: "москва" },
        { id: 28, name: "мосты" },
        { id: 29, name: "музеи" },
        { id: 30, name: "музей" },
        { id: 31, name: "музыка" },
        { id: 32, name: "наследие" },
        { id: 33, name: "национальности" },
        { id: 34, name: "отдых" },
        { id: 35, name: "отпуск" },
        { id: 36, name: "памятники" },
        { id: 37, name: "парки" },
        { id: 38, name: "пейзажи" },
        { id: 39, name: "пещеры" },
        { id: 40, name: "пляж" },
        { id: 41, name: "полярный круг" },
        { id: 42, name: "порты" },
        { id: 43, name: "природа" },
        { id: 44, name: "ремесло" },
        { id: 45, name: "роспись" },
        { id: 46, name: "сибирь" },
        { id: 47, name: "собор" },
        { id: 48, name: "соборы" },
        { id: 49, name: "спорт" },
        { id: 50, name: "столица" },
        { id: 51, name: "традиции" },
        { id: 52, name: "флот" },
        { id: 53, name: "форпост" },
        { id: 54, name: "холод" },
        { id: 55, name: "храм" },
        { id: 56, name: "храмы" },
        { id: 57, name: "художники" },
        { id: 58, name: "цветы" },
        { id: 59, name: "церкви" },
      ],
      cities: [
        { id: 1, name: "Арзамас" },
        { id: 2, name: "Белгород" },
        { id: 3, name: "Благовещенск" },
        { id: 4, name: "Владивосток" },
        { id: 5, name: "Владикавказ" },
        { id: 6, name: "Владимир" },
        { id: 7, name: "Вологда" },
        { id: 8, name: "Екатеринбург" },
        { id: 9, name: "Иркутск" },
        { id: 10, name: "Казань" },
        { id: 11, name: "Калининград" },
        { id: 12, name: "Калуга" },
        { id: 13, name: "Краснодар" },
        { id: 14, name: "Красноярск" },
        { id: 15, name: "Курган" },
        { id: 16, name: "Курск" },
        { id: 17, name: "Майкоп" },
        { id: 18, name: "Москва" },
        { id: 19, name: "Мурманск" },
        { id: 20, name: "Нижний Новгород" },
        { id: 21, name: "Новосибирск" },
        { id: 22, name: "Пенза" },
        { id: 23, name: "Пермь" },
        { id: 24, name: "Пятигорск" },
        { id: 25, name: "Ростов-на-Дону" },
        { id: 26, name: "Самара" },
        { id: 27, name: "Санкт-Петербург" },
        { id: 28, name: "Саратов" },
        { id: 29, name: "Сочи" },
        { id: 30, name: "Ставрополь" },
        { id: 31, name: "Старый Оскол" },
        { id: 32, name: "Тверь" },
        { id: 33, name: "Тула" },
        { id: 34, name: "Тюмень" },
        { id: 35, name: "Уфа" },
        { id: 36, name: "Хабаровск" },
        { id: 37, name: "Ярославль" },
      ],
      trainTypes: [
        { name: "Плацкарт", type: TrainCarType.Plazcard },
        { name: "Купе", type: TrainCarType.Coupe },
        { name: "Люкс", type: TrainCarType.Lux },
      ],
      cachedRequest: null,
      doShowSettings: false,
      isLoading: false,
      store,
    };
  },
  computed: {
    suggestions() {
      return this.$store.state.suggestions;
    },
  },
  methods: {
    async requestApplyFilters(requestDto) {
      this.cachedRequest = requestDto;
      let suggestions = [];
      console.log(requestDto);
      try {
        this.doShowSettings = false;
        this.isLoading = true;
        const path = process.env.VUE_APP_API + "/api/journeys/";
        const response = await fetch(path, {
          method: "POST",
          body: requestDto.toJson(),
          headers: {
            "content-type": "application/json",
          },
        });
        if (response.status === 200) {
          const text = await response.text();
          suggestions = JSON.parse(text).map(JourneyResponse.fromObject);
        } else {
          console.log(response.json());
        }
      } catch (e) {
        console.log(e.message);
      } finally {
        this.$store.commit(SET_SUGGESTIONS, suggestions);
        this.isLoading = false;
      }
    },

    openModal(journey) {
      this.$store.commit(SET_JOURNEY, journey);
      this.$router.push({ path: "/journey" });
    },

    openSettings() {
      this.doShowSettings = true;
      this.$refs?.settings?.setFilters(this.$store.state.journeyFilters);
    },

    isSettingsOpened() {
      return this.doShowSettings;
    },
  },
};
</script>

<style scoped lang="scss">
@import "../assets/css/Transition.css";

.home {
  display: flex;
  height: 100%;
  position: relative;
  flex-direction: column;
}

.header {
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 2.2em;
}
.content {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  height: 100%;
}

.left {
  margin-right: 1%;
  flex-grow: 20;
}

.right {
  flex-grow: 1;
  width: 1.7vmax;
  height: 5vh;
}
</style>
