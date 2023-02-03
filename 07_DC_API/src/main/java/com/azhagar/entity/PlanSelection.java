package com.azhagar.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name = "plan_selection")
@Data
public class PlanSelection {

	@Id
	@GeneratedValue
	private Integer caseid;

	private String planid;

	private Integer createdby;

	private Integer updatedby;

	@CreationTimestamp
	private Date createddate;

	@UpdateTimestamp
	private Date updatedate;
	
	@OneToOne(fetch = FetchType.EAGER,mappedBy = "planSelection",cascade = CascadeType.ALL)
	private IncomeDetails incomedetails;

	@OneToOne(fetch = FetchType.EAGER,mappedBy = "planSelection",cascade = CascadeType.ALL)
	private EducationDetails educationDetails;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "planSelection",cascade = CascadeType.ALL)
	private List<KidsDetails> kidsdetails;


}
