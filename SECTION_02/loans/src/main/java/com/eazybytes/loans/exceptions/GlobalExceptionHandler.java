package com.eazybytes.loans.exceptions;


import com.eazybytes.loans.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto>handleGlobalException(Exception ex ,WebRequest webRequest){
        ErrorResponseDto errorResponseDto =new ErrorResponseDto();
        errorResponseDto.setErrorTime(LocalDateTime.now());
        errorResponseDto.setApiPath(webRequest.getDescription(true));
        errorResponseDto.setErrorMessage("something went wrong please try again later ."+ex.getMessage());
        errorResponseDto.setErrorCode(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(errorResponseDto,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(LoanAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDto>handleLoanAlreadyExistException(LoanAlreadyExistsException ex, WebRequest webRequest){
          ErrorResponseDto errorResponseDto = new ErrorResponseDto();
          errorResponseDto.setApiPath(webRequest.getDescription(false));
          errorResponseDto.setErrorCode(HttpStatus.BAD_REQUEST);
          errorResponseDto.setErrorMessage(ex.getMessage());
          errorResponseDto.setErrorTime(LocalDateTime.now());

          return  new ResponseEntity<>(errorResponseDto,HttpStatus.BAD_REQUEST);
    }


}
