<template>
  <v-card>
    <v-card-title>Теги</v-card-title>
    <v-combobox
      v-model="tagsModel"
      :items="tagsCollection"
      label="Выберите теги"
      multiple
      chips
      class="ma-3"
    >
      <template #selection="data">
        <v-chip
          :key="JSON.stringify(data.item)"
          v-bind="data.attrs"
          :input-value="data.selected"
          :disabled="data.disabled"
          @click.stop.prevent="remove(data.item)"
        >
          <v-avatar
            class="accent white--text"
            left
            v-text="data.item.slice(0, 1).toUpperCase()"
          ></v-avatar>
          {{ data.item }}
        </v-chip>
      </template>
    </v-combobox>
  </v-card>
</template>

<script>
export default {
  name: "TagsFilter",
  model: {
    prop: "tags",
    event: "onchange",
  },
  props: {
    tagsCollection: {
      type: Array,
      default: () => [],
    },
    tags: {
      type: Array,
      default: () => [],
    },
  },
  computed: {
    tagsModel: {
      get() {
        return this.tags;
      },
      set(value) {
        this.$emit("onchange", value);
      },
    },
  },
  methods: {
    remove(item) {
      this.tagsModel = this.tags.filter((tag) => tag !== item);
    },
  },
};
</script>

<style scoped></style>
