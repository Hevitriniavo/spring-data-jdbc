package hei.shool.springdatajdbc.advices;

import hei.shool.springdatajdbc.exceptions.EntityBadRequestException;
import hei.shool.springdatajdbc.exceptions.EntityInternalServerException;
import hei.shool.springdatajdbc.exceptions.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;

@RestControllerAdvice
public class ApplicationRestControllerAdvice {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ApplicationErrorMessage handlerException(EntityNotFoundException ex) {
        return new ApplicationErrorMessage(
                ex.getMessage(),
                LocalDate.now(),
                HttpStatus.NOT_FOUND.value()
        );
    }

    @ExceptionHandler(EntityInternalServerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody ApplicationErrorMessage handlerException(EntityInternalServerException ex) {
        return new ApplicationErrorMessage(
                ex.getMessage(),
                LocalDate.now(),
                HttpStatus.INTERNAL_SERVER_ERROR.value()
        );
    }

    @ExceptionHandler(EntityBadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ApplicationErrorMessage handlerException(EntityBadRequestException ex) {
        return new ApplicationErrorMessage(
                ex.getMessage(),
                LocalDate.now(),
                HttpStatus.BAD_REQUEST.value()
        );
    }
}
