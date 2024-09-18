package FunctionalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ch5sec2 {
    public static void main(String[] args) {
        Function<String, Integer> fun = String::length;
        System.out.println(fun.apply("hello"));

        List<User> users = new ArrayList<>();
        users.add(new User(3, "Alice"));
        users.add(new User(1, "Bob"));
        users.add(new User(5, "Carl"));

        printUserField(users, User::getId);
    }


    public static void printUserField(List<User> list, Function<User, Object> getter) {
        for (User user : list) {
            System.out.println(getter.apply(user));
        }
    }}
