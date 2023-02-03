package com.azhagar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.azhagar.entity.Planname;
import com.azhagar.repository.Plannamerepo;

@Service
public class PlanNameServiceImpl implements PlanNameService{

	@Autowired
	private  Plannamerepo repo;

	@Override
	public List<Planname> planNames() {
		return repo.findAll();
	}

}
