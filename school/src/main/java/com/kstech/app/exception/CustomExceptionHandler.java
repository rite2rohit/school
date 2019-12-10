package com.kstech.app.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.kstech.app.util.MessageUtils;
import com.kstech.model.ErrorResponse;

@SuppressWarnings({ "unchecked", "rawtypes" })
@ControllerAdvice()
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private MessageUtils messageUtils;

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {

		List<String> details = new ArrayList<>();
		Throwable exCause = null;
		if (ex.getCause() != null) {
			exCause = ex.getCause().getCause();
		}
		if (exCause != null && exCause instanceof ConstraintViolationException) {
			return handleConstraintViolationException((ConstraintViolationException) exCause);
		}
		details.add(messageUtils.handleException(ex, request));
		ErrorResponse error = new ErrorResponse("Server Error", details);
		return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex) {
		List<String> details = new ArrayList<>();
		Set<ConstraintViolation<?>> viols = ex.getConstraintViolations();
		for (ConstraintViolation viol : viols) {
			details.add(viol.getMessage());
		}

		ErrorResponse error = new ErrorResponse("Validation/Validations Failed", details);
		return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(RecordNotFoundException.class)
	public final ResponseEntity<Object> handleRecordNotFoundException(RecordNotFoundException ex, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add(messageUtils.handleException(ex, request));
		ErrorResponse error = new ErrorResponse("No Record Found", details);
		return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> details = new ArrayList<>();
		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			details.add(error.getDefaultMessage());
		}
		ErrorResponse error = new ErrorResponse("Validation/Validations Failed", details);
		return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
	}
}
