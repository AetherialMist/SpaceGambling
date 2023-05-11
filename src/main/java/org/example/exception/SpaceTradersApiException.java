package org.example.exception;

public class SpaceTradersApiException extends Exception {

    public SpaceTradersApiException(String message) {
        super(message);
    }

    public SpaceTradersApiException(String message, Throwable cause) {
        super(message, cause);
    }

}
