package com.isaiah.personalexpensesproject.restcontrollers;

import com.isaiah.personalexpensesproject.objects.CustomCategory;
import com.isaiah.personalexpensesproject.services.CustomCategoryService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("category")
public class CustomCategoryRestController {

	private final String JSON = "application/json";
	private final String LOCALHOST = "http://localhost:3000";
	
	@Autowired
	private CustomCategoryService customCategoryService;
	
	//Get customCategory by category entry id
	@GetMapping(value = "entryid/{categoryentryid}", produces = "application/json")
	@CrossOrigin(origins = LOCALHOST)
	public CustomCategory getCustomCategory(@PathVariable long categoryentryid) {
		return customCategoryService.readCustomCategoryByCategoryEntryid(categoryentryid);
	}
	
	//Get customCategories by userid
	@GetMapping(value = "userid/{userid}", produces = "application/json")
	@CrossOrigin(origins = LOCALHOST)
	public List<CustomCategory> getCustomCategoriesByUserid(@PathVariable long userid) {
		return customCategoryService.readCustomCategoriesByUserid(userid);
	}
	
	//Post create a new Custom Category
	@PostMapping(value = "/create", consumes = JSON, produces = JSON)
	@CrossOrigin(origins = LOCALHOST)
	public CustomCategory createCustomCategory(@RequestBody CustomCategory category) {
		category = customCategoryService.createCustomCategory(category);
		return category;
	}
	
	//Put update CustomCategory
	@PutMapping(value = "/update/{categoryentryid}", consumes = JSON, produces = JSON)
	@CrossOrigin(origins = LOCALHOST)
	public CustomCategory updateCategory(@PathVariable long categoryentryid, @RequestBody CustomCategory category) {
		CustomCategory existingCustomCategory = customCategoryService.readCustomCategoryByCategoryEntryid(categoryentryid);
		
		if(existingCustomCategory == null) {
			return null;
		}
		
		existingCustomCategory.setCategoryName(category.getCategoryName());
		existingCustomCategory.setUserid(category.getUserid());
		customCategoryService.updateCustomCategory(existingCustomCategory);
		return existingCustomCategory;
	}
	
	//Delete a customCategory by entry id
	@DeleteMapping(value = "/delete/entryid/{categoryentryid}")
	@CrossOrigin(origins = LOCALHOST)
	public void deleteCustomCategory(@PathVariable long categoryentryid) {
		customCategoryService.deleteCustomCategoryByCategoryEntryid(categoryentryid);
	}
	
	//Delete customCategories by userid
	@DeleteMapping(value = "/delete/userid/{userid}")
	@CrossOrigin(origins = LOCALHOST)
	public void deleteCustomCategoriesByUserID(@PathVariable long userid) {
		customCategoryService.deleteCustomCategoryByUserid(userid);
	}
	
	
	
}
