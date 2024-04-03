package hei.shool.springdatajdbc.advices;


import java.time.LocalDate;

public record ApplicationErrorMessage(
        String message,
        LocalDate date,
        int code
) {
}
