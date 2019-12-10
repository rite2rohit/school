package com.kstech.app.exception;

public abstract class SchoolException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String key = "error.business.default";
	protected ErrorType errType;
	protected String[] errorArgs;
	protected String defaultMessage;
	
	public SchoolException(ErrorType errType) {
		super();
		this.errType = errType;
	}

	public SchoolException(ErrorType errType, String message, Throwable cause) {
		super(message, cause);
		this.errType = errType;
	}

	public SchoolException(ErrorType errType, String message) {
		super(message);
		this.errType = errType;
	}

	public SchoolException(ErrorType errType, Throwable cause) {
		super(cause);
		this.errType = errType;
	}

	public void setErrType(ErrorType errType) {
		this.errType = errType;
	}

	public ErrorType getErrType() {
		return errType;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public void setErrorArgs(String[] errorArgs) {
		this.errorArgs = errorArgs;
	}

	public String[] getErrorArgs() {
		return errorArgs;
	}

	public void setDefaultMessage(String defaultMessage) {
		this.defaultMessage = defaultMessage;
	}

	public String getDefaultMessage() {
		return defaultMessage;
	}


}
