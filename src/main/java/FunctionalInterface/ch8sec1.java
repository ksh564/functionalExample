package FunctionalInterface;

import FunctionalInterface.ch6.model.Order;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ch8sec1 {
    public static void main(String[] args) {
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

        //문제 - 오더 중 에러상태이면서 가장 비싼 오더 고르기

        Order maxOrder = orders.stream()
                .filter(order -> order.getStatus().equals(Order.OrderStatus.ERROR))
                .max(Comparator.comparing(Order::getAmount)).get();

        System.out.println(maxOrder);
    }
}
