package com.kstech.app.exception;

public class SchoolBusinessException extends SchoolException {

	
	private static final long serialVersionUID = 1L;
	public SchoolBusinessException(String key) {
		super(ErrorType.BUSINESS, key);
		this.key = key;
	}

	public SchoolBusinessException(String key, String[] args) {
		super(ErrorType.BUSINESS, key);
		this.key = key;
		this.errorArgs = args;
	}

	public SchoolBusinessException(String key, String defaultMessage) {
		super(ErrorType.BUSINESS, key);
		this.key = key;
		this.defaultMessage = defaultMessage;
	}

	public SchoolBusinessException(String key, String[] args,
			String defaultMessage) {
		super(ErrorType.BUSINESS, defaultMessage);
		this.key = key;
		this.errorArgs = args;
		this.defaultMessage = defaultMessage;
	}
	
	

}
