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

export default {
  name: "Home",
  components: { JourneySuggestions, JourneyFilters },
  data() {
    return {
      suggestions: [
        {
          id: 1,
          name: "Крутая поездочка",
        },
        {
          id: 2,
          name: "Курорт в Ишимчике",
        },
        {
          id: 3,
          name: "Солевые ванны на Уралмаше Екатеринбурга",
        },
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
    requestApplyFilters(requestDto) {
      console.log(requestDto.toJson());
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
}
</style>