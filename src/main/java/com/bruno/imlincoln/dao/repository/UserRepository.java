package com.bruno.imlincoln.dao.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.bruno.imlincoln.model.User;

public interface UserRepository extends CrudRepository<User, Long>{

	public User findUserById(Long id);
	@Query("SELECT u FROM User AS u INNER JOIN u.events WHERE u.id = :id")
	public User getUserWithEvent(@Param("id") Long id);

}
