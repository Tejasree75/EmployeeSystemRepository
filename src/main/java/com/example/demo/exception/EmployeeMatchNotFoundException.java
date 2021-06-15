package com.example.demo.exception;

import lombok.Getter;

/**
 * The type Employee match not found exception.
 */
@Getter
public class EmployeeMatchNotFoundException extends RuntimeException {
    private int employeeId;
    private String employeeName;
    private String errorCode;
    private String errorMessage;

    /**
     * Instantiates a new Employee match not found exception.
     *
     * @param errorCode    the error code
     * @param employeeId   the employee id
     * @param employeeName the employee name
     */
    public EmployeeMatchNotFoundException(ErrorCode errorCode, int employeeId, String employeeName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.errorCode = errorCode.getErrorCode();
        this.errorMessage = errorCode.getErrorMessage();
    }

}
