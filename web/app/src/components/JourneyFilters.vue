<template>
  <div class="wrapper">
    <div class="header">Настройки</div>
    <div>
      <select v-model="cityName">
        <option value="" selected disabled hidden>Выберите город...</option>
        <option>Обоссурийск</option>
        <option>Ебатеринбург</option>
        <option>Хреньбург</option>
      </select>
    </div>
    <div>
      <label>Цена: {{ price }}</label>
      <input type="range" v-model="price" min="0" max="10000" step="100" />
    </div>
    <div>
      <span>Начало {{ startDate }}</span>
      <input type="date" v-model="startDate" />
    </div>
    <div>
      <span>Конец {{ endDate }}</span>
      <input type="date" v-model="endDate" />
    </div>
    <div>
      <span>Теги</span>
      <div class="tags">
        <div
          class="tag"
          v-for="tag in this.tagsCollection"
          :key="tag.id"
          :class="{ active: isTagActive(tag.name) }"
          @click="toggleTag(tag.name)"
        >
          {{ tag.name }}
        </div>
      </div>
    </div>
    <div @click="applyFilters()">Принять</div>
  </div>
</template>

<script>
import { JourneyParametersRequest } from "../models/JourneyParametersRequest";

export default {
  name: "JourneyFilters",
  props: {
    tagsCollection: Array,
  },
  data() {
    return {
      cityName: "",
      price: 100,
      startDate: "",
      endDate: "",
      tags: [],
    };
  },
  methods: {
    toggleTag(tagName) {
      const tags = this.tags;
      const idx = tags.indexOf(tagName);
      if (idx === -1) {
        tags.push(tagName);
      } else {
        tags.splice(idx, 1);
      }
    },
    isTagActive(tagName) {
      return this.tags.includes(tagName);
    },
    applyFilters() {
      const request = new JourneyParametersRequest();
      request.cityName = this.cityName;
      request.budget = this.price;
      request.dateFrom = this.startDate;
      request.dateTo = this.endDate;
      request.tags = this.tags;
      this.$emit("onrequest", request);
    },
  },
};
</script>

<style scoped lang="scss">
.wrapper {
  background: #39b54a;
  .header {
    background: brown;
    padding: 0.3vmax;
  }
  .tags {
    display: flex;
    flex-direction: row;
    justify-content: space-evenly;
    .tag {
      background: green;
      display: flex;
      width: fit-content;
      &.active {
        background: blue;
      }
    }
  }
}
</style>
