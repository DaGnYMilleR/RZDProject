<template>
  <div class="home">
    <div class="content">
      <div class="left">
        <div class="header">Какой-то ссаный заголовок</div>
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
export default {
  name: "Home",
  components: { JourneyFilters },
  data() {
    return {
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
  .header {
    background: white;
    color: black;
    padding: 0.3vmax;
  }
}

.right {
  background: cornflowerblue;
  flex-grow: 1;
}
</style>
