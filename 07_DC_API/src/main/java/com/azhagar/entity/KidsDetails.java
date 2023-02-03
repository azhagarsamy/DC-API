package com.azhagar.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "kids_details")
@Data
public class KidsDetails {

	@Id
	private Integer id;

	private String kidname;

	private Integer age;

	private Long ssn;
	
	@ManyToOne
	@JoinColumn(name="caseid_fk")
	private PlanSelection planSelection;
}
