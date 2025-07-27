package com.erdal.exeptions;

public class ServiceOfferingBadRequestExeption extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private Long id;

	public ServiceOfferingBadRequestExeption(String message) {
		super(message);
	}

	public ServiceOfferingBadRequestExeption(String message, Long id) {
		super(message);
		this.id = id;

	}
}
