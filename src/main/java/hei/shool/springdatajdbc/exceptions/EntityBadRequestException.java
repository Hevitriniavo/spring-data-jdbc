package hei.shool.springdatajdbc.exceptions;

public class EntityBadRequestException extends RuntimeException {

    public EntityBadRequestException(String message) {
        super(message);
    }

    public EntityBadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
