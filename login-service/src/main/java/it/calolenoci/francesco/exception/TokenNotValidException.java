package it.calolenoci.francesco.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class TokenNotValidException extends WebApplicationException {
    // 0010
    private TokenNotValidException(String message) {
        super(message, Response.Status.INTERNAL_SERVER_ERROR);
    }

    public TokenNotValidException() {
        this(ExceptionMessage.getErrorMessage("0012", "Invalid token"));
    }
}
