package com.softuni.mobilele.repositories;

import com.softuni.mobilele.domain.entities.Brand;
import com.softuni.mobilele.domain.entities.Offer;
import com.softuni.mobilele.domain.entities.User;
import com.softuni.mobilele.domain.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import java.util.UUID;

@Repository
public interface BrandRepository extends JpaRepository<Brand, UUID> {
}

