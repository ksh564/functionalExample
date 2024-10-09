package FunctionalInterface.ch8;

import FunctionalInterface.ch6.model.User;

public abstract class AbstractUserService {
    protected abstract boolean validateUser(User user);

    protected abstract void wirteToDB(User user);

    public void createUser(User user) {
        if(validateUser(user)) {
            wirteToDB(user);
        } else {
            System.out.println("Cannot create User");
        }
    }
}
