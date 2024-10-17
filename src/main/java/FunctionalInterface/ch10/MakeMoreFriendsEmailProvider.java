package FunctionalInterface.ch10;

import FunctionalInterface.ch10.model.User;

public class MakeMoreFriendsEmailProvider implements EmailProvider {
    @Override
    public String getEmail(User user) {
        return "Make more Friends email for " + user.getName();
    }
}
