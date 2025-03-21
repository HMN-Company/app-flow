package org.example.flow.repositories;

import org.example.flow.models.Role;
import org.example.flow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
    List<Role> findByUser(User user);
}
