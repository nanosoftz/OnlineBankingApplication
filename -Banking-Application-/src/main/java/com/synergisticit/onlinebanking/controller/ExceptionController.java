package com.synergisticit.onlinebanking.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.synergisticit.onlinebanking.domain.ExceptionResponse;

@ControllerAdvice   //handles exception throughout the whole application
public class ExceptionController {
	
//	@ExceptionHandler  //works at method level exception
//	public ResponseEntity<String>handleException(Exception ex){
//		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
//	}
//}

	@ExceptionHandler  //works at method level exception
	public ResponseEntity<ExceptionResponse>handleException(Exception ex){
		ExceptionResponse exceptionResponse=new ExceptionResponse();
		exceptionResponse.setErrorCode(ex.getClass().getSimpleName());
		exceptionResponse.setErrorMessage(ex.getMessage());
		
		return new ResponseEntity<ExceptionResponse>(exceptionResponse,HttpStatus.NOT_FOUND);
	}

}
