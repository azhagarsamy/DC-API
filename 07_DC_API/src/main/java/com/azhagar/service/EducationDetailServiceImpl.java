package com.azhagar.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azhagar.binding.EducationDetailsBinding;
import com.azhagar.entity.EducationDetails;
import com.azhagar.entity.PlanSelection;
import com.azhagar.repository.EducationDetailrepo;
import com.azhagar.repository.PlanSelectionrepo;

@Service
public class EducationDetailServiceImpl implements EducationDetailService {
	
	@Autowired
	private EducationDetailrepo educationRepo;

	@Autowired
	private PlanSelectionrepo planSelectionRepo;
	
	@Override
	public String saveEducation(EducationDetailsBinding educationDetailsBinding, Integer caseNum) {
		PlanSelection planSelection=planSelectionRepo.findById(caseNum).get();
		EducationDetails educationDetails=new EducationDetails();
		BeanUtils.copyProperties(educationDetailsBinding, educationDetails);
		educationDetails.setPlanSelection(planSelection);
		EducationDetails save = educationRepo.save(educationDetails);
		return save.getPlanSelection().getCaseid().toString();
	}

}
