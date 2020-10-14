package us.overreacted.serverspring.model;

/**
 * @author Murad Hamza on 14.10.2020 г.
 */
public class LoginRequest extends Credentials {

    public LoginRequest() {
    }

    public LoginRequest(final String email, final String password) {
        super(email, password);
    }

}
