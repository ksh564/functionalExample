import java.util.function.*;

public class PlayGround {
    public static void main(String[] args) {

//        1급 시민의 조건
//
//        1.함수/메서드의 매개변수로 전달될 수 있는가?
        inputFunction( t -> System.out.println(t), "Hello World");
//        2.함수/메서드의 반환값(return)이 될 수 있는가?
        System.out.println(returnFunction().get());
//        3.변수에 담을 수 있는가?
        Consumer<String> consumer = t -> System.out.println(t);
        consumer.accept("Hello World Consumer");

//        (Integer x) -> {
//            return x + 10;
//        }

//        매개변수의 타입이 유추 가능할 경우 타입 생략 가능
//        매개변수가 하나일 경우 괄호 생략 가능
//        바로 리턴하는 경우 중괄호 생략 가능

//        Function<Integer, Integer> adder = new Adder();
        Function<Integer, Integer> adder = (Integer x) -> {return x + 10;};
        Integer result = adder.apply(10);
        System.out.println(result);

        BiFunction<Integer, Integer, Integer> add = (Integer x, Integer y) -> {return x + y;};
        Integer addResult = add.apply(5, 5);
        System.out.println(addResult);

        //Functional Interface는 단 하나의 abstract Method를 가진다.
        TriFunction<Integer, Integer, Integer, Integer> addTri = (Integer x, Integer y, Integer z) -> {return x + y + z;};


    }
    @FunctionalInterface
    public interface TriFunction<T, U, V ,R> {
      R apply(T t, U u, V v);
    }

    public static void inputFunction(Consumer<String> consumer, String input) {
        consumer.accept(input);
    }

    public static Supplier<Integer> returnFunction() {
        return () ->  15;
    }
}
