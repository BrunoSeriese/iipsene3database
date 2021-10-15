package nl.hsleiden.iipsene2database.DAO.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nl.hsleiden.iipsene2database.model.ERole;
import nl.hsleiden.iipsene2database.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}