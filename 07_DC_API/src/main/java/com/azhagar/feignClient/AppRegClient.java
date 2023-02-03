package com.azhagar.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="AR-SERVICE")
public interface AppRegClient {

	@GetMapping("/appIdExist/")
	public boolean isExists(@PathVariable Integer appId); 
}
