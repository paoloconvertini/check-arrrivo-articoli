package it.calolenoci.francesco.repository;

import it.calolenoci.francesco.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    List<User> findByName(String name);

    List<User> findByUsername(String username);

    Optional<User> findByUsernameAndPassword(String username, String password);

}
