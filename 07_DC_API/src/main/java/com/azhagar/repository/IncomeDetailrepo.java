package com.azhagar.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.azhagar.entity.IncomeDetails;

public interface IncomeDetailrepo extends JpaRepository<IncomeDetails, Serializable> {
	
	

}
