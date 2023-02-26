package com.example.demoprojectwithjpabuddyplugin.repositories;

import com.example.demoprojectwithjpabuddyplugin.model.entities.Role;
import com.example.demoprojectwithjpabuddyplugin.model.enums.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleType(RoleType roleType);
}