package com.azhagar.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="income_details")
@Data
public class IncomeDetails {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private Integer salary;
	
	private Integer rentincome;
	
	private Integer propincome;
	
	@OneToOne
	@JoinColumn(name="caseid_fk")
	private PlanSelection planSelection;
}
