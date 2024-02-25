package project.Oshana.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.Oshana.dto.UserDTO;
import project.Oshana.entity.Roles;
import project.Oshana.entity.Users;
import project.Oshana.repository.RolesRepository;
import project.Oshana.repository.UserRepository;
import project.Oshana.service.imp.UserServiceImp;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserServiceImp {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RolesRepository rolesRepository;

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserDTO> userDTOList = new ArrayList<>();
        List<Users> usersList = userRepository.findAll();
        Roles roles = new Roles();
        roles.setId(1);

        for (Users users : usersList){
            UserDTO userDTO = new UserDTO();
            userDTO.setId(users.getId());
            userDTO.setFullname(users.getFullname());
            userDTO.setUsername(users.getUsername());
            userDTO.setPassword(users.getPassword());
            userDTO.setRoles(roles);
            userDTO.setCreateDate(users.getCreateDate());

            userDTOList.add(userDTO);
        }
        return userDTOList;
    }
}
