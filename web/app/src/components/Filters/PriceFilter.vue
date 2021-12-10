<template>
  <v-card>
    <v-card-title>Бюджет</v-card-title>
    <vuetify-money
        v-model="priceInput"
        valueWhenIsEmpty="0"
        :clearable="true"
        :options="options"
        color="blue"
        class="input"
    />
  </v-card>
</template>

<script>
export default {
  name: "PriceFilter",
  components: {
  },
  model: {
    prop: "price",
    event: "input",
  },
  props: {
    price: Number,
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
      precision: 0
    },
  }),
  methods: {
    getFormattedPrice() {
      const formatter=  new Intl.NumberFormat("ru-RU");
      return formatter.format(this.price);
    }
  },
  computed: {
    priceInput: {
      set(value) {
        this.$emit("input", +value);
      },
      get() {
        return this.price;
      }
    },
  }
}
</script>

<style scoped>
.input {
  padding-left: 3%;
  padding-right: 3%;
}

.slider {
  margin: 0 3%;
}
</style>