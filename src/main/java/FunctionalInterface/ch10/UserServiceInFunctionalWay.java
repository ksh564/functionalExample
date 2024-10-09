package FunctionalInterface.ch10;

import FunctionalInterface.ch10.model.User;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class UserServiceInFunctionalWay {
    private final Predicate<User> validateUser; // Boolean 리턴을 받기 위해 Prediacte를 선언
    private final Consumer<User> writeToDB; //기존에 writeDB라는 작업이 void 반환형이기 때문에 여기서 특정 로직을 실행하지만 값을 반환하지 않는 Consumer를 사용

    public UserServiceInFunctionalWay(Predicate<User> validateUser, Consumer<User> writeToDB) {
        this.validateUser = validateUser;
        this.writeToDB = writeToDB;
    }

    public void createUser(User user) {
        if (validateUser.test(user)) {
            writeToDB.accept(user);
        } else {
            System.out.println("Cannot create User");
        }
    }
}
