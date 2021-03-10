package com.example.qatar.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.qatar.entities.Arbitre;
import com.example.qatar.entities.Role;

public interface RoleDao  extends CrudRepository<Role,Long> {

}
