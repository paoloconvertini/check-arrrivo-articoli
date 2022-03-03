package it.calolenoci.francesco;

import it.calolenoci.francesco.dto.ErrorResponseDTO;
import it.calolenoci.francesco.dto.UserRequestDTO;
import it.calolenoci.francesco.dto.UserResponseDTO;
import it.calolenoci.francesco.exception.UserNotFoundException;
import it.calolenoci.francesco.jwt.TokenUtils;
import it.calolenoci.francesco.model.User;
import it.calolenoci.francesco.service.UserService;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Path("api/v1/login")
@RequestScoped
public class LoginResource {

    @Autowired
    protected UserService userService;

    @Inject
    protected TokenUtils tokenUtils;

    @Inject
    Logger log;


    @POST
    @PermitAll
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses(
            value = {
                    @APIResponse(
                            responseCode = "500",
                            description = "Errore",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = ErrorResponseDTO.class)
                            )
                    ),
                    @APIResponse(
                            responseCode = "400",
                            description = "Errore di validazione",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = ErrorResponseDTO.class)
                            )
                    ),
                    @APIResponse(
                    responseCode = "401",
                    description = "Token non valido",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(implementation = ErrorResponseDTO.class)
                        )
                    ),
                    @APIResponse(
                            responseCode = "403",
                            description = "Utente non autorizzato",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = ErrorResponseDTO.class)
                            )
                    ),
                    @APIResponse(
                            responseCode = "200",
                            description = "login",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = File.class)
                            )
                    )
            }
    )
    @Operation(
            summary = "Login",
            description = "Login utente",
            operationId = "login"
    )
    public Response login(UserRequestDTO utente) {
        log.debug("user: " + utente.getUsername());
        log.debug("password: " + utente.getPassword());
        String username = utente.getUsername();
        String password = utente.getPassword();
        Optional<User> user = userService.findByUsernameAndPassword(username, password);
        if (user.isPresent()) {
            String token = tokenUtils.generateToken(user.get());
            return Response.ok(token).build();
        } else {
            throw  new UserNotFoundException();
        }
    }


    @GET
    @Path("/users/q/{name}")
    @RolesAllowed({ "Users", "Admin" })
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses(
            value = {
                    @APIResponse(
                            responseCode = "500",
                            description = "Errore",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = ErrorResponseDTO.class)
                            )
                    ),
                    @APIResponse(
                            responseCode = "400",
                            description = "Errore di validazione",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = ErrorResponseDTO.class)
                            )
                    ),
                    @APIResponse(
                            responseCode = "401",
                            description = "Utente non autorizzato",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = ErrorResponseDTO.class)
                            )
                    ),
                    @APIResponse(
                            responseCode = "200",
                            description = "findUser",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON,
                                    schema = @Schema(implementation = File.class)
                            )
                    )
            }
    )
    @Operation(
            summary = "FindUser",
            description = "Find user by name",
            operationId = "findByName"
    )
    public List<UserResponseDTO> getUserByName(@PathParam(value = "name") String name) {
        List<User> userList = userService.findByName(name);
        List<UserResponseDTO> list = new ArrayList<>();
        userList.forEach(u -> list.add(new UserResponseDTO(u)));
        return list;
    }
}