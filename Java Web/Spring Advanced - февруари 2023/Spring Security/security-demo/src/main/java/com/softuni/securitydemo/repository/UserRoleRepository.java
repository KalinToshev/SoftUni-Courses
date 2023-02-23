package com.softuni.securitydemo.repository;

import com.softuni.securitydemo.model.entity.UserRole;
import com.softuni.securitydemo.model.enums.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    Optional<UserRole> findUserRoleEntityByRole(UserRoleEnum role);
}
