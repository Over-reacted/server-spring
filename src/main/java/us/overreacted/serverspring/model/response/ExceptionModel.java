package us.overreacted.serverspring.model.response;

/**
 * @author Murad Hamza on 14.10.2020 г.
 */
public class ExceptionModel {

    private String message;

    public ExceptionModel() {
    }

    public ExceptionModel(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }
}
