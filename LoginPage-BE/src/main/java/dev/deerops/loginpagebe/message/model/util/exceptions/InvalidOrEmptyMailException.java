package dev.deerops.loginpagebe.message.model.util.exceptions;

public class InvalidOrEmptyMailException extends RuntimeException{
    public InvalidOrEmptyMailException(String message) {
        super(message);
    }
}
