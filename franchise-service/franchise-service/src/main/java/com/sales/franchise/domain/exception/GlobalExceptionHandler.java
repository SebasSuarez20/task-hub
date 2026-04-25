
package com.sales.franchise.domain.exception;
import com.sales.franchise.application.dto.ApiResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponseDTO<Void> handleRuntimeException(RuntimeException ex) {
        return new ApiResponseDTO<>(
            false,
            ex.getMessage(),
            null
        );
    }
}