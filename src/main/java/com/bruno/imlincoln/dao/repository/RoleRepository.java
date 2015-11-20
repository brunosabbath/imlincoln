package com.bruno.imlincoln.dao.repository;

import org.springframework.data.repository.CrudRepository;
import com.bruno.imlincoln.model.Role;

public interface RoleRepository extends CrudRepository<Role, Integer>{
	public Role findRoleById(int id);
}
