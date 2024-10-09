package FunctionalInterface.ch10;

import FunctionalInterface.ch6.model.User;

public class UserService extends AbstractUserService {

    @Override
    protected boolean validateUser(User user) {
        System.out.println("Validating User: " + user.getName());
        return user.getName() != null && user.getEmailAddress().isPresent();
    }

    @Override
    protected void wirteToDB(User user) {
        System.out.println("Writing user " + user.getName() + " to DB");
    }
}
