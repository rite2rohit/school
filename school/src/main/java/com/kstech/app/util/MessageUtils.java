package com.kstech.app.util;
import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import com.kstech.app.exception.ErrorType;
import com.kstech.app.exception.SchoolBusinessException;
import com.kstech.app.exception.SchoolException;



/**
 * The Class MessageUtils. Provides method for handling exceptions and
 * displaying error messages at controller level.
 */
@Component
public class MessageUtils {

	protected final Log logger = LogFactory.getLog(getClass());


	@Resource
	MessageSource messageSource;

	/**
	 * Gets error message corresponding to exception.
	 * 
	 * @param ex
	 *            the Exception
	 * @param request
	 *            the HttpServletRequest
	 * @param model
	 *            the ModelMap
	 */
	public String handleException(Exception ex, WebRequest httpRequest) {

		String errorMsg = this.getMessage(ex, httpRequest);
		if (ex instanceof SchoolBusinessException) {
			if (logger.isDebugEnabled()) {
				logger.debug(errorMsg, ex);
			} else {
				logger.info(errorMsg);
			}
		} else {
			logger.error(errorMsg, ex);
		}

		return errorMsg;
	}

	private String getMessage(Exception ex, WebRequest httpRequest) {
		String errorKey = "error.generic";
		String[] errorArgs = null;
		String defaultMessage = "Exception occurred. Please contact system administrator or try again later.";

		if (SchoolException.class.equals(ex.getClass().getSuperclass())) {

			SchoolException schoolEx = (SchoolException) ex;

			if (schoolEx.getKey() != null
					&& !"".equals(schoolEx.getKey().trim())) {
				errorKey = schoolEx.getKey();
			}

			if (schoolEx.getErrorArgs() != null) {
				errorArgs = schoolEx.getErrorArgs();
			}

			if (schoolEx.getDefaultMessage() != null
					&& !"".equals(schoolEx.getDefaultMessage().trim())) {
				defaultMessage = schoolEx.getDefaultMessage();
			}

			if (schoolEx.getErrType().equals(ErrorType.SYSTEM)) {
				logger.error(ex.getMessage(), ex);
			}

		} else {
			errorArgs = new String[] { ex.getClass().getName(), ex.getMessage() };
		}
		String errorMsg = messageSource.getMessage(errorKey, errorArgs,
				defaultMessage, httpRequest.getLocale());

		return errorMsg;
	}

	}