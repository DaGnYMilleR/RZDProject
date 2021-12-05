<template>
  <span class="multi-range">
    <input
      type="range"
      :min="min"
      :max="range.max"
      :value="range.min"
      @input="changeMinValue"
      id="lower"
    />
    <input
      type="range"
      :min="range.min"
      :value="range.max"
      :max="max"
      @input="changeMaxValue"
      id="upper"
    />
  </span>
</template>

<script>
export default {
  name: "DoubleRangeSlider",
  props: {
    max: Number,
    min: Number,
    range: Object,
  },
  methods: {
    changeMinValue(ev, newValue) {
      this.updateRange(newValue, this.range.max);
    },
    changeMaxValue(ev, newValue) {
      this.updateRange(this.range.min, newValue);
    },
    updateRange(minValue, maxValue) {
      this.$emit("oninput", {
        min: minValue,
        max: maxValue,
      });
    },
  },
};
</script>

<style scoped lang="scss">
body {
  padding: 4em;
  background-color: #333;
}

input[type="range"] {
  box-sizing: border-box;
  appearance: none;
  width: 400px;
  margin: 0;
  padding: 0 2px;
  /* Add some L/R padding to ensure box shadow of handle is shown */
  overflow: hidden;
  border: 0;
  border-radius: 1px;
  outline: none;
  background: linear-gradient(grey, grey) no-repeat center;
  /* Use a linear gradient to generate only the 2px height background */
  background-size: 100% 2px;
  pointer-events: none;

  &:active,
  &:focus {
    outline: none;
  }

  &::-webkit-slider-thumb {
    height: 28px;
    width: 28px;
    border-radius: 28px;
    background-color: #f00;
    position: relative;
    margin: 5px 0;
    cursor: pointer;
    appearance: none;
    pointer-events: all;
    box-shadow: 0 1px 4px 0.5px rgba(0, 0, 0, 0.25);
  }
}

.multi-range {
  position: relative;
  height: 50px;

  input[type="range"] {
    position: absolute;

    &:nth-child(1) {
      &::-webkit-slider-thumb::before {
        background-color: red;
      }
    }

    &:nth-child(2) {
      background: none;

      &::-webkit-slider-thumb::before {
        background-color: grey;
      }
    }
  }
}
</style>
