package it.calolenoci.francesco.service;


import it.calolenoci.francesco.model.User;
import it.calolenoci.francesco.model.UserRole;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    Optional<User> findById(String id);
    List<User> findByName(String name);
    List<UserRole> findByUsername(String username);
    Optional<User> findByUsernameAndPassword(String name, String password);
}
