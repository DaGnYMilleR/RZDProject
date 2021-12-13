import { DateSegment } from "./DateSegment";

export class TravellingTime {
  toPlace;
  fromPlace;

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
