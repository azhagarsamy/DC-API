package com.azhagar.service;

import java.util.List;

import com.azhagar.binding.KidsDetailsBinding;

public interface KidsDetailService {
	
	public String saveKids(List<KidsDetailsBinding> kidsDetailsBindings,Integer caseNum);

}
