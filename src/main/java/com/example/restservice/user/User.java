package com.example.restservice.user;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties(value = {"password","ssn"})
//@JsonFilter("UserInfo") //UserInfo라고 필터
@Entity //entity 사용시 반드시 주시 설정
public class User {
    @Id
    @GeneratedValue //1씩 증가/db에 따라 다르다(sql, 오라클)
    private Integer id; //기본데이터형을 오브젝트로 변환
    @Size(min=2, message = "Name은 2글자 이상 입력하세요")
    private String name;
    private Date joinDate;
    //@JsonIgnore //예민한 값 노출 안되게 한다.
    private  String password;
    private  String ssn; //주민등록번호
    @OneToMany(mappedBy = "user")
    private List<Post> post;

}
