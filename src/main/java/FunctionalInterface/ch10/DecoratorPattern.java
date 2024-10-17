package FunctionalInterface.ch10;

import FunctionalInterface.ch10.model.Price;

public class DecoratorPattern {
    public static void main(String[] args) {

        PriceProcessor originalProcessor = new BasicPriceProcessor();
        TaxPriceProcessor taxPriceProcessor = new TaxPriceProcessor();
        DiscountPriceProcessor discountPriceProcessor = new DiscountPriceProcessor();

        Price originalPrice = new Price("First Price");

       PriceProcessor decoratedProcess = originalProcessor
               .andThen(discountPriceProcessor)
               .andThen(taxPriceProcessor)
               .andThen(price -> new Price(price.getPrice() + ", then third Price"));


       Price processedPrice = decoratedProcess.process(originalPrice);
        System.out.println(processedPrice.getPrice());
    }
}
