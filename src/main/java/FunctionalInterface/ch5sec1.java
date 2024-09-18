package FunctionalInterface;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class ch5sec1 {
    public static void main(String[] args) {
        int a = Integer.parseInt("12");
        Function<String, Integer> f = Integer::parseInt;
        System.out.println(a);
        System.out.println(f.apply("20"));

        String str = "Hello";
        boolean b = str.equals("Hello");
        Predicate<String> equalsToHello = str::equals;
        System.out.println(equalsToHello.test("Hello"));
    }


}
