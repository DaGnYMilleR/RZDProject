export const MoneyFormatter = {
  format(value) {
    return new Intl.NumberFormat("en-US").format(value) + "RUB";
  },
};
