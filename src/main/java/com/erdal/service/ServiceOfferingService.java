package com.erdal.service;

import java.util.List;
import java.util.Set;

import com.erdal.DTO.CategoryDTO;
import com.erdal.DTO.SaloonDTO;
import com.erdal.model.ServiceOffering;
import com.erdal.request.ServiceOfferingRequest;

public interface ServiceOfferingService {
	
	ServiceOffering createService(SaloonDTO saloonDTO,ServiceOfferingRequest serviceOfferingRequest,CategoryDTO categoryDTO);
	
	ServiceOffering updateService(Long serviceId,ServiceOfferingService serviceOfferingService);
	
	Set<ServiceOfferingService> getAllserviceBySaloonId(Long saloonId,Long categoryId);
	
	List<ServiceOfferingService> getServiceOfferinById(Set<Long> ids);
	
	
	

}
