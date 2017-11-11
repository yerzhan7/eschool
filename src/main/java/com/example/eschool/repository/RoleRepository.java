package com.example.eschool.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.eschool.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	
}
