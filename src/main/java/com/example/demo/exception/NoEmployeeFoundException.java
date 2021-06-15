package com.example.demo.exception;

import lombok.Getter;

/**
 * The type No employee found exception.
 */
@Getter
public class NoEmployeeFoundException extends RuntimeException{
    private String errorCode;
    private String errorMessage;

    /**
     * Instantiates a new No employee found exception.
     *
     * @param errorCode the error code
     */
    public NoEmployeeFoundException(ErrorCode errorCode) {

        this.errorCode = errorCode.getErrorCode();
        this.errorMessage = errorCode.getErrorMessage();
    }
}
