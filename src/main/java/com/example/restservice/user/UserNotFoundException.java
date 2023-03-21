package com.example.restservice.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

//2xx => ok
//4xx => client error (ex json값 잘못 날리면
//5xx => server error
@ResponseStatus(HttpStatus.NOT_FOUND) //404에러 발생
public class UserNotFoundException  extends RuntimeException{
    //예외 발생 클래스
    public UserNotFoundException(String message){
        super(message);
    }
}
