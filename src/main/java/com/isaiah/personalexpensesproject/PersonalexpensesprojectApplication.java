package com.isaiah.personalexpensesproject;

import com.isaiah.personalexpensesproject.repositories.*;
import com.isaiah.personalexpensesproject.objects.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class PersonalexpensesprojectApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(PersonalexpensesprojectApplication.class, args);
	}

}
