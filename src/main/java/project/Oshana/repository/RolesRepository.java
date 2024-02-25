package project.Oshana.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.Oshana.entity.Roles;


@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {
    Roles getRolesById(int id);
}
