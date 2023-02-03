package com.azhagar.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="education_details")
@Data
public class EducationDetails {

	@Id
	@GeneratedValue
	private  Integer id;
	
	private String degree;
	
	private Integer gradeyear;
	
	private String univercity;
	
	@OneToOne
	@JoinColumn(name="caseid_fk")
	private PlanSelection planSelection;
}
