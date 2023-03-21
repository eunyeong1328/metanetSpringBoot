package com.example.restservice.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.websocket.server.PathParam;
import java.net.URI;
import java.util.Iterator;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService service;
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id){
        User user = service.findone(id);

        if(user == null){
            throw new UserNotFoundException(String.format("ID[%s] not found",id));
        }
        return user;
    }


    //이 uri 조회 시 방금 넣은 데이터 값 확인 가능
    @PostMapping("/users")
    public ResponseEntity createUser(@RequestBody User user){
        User savedUser = service.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        User user = service.deleteById(id);
        if(user == null){
            throw new UserNotFoundException(String.format("%s ID not found",id));
        }
    }

}
