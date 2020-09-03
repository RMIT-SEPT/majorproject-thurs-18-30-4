package com.rmit.sept.turtorial.demo.repositories;

import com.rmit.sept.turtorial.demo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
