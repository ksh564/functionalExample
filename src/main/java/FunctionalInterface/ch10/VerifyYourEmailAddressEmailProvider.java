package FunctionalInterface.ch10;

import FunctionalInterface.ch10.model.User;

public class VerifyYourEmailAddressEmailProvider implements EmailProvider {
    @Override
    public String getEmail(User user) {
        return "Verify Your Email Address " + user.getName();
    }
}
