import { City } from "../entity/City";
import { Hotel } from "../entity/Hotel";
import { Ticket } from "../entity/Ticket";

export class JourneyResponse {
  city;
  ticket;
  hotels;
  /**
   * @param {City} city
   * @param {Ticket} ticket
   * @param {Hotel[]} hotels
   */
  constructor(city, ticket, hotels) {
    this.city = city;
    this.ticket = ticket;
    this.hotels = hotels;
  }
}

JourneyResponse.parse = (obj) => {
  return new JourneyResponse(
    City.fromObject(obj.city),
    Ticket.fromObject(obj.ticket),
    obj.hotels.map(Hotel.fromObject)
  );
};
