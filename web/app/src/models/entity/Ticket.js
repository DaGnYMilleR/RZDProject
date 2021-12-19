import { City } from "./City";
import { TravellingTime } from "./TravellingTime";

export class Ticket {
  /**
   * @param {City} cityFrom
   * @param {City} cityTo
   * @param {Number} cost
   * @param {TravellingTime} travellingTime
   * @param {String} urlTo
   * @param {String} urlFrom
   */
  constructor(cityFrom, cityTo, cost, travellingTime, urlTo, urlFrom) {
    this.cityFrom = cityFrom;
    this.cityTo = cityTo;
    this.cost = cost;
    this.travellingTime = travellingTime;
    this.urlTo = urlTo;
    this.urlFrom = urlFrom;
  }
}

Ticket.fromObject = (obj) => {
  return new Ticket(
    City.fromObject(obj.cityFrom),
    City.fromObject(obj.cityTo),
    obj.cost,
    TravellingTime.fromObject(obj.travellingTime),
    obj.urlTo,
    obj.urlFrom
  );
};

Ticket.Null = new Ticket(City.Null, City.Null, 0, TravellingTime.Null, "", "");
