import { HotelImages } from "./HotelImages";

export class Hotel {
  id;
  name;
  address;
  price;
  rating;
  imageUrl;

  /**
   * @param {Number} id
   * @param {String} name
   * @param {Object} address
   * @param {Number} price
   * @param {Number} rating
   * @param {HotelImages} images
   */
  constructor(id, name, address, price, rating, images) {
    this.name = name;
    this.address = address;
    this.price = price;
    this.rating = rating;
    this.images = images;
    this.id = id;
  }
}

Hotel.fromObject = (obj) => {
  return new Hotel(
    obj.id,
    obj.name,
    obj.address,
    obj.price,
    obj.rating,
    HotelImages.fromObject(obj.images)
  );
};

Hotel.Null = new Hotel(0, "", {}, 0, 0, HotelImages.Null);
