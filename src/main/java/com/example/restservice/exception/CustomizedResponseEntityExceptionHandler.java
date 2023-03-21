package com.example.restservice.exception;

import com.example.restservice.user.UserNotFoundException;
import lombok.Data;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
//상황에 따라서 예외 메세지를 만들 수 있다.
//에러를 핸들링 하기 위해 스프링부트에서 제공하는 클래스
//모든 컨트롤러가 실행이 될 때 @ControllerAdvice가 예외를 전담해서 처리
@RestController
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    //모든 예외처리를 처리해 주는 메서드
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
        //예외 메세지
        ExceptionResponse exceptionResponse
                = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
                                                        //예외 발생 출력, 서버 에러
    }

    //    UserNotFoundException.class => handleUserNotfoundException();
    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity UserNotFoundException(Exception ex, WebRequest request){
        ExceptionResponse exceptionResponse
                = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
//에러의 종류의 따라서 다양한 메서드를 만들 수 있다.

    @Override //내가 입력된 데이터가 실패했을 때 이 메소드 출력
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status,WebRequest request){
        ExceptionResponse exceptionResponse
                = new ExceptionResponse(new Date(), "Validation Failed", ex.getBindingResult().toString()); //예러 관련된 메세지를 출력되도록 한다.

        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST); //400의 잘못된 요청이라고 출력
    }

}
