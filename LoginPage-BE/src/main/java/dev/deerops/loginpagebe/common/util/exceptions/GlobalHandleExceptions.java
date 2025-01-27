package dev.deerops.loginpagebe.common.util.exceptions;

import dev.deerops.loginpagebe.common.util.result.ExceptionsResponse;
import dev.deerops.loginpagebe.user.model.util.exceptions.UserGeneralValidationsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandleExceptions {

    @ExceptionHandler(UserGeneralValidationsException.class)
    public ResponseEntity<ExceptionsResponse> userEmptyFieldExceptions(UserGeneralValidationsException e){
        return new ResponseEntity<>(new ExceptionsResponse(false,e.getMessage()), HttpStatus.BAD_REQUEST);
    }

}
