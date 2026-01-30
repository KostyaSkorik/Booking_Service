package by.kostya.skorik.presentation.handler;

import by.kostya.skorik.domain.exception.BookingTimeIntersection;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BookingTimeIntersection.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(BookingTimeIntersection e) {
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(new ErrorResponse(e.getMessage(), LocalDateTime.now()));
    }

    public record ErrorResponse(String message, LocalDateTime time){}
}

