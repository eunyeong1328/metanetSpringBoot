package com.example.restservice.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.swing.text.html.Option;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/jpa")
public class UserJpaController {

//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private PostRepository postRepository;
//
//    @GetMapping("/users")
//    public List<User> retireveAllUser(){
//        return userRepository.findAll();
//    }
//
//    @GetMapping("/users/{id}")
//    public EntityModel<User> retrieveAllUsers(@PathVariable int id){
//        Optional<User> user = userRepository.findById(id);
//
//        if(!user.isPresent()) { //optional객체일 때만 사용
//            throw new UserNotFoundException(String.format("ID[%s] not found",id));
//        }
//        return EntityModel.of(user.get(),
//                linkTo(methodOn(UserController.class).retrieveAllUsers()).withRel("all-users"));
//    }
//
//    @DeleteMapping("/users/{id}")
//    public void deleteUser(@PathVariable int id){
//        userRepository.deleteById(id);
//    }
//
//    //db에 데이터값 저장
//    @PostMapping("/users")
//    public ResponseEntity<User> createUser(@RequestBody User user){
//        User savedUser = userRepository.save(user);
//
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(savedUser.getId())
//                .toUri();
//
//        return ResponseEntity.created(location).build(); //201이아니라 200
//    }
//
//    @GetMapping("/users/{id}/posts")
//    public List<Post> retrieveAllPostByUser(@PathVariable int id){
//        Optional<User> user = userRepository.findById(id);
//        if(!user.isPresent()) { //optional객체일 때만 사용
//            throw new UserNotFoundException(String.format("ID[%s] not found",id));
//        }
//        return user.get().getPosts();
//    }
//
//    @PostMapping("/users/{id}/posts")
//    public ResponseEntity<Post> createPost(@PathVariable int id, @RequestBody Post post){
//        Optional<User> user = userRepository.findById(id);
//        if(!user.isPresent()) { //optional객체일 때만 사용
//            throw new UserNotFoundException(String.format("ID[%s] not found",id));
//        }
//
//        post.setUser(user.get());
//        Post savePost = postRepository.save(post);
//
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(savePost.getId())
//                .toUri();
//        return ResponseEntity.created(location).build();
//    }
}
//usertable을 쓸 때만 user사용
//post 값만 사용 - postRepository 만 사용