package FunctionalInterface.ch10;

import FunctionalInterface.ch10.model.Order;

import java.util.Optional;
import java.util.function.Consumer;

public class OrderProcessStep {

    private final Consumer<Order> processOrder; //프로세스에 행위를 정의해주기 위해 컨슈머 선언
    private OrderProcessStep next; // 체이닝을 위해 똑같은 클래스를 선언

    public OrderProcessStep(Consumer<Order> processOrder) {
        this.processOrder = processOrder;
    }

    // 체이닝 함수 선언
    public OrderProcessStep setNext(OrderProcessStep orderProcessStep) {
        if(next == null) {
            this.next = orderProcessStep;
        } else {
            this.next.setNext(orderProcessStep);
        }
        return this;
    }

    public void process(Order order) {
        processOrder.accept(order);
        Optional.ofNullable(next)
                .ifPresent(nextStep -> nextStep.process(order));
    }
}
