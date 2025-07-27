package com.erdal.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.erdal.DTO.CategoryDTO;
import com.erdal.DTO.SaloonDTO;
import com.erdal.model.ServiceOffering;
import com.erdal.repository.ServiceOfferingRepository;
import com.erdal.request.ServiceOfferingRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServiceOfferingServiceImpl implements ServiceOfferingService {
	
	private final ServiceOfferingRepository serviceOfferingRepository;

	@Override
	public ServiceOffering createService(SaloonDTO saloonDTO, ServiceOfferingRequest serviceOfferingRequest,
			CategoryDTO categoryDTO) {
		
		ServiceOffering serviceOffering=new ServiceOffering();
		serviceOffering.setOfferingName(serviceOfferingRequest.getOfferingName());
		serviceOffering.setDescreption(serviceOfferingRequest.getDescreption());
		serviceOffering.setDuration(serviceOfferingRequest.getDuration());
		serviceOffering.setPrice(serviceOfferingRequest.getPrice());
		serviceOffering.setOfferingImage(serviceOfferingRequest.getOfferingImage());
		serviceOffering.setCategoryId(categoryDTO.getId());
		serviceOffering.setSaloonId(saloonDTO.getId());
		
		ServiceOffering seOfring=serviceOfferingRepository.save(serviceOffering);
		
		return seOfring;
	}

	@Override
	public ServiceOffering updateService(Long serviceId, ServiceOfferingService serviceOfferingService) {
		
		
		a

		return null;
	}

	@Override
	public Set<ServiceOfferingService> getAllserviceBySaloonId(Long saloonId, Long categoryId) {
		
		
		
		return null;
	}

	@Override
	public List<ServiceOfferingService> getServiceOfferinById(Set<Long> ids) {
		
		
		
		return null;
	}

}
