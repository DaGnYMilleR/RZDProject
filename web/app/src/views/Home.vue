<template>
  <div class="home">
    <div class="content">
      <div class="left">
        <div class="header">Какой-то ссаный заголовок</div>
      </div>
      <div class="right">
        <div class="wrapper">
          <div class="header">Настройки</div>
          <div>
            <select>
              <option value="" selected disabled hidden>
                Выберите город...
              </option>
              <option>Обоссурийск</option>
              <option>Хуень</option>
              <option>Ебатеринбург</option>
            </select>
          </div>
          <div>
            <label>Цена: {{ price }}</label>
            <input
              type="range"
              v-model="price"
              min="0"
              max="10000"
              step="100"
            />
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
                :class="{ active: tag.isActive }"
                v-for="tag in tags"
                :key="tag.id"
                @click="toggleTag(tag)"
              >
                {{ tag.name }}
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Home",
  data() {
    return {
      price: 100,
      startDate: "",
      endDate: "",

      tags: [
        {
          id: 1,
          name: "Tag1",
          isActive: false,
        },
        {
          id: 2,
          name: "Tag2",
          isActive: false,
        },
        {
          id: 3,
          name: "Tag3",
          isActive: false,
        },
        {
          id: 4,
          name: "Tag4",
          isActive: false,
        },
        {
          id: 5,
          name: "Tag5",
          isActive: false,
        },
        {
          id: 6,
          name: "Tag6",
          isActive: false,
        },
      ],
    };
  },
  methods: {
    toggleTag(tag) {
      tag.isActive = !tag.isActive;
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
}
</style>
