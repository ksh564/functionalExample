package FunctionalInterface.ch10;


import FunctionalInterface.ch10.model.Price;

public class BasicPriceProcessor implements PriceProcessor {

	@Override
	public Price process(Price price) {
		return price;
	}

}
