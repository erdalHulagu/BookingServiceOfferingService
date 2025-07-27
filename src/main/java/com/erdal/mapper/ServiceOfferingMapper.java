package com.erdal.mapper;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import com.erdal.DTO.ServiceOfferingDTO;
import com.erdal.model.ServiceOffering;

public class ServiceOfferingMapper {

	public static ServiceOfferingDTO serviceOfferingDTO(ServiceOffering serviceOffering) {

		ServiceOfferingDTO serviceOfferingDTO = new ServiceOfferingDTO();
		serviceOfferingDTO.setId(serviceOffering.getId());
		serviceOfferingDTO.setOfferingName(serviceOffering.getOfferingName());
		serviceOfferingDTO.setCategoryId(serviceOffering.getCategoryId());
		serviceOfferingDTO.setDescreption(serviceOffering.getDescreption());
		serviceOfferingDTO.setDuration(serviceOffering.getDuration());
		serviceOfferingDTO.setPrice(serviceOffering.getPrice());
		serviceOfferingDTO.setSaloonId(serviceOffering.getSaloonId());
		serviceOfferingDTO.setOfferingImage(serviceOffering.getOfferingImage());
		

		return serviceOfferingDTO;

	}
	
	//------------- List filtered map--------------
	public static List<ServiceOfferingDTO> mapAllListToSaloonDTO(List<ServiceOffering> serviceOfferings) {

		List<ServiceOfferingDTO>serviceOfferingDTOs = serviceOfferings.stream().map((serviceOff) -> {
			ServiceOfferingDTO serviceOfferingDTO = new ServiceOfferingDTO();
			return serviceOfferingDTO;
		}).toList();

		return serviceOfferingDTOs;

	}
	
	//------------- Set filtered map--------------
		public static Set<ServiceOfferingDTO> mapAllSetToSaloonDTO(Set<ServiceOffering> serviceOfferings) {
			
			Set<ServiceOfferingDTO>serviceOfferingDTOs = serviceOfferings.stream()
					                                                              .map(ServiceOfferingMapper::serviceOfferingDTO)
					                                                              .collect(Collectors.toSet());
			;
			
			return serviceOfferingDTOs;

	}
	

}
