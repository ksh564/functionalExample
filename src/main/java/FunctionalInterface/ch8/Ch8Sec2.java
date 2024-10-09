package FunctionalInterface.ch8;

import FunctionalInterface.ch6.model.Order;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Ch8Sec2 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, -4, 2, 7 ,8);
        boolean allPositiver = numbers.stream()
                .allMatch(number -> number > 0);
        System.out.println("Are all positive? " + allPositiver);

        boolean anyPositiver = numbers.stream()
                .anyMatch(number -> number > 0);
        System.out.println("Are any positive? " + anyPositiver);

        Order order1 = new Order()
                .setId(1001L)
                .setAmount(BigDecimal.valueOf(2000))
                .setStatus(Order.OrderStatus.CREATED);
        Order order2 = new Order()
                .setId(1002L)
                .setAmount(BigDecimal.valueOf(4000))
                .setStatus(Order.OrderStatus.ERROR);
        Order order3 = new Order()
                .setId(1003L)
                .setAmount(BigDecimal.valueOf(3000))
                .setStatus(Order.OrderStatus.ERROR);
        Order order4 = new Order()
                .setId(1004L)
                .setAmount(BigDecimal.valueOf(7000))
                .setStatus(Order.OrderStatus.PROCESSED);
        List<Order> orders = Arrays.asList(order1, order2, order3, order4);

        boolean isErrorOrder = orders.stream()
                .anyMatch(order -> order.getStatus().equals(Order.OrderStatus.ERROR));
        System.out.println("is Error Order? " + isErrorOrder);

    }
}
