package com.spring.orderservice_back202410.common.dto;

import org.springframework.http.HttpStatus;

public class CommonResDto {

    private int statusCode;

    private String statusMessage;

    private Object result;

    public CommonResDto(HttpStatus httpStatus, String statusMessage, Object result) {
        this.statusCode = httpStatus.value();
        this.statusMessage=statusMessage;
        this.result=result;
    }
}
