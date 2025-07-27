package com.erdal.controller;

import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@PostMapping("/saloon/{saloonId}")
	public ResponseEntity<ServiceOfferingDTO> createServiceOffering(@RequestBody ServiceOfferingRequest serviceOfferingRequest){
		
		SaloonDTO saloonDTO=new SaloonDTO();
		saloonDTO.setId(1L);
		
		CategoryDTO categoryDTO=new CategoryDTO();
		categoryDTO.setId(serviceOfferingRequest.getId());
		
		ServiceOfferingDTO serviceOfferingDTO=serviceOfferingService.createServiceOffering(saloonDTO, serviceOfferingRequest, categoryDTO);
		
		return ResponseEntity.ok(serviceOfferingDTO);
		
		
	}
	
	@PostMapping("{id}")
	public ResponseEntity<ServiceOfferingDTO> updateServiceOffering(@PathVariable Long id,@RequestBody ServiceOfferingDTO serviceOfferingDTO){
		
		
		ServiceOfferingDTO serviceOfferingDTO2=serviceOfferingService.updateServiceOffering(id, serviceOfferingDTO);
		
		return ResponseEntity.ok(serviceOfferingDTO2);
		
		
	}

}
