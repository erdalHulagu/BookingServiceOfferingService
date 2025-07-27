package com.erdal.repository;


import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erdal.model.ServiceOffering;

public interface ServiceOfferingRepository extends JpaRepository<ServiceOffering, Long>{
	
	Set<ServiceOffering> findBySaloonId(Long saloonId);

}
