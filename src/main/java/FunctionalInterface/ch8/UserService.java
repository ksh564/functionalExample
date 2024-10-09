package FunctionalInterface.ch8;

import FunctionalInterface.ch6.model.User;

import java.util.Collection;
import java.util.List;
import java.util.Set;

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
