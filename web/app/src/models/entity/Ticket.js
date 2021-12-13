import { City } from "./City";
import { TravellingTime } from "./TravellingTime";

export class Ticket {
  cityFrom;
  cityTo;
  cost;
  travellingTime;

  /**
   * @param {City} cityFrom
   * @param {City} cityTo
   * @param {Number} cost
   * @param {TravellingTime} travellingTime
   */
  constructor(cityFrom, cityTo, cost, travellingTime) {
    this.cityFrom = cityFrom;
    this.cityTo = cityTo;
    this.cost = cost;
    this.travellingTime = travellingTime;
  }
}

Ticket.fromObject = (obj) => {
  return new Ticket(
    City.fromObject(obj.cityFrom),
    City.fromObject(obj.cityTo),
    obj.cost,
    TravellingTime.fromObject(obj.travellingTime)
  );
};
