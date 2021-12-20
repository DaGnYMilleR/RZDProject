export class DateSegment {
  /**
   * @param {String} start
   * @param {String} end
   */
  constructor(start, end) {
    this.start = parseDate(start);
    this.end = parseDate(end);
  }
}

function parseDate(date) {
  return new Date(Date.parse(date)).toLocaleDateString();
}

DateSegment.fromObject = (obj) => {
  return new DateSegment(obj.start, obj.end);
};

DateSegment.Null = new DateSegment("", "");
