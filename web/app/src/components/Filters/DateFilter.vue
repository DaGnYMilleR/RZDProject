<template>
  <v-card class="ma-2">
    <v-card-title>{{ label }}</v-card-title>
    <v-menu
      v-model="menu2"
      :close-on-content-click="false"
      :nudge-right="40"
      transition="scale-transition"
      offset-y
      min-width="auto"
    >
      <template #activator="{ on, attrs }">
        <v-text-field
          v-model="dateModel"
          color="blue"
          :label="label"
          prepend-icon="mdi-calendar"
          readonly
          v-bind="attrs"
          class="ml-3 mr-3"
          v-on="on"
        ></v-text-field>
      </template>
      <v-date-picker
        v-model="dateModel"
        color="blue"
        :allowed-dates="allowedDates"
        @input="menu2 = false"
      ></v-date-picker>
    </v-menu>
  </v-card>
</template>

<script>
export default {
  name: "DateFilter",
  model: {
    prop: "date",
    event: "onchange",
  },
  props: {
    date: {
      type: String,
      default: "",
    },
    label: {
      type: String,
      default: "",
    },
    allowedDates: {
      type: Function,
      // eslint-disable-next-line no-unused-vars
      default: (_data) => true,
    },
  },
  data: () => ({
    menu2: false,
  }),
  computed: {
    dateModel: {
      set(value) {
        this.$emit("onchange", value);
      },
      get() {
        return this.date;
      },
    },
  },
};
</script>

<style scoped></style>
