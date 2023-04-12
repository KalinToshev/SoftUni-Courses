package com.softuni.battleships.repository;

import com.softuni.battleships.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);

    UserEntity findByUsername(String username);
}