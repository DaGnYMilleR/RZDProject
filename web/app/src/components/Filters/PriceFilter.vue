<template>
  <v-content class="pa-0">
    <v-card-title>Бюджет</v-card-title>
    <vuetify-money
      v-model="priceInput"
      value-when-is-empty="0"
      :clearable="true"
      :options="options"
      color="blue"
      class="input"
    />
  </v-content>
</template>

<script>
export default {
  name: "PriceFilter",
  components: {},
  model: {
    prop: "price",
    event: "input",
  },
  props: {
    price: {
      type: Number,
      default: 0,
    },
  },
  data: () => ({
    min: 0,
    max: 10_000,
    step: 100,
    options: {
      locale: "en-US",
      prefix: "RUB",
      suffix: "",
      length: 11,
      precision: 0,
    },
  }),
  computed: {
    priceInput: {
      set(value) {
        this.$emit("input", +value);
      },
      get() {
        return this.price;
      },
    },
  },
  methods: {
    getFormattedPrice() {
      const formatter = new Intl.NumberFormat("ru-RU");
      return formatter.format(this.price);
    },
  },
};
</script>

<style scoped>
.input {
  padding-left: 3%;
  padding-right: 3%;
}
</style>
