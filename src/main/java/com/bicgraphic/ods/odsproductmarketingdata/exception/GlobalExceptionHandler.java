package com.bicgraphic.ods.odsproductmarketingdata.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bicgraphic.ods.odsproductmarketingdata.common.ProductMarketingConstants;
import com.bicgraphic.ods.odsproductmarketingdata.model.EventDMResponse;
import com.bicgraphic.odsutils.EventResponse;
import com.bicgraphic.odsutils.LoggerUtil;
import com.bicgraphic.odsutils.ODSException;

/**
 * The Class GlobalExceptionHandler.
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
 

	/**
	 * Generic exception handler.
	 *
	 * @param exception the exception
	 * @return the response entity
	 */
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> genericExceptionHandler(Exception exception) {
		LoggerUtil.info("Exception Triggered:#{}",exception.getMessage());
		EventResponse eventResponse = new EventResponse();
		EventDMResponse eventDMResponse = new EventDMResponse();
		eventResponse.setEventStatus(EventResponse.EventStatus.ERROR);
		eventResponse.setEventErrorCode(ProductMarketingConstants.UNKNOWN_ERR_CODE);
		eventResponse.setMustRetryFlag(true);
		eventResponse.setEventStatusMessage(ProductMarketingConstants.UNKNOWN_ERR_MSG);
		eventDMResponse.setEventResponse(eventResponse);
		LoggerUtil.info("Exception #{}",eventResponse.toString());
		return new ResponseEntity<>(eventDMResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	/**
	 * Exception handler.
	 *
	 * @param exception the exception
	 * @return the response entity
	 */
	@ExceptionHandler(value = ODSException.class)
	public ResponseEntity<Object> exceptionHandler(ODSException exception) {
		LoggerUtil.info("Exception Triggered:#{}",exception.getMessage());
		EventResponse eventResponse = new EventResponse();
		EventDMResponse eventDMResponse = new EventDMResponse();
		eventResponse.setEventStatus(EventResponse.EventStatus.ERROR);
		eventResponse.setEventErrorCode(exception.getRespCode());
		eventResponse.setMustRetryFlag(true);
		eventResponse.setEventStatusMessage(exception.getRespMsg());
		eventDMResponse.setEventResponse(eventResponse);
		LoggerUtil.info("Exception #{}",eventResponse.toString());
		return new ResponseEntity<>(eventResponse, HttpStatus.OK);
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler#handleMethodArgumentNotValid(org.springframework.web.bind.MethodArgumentNotValidException, org.springframework.http.HttpHeaders, org.springframework.http.HttpStatus, org.springframework.web.context.request.WebRequest)
	 */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatus status,
			WebRequest request) {
		LoggerUtil.info("HTTP request Arguments Exception#{}" , exception.getMessage());
		List<FieldError> errors = exception.getBindingResult().getFieldErrors();
		List<String> validationErrorList = new ArrayList<>();
		for (FieldError error : errors) {
			validationErrorList.add(error.getDefaultMessage());
		}
		EventResponse eventResponse = new EventResponse();
		EventDMResponse eventDMResponse = new EventDMResponse();
		eventResponse.setEventStatus(EventResponse.EventStatus.ERROR);
		eventResponse.setEventErrorCode(ProductMarketingConstants.INV_INPUT_CODE);
		eventResponse.setEventStatusMessage(String.join(",", validationErrorList));
		eventResponse.setMustRetryFlag(true);
		eventDMResponse.setEventResponse(eventResponse);
		return new ResponseEntity<>(eventDMResponse, HttpStatus.BAD_REQUEST);
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler#handleHttpMessageNotReadable(org.springframework.http.converter.HttpMessageNotReadableException, org.springframework.http.HttpHeaders, org.springframework.http.HttpStatus, org.springframework.web.context.request.WebRequest)
	 */
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException exception,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		LoggerUtil.info("HTTP message NotReadable Exception#{}", exception.getMessage());
		EventResponse eventResponse = new EventResponse();
		EventDMResponse eventDMResponse = new EventDMResponse();
		eventResponse.setEventStatus(EventResponse.EventStatus.ERROR);
		eventResponse.setEventErrorCode(ProductMarketingConstants.INV_INPUT_CODE);
		eventResponse.setMustRetryFlag(true);
		Throwable mostSpecificCause = exception.getMostSpecificCause();
		if (mostSpecificCause != null) {
			String message = mostSpecificCause.getMessage();
			eventResponse.setEventStatusMessage(ProductMarketingConstants.INV_STRUCTURE_MSG + ":" + message);
		} else {
			eventResponse.setEventStatusMessage(ProductMarketingConstants.INV_STRUCTURE_MSG);
		}
		eventDMResponse.setEventResponse(eventResponse);
		return new ResponseEntity<>(eventDMResponse, HttpStatus.OK);
	}
}
