package com.bruno.imlincoln.dao.repository;

import java.sql.Timestamp;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.bruno.imlincoln.model.User;

public interface UserRepository extends CrudRepository<User, Long>{

	public User findUserById(Long id);
	@Query("SELECT u FROM User AS u INNER JOIN u.events WHERE u.email = :email")
	public User getUserWithEvent(@Param("email") String email);
	public User findUserByEmail(String email);

}
