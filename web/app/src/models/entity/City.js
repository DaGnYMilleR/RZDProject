import { Tag } from "./Tag";

export class City {
  /**
   * @param {String} name
   * @param {Tag[]} tags
   * @param {Number[]} stationsIds
   * @param {String} imageUrl
   */
  constructor(name, tags, stationsIds, imageUrl) {
    this.name = name;
    this.tags = tags;
    this.stationsIds = stationsIds;
    this.imageUrl = imageUrl;
  }
}

City.fromObject = (obj) => {
  return new City(
    obj.name,
    obj.tags.map(Tag.fromObject),
    obj.stationsIds,
    obj.imageUrl
  );
};

City.Null = new City("", [], [], "");
