package com.hero.SchoolHub.handlers;

import com.hero.SchoolHub.util.exceptions.BodyGuardException;
import com.hero.SchoolHub.util.response.CODE;
import com.hero.SchoolHub.util.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

@Slf4j
@ControllerAdvice
public class CustomizedExceptionHandler {

    @ExceptionHandler(value = BodyGuardException.class)
    public ResponseEntity<Response<?>> exception(BodyGuardException exception) {
        log.error("Error during request processing.", exception);
        Response<Object> response = Response.builder().message(exception.getMessage())
                .code(CODE.UNPROCESSABLE_ENTITY.getId())
                .success(false)
                .build();
        return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

}
