package com.shoroukkhaled.F1_Telemetery.shared.entities;


import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BusinessException extends RuntimeException {

    final int errorCode;
    final HttpStatus status;

    public BusinessException(String errorMessage, int errorCode) {
        this(errorMessage,errorCode, HttpStatus.BAD_REQUEST, null);
    }

    public BusinessException(String errorMessage, int errorCode , HttpStatus status) {
        this(errorMessage, errorCode, status, null);
    }

    public BusinessException(String errorMessage, int errorCode , Throwable cause) {
        this(errorMessage, errorCode, HttpStatus.BAD_REQUEST, cause);
    }

    public BusinessException(String errorMessage, int errorCode, HttpStatus status, Throwable cause) {
        super(errorMessage, cause);
        this.status = status;
        this.errorCode = errorCode;
    }
}
