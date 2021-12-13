<template>
  <v-container fluid style="height: 100%">
    <div class="home">
      <div class="header">Выбор путешествия</div>
      <div class="content">
        <div class="left">
          <JourneySuggestions :suggestions="suggestions" />
        </div>
        <div class="right">
          <JourneyFilters
            :tags-collection="tags"
            :cities="cities"
            @onrequest="requestApplyFilters"
          />
        </div>
      </div>
    </div>
  </v-container>
</template>

<script>
import JourneyFilters from "../components/JourneyFilters";
import JourneySuggestions from "../components/JourneySuggestions";
import { JourneyResponse } from "../models/response/JourneyResponse";

export default {
  name: "SearchJourneys",
  components: { JourneySuggestions, JourneyFilters },
  data() {
    return {
      suggestions: [
        JourneyResponse.fromObject({
          city: {
            name: "Пятигорск",
            tags: [
              { value: "минеральные воды" },
              { value: "кавказ" },
              { value: "красота" },
              { value: "горы" },
              { value: "живопись" },
              { value: "есентуки" },
            ],
            stationsIds: [2064060],
          },
          ticket: {
            cityFrom: {
              name: "Yekaterinburg",
              tags: [],
              stationsIds: [],
            },
            cityTo: {
              name: "Sochi",
              tags: [],
              stationsIds: [],
            },
            cost: 1000,
            travellingTime: {
              toPlace: {
                start: "2021-12-12",
                end: "2021-12-13",
              },
              fromPlace: {
                start: "2021-12-30",
                end: "2021-12-31",
              },
            },
          },
          hotels: [
            {
              id: 1406953704,
              name: "Guest House Pragma",
              address: { lon: 43.0594, lat: 44.0486 },
              price: 52274.15,
              rating: 5,
              imageUrl: "",
            },
            {
              id: 1224984043,
              name: "Hotel Kristella",
              address: { lon: 43.0594, lat: 44.0486 },
              price: 67150,
              rating: 4,
              imageUrl: "",
            },
            {
              id: 611050,
              name: "Bristol Spa-Hotel",
              address: { lon: 43.0594, lat: 44.0486 },
              price: 436644.99,
              rating: 4,
              imageUrl: "",
            },
            {
              id: 543356,
              name: "Zateryanny Ray u Mashuka",
              address: { lon: 43.0594, lat: 44.0486 },
              price: 42500,
              rating: 3,
              imageUrl: "",
            },
            {
              id: 9192717,
              name: "Гостевой дом Респект",
              address: { lon: 43.0594, lat: 44.0486 },
              price: 37400,
              rating: 2,
              imageUrl: "",
            },
          ],
        }),
        JourneyResponse.fromObject({
          city: {
            name: "Пятигорск",
            tags: [
              { value: "минеральные воды" },
              { value: "кавказ" },
              { value: "красота" },
              { value: "горы" },
              { value: "живопись" },
              { value: "есентуки" },
            ],
            stationsIds: [2064060],
          },
          ticket: {
            cityFrom: {
              name: "Yekaterinburg",
              tags: [],
              stationsIds: [],
            },
            cityTo: {
              name: "Sochi",
              tags: [],
              stationsIds: [],
            },
            cost: 1000,
            travellingTime: {
              toPlace: {
                start: "2021-12-12",
                end: "2021-12-13",
              },
              fromPlace: {
                start: "2021-12-30",
                end: "2021-12-31",
              },
            },
          },
          hotels: [
            {
              id: 1406953704,
              name: "Guest House Pragma",
              address: { lon: 43.0594, lat: 44.0486 },
              price: 52274.15,
              rating: 5,
              imageUrl: "",
            },
            {
              id: 1224984043,
              name: "Hotel Kristella",
              address: { lon: 43.0594, lat: 44.0486 },
              price: 67150,
              rating: 4,
              imageUrl: "",
            },
            {
              id: 611050,
              name: "Bristol Spa-Hotel",
              address: { lon: 43.0594, lat: 44.0486 },
              price: 436644.99,
              rating: 4,
              imageUrl: "",
            },
            {
              id: 543356,
              name: "Zateryanny Ray u Mashuka",
              address: { lon: 43.0594, lat: 44.0486 },
              price: 42500,
              rating: 3,
              imageUrl: "",
            },
            {
              id: 9192717,
              name: "Гостевой дом Респект",
              address: { lon: 43.0594, lat: 44.0486 },
              price: 37400,
              rating: 2,
              imageUrl: "",
            },
          ],
        }),
        JourneyResponse.fromObject({
          city: {
            name: "Пятигорск",
            tags: [
              { value: "минеральные воды" },
              { value: "кавказ" },
              { value: "красота" },
              { value: "горы" },
              { value: "живопись" },
              { value: "есентуки" },
            ],
            stationsIds: [2064060],
          },
          ticket: {
            cityFrom: {
              name: "Yekaterinburg",
              tags: [],
              stationsIds: [],
            },
            cityTo: {
              name: "Sochi",
              tags: [],
              stationsIds: [],
            },
            cost: 1000,
            travellingTime: {
              toPlace: {
                start: "2021-12-12",
                end: "2021-12-13",
              },
              fromPlace: {
                start: "2021-12-30",
                end: "2021-12-31",
              },
            },
          },
          hotels: [
            {
              id: 1406953704,
              name: "Guest House Pragma",
              address: { lon: 43.0594, lat: 44.0486 },
              price: 52274.15,
              rating: 5,
              imageUrl: "",
            },
            {
              id: 1224984043,
              name: "Hotel Kristella",
              address: { lon: 43.0594, lat: 44.0486 },
              price: 67150,
              rating: 4,
              imageUrl: "",
            },
            {
              id: 611050,
              name: "Bristol Spa-Hotel",
              address: { lon: 43.0594, lat: 44.0486 },
              price: 436644.99,
              rating: 4,
              imageUrl: "",
            },
            {
              id: 543356,
              name: "Zateryanny Ray u Mashuka",
              address: { lon: 43.0594, lat: 44.0486 },
              price: 42500,
              rating: 3,
              imageUrl: "",
            },
            {
              id: 9192717,
              name: "Гостевой дом Респект",
              address: { lon: 43.0594, lat: 44.0486 },
              price: 37400,
              rating: 2,
              imageUrl: "",
            },
          ],
        }),
      ],
      tags: [
        {
          id: 1,
          name: "Tag1",
        },
        {
          id: 2,
          name: "Tag2",
        },
        {
          id: 3,
          name: "Tag3",
        },
        {
          id: 4,
          name: "Tag4",
        },
        {
          id: 5,
          name: "Tag5",
        },
        {
          id: 6,
          name: "Tag6",
        },
      ],
      cities: [
        {
          id: 1,
          name: "Москва",
        },
        {
          id: 2,
          name: "Екатеринбург",
        },
        {
          id: 3,
          name: "Кропоткин",
        },
        {
          id: 4,
          name: "Ишим",
        },
      ],
    };
  },
  methods: {
    async requestApplyFilters(requestDto) {
      try {
        const response = await fetch("http://localhost:8080/api/journeys/", {
          method: "POST",
          body: requestDto.toJson(),
          headers: {
            "content-type": "application/json",
          },
        });
        if (response.status === 200) {
          this.suggestions = JSON.parse(await response.text()).map(
            JourneyResponse.fromObject
          );
          console.log(this.suggestions);
        } else {
          console.log(response.json());
        }
      } catch (e) {
        console.log(e.message);
      }
    },
  },
};
</script>

<style scoped lang="scss">
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
  flex-grow: 3;
  margin-right: 1%;
}

.right {
  background: cornflowerblue;
  flex-grow: 1;
  width: 9vmax;
  height: fit-content;
}
</style>
