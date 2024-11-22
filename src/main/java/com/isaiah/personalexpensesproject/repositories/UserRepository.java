package com.isaiah.personalexpensesproject.repositories;

import com.isaiah.personalexpensesproject.objects.User;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	//Save or update user
	<S extends User> S save (S User);
	
	//Read operations
	Optional<User> findByid(long id);
	Optional<User> findByUsername(String username);
	Optional<User> findByEmail(String email);
	List<User> findAll();
	
	//delete operations
	void deleteByid(long id);
	void deleteByUsername(String username);
	void delete(User user);
	
}
