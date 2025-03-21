package org.example.flow.services.impl;

import org.example.flow.models.Role;
import org.example.flow.models.User;
import org.example.flow.models.UserDetail;
import org.example.flow.repositories.RoleRepository;
import org.example.flow.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailService implements UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository rollRepository;

    public UserDetailService(UserRepository userRepository, RoleRepository rollRepository) {
        this.userRepository = userRepository;
        this.rollRepository = rollRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        List<Role> userRole = rollRepository.findByUser(user);
        return new UserDetail(user, userRole);
    }
}
