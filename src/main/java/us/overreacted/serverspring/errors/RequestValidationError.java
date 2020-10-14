package us.overreacted.serverspring.errors;

/**
 * @author Murad Hamza on 14.10.2020 г.
 */

public class RequestValidationError extends CustomException {
    private static final int STATUS_CODE = 400;

    private final String message;

    public RequestValidationError(final String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    int getStatusCode() {
        return STATUS_CODE;
    }
}
