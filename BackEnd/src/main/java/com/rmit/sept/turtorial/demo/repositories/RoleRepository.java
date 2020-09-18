package com.rmit.sept.turtorial.demo.repositories;

import com.rmit.sept.turtorial.demo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {

    //variable to find by role name
    Optional<Role> findByName(Role.ERole name);
}
