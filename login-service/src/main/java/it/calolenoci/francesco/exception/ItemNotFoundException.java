package it.calolenoci.francesco.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class ItemNotFoundException extends WebApplicationException {
    // 0010
    private ItemNotFoundException(String message) {
        super(message, Response.Status.INTERNAL_SERVER_ERROR);
    }

    public ItemNotFoundException() {
        this(ExceptionMessage.getErrorMessage("0010", "Oggetto non trovato"));
    }
}
