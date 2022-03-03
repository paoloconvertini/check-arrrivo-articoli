package it.calolenoci.francesco.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class ElementNotFoundException extends WebApplicationException {
    private ElementNotFoundException(String message) {
        super(message, Response.Status.INTERNAL_SERVER_ERROR);
    }

    public ElementNotFoundException(){
        this(ExceptionMessage.getErrorMessage("001", "Element not found"));
    }
}
