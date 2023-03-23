package com.example.restservice.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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
    public EntityModel<User> retrieveUser(@PathVariable int id){
       // User user = service.findone(id);
        User user = service.findUser(id);

        if(user == null){
            throw new UserNotFoundException(String.format("ID[%s] not found",id));
            //인위적으로 예외 발생 throw
        }
        return EntityModel.of(user,
                linkTo(methodOn(UserController.class).retrieveAllUsers()).withRel("all-users"));
    }
//
//    //이 uri 조회 시 방금 넣은 데이터 값 확인 가능
    @PostMapping("/users")
    public ResponseEntity createUser(@Valid @RequestBody User user){
        //User savedUser = service.save(user);
        service.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())//save한 후에 넘어옴
                .toUri();
        return ResponseEntity.created(location).build();
    }
//
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        //User user = service.deleteById(id);
        service.deleteUser(id);
    }

}
