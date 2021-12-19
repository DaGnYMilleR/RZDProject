export class HotelImages {
  /**
   * @param {Number} mainId
   * @param {Number[]} extraIds
   */
  constructor(mainId, extraIds) {
    this.mainImgUrl = getImageUrl(mainId);
    this.extraImgUrls = extraIds.map(getImageUrl);
  }
}

function getImageUrl(hotelImageId) {
  return `https://photo.hotellook.com/image_v2/limit/${hotelImageId}/800/520.auto`;
}

HotelImages.fromObject = (obj) => {
  return new HotelImages(obj.mainId, obj.extraIds);
};

HotelImages.Null = new HotelImages(1, []);
