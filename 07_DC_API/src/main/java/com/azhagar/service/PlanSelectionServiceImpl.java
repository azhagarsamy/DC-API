package com.azhagar.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azhagar.entity.PlanSelection;
import com.azhagar.repository.PlanSelectionrepo;

@Service
public class PlanSelectionServiceImpl implements PlanSelectionService {

	@Autowired
	private PlanSelectionrepo repo;

	@Override
	public String planSave(Integer caseId, String PlanId) {
		PlanSelection selection = repo.findById(caseId).get();
		selection.setPlanid(PlanId);
		PlanSelection save = repo.save(selection);
		return save.getCaseid().toString();
	}

	@Override
	public Integer generateCaseId() {
		PlanSelection selection = new PlanSelection();
		selection.setPlanid("");
		PlanSelection save = repo.save(selection);
		return save.getCaseid();
	}

	@Override
	public PlanSelection findById(Integer caseId) {
		Optional<PlanSelection> opt = repo.findById(caseId);
		if(opt.isPresent()) {
			return opt.get();
		}
		return null;
	}

}
