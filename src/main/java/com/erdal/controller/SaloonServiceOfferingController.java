package com.erdal.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.erdal.DTO.CategoryDTO;
import com.erdal.DTO.SaloonDTO;
import com.erdal.DTO.ServiceOfferingDTO;
import com.erdal.request.ServiceOfferingRequest;
import com.erdal.service.ServiceOfferingService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/service-offering/salon-owner")
public class SaloonServiceOfferingController {
	
	private final ServiceOfferingService serviceOfferingService;
	
	@PostMapping("/saloon")
	public ResponseEntity<ServiceOfferingDTO> createServiceOffering(@RequestBody ServiceOfferingRequest serviceOfferingRequest){
		
		SaloonDTO saloonDTO=new SaloonDTO();
		saloonDTO.setId(1L);
		
		CategoryDTO categoryDTO=new CategoryDTO();
		categoryDTO.setId(2L);
		
		ServiceOfferingDTO serviceOfferingDTO=serviceOfferingService.createServiceOffering(saloonDTO, serviceOfferingRequest, categoryDTO);
		
		return ResponseEntity.ok(serviceOfferingDTO);
		
		
	}
	
	@PutMapping("{id}")
	public ResponseEntity<ServiceOfferingDTO> updateServiceOffering(@PathVariable Long id,@RequestBody ServiceOfferingRequest serviceOfferingRequest){
		
		
		ServiceOfferingDTO serviceOfferingDTO2=serviceOfferingService.updateServiceOffering(id, serviceOfferingRequest);
		
		return ResponseEntity.ok(serviceOfferingDTO2);
		
		
	}

}
