<template>
  <div class="home">
    <div class="content">
      <div class="left">
        <JourneySuggestions :suggestions="suggestions" />
      </div>
      <div class="right">
        <JourneyFilters
          :tags-collection="tags"
          @onrequest="requestApplyFilters"
        />
      </div>
    </div>
  </div>
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
  flex-grow: 1;
}

.content {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
  height: 100%;
}

.left {
  background: rebeccapurple;
  flex-grow: 3;
}

.right {
  background: cornflowerblue;
  flex-grow: 1;
}
</style>
