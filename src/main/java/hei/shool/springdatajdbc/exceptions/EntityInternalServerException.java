package hei.shool.springdatajdbc.exceptions;

public class EntityInternalServerException extends RuntimeException {
    public EntityInternalServerException(String message) {
        super(message);
    }

    public EntityInternalServerException(String message, Throwable cause) {
        super(message, cause);
    }
}
