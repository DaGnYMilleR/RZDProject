export class HotelImages {
  /**
   * @param {Number} mainImage
   * @param {Number[]} extraImages
   */
  constructor(mainImage, extraImages) {
    this.mainImgUrl = getImageUrl(mainImage);
    this.extraImgUrls = extraImages?.map(getImageUrl) ?? [];
  }
}

function getImageUrl(hotelImageId) {
  return `https://photo.hotellook.com/image_v2/limit/${hotelImageId}/800/520.auto`;
}

HotelImages.fromObject = (obj) => {
  return new HotelImages(obj.mainImage, obj.extraImages);
};

HotelImages.Null = new HotelImages(1, []);
