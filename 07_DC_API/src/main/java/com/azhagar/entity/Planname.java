package com.azhagar.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "plan_master", schema = "masterdb")
@Data
public class Planname {

	@Id
	private Integer planid;

	private String planname;

}
