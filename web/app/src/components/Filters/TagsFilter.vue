<template>
  <v-content class="pa-0">
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
        <TagComponent
          :attrs="data.attrs"
          :disabled="data.disabled"
          :selected="data.selected"
          :value="data.item"
          @click="remove"
        />
      </template>
    </v-combobox>
  </v-content>
</template>

<script>
import TagComponent from "../TagComponent";
export default {
  name: "TagsFilter",
  components: { TagComponent },
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
