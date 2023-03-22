package com.example.restservice.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
//    private static List<User> users = new ArrayList<>();

//    private static int userCount = 3;
//3개의 데이터값 생성
//    static {
//        users.add(new User(1,"kosa",new Date(),"pass1","791919-111111"));
//        users.add(new User(2,"kosa",new Date(),"pass2","791919-111111"));
//        users.add(new User(3,"kosa",new Date(),"pass3","791919-111111"));
//    }

    public List<User> findAll() {
        return userMapper.findAllUsers();
    }

    public User findUser(int id){
        return userMapper.findUser(id);
    }

    public void save(User user){
        userMapper.createUser(user);
    }

    public void deleteUser(int id){
        userMapper.deleteUser(id);
    }

//    public User findone(int id){
//        for(User user : users){
//            if(user.getId() == id){
//                return user;
//            }
//        }
//        return null;
//    }
//    public User save(User user){
//        if(user.getId() == null){
//            user.setId(++userCount);
//        }
//        users.add(user);
//        return user;
//    }
//
//    public User deleteById(int id){
//        Iterator<User> iterator = users.iterator();
//
//        while(iterator.hasNext()){
//            User user = iterator.next();
//            if(user.getId() == id){
//                iterator.remove();
//                return user;
//            }
//        }
//        return null;
//    }
}
