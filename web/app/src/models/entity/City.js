import { Tag } from "./Tag";

export class City {
  /**
   * @param {String} name
   * @param {Tag[]} tags
   * @param {Number[]} stationsIds
   */
  constructor(name, tags, stationsIds) {
    this.name = name;
    this.tags = tags;
    this.stationsIds = stationsIds;
  }
}

City.fromObject = (obj) => {
  return new City(obj.name, obj.tags.map(Tag.fromObject), obj.stationsId);
};

City.Null = new City("", [], []);
