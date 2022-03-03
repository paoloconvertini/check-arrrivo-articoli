package it.calolenoci.francesco.jwt;

import io.smallrye.jwt.build.Jwt;
import it.calolenoci.francesco.model.User;
import it.calolenoci.francesco.model.UserRole;
import it.calolenoci.francesco.service.UserService;
import org.eclipse.microprofile.jwt.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class TokenUtils {

    @Autowired UserService userService;

    public String generateToken(User user){
        List<UserRole> list = userService.findByUsername(user.getUsername());
        Set<String> collect = list.stream()
                .map(UserRole::getRolename)
                .collect(Collectors.toSet());

        return Jwt.issuer("${mp.jwt.verify.issuer}")
                .upn("Paolo")
                .groups(collect)
                .claim(Claims.full_name.name(), user.getUsername())
                .expiresIn(300)
                .sign();
    }

}
