package com.azhagar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azhagar.binding.KidsDetailsBinding;
import com.azhagar.entity.KidsDetails;
import com.azhagar.entity.PlanSelection;
import com.azhagar.repository.KidsDetailrepo;
import com.azhagar.repository.PlanSelectionrepo;

@Service
public class KidsDetailServiceImpl implements KidsDetailService {

	@Autowired
	private KidsDetailrepo kidsRepo;

	@Autowired
	private PlanSelectionrepo planSelectionRepo;

	@Override
	public String saveKids(List<KidsDetailsBinding> kidsDetailsBindings, Integer caseNum) {
		PlanSelection planSelection = planSelectionRepo.findById(caseNum).get();
		List<KidsDetails> kidsDetails = new ArrayList<>();
		for (KidsDetailsBinding k : kidsDetailsBindings) {
			KidsDetails kidDetail = new KidsDetails();
			BeanUtils.copyProperties(k, kidDetail);
			kidDetail.setPlanSelection(planSelection);
			kidsDetails.add(kidDetail);
		}
		List<KidsDetails> saveAll = kidsRepo.saveAll(kidsDetails);
		return saveAll.get(0).getPlanSelection().getCaseid().toString();
	}

}
