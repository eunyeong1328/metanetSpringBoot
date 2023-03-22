package com.example.restservice.user;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public List<User> findAllUsers();
    public User findUser(int id);
    public void createUser(User user);
}
