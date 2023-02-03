package com.azhagar.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.azhagar.entity.PlanSelection;

public interface PlanSelectionrepo extends JpaRepository<PlanSelection,Serializable> {

}
