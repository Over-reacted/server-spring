package eu.overreacted.serverspring.errors;

/**
 * @author Murad Hamza on 14.10.2020 г.
 */
public abstract class CustomException extends RuntimeException {

    abstract int getStatusCode();
}
