package com.rmit.sept.turtorial.demo.repositories;

import com.rmit.sept.turtorial.demo.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
}
