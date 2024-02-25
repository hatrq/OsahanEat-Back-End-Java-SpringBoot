package project.Oshana.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.Oshana.dto.UserDTO;
import project.Oshana.entity.Users;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findUsersByUsernameAndPassword(String username, String password);
    Users findUsersByUsername(String username);
}
