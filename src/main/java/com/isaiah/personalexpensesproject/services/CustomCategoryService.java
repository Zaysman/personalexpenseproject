package com.isaiah.personalexpensesproject.services;

import com.isaiah.personalexpensesproject.objects.CustomCategory;
import com.isaiah.personalexpensesproject.repositories.CustomCategoryRepository;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomCategoryService {
	
	@Autowired
	private CustomCategoryRepository customCategoryRepository;
	
	public CustomCategory createCustomCategory(CustomCategory category) {
		Optional<CustomCategory> existingCategory = customCategoryRepository.findBycategoryentryid(category.getCategoryentryid());
		if(existingCategory.isPresent()) {
			throw new RuntimeException("CustomCategory with categoryentryid " + category.getCategoryentryid() + " already exists.");
		}
		
		CustomCategory savedCategory = customCategoryRepository.save(category);
		return savedCategory;
	}
	
	public CustomCategory readCustomCategoryByCategoryEntryid(long categoryentryid) {
		return customCategoryRepository.findBycategoryentryid(categoryentryid).orElse(null);
	}
	
	public List<CustomCategory> readCustomCategoriesByUserid(long userid) {
		return customCategoryRepository.findByuserid(userid);
	}
	
	public CustomCategory updateCustomCategory(CustomCategory category) {
		return customCategoryRepository.save(category);
	}
	
	@Transactional
	public void deleteCustomCategoryByCategoryEntryid(long categoryentryid) {
		customCategoryRepository.deleteBycategoryentryid(categoryentryid);
	}
	
	@Transactional
	public void deleteCustomCategoryByUserid(long userid) {
		customCategoryRepository.deleteByuserid(userid);
	}
	
	
	
	

}
