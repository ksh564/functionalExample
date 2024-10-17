package FunctionalInterface.ch10;

import FunctionalInterface.ch10.model.User;

@FunctionalInterface
public interface EmailProvider {
    String getEmail(User user);
}
