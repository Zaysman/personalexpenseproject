package com.isaiah.personalexpensesproject.repositories;

import com.isaiah.personalexpensesproject.objects.CustomCategory;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface CustomCategoryRepository extends JpaRepository<CustomCategory, Long> {


	//Save or update CustomCategory
	<S extends CustomCategory> S save (S CustomCategory);

	//Read operation(s)
	Optional<CustomCategory> findBycategoryentryid(long id);
	List<CustomCategory> findByuserid(long id);
	
	//delete
	void deleteBycategoryentryid(long id);
	void delete(CustomCategory category);
	void deleteByuserid(long userid);
	void deleteByuseridIn(List<Long> expenseids);
	

}
