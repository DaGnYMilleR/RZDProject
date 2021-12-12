<template>
  <v-card>
    <v-card-title>Город отправления</v-card-title>
    <v-combobox
        v-model="cityName"
        :hint="cityName"
        :items="cities.map(c => c.name)"
        :label="label"
        placeholder="Выберите город"
        dense
        outlined
        clearable
        color="blue"
        item-color="blue"
        class="ml-3 mr-3"
    ></v-combobox>
  </v-card>
</template>

<script>
export default {
  name: "CitiesFilter",
  model: {
    prop: "city",
    event: "onchange",
  },
  props: {
    city: String,
    label: {
      type: String,
      default: "",
    },
    cities: Array
  },
  computed: {
    cityName: {
      get() {return this.city; },
      set(value) {
        this.$emit("onchange", value);
      }
    }
  }
}
</script>

<style scoped>
.input {
  margin-left: 3%;
  margin-right: 3%;
}
</style>