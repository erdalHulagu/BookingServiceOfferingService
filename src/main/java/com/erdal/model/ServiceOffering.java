package com.erdal.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="t_offering")
public class ServiceOffering {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String offeringName;
	
	@Column(nullable = false)
	private String descreption;
	
	@Column(nullable = false)
	private Integer price;
	
	@Column(nullable = false)
	private Integer duration;
	
	@Column(nullable = false)
	private Long saloonId;
	
	@Column(nullable = false)
	private Long categoryId;
	
	@Column(nullable = false)
	private String offeringImage;
	
	
	

}
