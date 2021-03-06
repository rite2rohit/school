package com.kstech.model;

import java.io.Serializable;
import java.util.List;

public class ErrorResponse implements Serializable {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ErrorResponse(String message, List<String> details) {
	        super();
	        this.setMessage(message);
	        this.setDetails(details);
	    }
	 
	    public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

		public List<String> getDetails() {
		return details;
	}

	public void setDetails(List<String> details) {
		this.details = details;
	}

		//General error message about nature of error
	    private String message;
	 
	    //Specific errors in API request processing
	    private List<String> details;


}
