package com.example.demo.exception;

/**
 * The enum Error code.
 */
public enum ErrorCode {

    /**
     * The Employee not found.
     */
    EMPLOYEE_NOT_FOUND("E111","employee not found for this id"),
    /**
     * The No employee found.
     */
    NO_EMPLOYEE_FOUND("E222", "No employee found"),
    /**
     * The Employee match not found.
     */
    EMPLOYEE_MATCH_NOT_FOUND("E333", "Employee for this id not found");


        private String errorCode;
        private String errorMessage;

        ErrorCode(String errorCode, String errorMessage) {
            this.errorCode = errorCode;
            this.errorMessage = errorMessage;
        }

    /**
     * Gets error code.
     *
     * @return the error code
     */
    public String getErrorCode() {
            return errorCode;
        }

    /**
     * Sets error code.
     *
     * @param errorCode the error code
     */
    public void setErrorCode(String errorCode) {
            this.errorCode = errorCode;
        }

    /**
     * Gets error message.
     *
     * @return the error message
     */
    public String getErrorMessage() {
            return errorMessage;
        }

    /**
     * Sets error message.
     *
     * @param errorMessage the error message
     */
    public void setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
        }


    }


