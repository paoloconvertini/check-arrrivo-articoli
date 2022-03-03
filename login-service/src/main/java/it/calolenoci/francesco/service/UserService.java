package it.calolenoci.francesco.service;

import it.calolenoci.francesco.model.User;
import it.calolenoci.francesco.model.UserRole;
import it.calolenoci.francesco.repository.UserRepository;
import it.calolenoci.francesco.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    protected UserRepository utenteRepository;

    @Autowired
    protected UserRoleRepository userRoleRepository;

    @Override
    public Optional<User> findById(String id) {
        return utenteRepository.findById(id);
    }

    @Override
    public List<User> findByName(String name) {
        return utenteRepository.findByName(name);
    }

    @Override
    public List<UserRole> findByUsername(String username) {
        return userRoleRepository.findByUsername(username);
    }

    public Optional<User> findByUsernameAndPassword(String name, String password){
        return utenteRepository.findByUsernameAndPassword(name, password);
    }
}
