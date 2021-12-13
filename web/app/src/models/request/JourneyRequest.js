export class JourneyRequest {
  constructor() {
    this.cityName = null;
    this.budget = 0;
    this.dateFrom = null;
    this.dateTo = null;
    this.tags = new Set();
  }

  toJson() {
    return JSON.stringify(this);
  }
}
