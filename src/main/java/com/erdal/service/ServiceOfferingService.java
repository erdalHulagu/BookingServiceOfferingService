package com.erdal.service;

import java.util.Set;

import com.erdal.DTO.CategoryDTO;
import com.erdal.DTO.SaloonDTO;
import com.erdal.DTO.ServiceOfferingDTO;
import com.erdal.request.ServiceOfferingRequest;

public interface ServiceOfferingService {
	
	ServiceOfferingDTO createServiceOffering(SaloonDTO saloonDTO,ServiceOfferingRequest serviceOfferingRequest,CategoryDTO categoryDTO);
	
	ServiceOfferingDTO updateServiceOffering(Long id,ServiceOfferingDTO serviceOfferingDTO);
	
	Set<ServiceOfferingDTO> getAllserviceBySaloonId(Long saloonId,Long categoryId);
	
	Set<ServiceOfferingDTO> getServiceOfferinByIds(Set<Long> ids);
	
	ServiceOfferingDTO getServiceById(Long id);
	

}
