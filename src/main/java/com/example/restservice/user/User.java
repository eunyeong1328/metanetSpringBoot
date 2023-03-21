package com.example.restservice.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id; //기본데이터형을 오브젝트로 변환
    @Size(min=2, message = "Name은 2글자 이상 입력하세요")
    private String name;
    private Date joinDate;
}
