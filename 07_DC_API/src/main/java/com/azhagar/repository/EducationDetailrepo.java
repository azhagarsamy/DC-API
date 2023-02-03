package com.azhagar.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.azhagar.entity.EducationDetails;

public interface EducationDetailrepo extends JpaRepository<EducationDetails, Serializable> {

}
