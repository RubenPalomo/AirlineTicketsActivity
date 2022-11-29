class Trip {
  constructor(destination, date, company, scales, luggage, price) {
    this.destination = destination;
    this.date = date;
    this.company = company;
    this.scales = scales;
    this.luggage = luggage;
    this.price = luggage ? price + price / 10 : price;
  }
}

export default Trip;
