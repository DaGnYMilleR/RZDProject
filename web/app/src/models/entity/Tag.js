export class Tag {
  value;

  /**
   * @param {String} value
   */
  constructor(value) {
    this.value = value;
  }
}

Tag.fromObject = (obj) => new Tag(obj.value);
