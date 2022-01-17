export class JourneyRequest {
  constructor() {
    this.cityName = null;
    this.trainsBudget = 0;
    this.dateFrom = null;
    this.dateTo = null;
    this.hotelsBudget = null;
    this.tags = new Set();
    this.typeOfTrainCar = 0;
  }

  toJson() {
    return JSON.stringify(this);
  }
}
