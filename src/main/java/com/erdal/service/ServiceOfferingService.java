package com.erdal.service;

import com.erdal.DTO.CategoryDTO;
import com.erdal.DTO.SaloonDTO;
import com.erdal.DTO.ServiceOfferingDTO;

public interface ServiceOfferingService {
	
	ServiceOfferingService createService(SaloonDTO saloonDTO,ServiceOfferingDTO serviceDTO,CategoryDTO categoryDTO);

}
