package dev.deerops.loginpagebe.message.model.util.exceptions;

public class InvalidOrEmptyMessageException extends RuntimeException{
    public InvalidOrEmptyMessageException(String message) {
        super(message);
    }
}
