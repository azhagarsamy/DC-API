package com.azhagar.service;

import com.azhagar.entity.PlanSelection;

public interface PlanSelectionService {
	
	public Integer generateCaseId();
	
	public String planSave(Integer caseId,String PlanId);
	
	public PlanSelection findById(Integer caseId);

}
