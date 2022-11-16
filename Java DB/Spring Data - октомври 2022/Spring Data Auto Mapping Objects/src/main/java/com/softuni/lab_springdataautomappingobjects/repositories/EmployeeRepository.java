package com.softuni.lab_springdataautomappingobjects.repositories;

import com.softuni.lab_springdataautomappingobjects.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
