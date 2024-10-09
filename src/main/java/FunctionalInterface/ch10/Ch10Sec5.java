package FunctionalInterface.ch10;

import FunctionalInterface.ch10.model.User;

import java.util.Arrays;

public class Ch10Sec5 {
    public static void main(String[] args) {
        User dummy = User.builder(1, "Dummy")
                .with(builder -> {
                    builder.emailAddress = "dummy@hyundai-autoever.com";
                    builder.isVerified = false;
                    builder.friendUserIds = Arrays.asList(1,2,3,4,5,6);
                }).build();

        InternalUserService internalUserService = new InternalUserService();
        internalUserService.createUser(dummy);

        UserService userService = new UserService();
        userService.createUser(dummy);

        UserServiceInFunctionalWay userServiceInFunctionalWay = new UserServiceInFunctionalWay(
                user -> {
                    System.out.println("Validating User: " + user.getName());
                    return user.getName() != null && user.getEmailAddress().isPresent();
                },
                user -> {
                    System.out.println("Writing user " + user.getName() + " to internal DB");
                }
        );
        userServiceInFunctionalWay.createUser(dummy);
    }
}
