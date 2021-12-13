export class DateSegment {
  start;
  end;

  /**
   * @param {String} start
   * @param {String} end
   */
  constructor(start, end) {
    this.start = start;
    this.end = end;
  }
}

DateSegment.fromObject = (obj) => {
  return new DateSegment(obj.start, obj.end);
};
