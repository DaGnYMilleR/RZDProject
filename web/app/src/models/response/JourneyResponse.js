import { City } from "../entity/City";
import { Hotel } from "../entity/Hotel";
import { Ticket } from "../entity/Ticket";

export class JourneyResponse {
  /**
   * @param {City} city
   * @param {Ticket[]} tickets
   * @param {Hotel[]} hotels
   */
  constructor(city, tickets, hotels) {
    this.city = city;
    this.tickets = tickets;
    this.hotels = hotels;
  }
}

JourneyResponse.fromObject = (obj) => {
  return new JourneyResponse(
    City.fromObject(obj.city),
    obj.tickets.map(Ticket.fromObject),
    obj.hotels.map(Hotel.fromObject)
  );
};

JourneyResponse.Null = new JourneyResponse(City.Null, [], []);
