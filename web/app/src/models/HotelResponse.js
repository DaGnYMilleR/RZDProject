export class HotelResponse {
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
     * @param {String} imageUrl
     */
    constructor(id, name, address, price, rating, imageUrl) {
        this.name = name;
        this.address = address;
        this.price = price;
        this.rating = rating;
        this.imageUrl = imageUrl;
        this.id = id;
    }
}

HotelResponse.parse = (obj) => {
    return new HotelResponse(obj.id, obj.name, obj.address, obj.price, obj.rating, obj.imageUrl);
}