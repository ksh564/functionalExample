package FunctionalInterface.ch10;

import FunctionalInterface.ch10.model.Order;
import FunctionalInterface.ch10.model.OrderLine;

import java.math.BigDecimal;
import java.util.Arrays;

public class BeforeChainOfResponsibilityPattern {
    public static void main(String[] args) {
        Order firstOrder = new Order()
                .setId(1001L)
                .setStatus(Order.OrderStatus.CREATED)
                .setOrderLines(Arrays.asList(
                        new OrderLine().setAmount(BigDecimal.valueOf(1000)),
                        new OrderLine().setAmount(BigDecimal.valueOf(2000))));

        // 처리 단계 생성 및 체인 연결
        BeforeOrderProcessStep initializeStep = new InitializeOrderStep();
        BeforeOrderProcessStep setOrderAmountStep = new SetOrderAmountStep();
        BeforeOrderProcessStep verifyOrderStep = new VerifyOrderStep();
        BeforeOrderProcessStep processPaymentStep = new ProcessPaymentStep();
        BeforeOrderProcessStep handleErrorStep = new HandleErrorStep();
        BeforeOrderProcessStep completeProcessingOrderStep = new CompleteProcessingOrderStep();

        // 처리 단계 체인 설정
        initializeStep.setNext(setOrderAmountStep)
                .setNext(verifyOrderStep)
                .setNext(processPaymentStep)
                .setNext(handleErrorStep)
                .setNext(completeProcessingOrderStep);

        // 첫 번째 단계에서 처리 시작
        initializeStep.process(firstOrder);
    }
}

// 기본적인 책임 연쇄 패턴의 추상 클래스

// 각 처리 단계를 명시적으로 구현한 클래스들

class InitializeOrderStep extends BeforeOrderProcessStep {
    @Override
    protected void processOrder(Order order) {
        if (order.getStatus() == Order.OrderStatus.CREATED) {
            System.out.println("오더 시작 " + order.getId());
            order.setStatus(Order.OrderStatus.IN_PROGRESS);
        }
    }
}

class SetOrderAmountStep extends BeforeOrderProcessStep {
    @Override
    protected void processOrder(Order order) {
        if (order.getStatus() == Order.OrderStatus.IN_PROGRESS) {
            System.out.println("오더가격 설정 " + order.getId());
            order.setAmount(order.getOrderLines().stream()
                    .map(OrderLine::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add));
        }
    }
}

class VerifyOrderStep extends BeforeOrderProcessStep {
    @Override
    protected void processOrder(Order order) {
        if (order.getStatus() == Order.OrderStatus.IN_PROGRESS) {
            System.out.println("가격 검증 " + order.getId());
            if (order.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
                order.setStatus(Order.OrderStatus.ERROR);
            }
        }
    }
}

class ProcessPaymentStep extends BeforeOrderProcessStep {
    @Override
    protected void processOrder(Order order) {
        if (order.getStatus() == Order.OrderStatus.IN_PROGRESS) {
            System.out.println("오더 중 " + order.getId());
            order.setStatus(Order.OrderStatus.PROCESSED);
        }
    }
}

class HandleErrorStep extends BeforeOrderProcessStep {
    @Override
    protected void processOrder(Order order) {
        if (order.getStatus() == Order.OrderStatus.ERROR) {
            System.out.println("오더 실패 " + order.getId());
        }
    }
}

class CompleteProcessingOrderStep extends BeforeOrderProcessStep {
    @Override
    protected void processOrder(Order order) {
        if (order.getStatus() == Order.OrderStatus.PROCESSED) {
            System.out.println("오더 종료 " + order.getId());
        }
    }
}