<template>
  <v-chip
    :key="JSON.stringify(value)"
    v-bind="attrs"
    :input-value="selected"
    :disabled="disabled"
    @click.stop.prevent="click(value)"
  >
    <v-avatar
      class="accent white--text"
      left
      v-text="value.slice(0, 1).toUpperCase()"
    />
    {{ value }}
  </v-chip>
</template>

<script>
export default {
  name: "TagComponent",
  props: {
    data: {
      type: Object,
      default: () => {},
    },
    value: {
      type: String,
      default: "",
    },
    selected: {
      type: Boolean,
      default: false,
    },
    disabled: {
      type: Boolean,
      default: false,
    },
    attrs: {
      type: Object,
      default: () => {},
    },
  },
  methods: {
    click(item) {
      this.$emit("click", item);
    },
  },
};
</script>

<style scoped></style>
