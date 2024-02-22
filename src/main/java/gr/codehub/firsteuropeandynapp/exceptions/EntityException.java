package gr.codehub.firsteuropeandynapp.exceptions;

public class EntityException extends Exception {
    public EntityException(String message){
        super(message);
    }

    public EntityException(){
        super();
    }

    public EntityException(String message, Throwable t) {
        super(message, t);
    }
}
