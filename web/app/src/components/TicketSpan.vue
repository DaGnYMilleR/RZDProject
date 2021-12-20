<template>
  <div>
    <div class="pa-1">{{ city.name }}</div>
    <div class="pa-1">
      Отправление: <strong>{{ dateRange.start }}</strong>
    </div>
    <div class="pa-1">
      Прибытие: <strong>{{ dateRange.end }}</strong>
    </div>
    <a :href="url" style="text-decoration: none" class="pa-1">
      <v-btn>Купить билет</v-btn>
    </a>
  </div>
</template>

<script>
import { City } from "../models/entity/City";
import { DateSegment } from "../models/entity/DateSegment";

export default {
  name: "TicketSpan",
  props: {
    city: {
      type: City,
      default: () => City.Null,
    },
    dateRange: {
      type: DateSegment,
      default: () => DateSegment.Null,
    },
    url: {
      type: String,
      default: "",
    },
  },
};
</script>

<style scoped></style>
