package dev.deerops.loginpagebe.common.util.exceptions;

import dev.deerops.loginpagebe.common.util.result.ExceptionsResponse;
import dev.deerops.loginpagebe.message.model.util.exceptions.InvalidOrEmptyMailException;
import dev.deerops.loginpagebe.message.model.util.exceptions.InvalidOrEmptyMessageException;
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

    @ExceptionHandler(InvalidOrEmptyMailException.class)
    public ResponseEntity<ExceptionsResponse> invalidOrEmptyMailExceptions(InvalidOrEmptyMailException e){
        return new ResponseEntity<>(new ExceptionsResponse(false,e.getMessage()),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidOrEmptyMessageException.class)
    public ResponseEntity<ExceptionsResponse> invalidOrEmptyMessagesExceptions(InvalidOrEmptyMessageException e){
        return new ResponseEntity<>(new ExceptionsResponse(false,e.getMessage()),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundEntityException.class)
    public ResponseEntity<ExceptionsResponse> notFoundEntityExceptions(NotFoundEntityException e){
        return new ResponseEntity<>(new ExceptionsResponse(false, e.getMessage()),HttpStatus.NOT_FOUND);
    }
}
