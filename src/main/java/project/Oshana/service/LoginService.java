package project.Oshana.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import project.Oshana.entity.Users;
import project.Oshana.repository.UserRepository;
import project.Oshana.service.imp.LoginServiceImp;

import java.util.Optional;

@Service
public class LoginService implements LoginServiceImp {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Boolean login(String username, String password) {
        Users users = userRepository.findUsersByUsername(username);
        return passwordEncoder.matches(password, users.getPassword());
    }
}
