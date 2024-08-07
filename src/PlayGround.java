import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class PlayGround {
    public static void main(String[] args) {

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
    }
}
