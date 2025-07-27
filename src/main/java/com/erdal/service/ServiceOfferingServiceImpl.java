package com.erdal.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.erdal.DTO.CategoryDTO;
import com.erdal.DTO.SaloonDTO;
import com.erdal.DTO.ServiceOfferingDTO;
import com.erdal.exeptions.ServiceOfferingErrorMessages;
import com.erdal.exeptions.ServiceOfferingNotFoundExeption;
import com.erdal.mapper.ServiceOfferingMapper;
import com.erdal.model.ServiceOffering;
import com.erdal.repository.ServiceOfferingRepository;
import com.erdal.request.ServiceOfferingRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServiceOfferingServiceImpl implements ServiceOfferingService {
	
	private final ServiceOfferingRepository serviceOfferingRepository;

	@Override
	public ServiceOfferingDTO createServiceOffering(SaloonDTO saloonDTO, ServiceOfferingRequest serviceOfferingRequest,
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
		ServiceOfferingMapper.serviceOfferingDTO(seOfring);
		
		return ServiceOfferingMapper.serviceOfferingDTO(seOfring);
	}

	@Override
	public ServiceOfferingDTO updateServiceOffering(Long Id, ServiceOfferingDTO serviceOfferingDTO) {
		
	ServiceOffering serviceOffering=findServiceOfferingById(Id);
		
	serviceOffering.setOfferingName(serviceOfferingDTO.getOfferingName());
	serviceOffering.setDescreption(serviceOfferingDTO.getDescreption());
	serviceOffering.setDuration(serviceOfferingDTO.getDuration());
	serviceOffering.setPrice(serviceOfferingDTO.getPrice());
	serviceOffering.setOfferingImage(serviceOfferingDTO.getOfferingImage());
	
	ServiceOffering serviceOffering2=serviceOfferingRepository.save(serviceOffering);
	
	ServiceOfferingDTO serviceOffDTO=ServiceOfferingMapper.serviceOfferingDTO(serviceOffering2);
	
	return serviceOffDTO;
	}

	@Override
	public Set<ServiceOfferingDTO> getAllserviceBySaloonId(Long saloonId, Long categoryId) {
		
		
		Set<ServiceOffering> serviceOfferings= serviceOfferingRepository.findBySaloonId(saloonId);
		
		if (categoryId==null) {
			
			serviceOfferings.stream().filter((service)->service.getCategoryId()!=null && service.getCategoryId()==categoryId).collect(Collectors.toSet());	
		}
		
		return ServiceOfferingMapper.mapAllSetToSaloonDTO(serviceOfferings); 
	}

	@Override
	public Set<ServiceOfferingDTO> getServiceOfferinByIds(Set<Long> ids) {
		
		List<ServiceOffering> serviceOfferings=serviceOfferingRepository.findAllById(ids);
		
		Set<ServiceOffering>offeringsSets=new HashSet<>(serviceOfferings);
		
		ServiceOfferingMapper.mapAllSetToSaloonDTO(offeringsSets);
		
		return ServiceOfferingMapper.mapAllSetToSaloonDTO(offeringsSets);
	}

	@Override
	public ServiceOfferingDTO getServiceById(Long id) {
		
	ServiceOffering serviceOffering= findServiceOfferingById(id);
	
	return ServiceOfferingMapper.serviceOfferingDTO(serviceOffering);
	}
	
	//------------ classs methods
	private ServiceOffering findServiceOfferingById(Long id) {
		
	return	serviceOfferingRepository.findById(id)
			                                      .orElseThrow(
			                                      ()-> new ServiceOfferingNotFoundExeption
			                                      (String.format
			                                      (ServiceOfferingErrorMessages.SERVICE_OFFERING_NOT_FOUND,id)));
		
	}


}
