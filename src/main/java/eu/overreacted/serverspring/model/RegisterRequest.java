package eu.overreacted.serverspring.model;

import javax.validation.constraints.NotNull;

/**
 * @author Murad Hamza on 14.10.2020 г.
 */
public class RegisterRequest extends Credentials {

    @NotNull
    private String repeatPassword;

    public RegisterRequest() {
    }

    public RegisterRequest(final String email, final String password, final String repeatPassword) {
        super(email, password);
        this.repeatPassword = repeatPassword;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(final String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }
}
