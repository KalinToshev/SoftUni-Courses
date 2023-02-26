package com.example.demoprojectwithjpabuddyplugin.init;

import com.example.demoprojectwithjpabuddyplugin.services.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RolesInit implements CommandLineRunner {
    private final RoleService roleService;

    @Autowired
    public RolesInit(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public void run(String... args) throws Exception {
        roleService.initRoles();
    }
}
