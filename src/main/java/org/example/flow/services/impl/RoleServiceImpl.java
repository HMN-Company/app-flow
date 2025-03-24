package org.example.flow.services.impl;

import org.example.flow.models.Role;
import org.example.flow.models.User;
import org.example.flow.repositories.RoleRepository;
import org.example.flow.services.RoleService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getRoles(User user) {
        return roleRepository.findByUser(user);
    }

    @Override
    public void save(Role entity) {
        roleRepository.save(entity);
    }

    @Override
    public void update(Role entity) {

    }

    @Override
    public void delete(Role entity) {

    }

    @Override
    public Role get(String id) {
        return null;
    }

    @Override
    public Collection<Role> getAll() {
        return List.of();
    }
}
