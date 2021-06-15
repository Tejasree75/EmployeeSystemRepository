package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The type Global exception handler.
 */
@ControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {
 /**
  * Handle employee not found response entity.
  *
  * @param e       the e
  * @param request the request
  * @return the response entity
  */
 @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Object> handleEmployeeNotFound(EmployeeNotFoundException e, WebRequest request){
     Map<String,Object> values= new LinkedHashMap<>();
     values.put("code",e.getErrorCode());
     values.put("message",e.getErrorMessage());
     values.put("employeeId",e.getEmployeeId());
     return new ResponseEntity<Object> (values, HttpStatus.NOT_FOUND);
 }

 /**
  * Handle no employee found response entity.
  *
  * @param e       the e
  * @param request the request
  * @return the response entity
  */
 @ExceptionHandler(NoEmployeeFoundException.class)
 public ResponseEntity<Object> handleNoEmployeeFound(NoEmployeeFoundException e,WebRequest request){
  Map<String,Object> values= new LinkedHashMap<>();
  values.put("code",e.getErrorCode());
  values.put("message",e.getErrorMessage());
  return new ResponseEntity<Object>(values,HttpStatus.NOT_FOUND);
 }

 /**
  * Handle employee match not found response entity.
  *
  * @param e       the e
  * @param request the request
  * @return the response entity
  */
 @ExceptionHandler(EmployeeMatchNotFoundException.class)
 public ResponseEntity<Object> handleEmployeeMatchNotFound(EmployeeMatchNotFoundException e,WebRequest request){
  Map<String,Object> values= new LinkedHashMap<>();
  values.put("code",e.getErrorCode());
  values.put("message",e.getErrorMessage());
  values.put("employeeId",e.getEmployeeId());
  values.put("employeeName",e.getEmployeeName());
  return new ResponseEntity<Object>(values,HttpStatus.NOT_FOUND);
 }


}
