package com.azhagar.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.azhagar.entity.KidsDetails;

public interface KidsDetailrepo extends JpaRepository<KidsDetails, Serializable> {

}
