<template>
  <v-content class="pa-0">
    <v-card-title>Город отправления</v-card-title>
    <v-combobox
      v-model="cityName"
      :hint="cityName"
      :items="cities.map((c) => c.name)"
      :label="label"
      placeholder="Выберите город"
      dense
      outlined
      clearable
      color="blue"
      item-color="blue"
      class="ml-3 mr-3"
    ></v-combobox>
  </v-content>
</template>

<script>
export default {
  name: "CitiesFilter",
  model: {
    prop: "city",
    event: "onchange",
  },
  props: {
    city: {
      type: String,
      default: "",
    },
    label: {
      type: String,
      default: "",
    },
    cities: {
      type: Array,
      default: () => [],
    },
  },
  computed: {
    cityName: {
      get() {
        return this.city;
      },
      set(value) {
        this.$emit("onchange", value);
      },
    },
  },
};
</script>
