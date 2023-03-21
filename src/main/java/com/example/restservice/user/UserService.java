package com.example.restservice.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserService {
    private static List<User> users = new ArrayList<>();

    private static int userCount = 3;
//3개의 데이터값 생성
    static { 
        users.add(new User(1,"kosa",new Date()));
        users.add(new User(2,"kosa",new Date()));
        users.add(new User(3,"kosa",new Date()));
    }

    public List<User> findAll() {
        return users;
    }

    public User findone(int id){
        for(User user : users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }
    public User save(User user){
        if(user.getId() == null){
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }
}
