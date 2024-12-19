package com.barisozkan.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //bu anatasyonla bu sınıfın exceptionhandler oldugunu söylemis oluruz.
public class GlobalExceptionHandler {
	
	//Spring valdiation dan fırlatılan hataları alıp yonetmek ve adam akıllı response donmek.
	
	private List<String> addMapValue(List<String> list, String newValue) {
		list.add(newValue);
		return list;
	}
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<ApiError> handleMethodArgumentNoValidException(MethodArgumentNotValidException ex) {
		Map<String, List<String>> errorsMap = new HashMap<>();
		
		//bolum 5 - 2. video tekrar izleyebilirsin.
		for (ObjectError objError : ex.getBindingResult().getAllErrors()) {
			String fieldName= ((FieldError)objError).getField(); 
			if (errorsMap.containsKey(fieldName)) {
				errorsMap.put(fieldName, addMapValue(errorsMap.get(fieldName), objError.getDefaultMessage()));
			}
			else {
				errorsMap.put(fieldName, addMapValue(new ArrayList<>(), objError.getDefaultMessage()));
			}
		}
		return ResponseEntity.badRequest().body(createApiError(errorsMap));
			
	}
	
	private <T> ApiError<T> createApiError(T errors) { //<T> ilk t generic fonk. oldugunu belirtiyor sadece 2. <T> ise t tipinde dondugunu belirtiyor.
		ApiError<T> apiError = new ApiError<T>();
		apiError.setId(UUID.randomUUID().toString());
		apiError.setErrorTime(new Date());
		apiError.setErrors(errors);
		return apiError;
	}
}
