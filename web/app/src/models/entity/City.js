import { Tag } from "./Tag";

export class City {
  /**
   * @param {String} name
   * @param {Tag[]} tags
   * @param {Number[]} stationsId
   * @param {String} imageUrl
   */
  constructor(name, tags, stationsId, imageUrl) {
    this.name = name;
    this.tags = tags;
    this.stationsId = stationsId;
    this.imageUrl = imageUrl;
  }
}

City.fromObject = (obj) => {
  return new City(
    obj.name,
    obj.tags.map(Tag.fromObject),
    obj.stationsId,
    obj.imageUrl
  );
};

City.Null = new City("", [], [], "");
