package com.azhagar.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.azhagar.entity.Planname;

public interface Plannamerepo extends JpaRepository<Planname, Serializable> {

}
