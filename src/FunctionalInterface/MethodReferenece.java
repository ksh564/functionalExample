package FunctionalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;

public class MethodReferenece {
    public static void main(String[] args) {
        Function<String, Integer> strLength = String::length;
        int length = strLength.apply("Hello World");
        //sout + tap
        System.out.println(length);

        BiFunction<String, String, Boolean> strLength2 = String::equals;
        boolean strr = strLength2.apply("Hello","World");
        System.out.println(strr);


        BiPredicate<String, String> strEquls = String::equals;
        //ctrl + alt + v
        strEquls.test("hello", "hello");
        boolean stringEquals = strEquls.test("hello", "world");
        System.out.println(stringEquals);

        List<User> users = new ArrayList<>();
        users.add(new User(3,"Alice"));
        users.add(new User(1,"Charlie"));
        users.add(new User(2,"Bob"));

        printUserField(users, User::getId);
    }

    public static void printUserField(List<User> users, Function<User, Object> getter) {
        for (User user : users) {
            System.out.println(getter.apply(user));
        }
    }
}
