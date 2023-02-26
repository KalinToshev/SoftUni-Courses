package com.example.demoprojectwithjpabuddyplugin.services.role;

import com.example.demoprojectwithjpabuddyplugin.model.entities.Role;
import com.example.demoprojectwithjpabuddyplugin.model.enums.RoleType;
import com.example.demoprojectwithjpabuddyplugin.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void initRoles() {
        if (roleRepository.count() == 0) {
            Arrays.stream(RoleType.values())
                    .forEach(roleType -> {
                        Role role = new Role();
                        role.setRoleType(roleType);
                        roleRepository.save(role);
                    });
        }
    }
}
