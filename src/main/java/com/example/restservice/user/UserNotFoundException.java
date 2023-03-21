package com.example.restservice.user;

//2xx => ok
//4xx => client error (ex json값 잘못 날리면
//5xx => server error
public class UserNotFoundException  extends RuntimeException{
    //예외 발생 클래스
    public UserNotFoundException(String message){
        super(message);
    }
}
