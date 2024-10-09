package FunctionalInterface.ch10;

import FunctionalInterface.ch10.model.Order;
import FunctionalInterface.ch10.model.OrderLine;

import java.math.BigDecimal;
import java.util.Arrays;

public class ChainOfResponsibilityPattern {
    public static void main(String[] args) {


        Order firstOrder = new Order()
                .setId(1001L)
                .setStatus(Order.OrderStatus.CREATED)
                .setOrderLines(Arrays.asList(
                        new OrderLine().setAmount(BigDecimal.valueOf(1000)),
                        new OrderLine().setAmount(BigDecimal.valueOf(2000))));

        orderProcess(firstOrder);





        OrderProcessStep initializeStep = new OrderProcessStep(order -> {
            if (order.getStatus() == Order.OrderStatus.CREATED) {
                System.out.println("오더 시작 " + order.getId());
                order.setStatus(Order.OrderStatus.IN_PROGRESS);
            }
        });

        OrderProcessStep setOrderAmountStep = new OrderProcessStep(order -> {
            if (order.getStatus() == Order.OrderStatus.IN_PROGRESS) {
                System.out.println("오더가격 설정 " + order.getId());
                order.setAmount(order.getOrderLines().stream()
                        .map(OrderLine::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add));
            }
        });

        OrderProcessStep verifyOrderStep = new OrderProcessStep(order -> {
            if (order.getStatus() == Order.OrderStatus.IN_PROGRESS) {
                System.out.println("가격 검증  " + order.getId());
                if (order.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
                    order.setStatus(Order.OrderStatus.ERROR);
                }
            }
        });

        OrderProcessStep processPaymentStep = new OrderProcessStep(order -> {
            if (order.getStatus() == Order.OrderStatus.IN_PROGRESS) {
                System.out.println("오더 중 " + order.getId());
                order.setStatus(Order.OrderStatus.PROCESSED);
            }
        });

        OrderProcessStep handleErrorStep = new OrderProcessStep(order -> {
            if (order.getStatus() == Order.OrderStatus.ERROR) {
                System.out.println("오더 실패 " + order.getId());
            }
        });

        OrderProcessStep completeProcessingOrderStep = new OrderProcessStep(order -> {
            if(order.getStatus() == Order.OrderStatus.PROCESSED) {
                System.out.println("오더 종료 " + order.getId());
            }
        });


        OrderProcessStep chainedOrderProcessSteps = initializeStep
                .setNext(setOrderAmountStep)
                .setNext(verifyOrderStep)
                .setNext(processPaymentStep)
                .setNext(handleErrorStep)
                .setNext(completeProcessingOrderStep);

//        chainedOrderProcessSteps.process(firstOrder);
    }


    public static void orderProcess(Order order) {
        if (order.getStatus() == Order.OrderStatus.CREATED) {
            System.out.println("오더 시작 " + order.getId());
            order.setStatus(Order.OrderStatus.IN_PROGRESS);
        }

        if (order.getStatus() == Order.OrderStatus.IN_PROGRESS) {
            System.out.println("오더가격 설정 " + order.getId());
            order.setAmount(order.getOrderLines().stream()
                    .map(OrderLine::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add));
        }

        if (order.getStatus() == Order.OrderStatus.IN_PROGRESS) {
            System.out.println("가격 검증  " + order.getId());
            if (order.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
                order.setStatus(Order.OrderStatus.ERROR);
            }
        }

        if (order.getStatus() == Order.OrderStatus.IN_PROGRESS) {
            System.out.println("오더 중 " + order.getId());
            order.setStatus(Order.OrderStatus.PROCESSED);
        }

        if (order.getStatus() == Order.OrderStatus.ERROR) {
            System.out.println("오더 실패 " + order.getId());
        }

        if(order.getStatus() == Order.OrderStatus.PROCESSED) {
            System.out.println("오더 종료 " + order.getId());
        }

    }
}
