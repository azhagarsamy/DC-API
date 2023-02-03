package com.azhagar.restcontrollers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.azhagar.binding.EducationDetailsBinding;
import com.azhagar.binding.IncomeDetailsBinding;
import com.azhagar.binding.KidsDetailsBinding;
import com.azhagar.entity.PlanSelection;
import com.azhagar.feignClient.AppRegClient;
import com.azhagar.service.EducationDetailService;
import com.azhagar.service.IncomeDetailService;
import com.azhagar.service.KidsDetailService;
import com.azhagar.service.PlanNameService;
import com.azhagar.service.PlanSelectionService;

@RestController
public class DataCollectionController {

	@Autowired
	private AppRegClient appRegClient;

	@Autowired
	private PlanSelectionService planService;

	@Autowired
	private PlanNameService planName;

	@Autowired
	private IncomeDetailService incomeService;

	@Autowired
	private EducationDetailService educationService;

	@Autowired
	private KidsDetailService kidsDetailService;

	@GetMapping("/appId")
	public ResponseEntity<?> generateCaseNumber(@PathVariable Integer appId) {

		boolean isExists = appRegClient.isExists(appId);
		if (isExists) {
			HashMap<String, Object> map = new HashMap<>();
			map.put("casenum", planService.generateCaseId().toString());
			map.put("planname", planName.planNames());
			return new ResponseEntity<>(map, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Given application Id not available", HttpStatus.OK);
		}
	}

	@PostMapping("/plan")
	public ResponseEntity<String> savePlan(@PathVariable Integer caseNum, @PathVariable String PlanId) {
		String planSave = planService.planSave(caseNum, PlanId);
		return new ResponseEntity<>(planSave, HttpStatus.OK);
	}

	@PostMapping("/income")
	public ResponseEntity<String> saveIncome(@RequestBody IncomeDetailsBinding incomeDetailsBinding, Integer caseNum) {
		String saveIncome = incomeService.saveIncome(incomeDetailsBinding, caseNum);
		return new ResponseEntity<>(saveIncome, HttpStatus.OK);
	}

	@PostMapping("/education")
	public ResponseEntity<String> saveIncome(@RequestBody EducationDetailsBinding educationDetailsBinding,
			Integer caseNum) {
		String saveEducation = educationService.saveEducation(educationDetailsBinding, caseNum);
		return new ResponseEntity<>(saveEducation, HttpStatus.OK);
	}

	@PostMapping("/kids")
	public ResponseEntity<?> saveKids(@RequestBody List<KidsDetailsBinding> kidsDetailsBindings,
			Integer caseNum) {
		String saveIncome = kidsDetailService.saveKids(kidsDetailsBindings, caseNum);
		if (saveIncome != null) {
			PlanSelection planData = planService.findById(caseNum);
			return new ResponseEntity<>(planData, HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Data not available to view",HttpStatus.NOT_FOUND);
		}
	}
}
