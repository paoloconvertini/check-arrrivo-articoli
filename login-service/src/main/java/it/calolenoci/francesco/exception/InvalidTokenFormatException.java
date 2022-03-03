package it.calolenoci.francesco.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class InvalidTokenFormatException extends WebApplicationException {
    // 0010
    private InvalidTokenFormatException(String message) {
        super(message, Response.Status.INTERNAL_SERVER_ERROR);
    }

    public InvalidTokenFormatException() {
        this(ExceptionMessage.getErrorMessage("0013", "Invalid token format"));
    }
}
