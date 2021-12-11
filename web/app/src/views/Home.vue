<template>
  <v-container fluid style="height: 100%">
    <div class="home">
      <div class="header">Выбор путешествия</div>
      <div class="content">
        <div class="left">
          <JourneySuggestions :suggestions="suggestions"/>
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
import {HotelResponse} from "../models/JourneyParametersRequest";

export default {
  name: "Home",
  components: { JourneySuggestions, JourneyFilters },
  data() {
    return {
      suggestions: [
        HotelResponse.parse({
          address: {lon: 37.617508, lat: 55.75204},
          id: 333578,
          imageUrl: "https://photo.hotellook.com/image_v2/limit/8678014703/800/520.auto",
          name: "Moscow Marriott Grand Hotel",
          price: 65345,
          rating: 5,
        }),
        HotelResponse.parse({
          address: {lon: 37.617508, lat: 55.75204},
          id: 333578,
          imageUrl: "https://photo.hotellook.com/image_v2/limit/8678014703/800/520.auto",
          name: "Moscow Marriott Grand Hotel",
          price: 65345,
          rating: 5,
        }),
        HotelResponse.parse({
          address: {lon: 37.617508, lat: 55.75204},
          id: 333578,
          imageUrl: "https://photo.hotellook.com/image_v2/limit/8678014703/800/520.auto",
          name: "Moscow Marriott Grand Hotel",
          price: 65345,
          rating: 5,
        }),
        HotelResponse.parse({
          address: {lon: 37.617508, lat: 55.75204},
          id: 333578,
          imageUrl: "https://photo.hotellook.com/image_v2/limit/8678014703/800/520.auto",
          name: "Moscow Marriott Grand Hotel",
          price: 65345,
          rating: 5,
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
          name: "Москва"
        },
        {
          id: 2,
          name: "Екатеринбург"
        },
        {
          id: 3,
          name: "Кропоткин"
        },
        {
          id: 4,
          name: "Ишим"
        },
      ]
    };
  },
  methods: {
    async requestApplyFilters(requestDto) {
      try {
        const response = await fetch('http://localhost:8080/api/journeys/',
            {
              method: 'POST',
              body:requestDto.toJson(),
              headers: {
                'content-type': 'application/json'
              }});
        if (response.status === 200) {
          this.suggestions = JSON.parse(await response.text()).map(HotelResponse.parse);
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