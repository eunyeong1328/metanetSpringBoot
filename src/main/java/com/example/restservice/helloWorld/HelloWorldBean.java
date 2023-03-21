package com.example.restservice.helloWorld;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor//message에 대한 생성자를 만들어준다.
@NoArgsConstructor //default 생성자 생성
public class HelloWorldBean {
    private String mesage;

}
