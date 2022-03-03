package it.calolenoci.francesco.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class RoleUnauthorizationException extends WebApplicationException {
    // 0010
    private RoleUnauthorizationException(String message) {
        super(message, Response.Status.INTERNAL_SERVER_ERROR);
    }

    public RoleUnauthorizationException() {
        this(ExceptionMessage.getErrorMessage("0011", "Ruolo non autorizzato"));
    }
}
