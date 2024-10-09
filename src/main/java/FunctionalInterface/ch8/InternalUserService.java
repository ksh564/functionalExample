package FunctionalInterface.ch8;

import FunctionalInterface.ch6.model.User;

public class InternalUserService extends AbstractUserService{
    @Override
    protected boolean validateUser(User user) {
        System.out.println("validating internal user " + user.getName());
        return true;
    }

    @Override
    protected void wirteToDB(User user) {
        System.out.println("Writing user " + user.getName() + " to internal DB");
    }
}
