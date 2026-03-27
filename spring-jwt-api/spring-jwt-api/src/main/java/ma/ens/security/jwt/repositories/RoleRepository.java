package ma.ens.security.jwt.repositories;

import ma.ens.security.jwt.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}