<template>
  <v-card>
    <v-card-title>{{ label }}</v-card-title>
    <v-menu
        v-model="menu2"
        :close-on-content-click="false"
        :nudge-right="40"
        transition="scale-transition"
        offset-y
        min-width="auto"

    >
      <template v-slot:activator="{ on, attrs }">
        <v-text-field
            color="blue"
            v-model="dateModel"
            :label="label"
            prepend-icon="mdi-calendar"
            readonly
            v-bind="attrs"
            v-on="on"
            class="ml-3 mr-3"
        ></v-text-field>
      </template>
      <v-date-picker
          color="blue"
          v-model="dateModel"
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
    date: String,
    label: {
      type: String,
      default: "",
    }
  },
  data: () => ({
    menu2: false,
  }),
  computed: {
    dateModel: {
      set(value) { this.$emit("onchange", value); },
      get() { return this.date; }
    }
  }
}
</script>

<style scoped>

</style>