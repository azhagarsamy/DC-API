package com.azhagar.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azhagar.binding.IncomeDetailsBinding;
import com.azhagar.entity.IncomeDetails;
import com.azhagar.entity.PlanSelection;
import com.azhagar.repository.IncomeDetailrepo;
import com.azhagar.repository.PlanSelectionrepo;

@Service
public class IncomeDetailServiceImpl implements IncomeDetailService {
	
	@Autowired
	private IncomeDetailrepo incomeRepo;

	@Autowired
	private PlanSelectionrepo planSelectionRepo;
	
	@Override
	public String saveIncome(IncomeDetailsBinding incomeDetailsBinding, Integer caseNum) {
		PlanSelection planSelection=planSelectionRepo.findById(caseNum).get();
		IncomeDetails incomeDetails=new IncomeDetails();
		BeanUtils.copyProperties(planSelection, incomeDetails);
		incomeDetails.setPlanSelection(planSelection);
		IncomeDetails save = incomeRepo.save(incomeDetails);
		return save.getPlanSelection().getCaseid().toString();
	}

}
