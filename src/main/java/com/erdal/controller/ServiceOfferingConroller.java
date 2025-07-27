package com.erdal.controller;

import java.util.Set;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.erdal.DTO.ServiceOfferingDTO;
import com.erdal.service.ServiceOfferingService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/service-offerings")
public class ServiceOfferingConroller {
	
	private final ServiceOfferingService serviceOfferingService;
	
	@GetMapping("/saloon/{saloonId}")
	public ResponseEntity <Set<ServiceOfferingDTO>> getServiceOfferingBysaloonId(@PathVariable Long saloonId,
			                                                             @RequestParam(required = false) Long categoryId){
		
		Set<ServiceOfferingDTO> serviceOfferingDTOs=serviceOfferingService.getAllserviceBySaloonId(saloonId, categoryId);
		
		return ResponseEntity.ok(serviceOfferingDTOs);
		
		
	}
	
	
	@GetMapping("{id}")
	public ResponseEntity <ServiceOfferingDTO> getServiceOfferingById(@PathVariable Long id){
		
		ServiceOfferingDTO serviceOfferingDTO=serviceOfferingService.getServiceById(id);
		
		return ResponseEntity.ok(serviceOfferingDTO);
		
		
	}
	@GetMapping("/list/ids}")
	public ResponseEntity <Set<ServiceOfferingDTO> >getAllServiceOfferingByIds(@PathVariable Set<Long> ids){
		
		Set<ServiceOfferingDTO> serviceOfferingDTOs=serviceOfferingService.getServiceOfferinByIds(ids);
		
		return ResponseEntity.ok(serviceOfferingDTOs);
		
		
	}
	
	
	

}
