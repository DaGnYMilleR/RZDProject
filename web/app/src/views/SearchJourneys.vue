<template>
  <v-container fluid style="height: 100%">
    <transition-group name="fade" duration="500">
      <JourneyModal
        v-if="isModalOpened()"
        key="modal"
        :journey="selectedJourney"
        @close="closeModal"
      />
      <div v-else key="content" class="home">
        <div class="header">Выбор путешествия</div>
        <div class="content">
          <div class="left">
            <JourneySuggestions
              :suggestions="suggestions"
              @select="openModal"
            />
          </div>
          <div class="right">
            <JourneyFilters
              :tags-collection="tags"
              :cities="cities"
              :cached-request="cachedRequest"
              @onrequest="requestApplyFilters"
            />
          </div>
        </div>
      </div>
    </transition-group>
  </v-container>
</template>

<script>
import JourneyFilters from "../components/JourneyFilters";
import JourneyModal from "../components/JourneyModal";
import JourneySuggestions from "../components/JourneySuggestions";
import { JourneyResponse } from "../models/response/JourneyResponse";

export default {
  name: "SearchJourneys",
  components: { JourneyModal, JourneySuggestions, JourneyFilters },
  data() {
    return {
      suggestions: [
        // JourneyResponse.fromObject({
        //   city: {
        //     name: "Пятигорск",
        //     tags: [
        //       { value: "минеральные воды" },
        //       { value: "кавказ" },
        //       { value: "красота" },
        //       { value: "горы" },
        //       { value: "живопись" },
        //       { value: "есентуки" },
        //     ],
        //     stationsIds: [2064060],
        //     imageUrl:
        //       "https://www.study.ru/uploads/server/NkkQL85HhpDn6Xq0.jpg",
        //   },
        //   tickets: [
        //     {
        //       cityFrom: {
        //         name: "Yekaterinburg",
        //         tags: [],
        //         stationsIds: [],
        //       },
        //       cityTo: {
        //         name: "Sochi",
        //         tags: [],
        //         stationsIds: [],
        //       },
        //       cost: 1000,
        //       travellingTime: {
        //         toPlace: {
        //           start: "2021-12-12",
        //           end: "2021-12-13",
        //         },
        //         fromPlace: {
        //           start: "2021-12-30",
        //           end: "2021-12-31",
        //         },
        //       },
        //       urlTo: "ASDASDA",
        //       urlFrom: "ASDSADA",
        //     },
        //     {
        //       cityFrom: {
        //         name: "Yekaterinburg",
        //         tags: [],
        //         stationsIds: [],
        //       },
        //       cityTo: {
        //         name: "Sochi",
        //         tags: [],
        //         stationsIds: [],
        //       },
        //       cost: 1000,
        //       travellingTime: {
        //         toPlace: {
        //           start: "2021-12-12",
        //           end: "2021-12-13",
        //         },
        //         fromPlace: {
        //           start: "2021-12-30",
        //           end: "2021-12-31",
        //         },
        //       },
        //       urlTo: "ASDASDA",
        //       urlFrom: "ASDSADA",
        //     },
        //   ],
        //   hotels: [
        //     {
        //       id: 1406953704,
        //       name: "Guest House Pragma",
        //       address: { lon: 43.0594, lat: 44.0486 },
        //       price: 52274.15,
        //       rating: 5,
        //       images: {
        //         mainId: 1,
        //         extraIds: [],
        //       },
        //     },
        //     {
        //       id: 1224984043,
        //       name: "Hotel Kristella",
        //       address: { lon: 43.0594, lat: 44.0486 },
        //       price: 67150,
        //       rating: 4,
        //       images: {
        //         mainId: 1,
        //         extraIds: [],
        //       },
        //     },
        //     {
        //       id: 611050,
        //       name: "Bristol Spa-Hotel",
        //       address: { lon: 43.0594, lat: 44.0486 },
        //       price: 436644.99,
        //       rating: 4,
        //       images: {
        //         mainId: 1,
        //         extraIds: [],
        //       },
        //     },
        //     {
        //       id: 543356,
        //       name: "Zateryanny Ray u Mashuka",
        //       address: { lon: 43.0594, lat: 44.0486 },
        //       price: 42500,
        //       rating: 3,
        //       images: {
        //         mainId: 1,
        //         extraIds: [],
        //       },
        //     },
        //     {
        //       id: 9192717,
        //       name: "Гостевой дом Респект",
        //       address: { lon: 43.0594, lat: 44.0486 },
        //       price: 37400,
        //       rating: 2,
        //       images: {
        //         mainId: 1,
        //         extraIds: [],
        //       },
        //     },
        //   ],
        // }),
        // JourneyResponse.fromObject({
        //   city: {
        //     name: "Пятигорск",
        //     tags: [
        //       { value: "минеральные воды" },
        //       { value: "кавказ" },
        //       { value: "красота" },
        //       { value: "горы" },
        //       { value: "живопись" },
        //       { value: "есентуки" },
        //     ],
        //     stationsIds: [2064060],
        //     imageUrl:
        //       "https://www.study.ru/uploads/server/NkkQL85HhpDn6Xq0.jpg",
        //   },
        //   tickets: [
        //     {
        //       cityFrom: {
        //         name: "Yekaterinburg",
        //         tags: [],
        //         stationsIds: [],
        //       },
        //       cityTo: {
        //         name: "Sochi",
        //         tags: [],
        //         stationsIds: [],
        //       },
        //       cost: 1000,
        //       travellingTime: {
        //         toPlace: {
        //           start: "2021-12-12",
        //           end: "2021-12-13",
        //         },
        //         fromPlace: {
        //           start: "2021-12-30",
        //           end: "2021-12-31",
        //         },
        //       },
        //       urlTo: "",
        //       urlFrom: "",
        //     },
        //   ],
        //   hotels: [
        //     {
        //       id: 1406953704,
        //       name: "Guest House Pragma",
        //       address: { lon: 43.0594, lat: 44.0486 },
        //       price: 52274.15,
        //       rating: 5,
        //       images: {
        //         mainId: 1,
        //         extraIds: [],
        //       },
        //     },
        //     {
        //       id: 1224984043,
        //       name: "Hotel Kristella",
        //       address: { lon: 43.0594, lat: 44.0486 },
        //       price: 67150,
        //       rating: 4,
        //       images: {
        //         mainId: 1,
        //         extraIds: [],
        //       },
        //     },
        //     {
        //       id: 611050,
        //       name: "Bristol Spa-Hotel",
        //       address: { lon: 43.0594, lat: 44.0486 },
        //       price: 436644.99,
        //       rating: 4,
        //       images: {
        //         mainId: 1,
        //         extraIds: [],
        //       },
        //     },
        //     {
        //       id: 543356,
        //       name: "Zateryanny Ray u Mashuka",
        //       address: { lon: 43.0594, lat: 44.0486 },
        //       price: 42500,
        //       rating: 3,
        //       images: {
        //         mainId: 1,
        //         extraIds: [],
        //       },
        //     },
        //     {
        //       id: 9192717,
        //       name: "Гостевой дом Респект",
        //       address: { lon: 43.0594, lat: 44.0486 },
        //       price: 37400,
        //       rating: 2,
        //       images: {
        //         mainId: 1,
        //         extraIds: [],
        //       },
        //     },
        //   ],
        // }),
        // JourneyResponse.fromObject({
        //   city: {
        //     name: "Пятигорск",
        //     tags: [
        //       { value: "минеральные воды" },
        //       { value: "кавказ" },
        //       { value: "красота" },
        //       { value: "горы" },
        //       { value: "живопись" },
        //       { value: "есентуки" },
        //     ],
        //     stationsIds: [2064060],
        //     imageUrl:
        //       "https://www.study.ru/uploads/server/NkkQL85HhpDn6Xq0.jpg",
        //   },
        //   tickets: [
        //     {
        //       cityFrom: {
        //         name: "Yekaterinburg",
        //         tags: [],
        //         stationsIds: [],
        //       },
        //       cityTo: {
        //         name: "Sochi",
        //         tags: [],
        //         stationsIds: [],
        //       },
        //       cost: 1000,
        //       travellingTime: {
        //         toPlace: {
        //           start: "2021-12-12",
        //           end: "2021-12-13",
        //         },
        //         fromPlace: {
        //           start: "2021-12-30",
        //           end: "2021-12-31",
        //         },
        //       },
        //       urlTo: "",
        //       urlFrom: "",
        //     },
        //   ],
        //   hotels: [
        //     {
        //       id: 1406953704,
        //       name: "Guest House Pragma",
        //       address: { lon: 43.0594, lat: 44.0486 },
        //       price: 52274.15,
        //       rating: 5,
        //       images: {
        //         mainId: 1,
        //         extraIds: [],
        //       },
        //     },
        //     {
        //       id: 1224984043,
        //       name: "Hotel Kristella",
        //       address: { lon: 43.0594, lat: 44.0486 },
        //       price: 67150,
        //       rating: 4,
        //       images: {
        //         mainId: 1,
        //         extraIds: [],
        //       },
        //     },
        //     {
        //       id: 611050,
        //       name: "Bristol Spa-Hotel",
        //       address: { lon: 43.0594, lat: 44.0486 },
        //       price: 436644.99,
        //       rating: 4,
        //       images: {
        //         mainId: 1,
        //         extraIds: [],
        //       },
        //     },
        //     {
        //       id: 543356,
        //       name: "Zateryanny Ray u Mashuka",
        //       address: { lon: 43.0594, lat: 44.0486 },
        //       price: 42500,
        //       rating: 3,
        //       images: {
        //         mainId: 1,
        //         extraIds: [],
        //       },
        //     },
        //     {
        //       id: 9192717,
        //       name: "Гостевой дом Респект",
        //       address: { lon: 43.0594, lat: 44.0486 },
        //       price: 37400,
        //       rating: 2,
        //       images: {
        //         mainId: 1,
        //         extraIds: [],
        //       },
        //     },
        //   ],
        // }),
      ],
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
      selectedJourney: null,
      cachedRequest: null,
    };
  },
  methods: {
    async requestApplyFilters(requestDto) {
      console.log(requestDto.toJson());
      this.cachedRequest = requestDto;
      try {
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
          console.log(JSON.parse(text));
          this.suggestions = JSON.parse(text).map(JourneyResponse.fromObject);
          console.log(this.suggestions);
        } else {
          console.log(response.json());
        }
      } catch (e) {
        console.log(e.message);
      }
    },

    openModal(journey) {
      this.selectedJourney = journey;
    },

    closeModal() {
      this.selectedJourney = null;
    },

    isModalOpened() {
      return this.selectedJourney !== null;
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
  flex-grow: 2;
}

.right {
  background: cornflowerblue;
  flex-grow: 1;
  width: 9vmax;
  height: fit-content;
}
</style>
