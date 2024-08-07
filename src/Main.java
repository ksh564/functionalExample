

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Function<Integer, Integer> integerIntegerFunction = x -> x + 10;


        int result = integerIntegerFunction.apply(10);
        System.out.println(result);
    }
    @FunctionalInterface
    public interface Function<T, R> {
        R apply(T t);
    }


}