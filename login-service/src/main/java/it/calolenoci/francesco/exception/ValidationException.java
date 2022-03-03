package it.calolenoci.francesco.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class ValidationException extends WebApplicationException {
    private ValidationException(String message) {
        super(message, Response.Status.BAD_REQUEST);
    }

    public ValidationException(){
        this(ExceptionMessage.getErrorMessage("001", "Parametri in input errati"));
    }
}
