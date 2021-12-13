import { DateSegment } from "./DateSegment";

export class TravellingTime {
  /**
   * @param {DateSegment} toPlace
   * @param {DateSegment} fromPlace
   */
  constructor(toPlace, fromPlace) {
    this.toPlace = toPlace;
    this.fromPlace = fromPlace;
  }
}

TravellingTime.fromObject = (obj) => {
  return new TravellingTime(
    DateSegment.fromObject(obj.toPlace),
    DateSegment.fromObject(obj.fromPlace)
  );
};

TravellingTime.Null = new TravellingTime(DateSegment.Null, DateSegment.Null);
