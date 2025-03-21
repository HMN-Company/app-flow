package org.example.flow.services;

import org.example.flow.models.Role;
import org.example.flow.models.User;

import java.util.List;

public interface RoleService extends BaseService<Role> {
    List<Role> getRoles(User user);
}
