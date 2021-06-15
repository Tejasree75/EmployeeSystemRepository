package com.example.demo.exception;

import lombok.Getter;

/**
 * The type Employee not found exception.
 */
@Getter
public class EmployeeNotFoundException extends RuntimeException{
    private int employeeId;
    private String errorCode;
    private String errorMessage;


    /**
     * Instantiates a new Employee not found exception.
     *
     * @param errorCode  the error code
     * @param employeeId the employee id
     */
    public EmployeeNotFoundException(ErrorCode errorCode,int employeeId) {
        this.employeeId = employeeId;
        this.errorCode = errorCode.getErrorCode();
        this.errorMessage = errorCode.getErrorMessage();
    }
}
