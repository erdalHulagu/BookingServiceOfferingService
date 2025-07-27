package com.erdal.exeptions;

public class ServiceOfferingNotFoundExeption extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private Long id;

	public ServiceOfferingNotFoundExeption(String message) {
		super(message);
	}

	public ServiceOfferingNotFoundExeption(String message, Long id) {
		super(message);
		this.id = id;

	}
}