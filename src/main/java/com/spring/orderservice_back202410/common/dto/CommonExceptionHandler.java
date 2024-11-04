package com.spring.orderservice_back202410.common.dto;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class CommonExceptionHandler {

    // 엔티티를 찾지 못했을 때 예외 처리
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<CommonErrorDto> entityNotFoundHandler(EntityNotFoundException e) {
        e.printStackTrace();
        CommonErrorDto dto = new CommonErrorDto(NOT_FOUND, e.getMessage());
        return new ResponseEntity<>(dto, NOT_FOUND);
    }

    // 옳지 않은 입력값 주입 시 예외 처리
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<CommonErrorDto> illegalHandler(IllegalArgumentException e) {
        e.printStackTrace();
        CommonErrorDto commonErrorDto = new CommonErrorDto(BAD_REQUEST, e.getMessage());
        return new ResponseEntity<>(commonErrorDto, BAD_REQUEST);
    }

    // @Valid를 통한 입력값 검증에서 에러 발생 시 예외 처리
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CommonErrorDto> validHandler(MethodArgumentNotValidException e) {
        e.printStackTrace();
        CommonErrorDto commonErrorDto = new CommonErrorDto(BAD_REQUEST, "arguments not valid");
        return new ResponseEntity<>(commonErrorDto, BAD_REQUEST);
    }

    // 일반적인 예외 처리
    @ExceptionHandler(Exception.class)
    public ResponseEntity<CommonErrorDto> exceptionHandler(Exception e) {
        e.printStackTrace();
        CommonErrorDto commonErrorDto = new CommonErrorDto(INTERNAL_SERVER_ERROR, "server error");
        return new ResponseEntity<>(commonErrorDto, INTERNAL_SERVER_ERROR); // 500 에러
    }
}
