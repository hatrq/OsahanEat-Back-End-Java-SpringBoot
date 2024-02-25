package project.Oshana.service.imp;

import project.Oshana.dto.UserDTO;
import project.Oshana.entity.Users;

import java.util.Optional;

public interface LoginServiceImp {
    Boolean login(String username, String password);
}
