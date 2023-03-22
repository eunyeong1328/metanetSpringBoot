package com.example.restservice.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue
    private Integer id;
    private String description;

    //@ManyToOne(fetch = FetchType.LAZY)//user의 값이 필요한 시점에만 User의 데이터값 출력
    //@JsonIgnore //연관 관계시 굳이 필요하지 않은 데이터를 출력할 때 사용
    private User user;
}
