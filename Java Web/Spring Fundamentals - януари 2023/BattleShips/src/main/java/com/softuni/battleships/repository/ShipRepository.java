package com.softuni.battleships.repository;

import com.softuni.battleships.model.entity.ShipEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Repository
public interface ShipRepository extends JpaRepository<ShipEntity, Long> {
    void deleteByName(String name);

    Set<ShipEntity> findByOwner_IdNot(Long id);

    Set<ShipEntity> findByOwner_Id(Long id);

    ShipEntity findByName(String name);
}