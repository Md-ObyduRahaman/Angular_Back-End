package com.coderdot.exceptions;

import com.coderdot.dto.BaseResponse;
import com.coderdot.exceptions.AppCommonException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ AccessDeniedException.class })
    public ResponseEntity<Object> handleAccessDeniedException(
            Exception ex, WebRequest request) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.status = false;
        baseResponse.errorMsg = "AccessDeniedException";
        baseResponse.errorCode = 4041;
        baseResponse.version="V.0.0.1";
        baseResponse.apiName="";
        return new ResponseEntity<Object>(
                baseResponse, new HttpHeaders(), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler({ BadCredentialsException.class })
    public ResponseEntity<Object> handleUsernameNotFoundException(
            Exception ex, WebRequest request) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.status = false;
        baseResponse.errorMsg = "Login failed. Please check your credentials.";
        baseResponse.errorCode = 4042;
        baseResponse.version="V.0.0.1";
        baseResponse.apiName="";
        return new ResponseEntity<Object>(
                baseResponse, new HttpHeaders(), HttpStatus.FORBIDDEN);
    }


}
