package FunctionalInterface.ch10;

import FunctionalInterface.ch10.model.Price;

@FunctionalInterface
public interface PriceProcessor {
    Price process(Price price);
    default PriceProcessor andThen(PriceProcessor next) {
        return price -> next.process(process(price)); // 프로세스 하고 next의 프로세스
    }
}
