package com.roboresumews.project.Repository;

import com.roboresumews.project.Model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByRole(String role);
}
