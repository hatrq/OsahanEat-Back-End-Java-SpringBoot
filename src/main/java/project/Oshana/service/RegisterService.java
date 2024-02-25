package project.Oshana.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import project.Oshana.entity.Roles;
import project.Oshana.entity.Users;
import project.Oshana.payload.request.RegisterRequest;
import project.Oshana.repository.UserRepository;

@Service
public class RegisterService implements project.Oshana.service.imp.RegisterServiceImp {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public Boolean register(RegisterRequest registerRequest) {
        Roles roles = new Roles();
        roles.setId(registerRequest.getRoleID());

        Users users = new Users();
        users.setUsername(registerRequest.getUsername());
        users.setFullname(registerRequest.getFullname());
        users.setEmail(registerRequest.getEmail());
        users.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        users.setRoles(roles);
        try{
            userRepository.save(users);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
