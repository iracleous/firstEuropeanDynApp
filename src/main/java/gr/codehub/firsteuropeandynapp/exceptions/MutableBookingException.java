package gr.codehub.firsteuropeandynapp.exceptions;

public class MutableBookingException extends RuntimeException {
    public MutableBookingException(String message) {
        super(message);
    }

    public MutableBookingException() {
        super();
    }
}
