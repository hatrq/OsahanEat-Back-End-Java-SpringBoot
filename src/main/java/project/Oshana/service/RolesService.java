package project.Oshana.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.Oshana.dto.RolesDTO;
import project.Oshana.entity.Roles;
import project.Oshana.repository.RolesRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class RolesService {
    @Autowired
    RolesRepository rolesRepository;

    List<RolesDTO> getAllRoles(){
        List<Roles> list = rolesRepository.findAll();
        List<RolesDTO> dtoList = new ArrayList<>();

        for (Roles roles : list){
            RolesDTO rolesDTO = new RolesDTO();
            rolesDTO.setId(roles.getId());
            rolesDTO.setName(roles.getName());
            rolesDTO.setCreateDate(roles.getCreateDate());

            dtoList.add(rolesDTO);
        }

        return dtoList;
    }

    RolesDTO getRolesById(int id){
        RolesDTO rolesDTO = new RolesDTO();
        Roles roles = rolesRepository.getRolesById(id);
        rolesDTO.setId(roles.getId());
        rolesDTO.setName(roles.getName());
        rolesDTO.setCreateDate(roles.getCreateDate());
        return rolesDTO;
    }
}
